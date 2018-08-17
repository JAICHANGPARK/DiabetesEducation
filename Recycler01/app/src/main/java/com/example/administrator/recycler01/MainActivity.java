package com.example.administrator.recycler01;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        foodInfoArrayList.add(new FoodInfo(R.drawable.ic_expand_more_black_24dp, "5,000원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.ic_launcher_background, "4,600원"));
        foodInfoArrayList.add(new FoodInfo(R.drawable.ic_launcher_foreground, "4,000원"));

        EduWordAdapter myAdapter = new EduWordAdapter(foodInfoArrayList);

        mRecyclerView.setAdapter(myAdapter);

    }
}

