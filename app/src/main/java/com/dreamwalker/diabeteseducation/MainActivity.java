package com.dreamwalker.diabeteseducation;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button action_word = (Button) findViewById(R.id.action_word);
        action_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 교육(추가자료) 페이지로 이동
                Intent intent_edu = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_edu);
            }
        });

        Button action_image = (Button) findViewById(R.id.action_image);
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
    public boolean onOptionsItemSelected(MenuItem item){
//        // 툴바 탭 클릭 이벤트
//        switch(item.getItemId()){
//            case R.id.action_word:
//                break;
//        }
        return super.onOptionsItemSelected(item);
    }
}