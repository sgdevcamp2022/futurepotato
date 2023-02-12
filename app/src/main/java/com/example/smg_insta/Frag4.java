package com.example.smg_insta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.NoticeAdapter;
import com.example.smg_insta.DTO.NoticeResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// 알림기능 프래그먼트
public class Frag4 extends Fragment {

    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private TextView noAlarm;
    private NoticeAdapter noticeAdapter;

    Service dataService = new Service();
    String accountId;
    List<NoticeResponse> resultData;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_notice, container, false);

        accountId = PreferenceManager.getString(getContext(), "accountID");

        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        mRecyclerView = view.findViewById(R.id.rcv_notice);
        noAlarm = view.findViewById(R.id.tv_noAlarm);

        resultData = new ArrayList<>();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        //----test
        resultData.add(new NoticeResponse(9, "123qq", accountId, "asd", "adf", "123qq님이 내 게시물에 댓글을 달았습니다."));
        resultData.add(new NoticeResponse(9, "est12324", accountId, "asd", "adf", "est12324님이 내 게시물에 좋아요를 눌렀땅."));


        //-------------

        if(resultData.size() <= 0) {
            noAlarm.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
            noAlarm.setText("알림이 없습니다.");
        } else {

            mRecyclerView.setAdapter(new NoticeAdapter(resultData, getContext(), dataService));
            //getNotice(accountId);
            noAlarm.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }

        // 새로고침!
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                 새로고침!
//                 아래도 당겼을 때 다시 로드하는 코드추가
                getNotice(accountId);
//                 리프레쉬 완료
//                swipeRefreshLayout.setRefreshing(false);
            }
        });


        //----리싸이클러뷰 연결하기!!
        //


        return view;
    }

    private void getNotice(String id) {

        dataService.notice.getNoticeList(id).enqueue(new Callback<List<NoticeResponse>>() {
            @Override
            public void onResponse(Call<List<NoticeResponse>> call, Response<List<NoticeResponse>> response) {
                if(response.isSuccessful()) {
                    resultData = response.body();
                    noticeAdapter.clear();
                    noticeAdapter = new NoticeAdapter(resultData, getContext(), dataService);

                    mRecyclerView.setAdapter(noticeAdapter);

                    if(resultData.size() <= 0) {
                        noAlarm.setVisibility(View.VISIBLE);
                        mRecyclerView.setVisibility(View.GONE);
                        noAlarm.setText("알림이 없습니다.");
                    } else {
                        noAlarm.setVisibility(View.GONE);
                        mRecyclerView.setVisibility(View.VISIBLE);
                    }

                } else {
                    Toast.makeText(getContext(), "errorCode: " + response.code(), Toast.LENGTH_LONG).show();
                }

                swipeRefreshLayout.setRefreshing(false);
            }
            @Override
            public void onFailure(Call<List<NoticeResponse>> call, Throwable t) {t.printStackTrace();}
        });
    }
}
