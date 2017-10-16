package com.example.cosain.firebasehaters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.FileInputStream;

/**
 * Created by cosain on 9/27/2017.
 */

public class RecallReader extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      readFile();

    }

public void readFile() {
    String file = getIntent().getStringExtra("temp");
    String filelog = getIntent().getStringExtra("temp_log");
    String filetime = getIntent().getStringExtra("temp_time");
    try {
        FileInputStream fin = openFileInput(file);
        int c;
        String temp="";
        while( (c = fin.read()) != -1){
            temp = temp + Character.toString((char)c);
        }

        FileInputStream fin1 = openFileInput(filelog);
        int c1;
        String temp1="";
        while( (c1 = fin1.read()) != -1){
            temp1 = temp1 + Character.toString((char)c1);
        }

        FileInputStream fin2 = openFileInput(filetime);
        int c2;
        String temp2="";
        while( (c2 = fin2.read()) != -1){
            temp2 = temp2 + Character.toString((char)c2);
        }

        }
        catch(Exception e){
        }
        finish();

}
}
