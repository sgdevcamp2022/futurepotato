package com.example.smg_insta;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.RVAdapter_profile;
import com.example.smg_insta.DTO.MypageResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag5 extends Fragment {

    private View view;
    private ImageView btn_addContent, btn_setup, userImage;
    private TextView userId, post, following, follower;
    private RecyclerView account_recyclerview;
    private Button btn_edit_profile;
    private LinearLayout linearLayout_follower, linearLayout_following;

    private GridLayoutManager gridLayoutManager;
    RVAdapter_profile adapter;
    MypageResponse feeds;
    Service dataService = new Service();

    // 로그인시 받아와야 함!!
    String accountId;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_info, container, false);


        //--------마이페이지 테스트 더미데이터-----------------
        MypageResponse testData = new MypageResponse();
        testData.setName("_user1_test_");
        testData.setProfileImage("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        testData.setFollowerCount(101);
        testData.setFollowingCount(95);
        testData.setPostCount(10);

        List<MypageResponse.MyImage> images = new ArrayList<>();
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg", 12, true));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg", 14, false));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg", 20, true));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg", 21, false));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg", 30, false));

        testData.setImageList(images);


        //----------------------------------

        userImage = view.findViewById(R.id.iv_account_profile);
        userId = view.findViewById(R.id.tv_useriInfo_id);
        post = view.findViewById(R.id.tv_postCount);
        following = view.findViewById(R.id.tv_followingCount);
        follower = view.findViewById(R.id.tv_followerCount);

        linearLayout_follower = view.findViewById(R.id.lL_follower);
        linearLayout_following = view.findViewById(R.id.lL_following);


        account_recyclerview = view.findViewById(R.id.recyclerview_profile);
        account_recyclerview.setHasFixedSize(true);
        //3분할로 화면을 나타냄
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        account_recyclerview.setLayoutManager(gridLayoutManager);
        //adapter = new RVAdapter_profile(feeds, getContext(), dataService);
        //account_recyclerview.setAdapter(adapter);

        //-----test----
        adapter = new RVAdapter_profile(images, getContext(), dataService);
        //-------
        account_recyclerview.setAdapter(adapter);

        // 1. mypage 정보 보여주기
        dataService.selectMyPage.SelectMyPage(accountId).enqueue(new Callback<MypageResponse>() {
            @Override
            public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                feeds = response.body();

                List<MypageResponse.MyImage> myImages = feeds.getImageList();
                adapter = new RVAdapter_profile(myImages, getContext(), dataService);

                userId.setText(feeds.getName());
                userImage.setImageURI(Uri.parse(feeds.getProfileImage()));

                post.setText(feeds.getPostCount());
                following.setText(feeds.getFollowingCount());
                follower.setText(feeds.getFollowerCount());

            }

            @Override
            public void onFailure(Call<MypageResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


        // 2. 팔로워 정보 보여주기
        linearLayout_follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        // 3. 팔로잉 정보 보여주기
        linearLayout_following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });


        // 4. 프로필 편집 버튼
        btn_edit_profile = view.findViewById(R.id.btn_edit_profile);
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 프로필 수정 부분!
                // 프로필 수정 화면으로 넘어가기
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                EditProfileFrag editProfileFrag = new EditProfileFrag();

                Bundle bundle = new Bundle();
                //이름은 회원가입할 때 작성하는 듯. 있을수도있고 없을수도있음.
                //bundle.putString("name", name);
                bundle.putString("accountId", accountId);
                // 아니면 게시물 조회에 프로필 사진 추가 부탁
                bundle.putString("profileImage", String.valueOf(userImage));
                editProfileFrag.setArguments(bundle);

                transaction.replace(R.id.main_frame, editProfileFrag).commit();

            }
        });



        // 5. 상단의 플러스 버튼(post추가)과 셋업 버튼(로그아웃)
        btn_addContent = view.findViewById(R.id.btn_addContent);
        btn_setup = view.findViewById(R.id.btn_setup);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        btn_setup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] strChoiceItems = {"로그아웃 하기", "..."};
                builder.setTitle("설정");
                builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        if (position == 0) {
                            // logout 눌렀을 때

                            // 로컬 스토리지에 저장한 토큰값 삭제해야함.
                            //

                            Intent intent = new Intent(getActivity(),LoginActivity.class); //fragment라서 activity intent와는 다른 방식
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(intent);

                        } else if (position == 1) {
                            // ... 눌렀을 때
                        }
                    }
                });
                builder.show();
            }
        });


        btn_addContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] strChoiceItems = {"게시물", "스토리"};
                builder.setTitle("만들기");
                builder.setItems(strChoiceItems, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        if (position == 0) {
                            MainActivity activity = (MainActivity) getActivity(); // 프래그먼트에서 메인엑티비티 접근
                            activity.setFrag(2);

                        } else if (position == 1) {
                            // ... 눌렀을 때
                        }
                    }
                });
                builder.show();
            }
        });


        return view;
    }
}