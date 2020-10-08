package com.example.sqlitetutorialfollowalongpractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


///////////////Notes////////////////////////////

//SQLiteOpenHelper is used to handle SQLite


//db format
//Table Name: Student.db
//Fields: ID(pk), Name, Surname, Marks



//////////////////////////////////////////////////

//sqlLite db name not case sensetive.
public class DatabaseHelper extends SQLiteOpenHelper {
    //placeholder to hold db name
    public static final String DATABASE_NAME = " Student.db";
    //place holder to hold table name
    public static final String TABLE_NAME = "Student_table";
    //create placeholders to hold Column Names
    /*
    ie ID, Name, Surname, Marks
    */
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Surname";
    public static final String COL_4 = "Marks";

    //create db
    public DatabaseHelper(@Nullable Context context) {
        super(context, DatabaseHelper.DATABASE_NAME, null, 1);

    }

    //Create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //NOTE: SQLITE data types: NULL, INTEGER, REAL (FLOAT), TEXT, BLOB


        //execute sql CREATE TABLE query
        sqLiteDatabase.execSQL("CREATE TABLE " + DatabaseHelper.TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Surname TEXT, Marks TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
