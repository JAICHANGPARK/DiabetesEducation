package com.dreamwalker.diabeteseducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.dreamwalker.diabeteseducation.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        set();
    }

    // 툴바
    public void setToolbar() {
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");
    }

    // 객체 생성
    public void set() {
        Button action_word = (Button) findViewById(R.id.action_word);
        Button action_image = (Button) findViewById(R.id.action_image);
        Button action_introduction = (Button) findViewById(R.id.action_introduction);
        action_word.setOnClickListener(this);
        action_image.setOnClickListener(this);
        action_introduction.setOnClickListener(this);
    }

    // 클릭이벤트
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_introduction:
                // 앱 소개 페이지로 이동
                Intent action_introduction = new Intent(MainActivity.this, AppIntroductionActivity.class);
                startActivity(action_introduction);
                break;
            case R.id.action_word:
                // 용어 페이지로 이동
                Intent intent_word = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_word);
                break;
            case R.id.action_image:
                // 메뉴얼 페이지로 이동
                Intent intent_image = new Intent(MainActivity.this, EduPdfActivity.class);
                startActivity(intent_image);
                break;
        }
    }
}