package com.dreamwalker.diabeteseducation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button action_word = ( Button ) findViewById(R.id.action_word);

        //
        // 상태바 색 변경
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.parseColor(getResources().getString(R.color.colorPrimaryPurle)));

        // 버튼 이벤트
        action_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 교육(추가자료) 페이지로 이동
                Intent intent_edu = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_edu);
            }
        });

        Button action_image = ( Button ) findViewById(R.id.action_image);
        action_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 설정 페이지로 이동
                Intent intent = new Intent(MainActivity.this, EduPdfActivity.class);
                startActivity(intent);
            }
        });
    }

    // 메뉴.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // 툴바 탭 클릭 이벤트
//        switch(item.getItemId()){
//            case R.id.action_word:
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}