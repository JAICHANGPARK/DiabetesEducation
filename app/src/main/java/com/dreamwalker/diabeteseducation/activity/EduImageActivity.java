/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.dreamwalker.diabeteseducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.EduImageAdapter;

import java.util.ArrayList;

public class EduImageActivity extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ArrayList<Integer> imageList;
    EduImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_image);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        imageList = new ArrayList<>();

        imageList.add(R.drawable.image_education_00);
        imageList.add(R.drawable.image_education_01);

        adapter = new EduImageAdapter(this, imageList);
        recyclerView.setAdapter(adapter);
//        imageView = findViewById(R.id.image_view);
//        Glide.with(this).load(R.drawable.image_education_00).into(imageView);
    }
}