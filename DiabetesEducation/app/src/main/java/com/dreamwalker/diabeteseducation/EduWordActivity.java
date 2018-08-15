package com.dreamwalker.diabeteseducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EduWordActivity extends AppCompatActivity {

    RecyclerView recycler_view;
    EduWordAdapter eduWordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_word);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));  // 한 줄로

        eduWordAdapter = new EduWordAdapter(this, list);  // 배열이니까
        recycler_view.setAdapter(eduWordAdapter);  // setAdapter();
    }
}