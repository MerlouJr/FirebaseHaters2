package com.example.cosain.firebasehaters;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by cosain on 9/27/2017.
 */

public class RecallWriter extends AppCompatActivity{

    private static String files = "offline";
    private static String fileslog = "offline_log";
    private static String filestime = "offline_time";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isOnline()) {
            toRecord();
        } else {
            toUnrecorded();

        }
        registerReceiver(broadcastReceiver, new IntentFilter("Internet is Available"));
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    //TODO your background code
                    checkInternet();
                    deleteFile(files);
                    deleteFile(fileslog);
                    deleteFile(filestime);
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public void toRecord() {
        String rContent = getIntent().getStringExtra("rawcon");
        String tContent = getIntent().getStringExtra("tagcon");
        String tStamp = getIntent().getStringExtra("timest");

        Toast.makeText(this,"Save data into Firebase",Toast.LENGTH_LONG).show();
          // long stampLong = Long.getLong(tStamp);
            DatabaseReference databaseLog = FirebaseDatabase.getInstance().getReference("Log");
            LogDAO dao = new LogDAO();
            dao.setRaw_content(rContent);
            dao.setTag_content(tContent);
            dao.setTimestamp_recorded(Long.parseLong(tStamp.trim()));
            String userLog = databaseLog.push().getKey();
            databaseLog.child(userLog).setValue(dao);
           finish();

    }
    public void toUnrecorded(){
        String rContent = getIntent().getStringExtra("rawcon");
        String tContent = getIntent().getStringExtra("tagcon");
        String tStamp = getIntent().getStringExtra("timest");
        try {
            FileOutputStream fileOutputStream = openFileOutput(files,MODE_PRIVATE),fileOutputStream1 = openFileOutput(fileslog,MODE_PRIVATE)
                    ,fileOutputStream2 = openFileOutput(filestime,MODE_PRIVATE);

            fileOutputStream.write(rContent.getBytes());
            fileOutputStream1.write(tContent.getBytes());
            fileOutputStream2.write(tStamp.getBytes());
            fileOutputStream.close();
            Intent intent = new Intent(getBaseContext(),RecallReader.class);
            intent.putExtra("temp",files);
            intent.putExtra("temp_log",fileslog);
            intent.putExtra("temp_time",filestime);
            startActivity(intent);
            Toast.makeText(getApplication(),"File successfully saved...",Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

        public void checkInternet(){

            try {
                FileInputStream fin = openFileInput(files);
                int c;
                String temp="";
                while( (c = fin.read()) != -1){
                    temp = temp + Character.toString((char)c);
                }

                FileInputStream fin1 = openFileInput(fileslog);
                int c1;
                String temp1="";
                while( (c1 = fin1.read()) != -1){
                    temp1 = temp1 + Character.toString((char)c1);
                }

                FileInputStream fin2 = openFileInput(filestime);
                int c2;
                String temp2="";
                while( (c2 = fin2.read()) != -1){
                    temp2 = temp2 + Character.toString((char)c2);
                }

                DatabaseReference databaseLog = FirebaseDatabase.getInstance().getReference("Log");
                LogDAO dao = new LogDAO();
                dao.setRaw_content(temp);
                dao.setTag_content(temp1);
                dao.setTimestamp_recorded(Long.parseLong(temp2.trim()));
                String userLog = databaseLog.push().getKey();
                databaseLog.child(userLog).setValue(dao);

            }
            catch(Exception e){
            }
        }

    public boolean isOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        }
        catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }

}


