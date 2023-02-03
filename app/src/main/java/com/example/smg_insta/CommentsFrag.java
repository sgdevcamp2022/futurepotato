package com.example.smg_insta;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentsFrag extends Fragment {

    private View view;
    private RecyclerView mRV_comments;
    //private 어뎁터 추가하기 
    private ImageView Btn_back, Btn_sendComment;
    private EditText et_comment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    //프래그먼트 메인을 인플레이트해주고 컨테이너에 붙여달라는 뜻임
        view = (ViewGroup) inflater.inflate(R.layout.comments , container, false);


        mRV_comments = view.findViewById(R.id.recyclerView_comments);
        //mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRV_comments.setLayoutManager(layoutManager);


        return null;
    }
}
