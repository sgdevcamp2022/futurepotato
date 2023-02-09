package com.example.smg_insta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.MypageResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragUserInfo extends Fragment {

    private View view;

    private ImageView btn_back, btn_menu, profileImage;
    private TextView userId, userName, postCount, follower, following;
    private Button btnFollow, btnUnfollow;
    private RecyclerView mRecyclerView;

    private Service dataService = new Service();
    private Bundle bundle;
    private String myId;    // 사용자 계정 아이디
    private String id;      // 검색한 유저 아이디


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_user_info, container, false);

        bundle = getArguments();
        id = bundle.getString("userId");

        // 1. 뒤로가기
        btn_back = view.findViewById(R.id.iv_btn_back_userInfo);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(FragUserInfo.this).commit();
                fragmentManager.popBackStack();
            }
        });
        
        // 2. 메뉴바 - 차단
        btn_menu = view.findViewById(R.id.btn_setup_userInfo);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // popup띄우기 -> 차단 / 차단 해제 ...
                // 내가 이 user를 차단하고 있는지 확인
                myId = PreferenceManager.getString(getContext(), "accountID");
                dataService.graph.isBlocking(myId, id).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        if(response.body()) {
                            // 차단 해제

                        } else {
                            // 차단하기

                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {t.printStackTrace();}
                });

            }
        });

        

        // 3. 유저 정보
        profileImage = view.findViewById(R.id.iv_user_profile);
        userId = view.findViewById(R.id.tv_userInfo_id);
        userName = view.findViewById(R.id.tv_introduce);
        postCount = view.findViewById(R.id.tv_user_postCount);
        follower = view.findViewById(R.id.tv_user_followerCount);
        following = view.findViewById(R.id.tv_user_followingCount);
        dataService.selectMyPage.SelectMyPage(id).enqueue(new Callback<MypageResponse>() {
            @Override
            public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                if(response.body() != null) {
                    MypageResponse data = response.body();
                    // 프로필 이미지 설정
                    Glide.with(getActivity())
                        .load(data.getProfileImage())
                        .into(profileImage);

                    // 유저 아이디/이름
                    userId.setText(data.getName());

                    // count
                    postCount.setText(data.getPostCount());
                    follower.setText(data.getFollowerCount());
                    following.setText(data.getFollowingCount());
                }

            }

            @Override
            public void onFailure(Call<MypageResponse> call, Throwable t) {t.printStackTrace();}
        });


        // 4. 팔로우 / 팔로우 취소
        btnFollow = view.findViewById(R.id.btn_user_follow);
        btnUnfollow = view.findViewById(R.id.btn_user_unfollow);

        // 먼저 팔로우 여부 확인하고, 팔로우 또는 언팔 버튼 visible 설정.
        // 클릭시 팔로우 또는 팔로우 취소 기능 구현
        checkFollow(myId, id);
        // (1) 팔로잉버튼 클릭시 -> 언팔로우(팔로우 취소)
        btnUnfollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.graph.unfollow(myId, id).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            checkFollow(myId, id);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                });
            }
        });

        // (2) 팔로우 하기
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.graph.follow(myId, id).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            checkFollow(myId, id);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                });
            }
        });


        
        // 5. feed 사진 띄우기
        mRecyclerView = view.findViewById(R.id.recyclerview_user_profile);
        //
        //
        //
        //

        
        


        return view;
    }

    public void checkFollow(String SenderId, String recipientId) {
        dataService.graph.isFollowing(SenderId, recipientId).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.body()) {
                    // 팔로우 하고 있을 때
                    // 버튼 팔로잉(회색) 으로 바꾸기
                    btnFollow.setVisibility(View.GONE);
                    btnUnfollow.setVisibility(View.VISIBLE);
                }

                else {
                    //팔로우 안하고 있을 때
                    dataService.graph.isFollowing(recipientId, SenderId).enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            if(response.body()) {
                                // 맞팔하기 버튼 추가하기


                            } else {
                                // 팔로우 버튼
                                btnFollow.setVisibility(View.VISIBLE);
                                btnUnfollow.setVisibility(View.GONE);
                            }
                        }
                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {t.printStackTrace();}
                    });
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {t.printStackTrace();}
        });


    }
}
