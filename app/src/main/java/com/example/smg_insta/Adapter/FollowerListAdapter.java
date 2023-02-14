package com.example.smg_insta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FollowListResponse;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowerListAdapter extends RecyclerView.Adapter<FollowerListAdapter.ViewHolder>{
    private Context context;
    private List<FollowListResponse.Follow> data;
    private Service dataService;

    public FollowerListAdapter(List<FollowListResponse.Follow> data, Context context, Service dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public FollowerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.cardview_follow, parent, false);
        FollowerListAdapter.ViewHolder vh = new FollowerListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull FollowerListAdapter.ViewHolder holder, int position) {
        // 프로필 이미지
        if(data.get(position).getProfileImage() == null) {
            Glide.with(context)
                    .load(R.drawable.user_default)
                    .into(holder.civ_profile);
        } else {
            Glide.with(context)
                    .load(data.get(position).getProfileImage())
                    .into(holder.civ_profile);
        }
        // 아이디
        holder.tv_id.setText(data.get(position).getAccountId());


    }

    @Override
    public int getItemCount()  {return data.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView civ_profile;
        TextView tv_id;
        Button btn_delete, btn_follow;
        ImageView btn_bar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            civ_profile = itemView.findViewById(R.id.civ_follow_profile);
            tv_id = itemView.findViewById(R.id.tv_followId);

            // 팔로우버튼 GONE으로 바꾸고, 삭제버튼 VISIABLE 해야함.
            btn_delete = itemView.findViewById(R.id.btn_follow_delete);
            btn_delete.setVisibility(View.VISIBLE);
            btn_follow = itemView.findViewById(R.id.btn_follow);
            btn_follow.setVisibility(View.GONE);

            btn_bar = itemView.findViewById(R.id.iv_follow_bar);
            btn_bar.setVisibility(View.GONE);

        }
    }
}
