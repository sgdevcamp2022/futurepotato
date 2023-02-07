package com.example.smg_insta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder>{

    private Context context;
    private ArrayList<FeedResponse.Reply> replyList;

    public ReplyAdapter(Context context, ArrayList<FeedResponse.Reply> replyList) {
        this.context = context;
        this.replyList = replyList;
    }

    @NonNull
    @Override
    public ReplyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reply_item, parent, false);
        return new ReplyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReplyAdapter.ViewHolder holder, int position) {
        holder.bindReply(replyList.get(position));
    }

    @Override
    public int getItemCount() {return replyList.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_image;
        TextView userId, reply;

        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.iv_reply_accountImage);
            userId = itemView.findViewById(R.id.tv_reply_accountId);
            reply = itemView.findViewById(R.id.tv_reply);
        }

        public void bindReply(FeedResponse.Reply item) {
            Glide.with(context)
                    .load(item.getImage())
                    .into(profile_image);

            userId.setText(item.getReplyWriter());
            reply.setText(item.getReply());
        }
    }
}
