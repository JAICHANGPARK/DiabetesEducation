package com.dreamwalker.diabeteseducation.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.YoutubeAdapter;
import com.dreamwalker.diabeteseducation.model.YoutubeItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class EduYoutubeActivity extends AppCompatActivity implements YoutubeAdapter.YoutubeViewClickListener {
    // TODO 저작권 추가
    private Handler mHandler;
    public TextView mTextView;
    Context mContext;
    String youtube_link[] = {
            // 질병관리본부(1)
            "https://www.youtube.com/watch?v=IVaW-aJZ9Vo&t=29s"
            // 삼성서울병원(9)
            , "https://www.youtube.com/watch?v=raciLwP--L0", "https://www.youtube.com/watch?v=s5tbhH8bwEI", "https://www.youtube.com/watch?v=7NDAbacKVqQ"
            , "https://www.youtube.com/watch?v=xIY46uFujZQ", "https://www.youtube.com/watch?v=cnmMqfAliGU", "https://www.youtube.com/watch?v=glte-8TI4L4"
            , "https://www.youtube.com/watch?v=2fKh70kh9tM&t=11s", "https://www.youtube.com/watch?v=19HG-_vNEAU&t=4s", "https://www.youtube.com/watch?v=2A1qBDpbQEs"
            //
            , "", "http://www.samsunghospital.com/home/healthInfo/main.do"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        mContext = this;
        wifi_alarm();
        setStatusbar();
        setToolbar();
        recyclerview_dduddak();
    }

    // 상태바 색 변경
    public void setStatusbar() {
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

    // 1초 후 와이파이 권장 알람
    public void wifi_alarm(){
        mHandler = new Handler();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 알람
                            AlertDialog.Builder dialog = new AlertDialog.Builder(mContext)
                                    .setTitle("주의")
                                    .setMessage("3G/4G환경에서는 데이터 요금이 발생할 수 있습니다.")
                                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int which) {
                                        }
                                    });
                            dialog.create()
                                    .show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    // 1초 후
                }, 1000);
            }
        });
    }

    // 리사이클러뷰
    public void recyclerview_dduddak(){
        // 리사이클러뷰
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        // 레이아웃매니저
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        // 리스트 생성
        List<YoutubeItem> youtubeList = new ArrayList<>();
        //// 질병관리본부
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_01, "[질병관리본부 - 심뇌혈관질환예방관리]_인포그래픽 동영상_'13년_당뇨병편"));
        //// 삼성서울병원
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_02, "으랏차차_당뇨_1_당신의 혈당은 안녕하십니까 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_03, "으랏차차_당뇨_2_당뇨병, 피할 수 있는 방안은 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_04, "으랏차차_당뇨_3_당뇨병 전단계를 관리하는 법 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_05, "으랏차차_당뇨_4_당뇨,발견했다면 이것만은 챙기자 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_06, "으랏차차_당뇨_5_당뇨관리, 밥상과 운동에 답이 있다 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_07, "으랏차차_당뇨_6_당뇨에 관한 10가지 오해와 진실 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_08, "자가혈당측정 똑똑하게 활용하기[환자설명자료]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_09, "저혈당의 예방과 치료[환자설명자료]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_10, "뇌졸중과 당뇨병은 어떤 연관성이 있나요?[1분 메디캠_뇌졸중 편]"));
        // 출처
        youtubeList.add(new YoutubeItem(R.drawable.img_opentype04, "인포그래픽 동영상_'13년_당뇨병편 저작물은 \n" + "공공누리 제4유형(출처표시+상업적이용금지+변경금지) 조건에 따라 이용할 수 있습니다."));
        youtubeList.add(new YoutubeItem(R.drawable.samsungseoulhospital, "출처 : 삼성서울병원\n" +"더 자세한 정보를 얻고싶다면 홈페이지를 방문해주세요. 클릭시 이동합니다."));

        // 어댑터
        YoutubeAdapter mYouItems = new YoutubeAdapter(youtubeList);
        mYouItems.setOnClickListener(this);
        recyclerView.setAdapter(mYouItems);
    }

    // 리사이클러뷰 클릭 이벤트
    @Override
    public void onItemClicked(int position) {
//        Toast.makeText(getApplicationContext(), "선택값 = " + position, Toast.LENGTH_SHORT).show();
        if(position !=10){
            onURL(youtube_link[position]);
        }
    }

    // 클릭 시 해당 URL 연결
    public void onURL(String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}
