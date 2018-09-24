package com.dreamwalker.diabeteseducation.introduction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamwalker.diabeteseducation.R;

import java.util.ArrayList;

public class IntroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    ScrollView scrollview;
    // TODO 확장형 리스트뷰 :사이즈 조절, 내용 추가
    // TODO 스크롤뷰 : 처음 열면 맨 위로 올라오도록!

    int positionY;
    TextView index_no1, index_no2_1, index_no2_2, index_no2_3, index_no2_4, index_no2_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        set_scroll();
        set();

        ExpandableListView elv = (ExpandableListView) findViewById(R.id.elv);
        final ArrayList<Index> index = getData();
        //create and bind to adatper
        MyAdapter adapter = new MyAdapter(this, index);
        elv.setAdapter(adapter);
        //set onclick listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), index.get(groupPosition).contents.get(childPosition), Toast.LENGTH_LONG).show();
                // TODO 팝업창으로 하는건 어떨까
                return false;
            }
        });
    }

    // 스크롤뷰 설정
    public void set_scroll() {
        ScrollView scrollview = (ScrollView) findViewById(R.id.scrollview);

        scrollview.scrollTo(0, 0);
        // 수평 스크롤바 사용 가능 설정
        scrollview.setHorizontalScrollBarEnabled(true);
    }

    // 객체 생성
    public void set() {
        index_no1 = (TextView) findViewById(R.id.index_no1);
        index_no2_1 = (TextView) findViewById(R.id.index_no2_1);
        index_no2_2 = (TextView) findViewById(R.id.index_no2_2);
        index_no2_3 = (TextView) findViewById(R.id.index_no2_3);
        index_no2_4 = (TextView) findViewById(R.id.index_no2_4);
        index_no2_5 = (TextView) findViewById(R.id.index_no2_5);
        index_no1.setOnClickListener(this);
        index_no2_1.setOnClickListener(this);
        index_no2_2.setOnClickListener(this);
        index_no2_3.setOnClickListener(this);
        index_no2_4.setOnClickListener(this);
        index_no2_5.setOnClickListener(this);
    }

    //add and get data for list
    private ArrayList<Index> getData() {

        Index p1 = new Index("1. 당뇨그루에 관해");
        p1.contents.add(getResources().getString(R.string.Intro_content));

        Index p2 = new Index("2-1. 식이요법관리");
        p2.contents.add("식이요법 관리 애플리케이션은 스마트 식판을 자체 제작하여 저희의 식품교환표에 매칭하여 식단의 칼로리 정보를 알려줍니다.\n이를 토대로 사용자는 부족한 식품요소를 확인, 균형 잡힌 식사를 구성할 수 있습니다.\n애플리케이션으로 사진 전송을 하여 기록도 가능합니다.");

        Index p3 = new Index("2-2. 운동관리");
        p3.contents.add("에르고미터, 트레드밀과 연동하여 사용자의 운동 시간, 속도ㅡ 소모 칼로리 등을 확인하고 저장할 수 있습니다.\n각자 태그를 이용하여 사용자별로 저장 가능하며 장치를 두고 운동한 경우 연결 시 운동했던 데이터 수신이 가능합니다.");

        Index p4 = new Index("2-3. 투약");
        p4.contents.add("니들 저장 케이스를 제작하여 니들 잔여 개수를 확인 가능하고 사용 시 카운팅합니다.\n동시에 애플리케이션으로 투여 약품과 투여 시간을 전송합니다.\n사용자가 투여할 시간을 설정하는 알람 기능도 추가하였습니다.");

        Index p5 = new Index("2-4. 신체활동");
        p5.contents.add("웨어러블형 밴드와 연결하여 사용자의 실시간 심박수를 수신하여 확인할 수 있습니다.");

        Index p6 = new Index("2-5. 혈당계");
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
        switch (v.getId()){
            case R.id.index_no1:
                scrollview.post(new Runnable() {
                    public void run() {
                        scrollview.smoothScrollTo(index_no1.getScrollX(), index_no1.getScrollY());
                    }
                });
                break;
            case R.id.index_no2_1:
                int positionY1 = index_no2_1.getTop();

                break;
            case R.id.index_no2_2:
                int positionY2 = index_no2_2.getTop();

                break;
            case R.id.index_no2_3:
                int positionY3 = index_no2_3.getTop();

                break;
            case R.id.index_no2_4:
                int positionY4 = index_no2_4.getTop();

                break;
            case R.id.index_no2_5:
                int positionY5 = index_no2_5.getTop();

                break;
        }
    }
}
