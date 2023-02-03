package com.example.smg_insta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.CrudService;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.DTO.MainPageResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag1 extends Fragment {

    private View view;
    private TextView id, profile, content, like, explain, comment_count;

    private RecyclerView mRV_post;
    //private RVAdapter_post mRVAdapter_post;  serAdapter함수 만ㄷ르어서 사용함.
    private RecyclerView mRV_story;
    private RVAdapter_story mRVAdapter_story;

    CrudService dataService = new CrudService();
    MainPageResponse feeds;
    String accountId;
    List<MainPageResponse.Post> posts;
    List<MainPageResponse.Story> stories;


    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        //----post--------
        id = view.findViewById(R.id.tv_post_profile);
        profile = view.findViewById(R.id.img_post_profile);
        content = view.findViewById(R.id.img_post_content);
        like = view.findViewById(R.id.tv_like_count);
        explain = view.findViewById(R.id.tv_explain);
        comment_count = view.findViewById(R.id.tv_comment_count);

        mRV_post = view.findViewById(R.id.recyclerview_post);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRV_post.setLayoutManager(layoutManager);

        //----story----
        mRV_story = view.findViewById(R.id.recyclerview_stroy);
        // 가로 리싸이클러뷰
        mRV_story.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        dataService.selectMainPage.SelectMainPage(accountId).enqueue(new Callback<MainPageResponse>() {
            @Override
            public void onResponse(Call<MainPageResponse> call, Response<MainPageResponse> response) {
                feeds = response.body();
                posts = feeds.getPostList();
                stories = feeds.getStoryList();

                setPostAdapter(mRV_post);
                setStoryAdapter(mRV_story);
            }

            @Override
            public void onFailure(Call<MainPageResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });



        return view;
    }


    void setPostAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_post(posts, getContext(), dataService));
    }

    void setStoryAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_story(stories, getContext(), dataService));
    }
}
