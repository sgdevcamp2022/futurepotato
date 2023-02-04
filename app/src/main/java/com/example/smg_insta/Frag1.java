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
import com.example.smg_insta.Adapter.RVAdapter_post;
import com.example.smg_insta.Adapter.RVAdapter_story;
import com.example.smg_insta.DTO.MainPageResponse;

import java.util.ArrayList;
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

        //---테스트 더미데이터----

        List<MainPageResponse.Post> test_postList = new ArrayList<>();

        List<String> test1 = new ArrayList<>();
        test1.add("https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg");
        test1.add("https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg");
        MainPageResponse.Post testPost1 = new MainPageResponse.Post(12, "user1", "게시물1", "2023-01-01T12:11:00", "2023-01-01T13:11:00", 12, true, 110, test1);
        test_postList.add(testPost1);

        List<String> test2 = new ArrayList<>();
        test2.add("https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg");
        test2.add("https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg");
        test2.add("https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg");
        MainPageResponse.Post testPost2 = new MainPageResponse.Post(123, "user2","게시물2","2023-01-01T12:11:00","2023-01-01T13:11:00",102, false,10,test2);
        test_postList.add(testPost2);


        List<MainPageResponse.Story> test_storyList = new ArrayList<>();
        MainPageResponse.Story test_S1 = new MainPageResponse.Story("user1", "https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg","storyImage");
        MainPageResponse.Story test_S2 = new MainPageResponse.Story("user2", "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg", "storyImage");
        MainPageResponse.Story test_S3 = new MainPageResponse.Story("user3", "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg", "storyImage");

        test_storyList.add(test_S1);
        test_storyList.add(test_S2);
        test_storyList.add(test_S3);
        test_storyList.add(test_S1);
        test_storyList.add(test_S2);
        test_storyList.add(test_S3);



        //---------------------





        //----post--------
        id = view.findViewById(R.id.tv_post_profile);
        profile = view.findViewById(R.id.civ_post_profile);
        content = view.findViewById(R.id.img_post_content);
        like = view.findViewById(R.id.tv_like_count);
        explain = view.findViewById(R.id.tv_explain);
        comment_count = view.findViewById(R.id.tv_comment_count);

        mRV_post = view.findViewById(R.id.recyclerview_post);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRV_post.setLayoutManager(layoutManager);


        //----story----
        mRV_story = view.findViewById(R.id.recyclerview_story);
        // 가로 리싸이클러뷰
        mRV_story.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));


        //-----test-----------------
        mRV_post.setAdapter(new RVAdapter_post(test_postList, getContext(), dataService));
        mRV_story.setAdapter(new RVAdapter_story(test_storyList, getContext(), dataService));
        //-----------------------


        dataService.selectMainPage.SelectMainPage(accountId).enqueue(new Callback<MainPageResponse>() {
            @Override
            public void onResponse(Call<MainPageResponse> call, Response<MainPageResponse> response) {
                feeds = response.body();
                posts = feeds.getPostList();
                stories = feeds.getStoryList();

                //setPostAdapter(mRV_post);
                //setStoryAdapter(mRV_story);
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
