package com.inhatc.study_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView objTV = new TextView(this);
        objTV.setText("Android Programming !");
        setContentView(objTV);

        EditText objET = (EditText)findViewById(R.id.editText);
        objET.setText("Google : ");
        objET.setGravity(0x01);

//        String strData = objET.getText().toString();
//        objET.setText(strData + " Android Programming");

        objET.setText(objET.getText() + " Android Programming");
    }
}