package com.example.smg_insta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FollowListResponse;
import com.example.smg_insta.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class BlockerListAdapter extends RecyclerView.Adapter<BlockerListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FollowListResponse.Follow> blockerList;
    private Service dataService;

    public BlockerListAdapter(ArrayList<FollowListResponse.Follow> blockerList, Context context, Service dataService) {
        this.blockerList = blockerList;
        this.context = context;
        this.dataService = dataService;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.cardview_block, parent, false);
        BlockerListAdapter.ViewHolder vh = new BlockerListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BlockerListAdapter.ViewHolder holder, int position) {

        // 프로필 이미지
        if(blockerList.get(position).getProfileImage() == null) {
            Glide.with(context)
                    .load(R.drawable.user_default)
                    .into(holder.blockingProfile);
        } else {
            Glide.with(context)
                    .load(blockerList.get(position).getProfileImage())
                    .into(holder.blockingProfile);
        }
        // 나를 차단한 계정
        holder.blockingId.setText(blockerList.get(position).getAccountId());

    }


    @Override
    public int getItemCount() {return blockerList.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView blockingProfile;
        TextView blockingId;
        Button cancelBlock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            blockingProfile = itemView.findViewById(R.id.civ_block_profile);
            blockingId = itemView.findViewById(R.id.tv_blockId);
            cancelBlock = itemView.findViewById(R.id.btn_unblock);
            cancelBlock.setVisibility(View.GONE);
        }
    }
}
