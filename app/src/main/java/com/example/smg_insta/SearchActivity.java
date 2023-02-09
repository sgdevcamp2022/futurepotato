package com.example.smg_insta;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.RVAdapter_post;
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
        //mRecyclerView.setAdapter(new SearchAdapter(result, this, dataService));


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
                if (response.body() != null) {
                    mRecyclerView.setAdapter(new SearchAdapter(response.body(), getApplicationContext(), dataService));
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });

    }
}
