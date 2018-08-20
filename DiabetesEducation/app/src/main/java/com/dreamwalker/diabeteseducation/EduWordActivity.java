package com.dreamwalker.diabeteseducation;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EduWordActivity extends AppCompatActivity implements MyRecyclerAdapter.MyRecyclerViewClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private MyRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_word);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(false);

        // 레이아웃 매니저로 LinearLayoutManager를 설정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // 표시할 임시 데이터
        List<CardItem> dataList = new ArrayList<>();
        dataList.add(new CardItem("당뇨병"));
        dataList.add(new CardItem("공복혈당"));
        dataList.add(new CardItem("저혈당"));
        dataList.add(new CardItem("당화혈색소"));
        dataList.add(new CardItem("당뇨 지식"));
        dataList.add(new CardItem("자가 간호"));
        dataList.add(new CardItem("당뇨 자기 관리"));
        dataList.add(new CardItem("혈당강하제"));
        dataList.add(new CardItem("내당능장애"));
        dataList.add(new CardItem("동맥경화"));
        dataList.add(new CardItem("포도당"));
        dataList.add(new CardItem("인슐린"));
        dataList.add(new CardItem("당부하검사"));
        dataList.add(new CardItem("인슐린 저항성"));
        dataList.add(new CardItem("고혈압"));
        dataList.add(new CardItem("...etc"));

        // 어댑터 설정
        mAdapter = new MyRecyclerAdapter(dataList);
        mAdapter.setOnClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClicked(int position) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // 제목설정
        alertDialogBuilder.setTitle(title(position));
        alertDialogBuilder
                .setMessage(content(position))
                .setCancelable(false)
                .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // 프로그램을 종료한다
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        }

        String title(int position){
        String[] str_title = {"당뇨병","공복혈당",
                "저혈당", "당화혈색소", "당뇨 지식", "자가 간호",
                "당뇨 자기 관리", "혈당강하제", "내당능장애", "동맥경화",
                "포도당", "인슐린" , "당부하검사", "인슐린 저항성",
                "고혈압", "다갈", "다뇨", "다식",
                "etc"};
        return str_title[position];
        }

        String content(int position){
        String[] str_content = {
                // 책갈피, 구분하기 편하게
                // 당뇨병
                "혈액 속의 포도당 수치가 정상인보다 높아 몸에서 포도당이 소변으로 배출됩니다.",
                "8시간 이상 칼로리 섭취를 하지 않고 정맥에서 채혈해서 뽑은 혈액입니다.",
                // 저혈당
                "혈당이 70mg/dL 이하로 내려가는 경우를 말하며, 대개 관련 증상이 있습니다.",
                "혈당이 증가되어 적혈구에 있는 혈색소에 포도당이 붙은 상태를 말한다. 지난 2-3개월간의 평균 혈당 농도를 정확히 파악할 수 있는 측정 수치이다.",
                "당뇨병의 병인, 증상 및 질병 조절을 위한 처방 지침에 대한 환자의 지식의 정도를 의미한다.",
                "성숙되어 가는 개인 자신의 생명과 건강한 기능 상태를 유지하고 개인적 발전의 지속과 안녕을 이루기 위하여 시작하고 수행하는 행위를 의미한다.",
                // 당뇨 자기 관리
                "스스로 식이나 운동 등 생활 습관을 관리하고 혈당을 모니터링하는 자기관리를 실천하는 것을 의미힌다.",
                "당뇨병으로 인한 혈당을 내래기 위해 먹는 약이다.",
                "혈당치가 정상과 당뇨병의 중간에 있음을 의미한다. 당뇨병이 심하지 않다고 하여도 동맥경화증을 일으킬 수 있으므로 반드시 치료해야 한다.",
                "혈관 내벽에 생기며 점차 혈관을 좁게하는 문제점이 있다.",
                // 포도당
                "체내에서 연료로 사용되는 당의 가장 단순한 형태로 탄수화물의 소화를 통해 만들어지며 혈액을 통해 세포로 운반된다.",
                "혈당이 세포 안으로 들어갈 수 있도록 세포의 잠긴 문(수용체)을 열어주는 열쇠와 같은 작용을 하여 혈당을 정상 범위로 유지시켜 주는 역할을 합니다.",
                "당뇨병 검사법 중의 하나로 당뇨, 임신성 당뇨, 당대사이상 등을 정확하게 진단할 수 있다.",
                "몸에서 인슐린의 적용이 감소된 것을 의미한다. 인슐린의 기능이 떨어져 세포가 포도당을 효과적으로 연소하지 못하는 것을 말한다.",
                // 고혈압
                "혈압이 정상치보다 높으면 고혈압이라고 한다.",
                "몹시 갈증이 나는 것을 말한다.",
                "소변을 보통 때와 달리 많이 누는 것을 말한다.",
                "많이 먹는 증상이다.",
                // etc
                "추가예정"};

        return str_content[position];
        }
}