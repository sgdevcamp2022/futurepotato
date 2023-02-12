package com.example.smg_insta;

import static java.lang.Integer.parseInt;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

public class StoryFrag extends Fragment {

    private View view;
    private CircleImageView profileImage;
    private TextView userId;
    private AdapterViewFlipper viewFlipper;
    private ImageView btn_back, btn_menu, btn_add;


    ArrayList <String> storyImages = new ArrayList<>();     // 번들로 받아올 image
    List<StoryResponse.StoryList> storyLists = new ArrayList<>();   // 스토리 조회해서 저장할 스토리 리스트
    StoryResponse storyResponse;
    String accountId;
    String storyId;

    Service dataService = new Service();
    int delay;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.story, container, false);

        profileImage = view.findViewById(R.id.civ_stroy_profile);
        userId = view.findViewById(R.id.tv_story_userId);
        viewFlipper = view.findViewById(R.id.avf_story);
        btn_back = view.findViewById(R.id.iv_btn_storyBack);
        btn_menu = view.findViewById(R.id.iv_story_bar);
        btn_add = view.findViewById(R.id.iv_story_add);

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

        //------------

        Bundle bundle = getArguments();
        if(bundle != null){
            storyImages = bundle.getStringArrayList("image");
        }
        accountId = PreferenceManager.getString(getActivity(), "accountID");

        viewFlipper.setAdapter(new StorySliderAdapter(getContext(), storyLists));

        viewFlipper.startFlipping();

        // 내 스토리 조회하기
        dataService.story.SelectStory(accountId).enqueue(new Callback<StoryResponse>() {
            @Override
            public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                if(response.isSuccessful()) {
                    storyResponse = response.body();

                    // 프로필 이미지 설정
                    Glide.with(getContext())
                            .load(storyResponse.getProfileImage())
                            .into(profileImage);
                    // 유저 아이디 설정
                    userId.setText(storyResponse.getName());

                    // 일단 스토리 하나만 올린다고 가정했을때....
                    storyLists = storyResponse.getStoryImage();
                    viewFlipper.setAdapter(new StorySliderAdapter(requireContext().getApplicationContext(), storyLists));

                    viewFlipper.startFlipping();
                }
            }
            @Override
            public void onFailure(Call<StoryResponse> call, Throwable t) {t.printStackTrace();}
        });

        // 누르고 있으면..
        viewFlipper.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) { //눌렀을 때 동작
                    viewFlipper.stopFlipping();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) { //뗐을 때 동작
                    viewFlipper.startFlipping();
                }
                return false;
            }
        });




//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                이동
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                fragmentManager.beginTransaction().remove(StoryFrag.this).commit();
//                fragmentManager.popBackStack();
//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                Frag1 mainFrag = new Frag1();
//                transaction.replace(R.id.main_frame, mainFrag).commit();

//            }
//        }, 4000); // 4초후에


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                // 스토리 포스트 이미지 수정하기!!
                // 차라리 이미지 뷰랑 삭제 버튼 같이 있도록 해서.. 클릭시 스토리 아이디 얻어서 삭제하도록..
                // 아니면 꾹 눌렀을 떄,, 삭제 버튼 뜨도록 하는 것도 괜찮을 듯..!!


            }
        });


        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(getContext(), btn_menu); //팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.story_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 스토리 삭제
                                //

                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });


        return view;
    }
}
