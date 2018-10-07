package com.dreamwalker.diabeteseducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.EduAdapter;
import com.dreamwalker.diabeteseducation.model.Big;
import com.dreamwalker.diabeteseducation.model.Child;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EduPdfActivity extends AppCompatActivity {

    EduAdapter adapter;
    RecyclerView recyclerView;

    ArrayList<String> bigList = new ArrayList<>();
    ArrayList<String> childList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_pdf);
        setStatusbar();
        setToolbar();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        RecyclerView.ItemAnimator animator = recyclerView.getItemAnimator();
        if (animator instanceof DefaultItemAnimator) {
            ((DefaultItemAnimator) animator).setSupportsChangeAnimations(false);
        }

        adapter = new EduAdapter(this, makeGenres());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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

    private List<Big> makeGenres() {

        return Arrays.asList(makeParentOne(),
                makeParentTwo(),
                makeParentThree(),
                makeParentFour(),
                makeParentFive(),
                makeParentSix(),
                makeParentSeven(),
                makeParentEight(),
                makeParentNine());
    }

    private Big makeParentOne() {
        return new Big(getResources().getString(R.string.parent_0), makeChildOne());
    }

    private List<Child> makeChildOne() {
        Child queen = new Child(getResources().getString(R.string.child_parent_00));
        Child styx = new Child(getResources().getString(R.string.child_parent_01));
        Child reoSpeedwagon = new Child(getResources().getString(R.string.child_parent_02));
        Child boston = new Child(getResources().getString(R.string.child_parent_03));
        Child child4 = new Child(getResources().getString(R.string.child_parent_04));
        return Arrays.asList(queen, styx, reoSpeedwagon, boston, child4);
    }

    private Big makeParentTwo() {
        return new Big(getResources().getString(R.string.parent_1), makeChildTwo());
    }

    private List<Child> makeChildTwo() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_10));
        Child child1 = new Child(getResources().getString(R.string.child_parent_11));
        Child child2 = new Child(getResources().getString(R.string.child_parent_12));
        Child child3 = new Child(getResources().getString(R.string.child_parent_13));

        return Arrays.asList(child0, child1, child2, child3);
    }

    private Big makeParentThree() {
        return new Big(getResources().getString(R.string.parent_2), makeChildThree());
    }

    private List<Child> makeChildThree() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_20));
        Child child1 = new Child(getResources().getString(R.string.child_parent_21));
        Child child2 = new Child(getResources().getString(R.string.child_parent_22));
        Child child3 = new Child(getResources().getString(R.string.child_parent_23));

        return Arrays.asList(child0, child1, child2, child3);
    }

    private Big makeParentFour() {
        return new Big(getResources().getString(R.string.parent_3), makeChildFour());
    }

    private List<Child> makeChildFour() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_30));
        Child child1 = new Child(getResources().getString(R.string.child_parent_31));
        Child child2 = new Child(getResources().getString(R.string.child_parent_32));
        return Arrays.asList(child0, child1, child2);
    }

    private Big makeParentFive() {
        return new Big(getResources().getString(R.string.parent_4), makeChildFive());
    }

    private List<Child> makeChildFive() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_40));
        Child child1 = new Child(getResources().getString(R.string.child_parent_41));
        Child child2 = new Child(getResources().getString(R.string.child_parent_42));
        Child child3 = new Child(getResources().getString(R.string.child_parent_43));
        Child child4 = new Child(getResources().getString(R.string.child_parent_44));
        Child child5 = new Child(getResources().getString(R.string.child_parent_45));

        return Arrays.asList(child0, child1, child2, child3, child4, child5);
    }

    private Big makeParentSix() {
        return new Big(getResources().getString(R.string.parent_5), makeChildSix());
    }

    private List<Child> makeChildSix() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_50));
        Child child1 = new Child(getResources().getString(R.string.child_parent_51));
        Child child2 = new Child(getResources().getString(R.string.child_parent_52));
        Child child3 = new Child(getResources().getString(R.string.child_parent_53));
        Child child4 = new Child(getResources().getString(R.string.child_parent_54));
        Child child5 = new Child(getResources().getString(R.string.child_parent_55));
        Child child6 = new Child(getResources().getString(R.string.child_parent_56));
        return Arrays.asList(child0, child1, child2, child3, child4, child5, child6);
    }

    private Big makeParentSeven() {
        return new Big(getResources().getString(R.string.parent_6), makeChildSeven());
    }

    private List<Child> makeChildSeven() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_60));
        Child child1 = new Child(getResources().getString(R.string.child_parent_61));
        Child child2 = new Child(getResources().getString(R.string.child_parent_62));
        Child child3 = new Child(getResources().getString(R.string.child_parent_63));

        return Arrays.asList(child0, child1, child2, child3);
    }

    private Big makeParentEight() {
        return new Big(getResources().getString(R.string.parent_7), makeChildEight());
    }

    private List<Child> makeChildEight() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_70));
        Child child1 = new Child(getResources().getString(R.string.child_parent_71));

        return Arrays.asList(child0, child1);
    }

    private Big makeParentNine() {
        return new Big(getResources().getString(R.string.parent_8), makeChildNine());
    }

    private List<Child> makeChildNine() {
        Child child0 = new Child(getResources().getString(R.string.child_parent_80));
        Child child1 = new Child(getResources().getString(R.string.child_parent_81));
        Child child2 = new Child(getResources().getString(R.string.child_parent_82));
        Child child3 = new Child(getResources().getString(R.string.child_parent_83));

        return Arrays.asList(child0, child1, child2, child3);
    }
}