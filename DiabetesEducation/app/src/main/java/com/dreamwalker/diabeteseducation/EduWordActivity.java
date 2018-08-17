package com.dreamwalker.diabeteseducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class EduWordActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<WordInfo> wordInfoArrayList = new ArrayList<>();
        wordInfoArrayList.add(new WordInfo("당뇨병"));
        wordInfoArrayList.add(new WordInfo("제 1형 당뇨병"));
        wordInfoArrayList.add(new WordInfo("제 2형 당뇨병"));
        wordInfoArrayList.add(new WordInfo("임신성 당뇨병"));
        wordInfoArrayList.add(new WordInfo("저혈당"));
        wordInfoArrayList.add(new WordInfo("당화혈색소"));
        wordInfoArrayList.add(new WordInfo("당뇨 지식"));
        wordInfoArrayList.add(new WordInfo("자가 간호"));
        wordInfoArrayList.add(new WordInfo("당뇨 자기 관리"));
        wordInfoArrayList.add(new WordInfo("혈당강하제"));
        wordInfoArrayList.add(new WordInfo("내당능장애"));
        wordInfoArrayList.add(new WordInfo("동맥경화"));
        wordInfoArrayList.add(new WordInfo("포도당"));
        wordInfoArrayList.add(new WordInfo("인슐린"));
        wordInfoArrayList.add(new WordInfo("당부하검사"));
        wordInfoArrayList.add(new WordInfo("인슐린 저항성"));
        wordInfoArrayList.add(new WordInfo("고혈압"));
        wordInfoArrayList.add(new WordInfo("다갈"));
        wordInfoArrayList.add(new WordInfo("다뇨"));
        wordInfoArrayList.add(new WordInfo("다식"));

        EduWordAdapter myAdapter = new EduWordAdapter(wordInfoArrayList);
        mRecyclerView.setAdapter(myAdapter);
    }
}