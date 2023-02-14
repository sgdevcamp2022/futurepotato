package com.example.smg_insta;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.BlockerListAdapter;
import com.example.smg_insta.Adapter.BlockingListAdapter;
import com.example.smg_insta.DTO.FollowListResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag_blockList extends Fragment {

    private ImageView btn_back;
    private TextView title, explain;
    private RecyclerView mRecyclerView;

    private String accountID;

    Service dataService = new Service();
    ArrayList<FollowListResponse.Follow> blockList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.frag_block_list, container, false);

        accountID = PreferenceManager.getString(getActivity(), "accountID");

        btn_back = view.findViewById(R.id.iv_blockList_back);
        title = view.findViewById(R.id.tv_blockList);
        explain = view.findViewById(R.id.tv_none_blockList);

        mRecyclerView = view.findViewById(R.id.rv_blockList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        Bundle bundle = getArguments();
        //Blocking 목록 조회
        if (bundle.getString("Block").equals("Blocking")) {
            title.setText("차단된 계정");
            dataService.graph.getBlockingList(accountID).enqueue(new Callback<FollowListResponse>() {
                @Override
                public void onResponse(Call<FollowListResponse> call, Response<FollowListResponse> response) {
                    if(response.isSuccessful()) {
                        blockList = response.body().getData();
                        if(blockList.size() == 0) {
                            explain.setVisibility(View.VISIBLE);
                            Toast.makeText(getContext(), "연결 성공: 차단된 계정 없음", Toast.LENGTH_LONG).show();
                        } else {
                            explain.setVisibility(View.GONE);
                            mRecyclerView.setAdapter(new BlockingListAdapter(blockList, getContext(), dataService));
                            Toast.makeText(getContext(), "연결 성공.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getContext(), "followerList Error: " + response.code(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<FollowListResponse> call, Throwable t) {
                    t.printStackTrace();
                    Log.e("TAG", t.getMessage());
                    Toast.makeText(getContext(), "연결 실패.", Toast.LENGTH_LONG).show();
                }
            });


        } else {    // Blocker 목록 조회
            title.setText("차단한 계정");
            dataService.graph.getBlockerList(accountID).enqueue(new Callback<FollowListResponse>() {
                @Override
                public void onResponse(Call<FollowListResponse> call, Response<FollowListResponse> response) {
                    if(response.isSuccessful()) {
                        blockList = response.body().getData();
                        if(blockList.size() == 0) {
                            explain.setVisibility(View.VISIBLE);
                            Toast.makeText(getContext(), "연결 성공: 차단한 계정 없음", Toast.LENGTH_LONG).show();
                        } else {
                            explain.setVisibility(View.GONE);
                            mRecyclerView.setAdapter(new BlockerListAdapter(blockList, getContext(), dataService));
                            Toast.makeText(getContext(), "연결 성공.", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getContext(), "followerList Error: " + response.code(), Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                public void onFailure(Call<FollowListResponse> call, Throwable t) {
                    t.printStackTrace();
                    Toast.makeText(getContext(), "연결 실패.", Toast.LENGTH_LONG).show();
                }
            });
        }

        // 뒤로 가기 버튼 눌렀을 떄.
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Frag5 profileFrag = new Frag5();
                transaction.replace(R.id.main_frame, profileFrag).commit();
            }
        });


        return view;
    }
}
