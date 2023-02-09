package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.R;

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
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) context;
                Bundle bundle = new Bundle();
                bundle.putString("userId", data.get(position));
                activity.FragmentViewAddBundle(0, bundle);
            }
        });
        
    }

    @Override
    public int getItemCount()  {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_searchItem);
        }
    }
}
