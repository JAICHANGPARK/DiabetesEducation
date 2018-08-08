package com.dreamwalker.diabeteseducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EduAdapter adapter;

    RecyclerView recyclerView;

    ArrayList<String> bigList = new ArrayList<>();
    ArrayList<String> childList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        adapter = new EduAdapter(makeGenres());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public static List<Big> makeGenres() {

        return Arrays.asList(makeRockGenre(),makeRockGenre(),makeRockGenre(),makeRockGenre());
//        return Arrays.asList(makeRockGenre(),
//                makeJazzGenre(),
//                makeClassicGenre(),
//                makeSalsaGenre(),
//                makeBluegrassGenre());
    }

    public static Big makeRockGenre() {
        return new Big("Rock", makeRockArtists());
    }

    public static List<Child> makeRockArtists() {
        Child queen = new Child("Queen");
        Child styx = new Child("Styx");
        Child reoSpeedwagon = new Child("REO Speedwagon");
        Child boston = new Child("Boston");

        return Arrays.asList(queen, styx, reoSpeedwagon, boston);
    }
}
