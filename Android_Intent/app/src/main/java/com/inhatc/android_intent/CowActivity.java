package com.inhatc.android_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CowActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOK;       // 버튼 btnOK
    private EditText edtSound;  // EditText edtSound

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cow);  // 레이아웃 activity_cow.xml

        btnOK = (Button)findViewById(R.id.btnOK); // OK 버튼
        btnOK.setOnClickListener(this); // 클릭 이벤트
    }

    public void onClick(View v) {   // 클릭 이벤트
        if(v == btnOK) {    // btnOK 버튼이 클릭되었을 시
            Intent CallIntent = getIntent();    // intent 값을 받아옴.
            edtSound = (EditText)findViewById(R.id.editInputSound);
            CallIntent.putExtra("Animal_Sound", edtSound.getText().toString());
            setResult(RESULT_OK, CallIntent); // Result 반환
            finish(); // 액티비티 종료
        }
    }
}