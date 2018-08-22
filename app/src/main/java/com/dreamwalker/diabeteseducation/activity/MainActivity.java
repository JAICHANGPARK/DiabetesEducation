package com.dreamwalker.diabeteseducation.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dreamwalker.diabeteseducation.CustomDialog;
import com.dreamwalker.diabeteseducation.MyDialogListener;
import com.dreamwalker.diabeteseducation.R;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout action_word = ( LinearLayout ) findViewById(R.id.action_word);

        // 툴바
        Toolbar mytoolbar = ( Toolbar ) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");

        // 상태바 색 변경
        View view = getWindow().getDecorView();
        view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(Color.parseColor(getResources().getString(R.color.colorPrimaryPurle)));

        // 레이아웃(버튼) 이벤트
        action_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 교육(추가자료) 페이지로 이동
                Intent intent_edu = new Intent(MainActivity.this, EduWordActivity.class);
                startActivity(intent_edu);
            }
        });

        LinearLayout action_image = ( LinearLayout ) findViewById(R.id.action_image);
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
        switch (item.getItemId()) {
            case R.id.action_appinfo:
                // 앱정보 다이얼로그
                CustomDialog dialog = new CustomDialog(this, "앱정보", "이거는 이러이러한 앱이다.");
                dialog.setCanceledOnTouchOutside(true);

                dialog.setDialogListener(new MyDialogListener() {
                    @Override
                    public void onPositiveClicked(String title, String content) {
                    }
                });
                dialog.create();
                dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
                dialog.show();
                break;
            case R.id.action_myinfo:
                // 개발자정보 다이얼로그
                CustomDialog dialog2 = new CustomDialog(this, "개발자정보", "나는 이러한 사람이다.");
                dialog2.setCanceledOnTouchOutside(true);

                dialog2.setDialogListener(new MyDialogListener() {
                    @Override
                    public void onPositiveClicked(String title, String content) {
                    }
                });
                dialog2.create();
                dialog2.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
                dialog2.show();
                break;
        }
            return super.onOptionsItemSelected(item);
    }
}