package com.dreamwalker.diabeteseducation.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.MyAdapter;
import com.dreamwalker.diabeteseducation.model.Index;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    ExpandableListView elv;
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setStatusbar();
        set_scroll();
        TextView tvLinkify = (TextView) findViewById(R.id.tvLinkify);
        TextView abc = (TextView) findViewById(R.id.abc);
        elv = (ExpandableListView) findViewById(R.id.elv);
        final ArrayList<Index> index = getData();
        MyAdapter adapter = new MyAdapter(this, index);
        elv.setAdapter(adapter);
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                show(index.get(groupPosition), index.get(groupPosition).contents.get(childPosition));
                return false;
            }
        });
    }

    // 상태바 색 변경
    public void setStatusbar(){
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryPurle));
    }

    // 스크롤뷰 설정
    public void set_scroll() {
        scrollview = (ScrollView) findViewById(R.id.scrollview);
        scrollview.smoothScrollTo(0, 0);
        scrollview.setHorizontalScrollBarEnabled(true);
    }

    //add and get data for list
    private ArrayList<Index> getData() {

        Index p1 = new Index("1. 당뇨그루에 관해");
        p1.contents.add(getResources().getString(R.string.Intro_content));

        Index p2 = new Index("2_1. 식이요법관리");
        p2.contents.add("식이요법 관리 애플리케이션은 스마트 식판을 자체 제작하여 저희의 식품교환표에 매칭하여 식단의 칼로리 정보를 알려줍니다.\n이를 토대로 사용자는 부족한 식품요소를 확인, 균형 잡힌 식사를 구성할 수 있습니다.\n애플리케이션으로 사진 전송을 하여 기록도 가능합니다.");

        Index p3 = new Index("2_2. 운동관리");
        p3.contents.add("에르고미터, 트레드밀과 연동하여 사용자의 운동 시간, 속도ㅡ 소모 칼로리 등을 확인하고 저장할 수 있습니다.\n각자 태그를 이용하여 사용자별로 저장 가능하며 장치를 두고 운동한 경우 연결 시 운동했던 데이터 수신이 가능합니다.");

        Index p4 = new Index("2_3. 투약");
        p4.contents.add("니들 저장 케이스를 제작하여 니들 잔여 개수를 확인 가능하고 사용 시 카운팅합니다.\n동시에 애플리케이션으로 투여 약품과 투여 시간을 전송합니다.\n사용자가 투여할 시간을 설정하는 알람 기능도 추가하였습니다.");

        Index p5 = new Index("2_4. 신체활동");
        p5.contents.add("웨어러블형 밴드와 연결하여 사용자의 실시간 심박수를 수신하여 확인할 수 있습니다.");

        Index p6 = new Index("2_5. 혈당계");
        p6.contents.add("혈당을 자동으로 측정하고 저장합니다.");

        ArrayList<Index> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);
        allposition.add(p5);
        allposition.add(p6);
        return allposition;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onClick(View v) {
    }

    // 다이얼로그 메서드
    public void show(Index title, String context) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title.toString());
        builder.setMessage(context);
        builder.setPositiveButton("확인",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        builder.show();
    }
}
