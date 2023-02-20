package com.example.smg_insta;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.FollowerListAdapter;
import com.example.smg_insta.Adapter.RVAdapter_story;
import com.example.smg_insta.DTO.FollowListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag_follower extends Fragment {

    private RecyclerView mRecyclerView;
    private TextView mTextView;

    Service dataService = new Service();
    String accountID;
    Bundle bundle;

    List<FollowListResponse.Follow> followerData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.follower_list_frag, container, false);

        bundle = getArguments();
        if(bundle != null) {
            accountID = bundle.getString("userId");
        } else {
            accountID = PreferenceManager.getString(getActivity(), "accountID");
        }

        mTextView = view.findViewById(R.id.tv_noFollower);
        mRecyclerView = view.findViewById(R.id.rcv_followerList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        // 리싸이클러뷰 어뎁터 만들어서 연결하기!
        dataService.graph.readFollower(accountID).enqueue(new Callback<FollowListResponse>() {
            @Override
            public void onResponse(Call<FollowListResponse> call, Response<FollowListResponse> response) {
                if(response.isSuccessful()) {
                    followerData = response.body().getData();
                    mRecyclerView.setAdapter(new FollowerListAdapter(followerData, getContext(), dataService));
                    Toast.makeText(getContext(), "연결 성공.", Toast.LENGTH_LONG).show();
                    if(followerData.size() > 0) {
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mTextView.setVisibility(View.GONE);
                    } else {
                        mRecyclerView.setVisibility(View.GONE);
                        mTextView.setVisibility(View.VISIBLE);
                    }
                }
                else {
                    Log.e("followerList Error: ",response.code()+"");
                }
            }

            @Override
            public void onFailure(Call<FollowListResponse> call, Throwable t) {
                t.printStackTrace();
                Log.e("FollowerList Error: ", "연결 실패");
            }
        });



        return view;
    }
}
