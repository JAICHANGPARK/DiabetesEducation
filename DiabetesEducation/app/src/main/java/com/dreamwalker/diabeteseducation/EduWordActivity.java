package com.dreamwalker.diabeteseducation;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
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

        ArrayList<FoodInfo> foodInfoArrayList = new ArrayList<>();
        foodInfoArrayList.add(new FoodInfo("당뇨병"));
        foodInfoArrayList.add(new FoodInfo("제 1형 당뇨병"));
        foodInfoArrayList.add(new FoodInfo("제 2형 당뇨병"));

        EduWordAdapter myAdapter = new EduWordAdapter(foodInfoArrayList);
        mRecyclerView.setAdapter(myAdapter);
    }
}