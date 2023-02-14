package com.example.smg_insta;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReplyActivity extends AppCompatActivity {

    private ImageView btnBack, btnSend, btnLike, btnNoLike;
    private TextView commentWriter, comment, likeCount, replyCount;
    private CircleImageView commentImage, myImage;
    private EditText myReply;
    private RecyclerView rv_reply;

    String accountId;
    int getCommentId;

    Service dataService = new Service();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reply);

        accountId = PreferenceManager.getString(getApplication(), "accountID");
        Intent intent = getIntent();
        getCommentId = Integer.parseInt(intent.getStringExtra("commentId"));

        commentWriter = findViewById(R.id.tv_replyAct_accountId);
        commentWriter.setText(intent.getStringExtra("commentWriter"));
        comment = findViewById(R.id.replyAct_comment);
        comment.setText(intent.getStringExtra("comment"));
        likeCount = findViewById(R.id.tv_replyAct_commentLikeCount);
        likeCount.setText("좋아요 " + intent.getStringExtra("likeCount") + "개");
        replyCount = findViewById(R.id.tv_replyAct_commentCount);
        replyCount.setText("답글 " + intent.getStringExtra("replyCount") + "개");

        btnBack = findViewById(R.id.iv_replyAct_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();}
        });

        myReply = findViewById(R.id.et_replyAct_insert_reply);
        myReply.requestFocus();
        btnSend = findViewById(R.id.iv_replyAct_reply_sendBtn);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reply = myReply.getText().toString();
                dataService.comment.InsertReply(accountId, getCommentId, reply).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            myReply.setText(null);
                            finish();
                        }
                        else {
                            Log.e("Reply error: ", response.code() + " " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        myReply.setText(null);
                        Log.e("Reply - onFailure: ","답글달기 실패");
                    }
                });


            }
        });

        btnLike = findViewById(R.id.iv_replyAct_comment_like);
        //
        //

        btnNoLike = findViewById(R.id.iv_replyAct_comment_noLike);
        //
        //

        commentImage = findViewById(R.id.civ_replyAct_accountImage);
        Glide.with(this)
                .load(intent.getStringExtra("commentImage"))
                .into(commentImage);

        myImage = findViewById(R.id.civ_replyAct_userImage);
        //
        //










    }
}
