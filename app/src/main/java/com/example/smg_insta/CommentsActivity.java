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
import com.example.smg_insta.DTO.CommentData;
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

        Intent intent = getIntent();
        // userId가 왜 필요하지?? -> 어디서 넘어오는지 확인!
        if(intent.getStringExtra("userId") != null) {
            accountId = intent.getStringExtra("userId");
            postId = Integer.parseInt(intent.getStringExtra("postId"));
        } else {
            postId = Integer.parseInt(intent.getStringExtra("postId"));
            accountId = PreferenceManager.getString(getApplication(), "accountID");
        }

        mRV_comments = findViewById(R.id.recyclerView_comments);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRV_comments.setLayoutManager(layoutManager);
        //davin baboo

        readComment(postId);


        et_comment = findViewById(R.id.et_insert_comment);
        Btn_sendComment = findViewById(R.id.iv_commnet_sendBtn);

        Btn_sendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comment = et_comment.getText().toString();
                dataService.comment.InsertComment(accountId, postId, comment).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 댓글 쓰기 성공시
                        if(response.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "성공", Toast.LENGTH_LONG).show();
                            // 키보드 내리기
                            InputMethodManager mInputMethodManager = (InputMethodManager)getApplication().getSystemService(Context.INPUT_METHOD_SERVICE);
                            mInputMethodManager.hideSoftInputFromWindow(et_comment.getWindowToken(), 0);
                            // et_comment 내용 삭제
                            et_comment.setText(null);
                            readComment(postId);
                            Toast.makeText(getApplicationContext(), "댓글 성공", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "댓글 오류: " + response.code(), Toast.LENGTH_LONG).show();
                        }
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
