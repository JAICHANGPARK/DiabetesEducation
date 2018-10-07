package com.dreamwalker.diabeteseducation.activity;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.MyRecyclerAdapter;
import com.dreamwalker.diabeteseducation.model.CardItem;
import com.dreamwalker.diabeteseducation.model.CustomDialog;
import com.dreamwalker.diabeteseducation.model.MyDialogListener;

import java.util.ArrayList;
import java.util.List;

public class EduWordActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {
    private MyRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_word);
        setStatusbar();
        setToolbar();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        // 레이아웃 매니저로 LinearLayoutManager를 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // 표시할 임시 데이터
        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_0)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_1)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_2)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_3)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_4)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_5)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_6)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_7)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_8)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_9)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_10)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_11)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_12)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_13)));
        dataList.add(new CardItem(getResources().getString(R.string.parent_2_14)));

        // 어댑터 설정
        mAdapter = new MyRecyclerAdapter(dataList);
        mAdapter.setOnClickListener(this);
        recyclerView.setAdapter(mAdapter);
        }

    // 상태바 색 변경
    public void setStatusbar(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryPurle));
    }

    // 툴바
    public void setToolbar() {
        Toolbar mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mytoolbar);
        getSupportActionBar().setTitle("");
    }

    // 클릭 이벤트
    @Override
    public void onItemClicked(int position) {
        CustomDialog dialog = new CustomDialog(EduWordActivity.this, title(position), content(position));
        // 바깥 클릭 시 꺼짐
        dialog.setCanceledOnTouchOutside(true);
        dialog.setDialogListener(new MyDialogListener() {
            @Override
            public void onPositiveClicked(String title, String content) {
            }
        });
        // 생성
        dialog.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        dialog.show();
        // 디스플레이 해상도를 가져와서
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        // 비율에 맞게 다이얼로그 크기를 지정
        Window window = dialog.getWindow();
        int x = (int)(size.x * 0.8f);
        int y = (int)(size.y * 0.55f);
        window.setLayout(x, y);
    }

    String title(int position) {
        String[] str_title = {getResources().getString(R.string.parent_2_0), getResources().getString(R.string.parent_2_1), getResources().getString(R.string.parent_2_2), getResources().getString(R.string.parent_2_3),
                getResources().getString(R.string.parent_2_4), getResources().getString(R.string.parent_2_5), getResources().getString(R.string.parent_2_6), getResources().getString(R.string.parent_2_7),
                getResources().getString(R.string.parent_2_8), getResources().getString(R.string.parent_2_9), getResources().getString(R.string.parent_2_10), getResources().getString(R.string.parent_2_11),
                getResources().getString(R.string.parent_2_12), getResources().getString(R.string.parent_2_13), getResources().getString(R.string.parent_2_14)};
        return str_title[position];
    }

    String content(int position) {
        String[] str_content = new String[]{
                getResources().getString(R.string.child_parent_2_00),
                getResources().getString(R.string.child_parent_2_01),
                getResources().getString(R.string.child_parent_2_02),
                getResources().getString(R.string.child_parent_2_03),
                getResources().getString(R.string.child_parent_2_04),
                getResources().getString(R.string.child_parent_2_05),
                getResources().getString(R.string.child_parent_2_06),
                getResources().getString(R.string.child_parent_2_07),
                getResources().getString(R.string.child_parent_2_08),
                getResources().getString(R.string.child_parent_2_09),
                getResources().getString(R.string.child_parent_2_10),
                getResources().getString(R.string.child_parent_2_11),
                getResources().getString(R.string.child_parent_2_12),
                getResources().getString(R.string.child_parent_2_13),
                getResources().getString(R.string.child_parent_2_14)
        };
        return str_content[position];
    }
}