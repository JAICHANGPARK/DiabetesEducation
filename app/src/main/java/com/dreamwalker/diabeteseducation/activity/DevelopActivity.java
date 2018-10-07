package com.dreamwalker.diabeteseducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.dreamwalker.diabeteseducation.CardItem;
import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class DevelopActivity extends AppCompatActivity {
    private MyRecyclerAdapter mAdapter;
    RecyclerView recyclerView;
    List<CardItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_develop);
        setStatusbar();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("박제창", "강원대 전자공학전공 석사 2학년", "aristojeff@gmail.com", "https://github.com/JAICHANGPARK", "총괄"));
        dataList.add(new CardItem(getResources().getString(R.string.develop_name1), "강원대 전자공학 4학년", getResources().getString(R.string.develop_email1), "https://github.com/kin7274", getResources().getString(R.string.develop_assign1)));
        mAdapter = new MyRecyclerAdapter(dataList);
        recyclerView.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(), new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    // 상태바 색 변경
    public void setStatusbar(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryPurle));
    }
}
