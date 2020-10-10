package com.example.sqlitetutorialfollowalongpractice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

//Fields: ID(pk), Name, Surname, Marks

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = " Student.db";
    public static final String TABLE_NAME = "Student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Surname";
    public static final String COL_4 = "Marks";

    //create db
    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseHelper.DATABASE_NAME, null, 1);
    }

    //Create table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //execute sql query
        sqLiteDatabase.execSQL("CREATE TABLE " + DatabaseHelper.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Surname TEXT, Marks TEXT)");
    }

    //
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+DatabaseHelper.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    //insert data into table
    public boolean insertData(String name, String surname, String mark){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", name);
        contentValues.put("Surname",surname);
        contentValues.put("Marks",mark);
        //db.execSQL("INSERT INTO "+ DatabaseHelper.TABLE_NAME+" (Name,Surname,Marks) VALUES ("+name+","+surname+","+mark+")");
        long ret = db.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        return ret != -1;
    }

//method to get all tuples
    public Cursor getAllData(){
        //Get a writeable db
        SQLiteDatabase db = this.getWritableDatabase();
        //Query all items
        //Cursor data = db.rawQuery("SELECT * FROM Student_table")
        Cursor data=  db.rawQuery("SELECT * from "+DatabaseHelper.TABLE_NAME, null);
        return  data;
    }



}
