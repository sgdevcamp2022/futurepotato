package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder>{

    private Context context;
    private ArrayList<FeedResponse.Comment> data;
    private Service dataService;

    String accountId;

    ArrayList<FeedResponse.Reply> replies = new ArrayList<>();


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
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(data.get(position));
        //답글들 가져오기
        replies = data.get(position).getReplyList();


        // 대댓글(답글) 보기
        holder.replyCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.recyc_reply.setVisibility(View.VISIBLE);
                holder.recyc_reply.setAdapter(new ReplyAdapter(context, replies));
                //holder.replyCount.setText("답글 닫기");

            }
        });

        // 대댓글(답글) 달기
        holder.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                
            }
        });

        // 댓글 삭제
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(context, holder.commentWriter); //팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.story_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 댓글 삭제
                                // accountId 내부 데이터에서 가져와야 함.
                                dataService.comment.DeleteComment(accountId, data.get(position).getCommentId()).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        //
                                        notifyDataSetChanged();
                                    }
                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        Log.e("댓글삭제 에러 발생", t.getMessage());
                                    }
                                });
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
                return true;
            }
        });

        // 아이디 클릭시 유저 정보 확인
        holder.commentWriter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // FragUserInfo 로..
                MainActivity activity = (MainActivity) context;
                Bundle bundle = new Bundle();
                bundle.putString("userId", data.get(position).getCommentWriter());
                activity.FragmentViewAddBundle(0, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {return data.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView commentWriter, comment, likeCount, replyCount, btnReply;
        ImageView btnLike, btnNoLike;
        RecyclerView recyc_reply;

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
            recyc_reply = view.findViewById(R.id.rcv_reply);

        }

        void onBind(FeedResponse.Comment item){
            Glide.with(context)
                    .load(item.getImage())
                    .into(profile);

            commentWriter.setText(item.getCommentWriter());
            comment.setText(item.getComment());

            if (item.getLikeCount() > 0) {
                likeCount.setText("좋아요 " + item.getLikeCount() + "개");
            } else {
                likeCount.setText(null);
            }

            if (item.getReplyList().size() > 0) {
                replyCount.setText("답글 " + item.getReplyList().size() + "개 더 보기");
            } else {
                replyCount.setText(null);
            }

            // isLike 추가되면 좋아요 여부 받아서 하트 받기


        }
    }
}
