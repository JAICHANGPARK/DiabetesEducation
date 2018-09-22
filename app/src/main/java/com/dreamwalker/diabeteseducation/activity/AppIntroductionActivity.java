package com.dreamwalker.diabeteseducation.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.CustomDialog;
import com.dreamwalker.diabeteseducation.Introduction.ChangeLogActivity;
import com.dreamwalker.diabeteseducation.Introduction.DevelopActivity;
import com.dreamwalker.diabeteseducation.Introduction.IntroActivity;
import com.dreamwalker.diabeteseducation.MyDialogListener;
import com.dreamwalker.diabeteseducation.R;

public class AppIntroductionActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_introduction);
        set();
    }

    // 객체 생성
    public void set() {
        TextView menu1 = (TextView) findViewById(R.id.menu1);
        TextView menu2 = (TextView) findViewById(R.id.menu2);
        TextView menu3 = (TextView) findViewById(R.id.menu3);
        TextView menu4 = (TextView) findViewById(R.id.menu4);
        menu1.setOnClickListener(this);
        menu2.setOnClickListener(this);
        menu3.setOnClickListener(this);
        menu4.setOnClickListener(this);
    }

    // 메뉴 4개(텍스트뷰) 클릭 이벤트
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu1:
                // 1번 메뉴 : 당뇨그루에 대해
                // 액티비티 넘겨
                Intent IntroIntent = new Intent(AppIntroductionActivity.this, IntroActivity.class);
                startActivity(IntroIntent);
                break;
            case R.id.menu2:
                // 2번 메뉴 : 앱버전 정보
                // 커스텀 다이얼로그
                CustomDialog dialog = new CustomDialog(AppIntroductionActivity.this);
                dialog.setCanceledOnTouchOutside(true);
                dialog.setDialogListener(new MyDialogListener() {
                    @Override
                    public void onPositiveClicked(String title, String content) {
                    }
                });
                dialog.create();
                dialog.show();
                break;
            case R.id.menu3:
                // 3번 메뉴 : 개발자 정보
                // 리사이클러뷰
                // 뷰홀더 형식을 생각하자!
                Intent developer_Intent = new Intent(AppIntroductionActivity.this, DevelopActivity.class);
                startActivity(developer_Intent);
                break;
            case R.id.menu4:
                // 4번 메뉴 : Change log
                // 변경 내용
                Intent changeLogIntent = new Intent(AppIntroductionActivity.this, ChangeLogActivity.class);
                startActivity(changeLogIntent);
                break;
        }
    }
}
