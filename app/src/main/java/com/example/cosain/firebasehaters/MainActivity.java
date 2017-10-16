package com.example.cosain.firebasehaters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

   EditText editLogtime;
    EditText editLog , editRaw;
    Button saveButton , listviewButton,readButton;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String file = "offline";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editRaw = (EditText) findViewById(R.id.editText4);
        editLog = (EditText) findViewById(R.id.editText5);
        editLogtime = (EditText) findViewById(R.id.editText6);
        saveButton = (Button) findViewById(R.id.button2);
        //listviewButton = (Button) findViewById(R.id.button);
        //readButton = (Button) findViewById(R.id.read);

       final String raw = editRaw.getText().toString().trim();
        final  String log = editLog.getText().toString();
          final String textStr = editLogtime.getText().toString();

        Firebase.setAndroidContext(this);



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(getBaseContext(), RecallWriter.class);
                    intent.putExtra("rawcon",raw);
                    intent.putExtra("tagcon",log);
                    intent.putExtra("timest",textStr);
                    startActivity(intent);

            }
        });
    }
}
