package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import static com.example.smg_insta.Frag3.getFullPathFromUri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.RVAdapter_post;
import com.example.smg_insta.Adapter.RVAdapter_story;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.DTO.MainPage_test_Response;
import com.example.smg_insta.DTO.StoryResponse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag1 extends Fragment {

    private View view;
    private CircleImageView myStory;
    private LinearLayout searchBox;

    private RecyclerView mRV_post;
    private RecyclerView mRV_story;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    Service dataService = new Service();
    String accountId;
    List<MainPage_test_Response.Post_test> posts;
    List<MainPage_test_Response.Story_test> stories;

    List<String> MyStories = new ArrayList<>(); // 내 스토리 담아둘 곳
    Boolean isMyStories = false;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        accountId = PreferenceManager.getString(getActivity(), "accountID");

        searchBox = view.findViewById(R.id.lL_searchBox);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_main);

        mRV_post = view.findViewById(R.id.recyclerview_post);
        mRV_post.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRV_post.setLayoutManager(layoutManager);

        myStory = view.findViewById(R.id.civ_myStory);      // story
        mRV_story = view.findViewById(R.id.recyclerview_story);
        mRV_story.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false)); // 가로 리싸이클러뷰


        // postList 가져오기
        getPostList(accountId);


        // 스토리 리스트 가져오기
        dataService.selectMainPage.GetMainStory(accountId).enqueue(new Callback<MainPage_test_Response>() {
            @Override
            public void onResponse(Call<MainPage_test_Response> call, Response<MainPage_test_Response> response) {
                if(response.isSuccessful()) {
                    Log.e("Feed-Story", "Story 성공");

                    stories = response.body().getStoryList();
                    if(stories != null) {
                        setStoryAdapter(mRV_story);
                    }

                }
            }

            @Override
            public void onFailure(Call<MainPage_test_Response> call, Throwable t) {
                t.printStackTrace();
                Log.e("Feed-Story", "실패");
            }
        });


        // 짧게 눌렀을 때, 스토리 확인
        myStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 내 스토리가 있는지 확인
                dataService.story.SelectStory(accountId).enqueue(new Callback<StoryResponse>() {
                    @Override
                    public void onResponse(Call<StoryResponse> call, Response<StoryResponse> response) {
                        if(response.isSuccessful()) {
                            if(response.body().getStoryImage().size() > 0) {
                                Intent intent = new Intent(getActivity(), StoryActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getContext(), "길게 눌러서 스토리를 생성하세요..", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<StoryResponse> call, Throwable t) {

                    }
                });

            }
        });

        // 길게 눌렀을 때, 스토리 생성
        myStory.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                StoryPostFrag storyPostFrag = new StoryPostFrag();
                Bundle bundle = new Bundle();
                transaction.replace(R.id.main_frame, storyPostFrag).addToBackStack(null).commit();

                return true;
            }
        });

        // 검색 기능!
        searchBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });

        // 새로고침 기능
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //아래도 당겼을 때 다시 로드하는 코드추가
                getPostList(accountId);
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        return view;
    }



    private void getPostList(String id) {
        dataService.selectMainPage.GetMainPost(id).enqueue(new Callback<MainPage_test_Response>() {
            @Override
            public void onResponse(Call<MainPage_test_Response> call, Response<MainPage_test_Response> response) {
                if(response.isSuccessful()) {
                    Log.e("Feed-post", "post 성공");
                    posts = response.body().getPostList();
                    for(int i = 0; i < posts.size(); i++) {
                        Log.e("Feed-post", "content"+i+": "+posts.get(i).getContent());
                    }
                    if(posts != null) {
                        setPostAdapter(mRV_post);
                    }

                }
            }
            @Override
            public void onFailure(Call<MainPage_test_Response> call, Throwable t) {
                t.printStackTrace();
                Log.e("Feed-post", "실패");
            }
        });


    }


    void setPostAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_post(posts, getContext(), dataService));
    }

    void setStoryAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_story(stories, getContext(), dataService));
    }
}
