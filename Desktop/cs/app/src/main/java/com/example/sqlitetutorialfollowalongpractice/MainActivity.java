package com.example.sqlitetutorialfollowalongpractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
    Button viewAllButton;
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
        viewAllButton = (Button) findViewById(R.id.displayTableButton);

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


        //View all items when button pressed
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get all data
                Cursor cursor = db.getAllData();
                //res.getcount == 0 means nothing in table/no results returned by query.
                if(cursor.getCount()==0){
                    //0 results
                    Toast.makeText(MainActivity.this, "No results returned by query", Toast.LENGTH_LONG).show();
                }
                else{
                    //Query returned something. Display it with stringbuffer
                    //iterate over all data in cursor and append it row by row to stringbuffer
                    StringBuffer buffer = new StringBuffer();
                    while(cursor.moveToNext()){
                        buffer.append("ID: "+cursor.getString(0)+"Name: "+cursor.getString(1)+" Surname: "+cursor.getString(2)+"Mark: "+cursor.getString(3)+"\n\n");
                    }
                    //Results appended. Show data
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setCancelable(true);
                    builder.setTitle("Data");
                    builder.setMessage(buffer.toString());
                    builder.show();
                }
            }
        });
    }







}
