package com.dreamwalker.diabeteseducation.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.dreamwalker.diabeteseducation.R;
import com.dreamwalker.diabeteseducation.adapter.YoutubeAdapter;
import com.dreamwalker.diabeteseducation.model.YoutubeItem;

import java.util.ArrayList;
import java.util.List;

public class EduYoutubeActivity extends AppCompatActivity implements YoutubeAdapter.YoutubeViewClickListener {
    String youtube_link[] = {
            // 질병관리본부(1)
            "https://www.youtube.com/watch?v=IVaW-aJZ9Vo&t=29s"
            // 삼성서울병원(9)
            , "https://www.youtube.com/watch?v=raciLwP--L0", "https://www.youtube.com/watch?v=s5tbhH8bwEI", "https://www.youtube.com/watch?v=7NDAbacKVqQ"
            , "https://www.youtube.com/watch?v=xIY46uFujZQ", "https://www.youtube.com/watch?v=cnmMqfAliGU", "https://www.youtube.com/watch?v=glte-8TI4L4"
            , "https://www.youtube.com/watch?v=2fKh70kh9tM&t=11s", "https://www.youtube.com/watch?v=19HG-_vNEAU&t=4s", "https://www.youtube.com/watch?v=2A1qBDpbQEs"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtube);
        setStatusbar();
        setToolbar();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<YoutubeItem> youtubeList = new ArrayList<>();
        // 질병관리본부
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_01, "[질병관리본부 - 심뇌혈관질환예방관리]_인포그래픽 동영상_'13년_당뇨병편"));
        // 삼성서울병원
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_02, "으랏차차_당뇨_1_당신의 혈당은 안녕하십니까 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_03, "으랏차차_당뇨_2_당뇨병, 피할 수 있는 방안은 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_04, "으랏차차_당뇨_3_당뇨병 전단계를 관리하는 법 - 내분비대사내과 김재현 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_05, "으랏차차_당뇨_4_당뇨,발견했다면 이것만은 챙기자 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_06, "으랏차차_당뇨_5_당뇨관리, 밥상과 운동에 답이 있다 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_07, "으랏차차_당뇨_6_당뇨에 관한 10가지 오해와 진실 - 내분비대사내과 허규연 교수[의료진 ON Line 강의]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_08, "자가혈당측정 똑똑하게 활용하기[환자설명자료]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_09, "저혈당의 예방과 치료[환자설명자료]"));
        youtubeList.add(new YoutubeItem(R.drawable.youtube_image_10, "뇌졸중과 당뇨병은 어떤 연관성이 있나요?[1분 메디캠_뇌졸중 편]"));
        YoutubeAdapter mYouItems = new YoutubeAdapter(youtubeList);
        mYouItems.setOnClickListener(this);
        recyclerView.setAdapter(mYouItems);
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

    @Override
    public void onItemClicked(int position) {
//        Toast.makeText(getApplicationContext(), "선택값 = " + position, Toast.LENGTH_SHORT).show();
        onURL(youtube_link[position]);
    }

    public void onURL(String link) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
}
