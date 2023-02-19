package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.smg_insta.PreferenceManager;
import com.example.smg_insta.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReplyAdapter extends RecyclerView.Adapter<ReplyAdapter.ViewHolder>{

    private Context context;
    private ArrayList<FeedResponse.Reply> replyList;
    private Service dataService = new Service();

    private String accountId;

    public ReplyAdapter(Context context, ArrayList<FeedResponse.Reply> replyList) {
        this.context = context;
        this.replyList = replyList;
    }

    @NonNull
    @Override
    public ReplyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        accountId = PreferenceManager.getString(context, "accountID");

        View view = inflater.inflate(R.layout.reply_item, parent, false);
        ReplyAdapter.ViewHolder vh = new ReplyAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReplyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindReply(replyList.get(position));
        holder.checkReplyLike(replyList.get(position));

        // 길게 누르면 삭제 팝업
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(context, holder.reply); //팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.story_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 답글 삭제
                                dataService.comment.DeleteReply(accountId, replyList.get(position).getReplyId()).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        // 성공
                                        Log.e("댓글삭제 성공", response.code()+"");
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

        // 답글 좋아요
        holder.btnNoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.feedLike.likeReply(accountId, replyList.get(position).getReplyId()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            holder.btnLike.setVisibility(View.VISIBLE);
                            holder.btnNoLike.setVisibility(View.GONE);
                            Log.e("likeReply", "답글 좋아요를 눌렀습니다.");

                        } else {
                            Log.e("likeReply", "답글 좋아요 오류: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("likeReply", "답글 좋아요 실패");
                    }
                });
            }
        });

        // 답글 좋아요 취소
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.feedLike.unlikeReply(accountId, (long)replyList.get(position).getReplyId()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            holder.btnLike.setVisibility(View.GONE);
                            holder.btnNoLike.setVisibility(View.VISIBLE);
                            Log.e("unlikeReply", "답글 좋아요를 취소하였습니다..");

                        } else {
                            Log.e("unlikeReply", "답글 좋아요 취소 오류: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("unlikeReply", "답글 좋아요 취소 실패");
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {return replyList.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile_image;
        TextView userId, reply, likeCount;
        ImageView btnLike, btnNoLike;

        public ViewHolder(View itemView) {
            super(itemView);
            profile_image = itemView.findViewById(R.id.iv_reply_accountImage);
            userId = itemView.findViewById(R.id.tv_reply_accountId);
            reply = itemView.findViewById(R.id.tv_reply);
            btnLike = itemView.findViewById(R.id.iv_reply_like);
            btnNoLike = itemView.findViewById(R.id.iv_reply_noLike);
            // 답글 좋아요 갯수 확인 불가
            likeCount = itemView.findViewById(R.id.tv_replyLikeCount);
        }

        public void bindReply(FeedResponse.Reply item) {
            if(item.getImage() != null) {
                Glide.with(context)
                        .load(item.getImage())
                        .into(profile_image);
            }
            userId.setText(item.getReplyWriter());
            reply.setText(item.getReply());
            if(item.getLikeCount() > 0) {
                likeCount.setText("좋아요 " + item.getLikeCount() + "개");
            } else {
                likeCount.setVisibility(View.GONE);
            }
        }

        void checkReplyLike(FeedResponse.Reply item) {
            // 좋아요 초기화
            dataService.feedLike.isLikeReply(accountId, item.getReplyId()).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.isSuccessful()) {
                        Log.e("isLikeReply", "답글 좋아요 초기화 성공");

                        if(response.body()) {
                            btnLike.setVisibility(View.VISIBLE);
                            btnNoLike.setVisibility(View.GONE);
                        } else {
                            btnLike.setVisibility(View.GONE);
                            btnNoLike.setVisibility(View.VISIBLE);
                        }
                    } else {
                        Log.e("isLikeReply", "답글 좋아요 초기화 오류: " + response.code());
                    }
                }
                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    t.printStackTrace();
                    Log.e("isLikeReply", "답글 좋아요 초기화 실패");
                }
            });


        }


    }
}
