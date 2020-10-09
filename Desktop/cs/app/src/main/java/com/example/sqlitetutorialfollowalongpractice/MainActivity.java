package com.example.sqlitetutorialfollowalongpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText name;
    EditText surName;
    EditText mark;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create db
        db = new DatabaseHelper(this);

        //Make widgets
        button = (Button) findViewById(R.id.addDataButton);
        name = (EditText) findViewById(R.id.nameEditText);
        surName = (EditText) findViewById(R.id.surnameEditText);
        mark = (EditText) findViewById(R.id.marksEditBox);

        //when button clicked get text values from editTexts and insert data into db.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //insert Name, Surname, Mark tuple into db.
               boolean isInserted =  db.insertData(name.getText().toString(), surName.getText().toString(),mark.getText().toString());

               //Show message indicating tuple insertion success or failure
               if (isInserted){
                   Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
               }
               else{
                   Toast.makeText(MainActivity.this,"Data insertion failed", Toast.LENGTH_LONG).show();
               }
            }
        });
    }







}
