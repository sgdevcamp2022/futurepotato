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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.CrudService;
import com.example.smg_insta.DTO.MypageResponse;

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

    private GridLayoutManager gridLayoutManager;
    RVAdapter_profile adapter;
    MypageResponse feeds;
    CrudService dataService = new CrudService();

    // 로그인시 받아와야 함!!
    String accountId;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_info, container, false);

        userImage = view.findViewById(R.id.iv_account_profile);
        userId = view.findViewById(R.id.tv_useriInfo_id);
        post = view.findViewById(R.id.tv_postCount);
        following = view.findViewById(R.id.tv_followingCount);
        follower = view.findViewById(R.id.tv_followerCount);


        account_recyclerview = view.findViewById(R.id.recyclerview_profile);
        account_recyclerview.setHasFixedSize(true);
        //3분할로 화면을 나타냄
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        account_recyclerview.setLayoutManager(gridLayoutManager);
        //adapter = new RVAdapter_profile(feeds, getContext(), dataService);
        account_recyclerview.setAdapter(adapter);

        dataService.selectMyPage.SelectMyPage(accountId).enqueue(new Callback<MypageResponse>() {
            @Override
            public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                feeds = response.body();
                //adapter = new RVAdapter_profile(feeds, getContext(), dataService);
                List<MypageResponse.MyImage> myImages = feeds.getImageList();
                adapter.setMyImageList(myImages);

                userId.setText(feeds.getName());
                userImage.setImageURI(Uri.parse(feeds.getImage()));

                post.setText(feeds.getPostCount());
                following.setText(feeds.getFollowingCount());
                follower.setText(feeds.getFollowerCount());

            }

            @Override
            public void onFailure(Call<MypageResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });


        // 프로필 편집 버튼
        btn_edit_profile = view.findViewById(R.id.btn_edit_profile);
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 프로필 수정 부분!

            }
        });




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