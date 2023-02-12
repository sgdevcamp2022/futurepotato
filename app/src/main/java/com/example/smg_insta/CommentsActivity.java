package com.example.smg_insta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.CommentAdapter;
import com.example.smg_insta.DTO.FeedResponse;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// EditText 키보드 문제 때문에 Activity로 구현함.

public class CommentsActivity extends AppCompatActivity {

    private RecyclerView mRV_comments;
    //private 어뎁터 추가하기 
    private ImageView Btn_back, Btn_sendComment;
    private EditText et_comment;
    private CommentAdapter commentAdapter;

    String comment;
    Service dataService = new Service();
    ArrayList<FeedResponse.Comment> commentList = new ArrayList<>();
    FeedResponse feed;

    // 이 두 값 필요함!!!
    String accountId;
    int postId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        accountId = PreferenceManager.getString(getApplication(), "accountID");

        Intent intent = getIntent();
        //postId = Integer.parseInt(intent.getStringExtra("postId"));

        mRV_comments = findViewById(R.id.recyclerView_comments);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRV_comments.setLayoutManager(layoutManager);



        //------test
        ArrayList<FeedResponse.Reply> repliesTest1 = new ArrayList<>();
        FeedResponse.Reply r_test1 = new FeedResponse.Reply(1, "r1", "답글 테스트1", "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg", "0");
        FeedResponse.Reply r_test2 = new FeedResponse.Reply(2, "r2", "답글 테스트2", "https://cdn.pixabay.com/photo/2019/12/26/10/44/horse-4720178_1280.jpg", "0");
        repliesTest1.add(r_test1);
        repliesTest1.add(r_test2);

        FeedResponse.Comment test1 = new FeedResponse.Comment("test1", "https://cdn.pixabay.com/photo/2020/03/08/21/41/landscape-4913841_1280.jpg", "게시글 댓글 테스트1", 12, 55, "날짜", repliesTest1);
        FeedResponse.Comment test2 = new FeedResponse.Comment("test2", "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg", "게시글 댓글 테스트2", 35, 23, "날짜", new ArrayList<>());
        FeedResponse.Comment test3 = new FeedResponse.Comment("test3", "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg", "게시글 댓글 테스트3", 71, 65, "날짜", new ArrayList<>());

        commentList.add(test1);
        commentList.add(test2);
        commentList.add(test3);


        mRV_comments.setAdapter(new CommentAdapter(commentList, getApplication(), dataService));

        //------------

        // 매번 불러와야 되는건가..?ㅋㅋㅋㅋ
        //readComment(postId);




        et_comment = findViewById(R.id.et_insert_comment);
        Btn_sendComment = findViewById(R.id.iv_commnet_sendBtn);

        Btn_sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // comment에 저장된 내용 POST
                comment = et_comment.getText().toString();
                // accountId 받아와야 함...! -> 아직 못 함.
                //Toast.makeText(getApplicationContext(), "보내기", Toast.LENGTH_LONG).show();

                // 키보드 내리기----> 연동 성공하면 삭제하기
                InputMethodManager mInputMethodManager = (InputMethodManager)getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
                mInputMethodManager.hideSoftInputFromWindow(et_comment.getWindowToken(), 0);
                // et_comment 내용 삭제----> 연동 성공하면 삭제하기
                et_comment.setText(null);
                FeedResponse.Comment test4 = new FeedResponse.Comment("test3", "https://cdn.pixabay.com/photo/2014/03/03/16/15/mosque-279015_1280.jpg",comment , 12, 100, "날짜", new ArrayList<>());
                commentList.add(test4);
                mRV_comments.setAdapter(new CommentAdapter(commentList, getApplication(), dataService));
                //-----------------여기까지 테스트----

                dataService.comment.InsertComment(accountId, postId, comment).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 댓글 쓰기 성공시
                        Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_LONG).show();
                        // 키보드 내리기
                        InputMethodManager mInputMethodManager = (InputMethodManager)getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
                        mInputMethodManager.hideSoftInputFromWindow(et_comment.getWindowToken(), 0);
                        // et_comment 내용 삭제
                        et_comment.setText(null);

                        readComment(postId);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                });

            }
        });


        Btn_back = findViewById(R.id.iv_comments_back);
        Btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    private void readComment(int postId) {
        dataService.feed.selectOne(postId).enqueue(new Callback<FeedResponse>() {
            @Override
            public void onResponse(Call<FeedResponse> call, Response<FeedResponse> response) {
                feed = response.body();
                commentList = feed.getCommentList();
                mRV_comments.setAdapter(new CommentAdapter(commentList, getApplication(), dataService));
            }

            @Override
            public void onFailure(Call<FeedResponse> call, Throwable t) {t.printStackTrace();}
        });

    }

}
