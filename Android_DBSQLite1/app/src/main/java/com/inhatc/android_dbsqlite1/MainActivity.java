package com.inhatc.android_dbsqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase myDB;            // Database object
    SimpleAdapter myADT;            // Adapter object
    ArrayList<String> aryMBRList;   // ArrayList object
    ArrayAdapter<String> adtMembers;// ArrayAdapter object
    ListView lstView;               // ListView object
    String strRecode = null;        // Recode data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create DB(DB Name: PhoneBook)
//        myDB = this.oopenOrCreateDatabase("PhoneBook", MODE_PRIVATE, null);
        myDB.execSQL("Drop table if exists members");

        // Create Table(Table Name: members)
        myDB.execSQL("Create table members (" +
                " _id integer primary key autoincrement, " +
                "Name text not null, " + "Phone_No text not null);");

        // Store Data("kdhong", "011-8701-2320") to members table
        myDB.execSQL("Insert into members " +
                " (Name, Phone_NO) values ('Kdhong', '011-8701-2320');");


    }


}