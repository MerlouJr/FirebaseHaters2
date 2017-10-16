package com.example.cosain.firebasehaters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListData extends Activity {

    ListView lv;
    ArrayList<String> al = new ArrayList<>();
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    //    String key;
//    String value = null;
    final ArrayList<String> keyList = new ArrayList<>();
    final ArrayList<String> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        lv = (ListView) findViewById(R.id.list_item);

        myRef = FirebaseDatabase.getInstance().getReference("Log/data");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, al);
        lv.setAdapter(adapter);
        Firebase.setAndroidContext(this);

        new Firebase("https://fir-haters.firebaseio.com/Log")
                .addChildEventListener(new ChildEventListener() {

                    @Override
                    public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                        adapter.add((String) dataSnapshot.child("tag_content").getValue());

                    }

                    @Override
                    public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                        adapter.remove((String) dataSnapshot.child("tag_content").getValue());

                    }

                    @Override
                    public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {
                        adapter.remove((String) dataSnapshot.child("tag_content").getValue());

                    }

                    @Override
                    public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent, View view, final int position, long id) {

                final CharSequence[] items1 = {
                        "Delete", "Update"
                };

                AlertDialog.Builder builder1 = new AlertDialog.Builder(ListData.this);
                builder1.setTitle("Choose: ")
                        .setSingleChoiceItems(items1, -1, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                switch (which) {

                                    case 0:

                                        myRef.getRoot().child("Log/data")
                                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        if (dataSnapshot.hasChildren()) {
                                                            DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                                                            firstChild.getRef().removeValue();
                                                        }
                                                        Toast.makeText(ListData.this, "This item is deleted....", Toast.LENGTH_LONG).show();
                                                    }

                                                    @Override
                                                    public void onCancelled(DatabaseError databaseError) {

                                                    }
                                                });

                                        break;

                                    case 1:
                                        LayoutInflater factory = LayoutInflater.from(ListData.this);
                                        final View textEntryView = factory.inflate(R.layout.activity_main, null);

                                        final EditText input1 = (EditText) textEntryView.findViewById(R.id.editText5);
                                        final EditText input2 = (EditText) textEntryView.findViewById(R.id.editText6);

                                        input1.setText("DefaultValue", TextView.BufferType.EDITABLE);
                                        input2.setText("DefaultValue", TextView.BufferType.EDITABLE);

                                        final AlertDialog.Builder alert = new AlertDialog.Builder(ListData.this);
                                        alert.setIcon(R.mipmap.ic_launcher).setTitle("Enter the Text:").setView(textEntryView).setPositiveButton("Save",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int whichButton) {

                                                        Log.i("AlertDialog","TextEntry 1 Entered "+input1.getText().toString());
                                                        Log.i("AlertDialog","TextEntry 2 Entered "+input2.getText().toString());

                                                    }
                                                }).setNegativeButton("Cancel",
                                                new DialogInterface.OnClickListener() {
                                                    public void onClick(DialogInterface dialog,
                                                                        int whichButton) {
                                                    }
                                                });
                                        alert.show();
                                        break;

                                    case 2:

                                        break;
                                }
                            }
                        });

                AlertDialog alert = builder1.create();
                alert.show();

            }
        });


    }



}