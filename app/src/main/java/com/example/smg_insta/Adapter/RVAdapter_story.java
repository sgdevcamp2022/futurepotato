package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RVAdapter_story extends RecyclerView.Adapter<RVAdapter_story.ViewHolder> {
    Context context;
    private List<MainPageResponse.Story> data;
    private Service dataService;

    String bundleImage;

    public RVAdapter_story(List<MainPageResponse.Story> data, Context context, Service dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public RVAdapter_story.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_item, parent, false);
        return new RVAdapter_story.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter_story.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(data.get(position));

        holder.storyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 스토리 어떻게 띄울지...
                bundleImage = data.get(position).getImage();


            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView storyImage;
        TextView storyId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyImage = itemView.findViewById(R.id.civ_storyImage);
            storyId = itemView.findViewById(R.id.tv_storyId);

        }

        void onBind(MainPageResponse.Story item){
            Glide.with(context)
                    .load(item.getProfileImage())
                    .into(storyImage);

            storyId.setText(item.getName());
        }
    }
}