package com.example.smg_insta;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.StorySliderAdapter;
import com.example.smg_insta.DTO.StoryResponse;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryActivity extends AppCompatActivity {

    private View view;
    private CircleImageView profileImage;
    private TextView userId;
    private AdapterViewFlipper viewFlipper;
    private ImageView btn_back, btn_add;
    private LinearLayout mLinearLayout;


    ArrayList <String> storyImages = new ArrayList<>();     // 번들로 받아올 image
    ArrayList<StoryResponse.StoryList> storyLists = new ArrayList<>();   // 스토리 조회해서 저장할 스토리 리스트
    StoryResponse storyResponse;

    StoryResponse testStoryResponse;

    String story_userId;
    String storyId;

    GestureDetector detector;

    Service dataService = new Service();
    int delay;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story);

        profileImage = findViewById(R.id.civ_stroy_profile);
        userId = findViewById(R.id.tv_story_userId);
        viewFlipper = findViewById(R.id.avf_story);
        btn_back = findViewById(R.id.iv_btn_storyBack);
        btn_add = findViewById(R.id.iv_story_add);
        mLinearLayout = findViewById(R.id.lL_story);

        //-----------test---
        StoryResponse.StoryList test1 = new StoryResponse.StoryList(12, "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg", "2023-01-01T12:11:00");
        StoryResponse.StoryList test2 = new StoryResponse.StoryList(13, "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg", "2023-01-01T12:11:00");
        StoryResponse.StoryList test3 = new StoryResponse.StoryList(14, "https://cdn.pixabay.com/photo/2020/11/10/01/34/pet-5728249_1280.jpg", "2023-01-01T12:11:00");
        StoryResponse.StoryList test4 = new StoryResponse.StoryList(15, "https://cdn.pixabay.com/photo/2020/12/21/19/05/window-5850628_1280.png", "2023-01-01T12:11:00");
        StoryResponse.StoryList test5 = new StoryResponse.StoryList(16, "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg", "2023-01-01T12:11:00");
        StoryResponse.StoryList test6 = new StoryResponse.StoryList(17, "https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg", "2023-01-01T12:11:00");

        storyLists.add(test1);
        storyLists.add(test2);
        storyLists.add(test3);
        storyLists.add(test4);
        storyLists.add(test5);
        storyLists.add(test6);

        testStoryResponse = new StoryResponse("user123", "https://cdn.pixabay.com/photo/2019/10/15/13/33/red-deer-4551678_1280.jpg", storyLists);

        //------------
        Intent intent = getIntent();
        if(intent.getStringExtra("userId") != null) {
            story_userId = intent.getStringExtra("userId");
            btn_add.setVisibility(View.GONE);   // 내 스토리가 아닌 경우, 추가 버튼 가리기
        } else {
            story_userId = PreferenceManager.getString(getApplication(), "accountID");
            btn_add.setVisibility(View.VISIBLE);
        }

        viewFlipper.setAdapter(new StorySliderAdapter(this, testStoryResponse));
        viewFlipper.startFlipping();

        // 내 스토리 조회하기
        dataService.story.SelectStory(story_userId).enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                if(response.isSuccessful()) {
                    storyResponse = response.body();

                    // 프로필 이미지 설정
                    Glide.with(getApplication())
                            .load(storyResponse.getProfileImage())
                            .into(profileImage);
                    // 유저 아이디 설정
                    userId.setText(storyResponse.getAccountId());

                    // 일단 스토리 하나만 올린다고 가정했을때....
                    //storyLists = storyResponse.getStoryImage();
                    viewFlipper.setAdapter(new StorySliderAdapter(getApplication(), storyResponse));

                    viewFlipper.startFlipping();
                }
            }
            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {t.printStackTrace();}
        });


        // 누르고 있으면..멈춤
        // 눌렀다 뗐을 때 다시 동작..
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();

                if (action == MotionEvent.ACTION_DOWN) { //눌렀을 때 동작
                    viewFlipper.stopFlipping();
                    Log.i("TAG", "stopFlipping");
                }
                if (action == MotionEvent.ACTION_UP) { //뗐을 때 동작
                    viewFlipper.startFlipping();
                    Log.i("TAG", "startFlipping");
                }
                return true;
            }
        });


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                finish();
//            }
//        }, storyLists.size()*3000); // 4초후에


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }


}
