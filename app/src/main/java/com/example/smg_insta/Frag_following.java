package com.example.smg_insta;

import android.os.Bundle;
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
import com.example.smg_insta.Adapter.FollowingListAdapter;
import com.example.smg_insta.DTO.FollowListResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag_following extends Fragment {
    private RecyclerView mRecyclerView;
    private TextView mTextView;

    Service dataService = new Service();
    String accountID;
    Bundle bundle;

    ArrayList<FollowListResponse.Follow> followingData = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.following_list_frag, container, false);

        bundle = getArguments();
        if(bundle != null) {
            accountID = bundle.getString("userId");
        } else {
            accountID = PreferenceManager.getString(getActivity(), "accountID");
        }

        mTextView = view.findViewById(R.id.tv_noFollowing);

        mRecyclerView = view.findViewById(R.id.rcv_followingList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);


        dataService.graph.readFollowing(accountID).enqueue(new Callback<FollowListResponse>() {
            @Override
            public void onResponse(Call<FollowListResponse> call, Response<FollowListResponse> response) {
                if(response.isSuccessful()) {
                    followingData = response.body().getData();
                    mRecyclerView.setAdapter(new FollowingListAdapter(followingData, getContext(), dataService));
                    Toast.makeText(getContext(), "연결 성공.", Toast.LENGTH_LONG).show();

                    if(followingData.size() > 0) {
                        mRecyclerView.setVisibility(View.VISIBLE);
                        mTextView.setVisibility(View.GONE);
                    } else {
                        mRecyclerView.setVisibility(View.GONE);
                        mTextView.setVisibility(View.VISIBLE);
                    }
                }
                else {
                    Toast.makeText(getContext(), "Error code: "+response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FollowListResponse> call, Throwable t) {
                Toast.makeText(getContext(), "연결 실패.", Toast.LENGTH_LONG).show();
            }
        });




        return view;

    }
}
