package com.example.smg_insta.Adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.R;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private ArrayList<FeedResponse.Comment> data;
    private Service dataService;

    public CommentAdapter(ArrayList<FeedResponse.Comment> data, Context context, Service dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }



    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.comment_item, parent, false);
        CommentAdapter.ViewHolder vh = new CommentAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        holder.onBind(data.get(position));

        // 대댓글 달기
        holder.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }

    @Override
    public int getItemCount() {return data.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView commentWriter, comment, likeCount, replyCount, btnReply;
        ImageView btnLike, btnNoLike;

        public ViewHolder(View view) {
            super(view);

            profile = view.findViewById(R.id.iv_comment_accountImage);
            commentWriter = view.findViewById(R.id.tv_comment_accountId);
            comment = view.findViewById(R.id.tv_comment);
            likeCount = view.findViewById(R.id.tv_commentLikeCount);
            replyCount = view.findViewById(R.id.tv_commentCount);
            btnNoLike = view.findViewById(R.id.iv_comment_noLike);
            btnLike = view.findViewById(R.id.iv_comment_like);
            btnReply = view.findViewById(R.id.tv_btnReply);

        }

        void onBind(FeedResponse.Comment item){
            Glide.with(context)
                    .load(item.getImage())
                    .into(profile);

            commentWriter.setText(item.getCommentWriter());
            comment.setText(item.getComment());
            likeCount.setText("좋아요 " + item.getLikeCount() + "개");
            replyCount.setText("댓글 " + item.getReplyList().size() + "개");
            // isLike 추가되면 좋아요 여부 받아서 하트 받기


        }
    }
}
