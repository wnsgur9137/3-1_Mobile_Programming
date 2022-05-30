package com.inhatc.android_dbsqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase myDB;
    SimpleAdapter myADT;
    ArrayList<String> aryMBRList;
    ArrayAdapter<String> adtMembers;
    ListView lstView;
    String strRecode = null;
    ContentValues insertValue;
    Cursor allRCD;
    Button btnInsert, btnUpdate, btnDelete, btnSearch;
    EditText edtCarType, edtCarPower;
    String strSQL = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCarType = (EditText)findViewById(R.id.editCarType);
        edtCarPower = (EditText) findViewById(R.id.editCarPower);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnInsert.setOnClickListener(this);

        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(this);

        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);

        btnSearch = (Button) findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(this);

        lstView = (ListView) findViewById(R.id.lstMember);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                myDB = this.openOrCreateDatabase("CarInformation", MODE_PRIVATE, null);
                myDB.execSQL("Drop table if exists Carlist");

                myDB.execSQL("Create table Carlist (_id integer primary key autoincrement, CarType text not null, CarPower text not null);");

                myDB.execSQL("Insert into Carlist (CarType, CarPower) values('BMW S28i', '2800');");

                insertValue = new ContentValues();
                insertValue.put("CarType", "Benz 320");
                insertValue.put("CarPower", "3200");
                myDB.insert("Carlist", null, insertValue);

                getDBData(null);

                if(myDB != null) myDB.close();
            }
        });

//        myDB = this.openOrCreateDatabase("PhoneBook", MODE_PRIVATE, null);
//        myDB.execSQL("Drop table if exists members");
//
//        myDB.execSQL("Create table members (_id integer primary key autoincrement, Name text not null, Phone_No text not null);");
//
//        myDB.execSQL("Insert into members (Name, Phone_No) values ('kdhong', '011-8701-2320');");
//
//        ContentValues insertValue = new ContentValues();
//        insertValue.put("Name", "Juliet");
//        insertValue.put("Phone_No", "010-123-1234");
//        myDB.insert("members", null, insertValue);
//
//        myDB.execSQL("Insert into members (Name, Phone_No) values ('Romio', '010-100-5678');");
//
//        Cursor allRCD = myDB.query("members", null, null, null, null, null, null, null);
//
//        aryMBRList = new ArrayList<String>();
//        if (allRCD != null) {
//            if (allRCD.moveToFirst()) {
//                do {
//                    strRecode = allRCD.getString(1) + "\t\t" + allRCD.getString(2);
//                    aryMBRList.add(strRecode);
//                }while(allRCD.moveToNext());
//            }
//        }
//        adtMembers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, aryMBRList);
//
//        lstView = (ListView)findViewById(R.id.lstMember);
//        lstView.setAdapter(adtMembers);
//        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//
//        if(myDB != null) myDB.close();
    }

    public void getDBData(String strWhere) {
        allRCD = myDB.query("Carlist", null, strWhere, null, null, null, null, null);

        aryMBRList = new ArrayList<String>();
        if(allRCD != null) {
            if(allRCD.moveToFirst()) {
                do{
                    strRecode = allRCD.getString(1) + "\t\t" + allRCD.getString(2);
                    aryMBRList.add(strRecode);
                }while(allRCD.moveToNext());
            }
        }
        adtMembers = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, aryMBRList);

        lstView.setAdapter(adtMembers);
        lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public void onClick(View v) {
        myDB = this.openOrCreateDatabase("CarInformation", MODE_PRIVATE, null);

        if(v == btnInsert) {
            insertValue = new ContentValues();
            insertValue.put("CarType", edtCarType.getText().toString());
            insertValue.put("CarPower", edtCarPower.getText().toString());
            myDB.insert("Carlist", null, insertValue);
            getDBData(null);
        } else if(v == btnUpdate) {
            strSQL = "Update Carlist Set ";
            strSQL += "CarType = " + "'" + edtCarType.getText().toString() + "', ";
            strSQL += "CarPower = " + "'" + edtCarPower.getText().toString() + "; ";
            strSQL += "Where CarType = '" + edtCarType.getText().toString() + "';";
            myDB.execSQL(strSQL);
            getDBData(null);
        } else if(v == btnDelete) {
            strSQL = "Delete From Carlist";
            strSQL += " Where CarType = '" + edtCarType.getText().toString() + "';";
            myDB.execSQL(strSQL);
            getDBData(null);
        } else if(v == btnSearch) {
            strSQL = "CarType = '" + edtCarType.getText().toString() + "'";
            getDBData(strSQL);
        }
        if(myDB != null) myDB.close();
    }
}