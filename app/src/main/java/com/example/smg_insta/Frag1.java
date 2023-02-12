package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.RVAdapter_post;
import com.example.smg_insta.Adapter.RVAdapter_story;
import com.example.smg_insta.DTO.MainPageResponse;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag1 extends Fragment {

    private View view;
    //private TextView id, profile, content, like, explain, comment_count;
    private CircleImageView myStory;
    private LinearLayout searchBox;

    private RecyclerView mRV_post;
    //private RVAdapter_post mRVAdapter_post;  serAdapter함수 만ㄷ르어서 사용함.
    private RecyclerView mRV_story;
    private RVAdapter_story mRVAdapter_story;

    Service dataService = new Service();
    MainPageResponse feeds;
    String accountId;
    List<MainPageResponse.Post> posts;
    List<MainPageResponse.Story> stories;
    Uri storyImageUri;   // 스토리
    String text;      // 검색 내용

    List<String> MyStories = new ArrayList<>(); // 내 스토리 담아둘 곳
    
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag1, container, false);

        accountId = PreferenceManager.getString(getActivity(), "accountID");

        searchBox = view.findViewById(R.id.lL_searchBox);

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
//        id = view.findViewById(R.id.tv_post_profile);
//        profile = view.findViewById(R.id.civ_profile);
//        content = view.findViewById(R.id.img_post_content);
//        like = view.findViewById(R.id.tv_like_count);
//        explain = view.findViewById(R.id.tv_explain);
//        comment_count = view.findViewById(R.id.tv_comment_count);

        mRV_post = view.findViewById(R.id.recyclerview_post);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRV_post.setLayoutManager(layoutManager);


        //----story----
        myStory = view.findViewById(R.id.civ_myStory);
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
                Log.e("Feed", response.body()+"");

                if(feeds != null) {
                    posts = feeds.getPostList();
                    stories = feeds.getStoryList();

                    setPostAdapter(mRV_post);
                    setStoryAdapter(mRV_story);
                }

            }

            @Override
            public void onFailure(Call<MainPageResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

        // 짧게 눌렀을 때, 스토리 확인
        myStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 내 스토리가 있는지 확인
                // stories를 불러오지 못해서 에러뜨는 듯..?
                //for(int i = 0; i < stories.size(); i++) {
                //    if (stories.get(i).getName().equals(accountId)){
                //        MyStories.add(stories.get(i).getImage());
                //    }
                //}

                MyStories.add("mystory");   //test용
                
                // 내 스토리가 있으면
                if (MyStories.size() > 0) {
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    StoryFrag storyFrag = new StoryFrag();

                    Bundle bundle = new Bundle();
                    // 스토리 조회할 때, 이미지가 필요한데... 으잉??
                    // 개인 스토리 따로 뺄 수 있는지 얘기해보기! -> accountId로 조회?
                    bundle.putStringArrayList("image", (ArrayList<String>) MyStories);
                    storyFrag.setArguments(bundle);
                    transaction.replace(R.id.main_frame, storyFrag).addToBackStack(null).commit();

                } else {    // 스토리가 없으면
                    Toast.makeText(getContext(), "길게 눌러서 스토리를 생성하세요..", Toast.LENGTH_LONG).show();


                }
            }
        });

        // 길게 눌렀을 때, 스토리 생성
        myStory.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // 사진 선택
                //갤러리 호출
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                activityResultLauncher.launch(intent);

                // 스토리 생성
                dataService.story.InsertStory(accountId, storyImageUri.toString()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 스토리 생성 성공
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                });


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



        return view;
    }


    void setPostAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_post(posts, getContext(), dataService));
    }

    void setStoryAdapter(RecyclerView feedResponse_list) {
        feedResponse_list.setAdapter(new RVAdapter_story(stories, getContext(), dataService));
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        if(data == null){   // 어떤 이미지도 선택하지 않은 경우
                            Toast.makeText(getContext(), "이미지를 선택하지 않았습니다.", Toast.LENGTH_LONG).show();
                        }
                        else{   // 이미지를 선택한 경우
                            Log.e("single choice: ", String.valueOf(data.getData()));
                            storyImageUri = data.getData();
                        }
                    }
                }
            }
    );
}
