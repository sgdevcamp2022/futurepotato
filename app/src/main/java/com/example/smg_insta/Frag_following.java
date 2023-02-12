package com.example.smg_insta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        mRecyclerView = view.findViewById(R.id.rcv_followingList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        //------test
        followingData.add(new FollowListResponse.Follow(1, "test2", "nameTest2", "https://cdn.pixabay.com/photo/2020/09/02/18/03/girl-5539094_1280.jpg"));
        followingData.add(new FollowListResponse.Follow(2, "test3", "nameTest3", "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg"));
        followingData.add(new FollowListResponse.Follow(3, "test4", "nameTest4", "https://cdn.pixabay.com/photo/2020/11/04/15/29/coffee-beans-5712780_1280.jpg"));

        mRecyclerView.setAdapter(new FollowingListAdapter(followingData, getContext(), dataService));

        //---------

        dataService.graph.readFollowing(accountID).enqueue(new Callback<FollowListResponse>() {
            @Override
            public void onResponse(Call<FollowListResponse> call, Response<FollowListResponse> response) {
                if(response.isSuccessful()) {
                    //followerData = response.body().getData();
                    mRecyclerView.setAdapter(new FollowingListAdapter(followingData, getContext(), dataService));
                    Toast.makeText(getContext(), "연결 성공.", Toast.LENGTH_LONG).show();
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
