package com.inhatc.android_alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ToggleButton objTGButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTGButton = (ToggleButton)findViewById(R.id.tgbtnSwitch);
        objTGButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        // Call onCreateDialog(int), onPrepareDialog(int) method
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        super.onCreateDialog(id);

        AlertDialog dlgAlert;   // AlertDialog object
        final String items[] = {"통화 계속", "통화 종료"};

        dlgAlert = new AlertDialog.Builder(this)
                .setIcon(R.drawable.question)
//                .setTitle("알림 !") // v01
                .setTitle("통화시간 3분 초과!")
//                .setMessage("통화시간 3분 초과!")    // v01

                // v02
//                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int index) {
//                        String strData = null;
//                        if (index == 0) strData = "통화중.....";
//                        else strData = "통화를 종료합니다.";
//                        Toast.makeText(MainActivity.this, strData, Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setView(null)
                .setView(createCustomView())

                // Create Listener object for AlertDialog button event handler
                .setPositiveButton("확인(OK)", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return dlgAlert;
    }

    @Override
    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
    }

    // Create AlterDialog CustionView
    private LinearLayout createCustomView() {
        LinearLayout objLayoutView;
        ListView lstViewCalling;
        ArrayList<String> lstItems;
        ArrayAdapter<String> aryADTItems;

        objLayoutView = new LinearLayout(this);
        lstViewCalling = new ListView(this);
        lstItems = new ArrayList<String>();
        lstItems.add("통화 계속");
        lstItems.add("통화 종료");

        aryADTItems = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_single_choice, lstItems);
        lstViewCalling.setAdapter(aryADTItems);
        lstViewCalling.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lstViewCalling.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
                String strData = null;
                if (index == 0) strData = "통화중.....";
                else strData = "통화를 종료합니다.";
                Toast.makeText(MainActivity.this, strData, Toast.LENGTH_SHORT).show();
            }
        });
        objLayoutView.setOrientation(LinearLayout.VERTICAL);
        objLayoutView.addView(lstViewCalling);
        return objLayoutView;
    }
}