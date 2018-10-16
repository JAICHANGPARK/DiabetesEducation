package com.dreamwalker.diabeteseducation.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.dreamwalker.diabeteseducation.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final long FINISH_INTERVAL_TIME = 2000;  // 2초안에 BACK버튼 한번더 누르면 종료하겠다!
    private long backPressedTime = 0;  // 그 2초를 측정하기 위한 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();
        set();
        setStatusbar();
    }

    // 툴바
    public void setToolbar() {
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");
    }

    // 상태바 색 변경
    public void setStatusbar() {
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryPurle));
    }

    // 객체 생성
    public void set() {
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.layout1);
        RelativeLayout layout2 = (RelativeLayout) findViewById(R.id.layout2);
        RelativeLayout layout3 = (RelativeLayout) findViewById(R.id.layout3);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
        layout3.setOnClickListener(this);
    }

    // 메뉴.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // 클릭이벤트
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout1:
                // 용어 페이지로 이동
                Intent intent_word = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_word);
                break;
            case R.id.layout2:
                // 메뉴얼 페이지로 이동
                Intent intent_image = new Intent(MainActivity.this, EduPdfActivity.class);
                startActivity(intent_image);
                break;
            case R.id.layout3:
                // 영상 페이지로 이동
                Intent intent_youtube = new Intent(MainActivity.this, EduYoutubeActivity.class);
                startActivity(intent_youtube);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // 앱 평가하기
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "플레이스토어 댓글로 강제이동", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                // 앱 소개 페이지로 이동
                Intent intent = new Intent(MainActivity.this, AppIntroductionActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 뒤로가기 버튼
    // 한 번 누르면 팝업창
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;
        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("종료")
                    .setMessage("정말 종료하실껀가요?")
                    .setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            dialog.create();
            dialog.show();
        }
    }
}