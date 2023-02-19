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
import androidx.fragment.app.FragmentTransaction;
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


        Intent intent = getIntent();
        if(intent.getStringExtra("userId") != null) {
            story_userId = intent.getStringExtra("userId");
            btn_add.setVisibility(View.GONE);   // 내 스토리가 아닌 경우, 추가 버튼 가리기
        } else {
            story_userId = PreferenceManager.getString(getApplication(), "accountID");
            btn_add.setVisibility(View.VISIBLE);
        }

        // 스토리 추가(나만 가능)
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                StoryPostFrag storyPostFrag = new StoryPostFrag();
                Bundle bundle = new Bundle();
                transaction.replace(R.id.main_frame, storyPostFrag).addToBackStack(null).commit();

            }
        });

        //viewFlipper.setAdapter(new StorySliderAdapter(this, testStoryResponse));
        //viewFlipper.startFlipping();

        // 스토리 조회하기
        dataService.story.SelectStory(story_userId).enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                if(response.isSuccessful()) {
                    storyResponse = response.body();

                    // 프로필 이미지 설정
                    if(storyResponse.getProfileImage() != null) {
                        Glide.with(getApplication())
                                .load(storyResponse.getProfileImage())
                                .into(profileImage);
                    }
                    // 유저 아이디 설정
                    userId.setText(storyResponse.getAccountId());

                    // 일단 스토리 하나만 올린다고 가정했을때....
                    //storyLists = storyResponse.getStoryImage();
                    if(storyResponse.getStoryImage() != null) {
                        viewFlipper.setAdapter(new StorySliderAdapter(getApplication(), storyResponse));
                        viewFlipper.startFlipping();
                    }
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
