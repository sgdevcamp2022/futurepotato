package com.example.smg_insta;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsActivity extends AppCompatActivity {

    private View view;
    private RecyclerView mRV_comments;
    //private 어뎁터 추가하기 
    private ImageView Btn_back, Btn_sendComment;
    private EditText et_comment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comments);

        mRV_comments = view.findViewById(R.id.recyclerView_comments);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRV_comments.setLayoutManager(layoutManager);

    }

}
