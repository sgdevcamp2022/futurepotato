package com.example.smg_insta.Adapter;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.CommentsActivity;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.R;
import com.example.smg_insta.SearchActivity;

import java.util.List;

import retrofit2.Callback;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private List<String> data;
    private Context context;
    private Service dataService;
    public SearchAdapter(List<String> data, Context context, Service dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;

    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_item, parent, false);
        return new SearchAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mTextView.setText(data.get(position));
        
        // 검색한 유저 정보
        holder.searchItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("searchId", data.get(position));
                context.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK));
            }
        });
        
    }

    @Override
    public int getItemCount()  {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ConstraintLayout searchItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_searchItem);
            searchItem = itemView.findViewById(R.id.cl_searchItem);
        }
    }
}
