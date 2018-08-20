package com.dreamwalker.diabeteseducation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;  // 팝업창
    final int[] selectedItem = {0};  // 팝업창의 선택목록 표시

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 툴바
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");
    }

    // 메뉴.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // 툴바 탭 클릭 이벤트
        switch(item.getItemId()){
            case R.id.action_image:
                // 설정 페이지로 이동
                Intent intent = new Intent(MainActivity.this, EduPdfActivity.class);
                startActivity(intent);
                break;
            case R.id.action_word:
                // 교육(추가자료) 페이지로 이동
                Intent intent_edu = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_edu);
                break;
            case R.id.action_extre:
                // 어플에 대한 사용법 간단하게
                // dialog
                Toast.makeText(getApplicationContext(), "준비중이예유", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}