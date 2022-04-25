package com.inhatc.android_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCow, btnDog;  // 버튼 btnCow, btnDog
    private Toast objToast; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 레이아웃 activity_main.xml

        btnCow = (Button)findViewById(R.id.btnCow); // btnCow 버튼
        btnDog = (Button)findViewById(R.id.btnDog); // btnDog 버튼
        btnCow.setOnClickListener(this);    // 클릭 이벤트
        btnDog.setOnClickListener(this);    // 클릭 이벤트
    }

    public void onClick(View v) {   // 클릭 이벤트
        if (v == btnCow) {  // btnCow 버튼이 클릭되었을 시
            // 인수를 호출할 대상을 지정하는 Intent
            Intent cowIntent = new Intent(MainActivity.this, CowActivity.class);

            // cowIntent라는 Activity 실행
//            startActivity(cowIntent);

            // 리턴값을 돌려주는 Activity를 호출
            startActivityForResult(cowIntent, 1);

        } else if (v == btnDog) {   // btnDog 버튼이 클릭되었을 시
            Intent dogIntent = new Intent(MainActivity.this, DogActivity.class);

            // cowIntent라는 Activity 실행
//            startActivity(dogIntent);

            // 리턴값을 돌려주는 Activity를 호출
            startActivityForResult(dogIntent, 1);
        }
    }

    // 호출된 액티비티가 종료되면 onActivityResult가 호출된다
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {  // 호출하는 코드에서 requestCode 1을 받아오면
            // putExtra "Animal_Sound"의 값을 가져옴.
            String strData = data.getStringExtra("Animal_Sound");
            // 메세지 출력
            objToast = Toast.makeText(this, strData, Toast.LENGTH_LONG);
            objToast.show();
        }
    }
}