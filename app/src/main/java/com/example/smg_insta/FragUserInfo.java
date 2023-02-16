package com.example.smg_insta;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.RVAdapter_profile;
import com.example.smg_insta.DTO.MypageResponse;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragUserInfo extends Fragment {

    private View view;

    private ImageView btn_back, btn_menu;
    private CircleImageView profileImage;
    private TextView userId, userName, postCount, follower, following;
    private Button btnFollow, btnUnfollow;
    private LinearLayout linearLayout_follower, linearLayout_following;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mGridLayoutManager;

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

        myId = PreferenceManager.getString(getActivity(),"accountID");

        // 1. 뒤로가기
        // remove하니까 빈 화면 떠서.. 메인페이지로 넘어가게끔 했는데
        // FragUserInfo로 넘어오는 화면이?
        // (1) 메인 피드 아이디 선택했을 때
        // (2) 검색 했을 때
        btn_back = view.findViewById(R.id.iv_btn_back_userInfo);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Frag1 mainPage = new Frag1();
                transaction.replace(R.id.main_frame, mainPage).commit();
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
                        if(response.isSuccessful() && response.body()) {
                            // 차단 해제
                            //PopupMenu 객체 생성
                            PopupMenu popup= new PopupMenu(getActivity(), btn_menu); //두 번째 파라미터가 팝업메뉴가 붙을 뷰
                            popup.getMenuInflater().inflate(R.menu.unblock_popup, popup.getMenu());

                            //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {

                                    switch (menuItem.getItemId()){
                                        case R.id.menu_unblock:
                                            // block 해제 하기
                                            dataService.graph.unblock(myId, id).enqueue(new Callback<ResponseBody>() {
                                                @Override
                                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                                    if(response.isSuccessful()) {
                                                        Toast.makeText(getContext(), "차단을 해제하였습니다.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(getContext(), "errorCode: " + response.code(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }

                                                @Override
                                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                                    t.printStackTrace();
                                                }
                                            });
                                            break;
                                    }
                                    return false;
                                }
                            });
                            popup.show();
                            
                        } else {    // !response.isSuccessful() 해도 일단 차단하기 뜸ㅋㅋㅋㅋ
                            // 차단하기
                            //PopupMenu 객체 생성
                            PopupMenu popup= new PopupMenu(getActivity(), btn_menu); //두 번째 파라미터가 팝업메뉴가 붙을 뷰
                            popup.getMenuInflater().inflate(R.menu.block_popup, popup.getMenu());

                            //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {

                                    switch (menuItem.getItemId()){
                                        case R.id.menu_block:
                                            // block 해제 하기
                                            dataService.graph.block(myId, id).enqueue(new Callback<ResponseBody>() {
                                                @Override
                                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                                    if(response.isSuccessful()) {
                                                        Toast.makeText(getContext(), id + "님을 차단을 차단 하였습니다.", Toast.LENGTH_SHORT).show();
                                                    } else {
                                                        Toast.makeText(getContext(), "errorCode: " + response.code(), Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                                @Override
                                                public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace(); }
                                            });
                                            break;
                                    }
                                    return false;
                                }
                            });
                            popup.show();

                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {t.printStackTrace();}
                });

            }
        });


        // feed 사진 띄우기
        mRecyclerView = view.findViewById(R.id.recyclerview_user_profile);
        mRecyclerView.setHasFixedSize(true);
        //3분할로 화면을 나타냄
        mGridLayoutManager = new GridLayoutManager(getContext(),3);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        //-------test
        List<MypageResponse.MyImage> images = new ArrayList<>();
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg", 12, true));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg", 14, false));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg", 20, true));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg", 21, false));
        images.add(new MypageResponse.MyImage("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg", 30, false));

        mRecyclerView.setAdapter(new RVAdapter_profile(images, getContext(), dataService));
        //----


        // 3. 유저 정보 + feed 사진 띄우기
        profileImage = view.findViewById(R.id.iv_user_profile);
        userId = view.findViewById(R.id.tv_userInfo_id);
        userId.setText(id); // onResponse안에도 아이디 설정해놨지만,, 번들값으로 넘어오니까 일단설정함. 지워도 상관x
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
                    if(data.getProfileImage() != null) {
                        Glide.with(getActivity())
                                .load(data.getProfileImage())
                                .into(profileImage);
                    }

                    // 유저 아이디/이름
                    userId.setText(data.getAccountId());
                    userName.setText(data.getName());

                    // count
                    postCount.setText(data.getPostCount()+"");
                    follower.setText(data.getFollowerCount()+"");
                    following.setText(data.getFollowingCount()+"");

                    // feed들
                    mRecyclerView.setAdapter(new RVAdapter_profile(data.getImageList(), getContext(), dataService));
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
                            Toast.makeText(getContext(), "언팔 ㅅ성공", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "ErrorCode: "+response.code(), Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(getContext(), "팔로우 성공", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getContext(), "ErrorCode: "+response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                });
            }
        });

        // 5. 팔로워, 팔로잉 클릭시 리스트 확인
        linearLayout_follower = view.findViewById(R.id.lL_user_follower);
        linearLayout_following = view.findViewById(R.id.lL_user_following);
        linearLayout_follower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FollowActivity.class);
                intent.putExtra("NUM_PAGES", 0);
                intent.putExtra("userId", id);
                startActivity(intent);
            }
        });
        linearLayout_following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FollowActivity.class);
                intent.putExtra("NUM_PAGES", 1);
                intent.putExtra("userId", id);
                startActivity(intent);
            }
        });

        
        


        return view;
    }

    public void checkFollow(String SenderId, String recipientId) {
        dataService.graph.isFollowing(SenderId, recipientId).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(response.isSuccessful()) {
                    if (response.body()) {
                        // 팔로우 하고 있을 때
                        // 버튼 팔로잉(회색) 으로 바꾸기
                        btnFollow.setVisibility(View.GONE);
                        btnUnfollow.setVisibility(View.VISIBLE);
                        Toast.makeText(getContext(), "현재 팔로우하고 있음, 팔로잉 버튼", Toast.LENGTH_LONG).show();
                    } else {
                        //팔로우 안하고 있을 때
                        dataService.graph.isFollowing(recipientId, SenderId).enqueue(new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                                if (response.isSuccessful() && response.body()) {
                                    // 맞팔하기 버튼 추가하기

                                    Toast.makeText(getContext(), "현재 팔로우ㄴ, 근데 쟤는 나 팔로우, 맞팔 버튼 추가", Toast.LENGTH_LONG).show();
                                } else {
                                    // 팔로우 버튼
                                    btnFollow.setVisibility(View.VISIBLE);
                                    btnUnfollow.setVisibility(View.GONE);
                                    Toast.makeText(getContext(), "현재 팔로우ㄴㄴ, 팔로우버튼", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                t.printStackTrace();
                            }
                        });
                    }
                } else {
                    Toast.makeText(getContext(), "isFollowing error: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {t.printStackTrace();}
        });


    }
}
