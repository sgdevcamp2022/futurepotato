package com.example.smg_insta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private TextView btn_cancel;
    private RecyclerView mRecyclerView;

    Service dataService = new Service();
    List<String> result = new ArrayList<>();
    SearchAdapter mSearchAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        mSearchView = findViewById(R.id.sv_search);
        btn_cancel= findViewById(R.id.tv_search_btnBack);
        mRecyclerView = findViewById(R.id.rcv_search);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new SearchAdapter(result, this, dataService));

        mSearchView.setIconified(false);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                // 검색 버튼 누를 때 호출
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                // 검색창에서 글자가 변경이 일어날 때마다 호출
                search(s);

                return true;
            }
        });


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();}
        });
    }

    // 검색을 수행하는 메소드
    public void search(String text) {
        dataService.search.searchUser(text).enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                Log.e("TAG", "response.body(): " + response.body());
                if(response.isSuccessful()) {
                    if (response.body().size() > 0) {
                        mRecyclerView.setAdapter(new SearchAdapter(response.body(), getApplicationContext(), dataService));
                    }
                    else {
                        // 검색 값이 없습니다. 띄우기.. -> textView 추가하기!
                        Toast.makeText(getApplicationContext(), "검색값이 없습니다.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "ErrorCode: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
