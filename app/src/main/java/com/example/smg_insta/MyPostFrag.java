package com.example.smg_insta;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FeedResponse;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPostFrag extends Fragment {

    private View view;
    private ImageView btn_back, btn_like, btn_noLike, btn_comment, btn_menuBar;
    private TextView USER_ID, userId, likeCount, commentCount, content;
    private CircleImageView profileImage;
    private ViewPager2 info_img_content;
    private LinearLayout layoutIndicator;

    Service dataService = new Service();
    FeedResponse selectedFeed;
    ArrayList<String> images = new ArrayList<>();

    private int postId;
    private String profile;
    String bundle_id;
    String bundle_profile;
    String bundle_content;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.private_post_view, container, false);

        btn_back = view.findViewById(R.id.iv_comments_back);
        btn_like = view.findViewById(R.id.iv_user_like);
        btn_noLike = view.findViewById(R.id.iv_user_noLike);
        btn_comment = view.findViewById(R.id.iv_user_comment);
        btn_menuBar = view.findViewById(R.id.iv_btn_userPost_bar);

        USER_ID = view.findViewById(R.id.accountId);
        userId = view.findViewById(R.id.tv_post_userProfile);
        likeCount = view.findViewById(R.id.tv_user_like_count);
        commentCount = view.findViewById(R.id.tv_user_comment_count);
        content = view.findViewById(R.id.tv_user_explain);
        profileImage = view.findViewById(R.id.civ_post_userProfile);

        info_img_content = view.findViewById(R.id.sliderViewPager_profile);
        layoutIndicator = view.findViewById(R.id.layoutIndicators_profile);


        Bundle bundle = getArguments();  //번들 받기. getArguments() 메소드로 받음.
        if(bundle != null){
            postId = Integer.parseInt(bundle.getString("postId"));
            profile = bundle.getString("profileImage");
        }

        // 1. 뒤로가기 버튼 구현
        //
        // 넘어오는 화면
        // (1) 마이페이지에서 피드 클릭했을 떄
        // (2) 유저 정보 페이지에서 피드 클릭했을 때
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(MyPostFrag.this).commit();
                fragmentManager.popBackStack();
            }
        });


        // 2. 번들로 받아온 postId로 게시물 조회
        dataService.feed.selectOne(postId).enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                // 성공시
                if(response.isSuccessful()) {
                    selectedFeed = response.body();
                    bundle_id = selectedFeed.getAccountId();
                    userId.setText(bundle_id);
                    likeCount.setText("좋아요 " + selectedFeed.getLikeCount() + "개");
                    commentCount.setText("댓글 " + selectedFeed.getCommentCount() + "개");
                    bundle_content = selectedFeed.getContent();
                    content.setText(selectedFeed.getAccountId() + "  " + bundle_content);

                    // 프로필 이미지
                    Glide.with(getContext())
                            .load(profile)
                            .into(profileImage);

                    // 이미지들
                    images = selectedFeed.getImageList();
                    info_img_content.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                            super.onPageSelected(position);
                            setCurrentIndicator(position);
                        }
                    });
                    setupIndicators(images.size());

                    // 좋아요 버튼 설정
                    if(selectedFeed.isLikesCheck()) {
                        btn_like.setVisibility(View.VISIBLE);
                        btn_noLike.setVisibility(View.GONE);
                    } else {
                        btn_like.setVisibility(View.GONE);
                        btn_noLike.setVisibility(View.VISIBLE);
                    }

                } else {
                    Log.e("TAG", "ErrorCode: " + response.code() + " / " + response.message());
                }
            }
            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {t.printStackTrace();}
        });


        // 3. 좋아요 기능
        btn_noLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 좋아요 API 연결
                //
                //

                btn_like.setVisibility(View.VISIBLE);
                btn_noLike.setVisibility(View.GONE);
            }
        });

        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 좋아요 취소 API 연결
                //
                //

                btn_like.setVisibility(View.GONE);
                btn_noLike.setVisibility(View.VISIBLE);
            }
        });


        // 4. 메뉴 바 눌렀을 때(삭제, 수정)
        btn_menuBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(getContext(), btn_menuBar); //두 번째 파라미터가 팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.post_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 게시물 삭제 시도
                                dataService.feed.DeleteFeed(String.valueOf(userId), postId).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        Toast.makeText(getContext(), "삭제 되었습니다.", Toast.LENGTH_SHORT).show();

                                        // frag5로 가기
                                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                        Frag5 frag5 = new Frag5();
                                        transaction.replace(R.id.main_frame, frag5).commit();

                                    }
                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        t.printStackTrace();
                                        Toast.makeText(getContext(), "삭제 권한이 없습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            case R.id.menu_modify:
                                // 게시물 수정 화면으로 이동
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                UpdateFeedFrag updateFeedFrag = new UpdateFeedFrag();

                                Bundle bundle = new Bundle();
                                //이름은 회원가입할 때 작성하는 듯. 있을수도있고 없을수도있음.
                                //bundle.putString("name", name);
                                bundle.putString("userId", bundle_id);
                                bundle.putString("profileImage", profile);
                                bundle.putStringArrayList("images", images);
                                bundle.putString("content", bundle_content);
                                bundle.putString("postId", String.valueOf(postId));

                                updateFeedFrag.setArguments(bundle);
                                transaction.replace(R.id.main_frame, updateFeedFrag).commit();

                                break;
                        }

                        return false;
                    }
                });

                popup.show();



            }
        });


        // 5. 댓글 버튼 눌렀을 때
        btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // RVAdapter_post -> CommentsActivity 갈 때랑 똑같은 코드 & 똑같은 엑티비티로 넘어가는건데
                // 잘 실행될지 모르겠음..

                Intent intent = new Intent(getActivity(), CommentsActivity.class);
                // myAccountId 랑 postId 가져와야함!!
                intent.putExtra("accountId", bundle_id);
                intent.putExtra("postId", postId);
                startActivity(intent);


            }
        });


        return view;
    }


    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getContext(),
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getContext(),
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getContext(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}
