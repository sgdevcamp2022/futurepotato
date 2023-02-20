package com.example.smg_insta.Adapter;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.CommentsActivity;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.PreferenceManager;
import com.example.smg_insta.R;
import com.example.smg_insta.ReplyActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FeedResponse.Comment> data;
    private Service dataService;
    private int postId;

    String accountId;

    ArrayList<FeedResponse.Reply> replies = new ArrayList<>();


    public CommentAdapter(ArrayList<FeedResponse.Comment> data, Context context, Service dataService, int postId) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
        this.postId = postId;
    }



    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        accountId = PreferenceManager.getString(context, "accountID");
        
        View view = inflater.inflate(R.layout.comment_item, parent, false);
        CommentAdapter.ViewHolder vh = new CommentAdapter.ViewHolder(view);
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(data.get(position));
        holder.checkCommentLike(data.get(position));    // 댓글 좋아요 초기화

        //답글들 가져오기
        holder.getReply(data.get(position));

        // 대댓글(답글) 달기
        holder.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String reply;
                //EditText editText =(EditText) view.findViewById(R.id.et_insert_comment);
                //editText.requestFocus();

                //키보드 보이게 하는 부분
                //InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
                //imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

                Intent intent = new Intent(context, ReplyActivity.class);
                // myAccountId 랑 postId 가져와야함!!
                //intent.putExtra("accountId", );
                intent.putExtra("commentId", data.get(position).getCommentId()+"");
                intent.putExtra("commentWriter", data.get(position).getCommentWriter());
                intent.putExtra("commentImage", data.get(position).getImage());
                intent.putExtra("comment", data.get(position).getComment());
                intent.putExtra("likeCount", data.get(position).getLikeCount()+"");
                intent.putExtra("replyCount", data.get(position).getReplyCount()+"");
                context.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK));

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
                                dataService.comment.DeleteComment(accountId, data.get(position).getCommentId()).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                                        if(response.isSuccessful()) {
                                            Log.e("댓글삭제 성공", response.code()+"");

                                        } else {
                                            Log.e("댓글삭제 오류", response.code()+"");
                                        }

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

        // 좋아요 기능
        holder.btnNoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.feedLike.likeComment(accountId, data.get(position).getCommentId()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            holder.btnLike.setVisibility(View.VISIBLE);
                            holder.btnNoLike.setVisibility(View.GONE);
                            Log.e("likeComment", "좋아요를 눌렀습니다.");
                        } else {
                            Log.e("likeComment", "댓글 좋아요 오류: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("likeComment", "댓글 좋아요 실패");
                    }
                });
            }
        });


        // 좋아요 취소
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataService.feedLike.unlikeComment(accountId, data.get(position).getCommentId()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            holder.btnLike.setVisibility(View.GONE);
                            holder.btnNoLike.setVisibility(View.VISIBLE);
                            Log.e("likeComment", "좋아요를 취소하였습니다.");
                        } else {
                            Log.e("likeComment", "댓글 좋아요 취소 오류: "+response.code());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("likeComment", "댓글 좋아요 취소 실패");
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {return data.size();}


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView commentWriter;
        TextView comment;
        TextView likeCount;
        TextView replyCount;
        TextView btnReply;
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
            if(item.getImage() != null) {
                Glide.with(context)
                        .load(item.getImage())
                        .into(profile);
            }

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

        }


        void getReply(FeedResponse.Comment item) {
            replyCount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyc_reply.getVisibility() == View.VISIBLE) {
                        recyc_reply.setVisibility(View.GONE);
                        replyCount.setText("답글 " + item.getReplyList().size() + "개 더보기");
                    } else {
                        recyc_reply.setVisibility(View.VISIBLE);
                        recyc_reply.setAdapter(new ReplyAdapter(context, item.getReplyList()));
                        replyCount.setText("답글 닫기");
                    }

                }
            });
        }

        void checkCommentLike(FeedResponse.Comment item) {
            // 좋아요 초기화
            dataService.feedLike.isLikeComment(accountId, item.getCommentId()).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.isSuccessful()) {
                        Log.e("isLikeComment", "좋아요 초기화 성공");

                        if(response.body()) {
                            btnLike.setVisibility(View.VISIBLE);
                            btnNoLike.setVisibility(View.GONE);
                        } else {
                            btnLike.setVisibility(View.GONE);
                            btnNoLike.setVisibility(View.VISIBLE);
                        }
                    } else {
                        Log.e("isLikeComment", "좋아요초기화 오류: " + response.code());
                    }
                }
                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    t.printStackTrace();
                    Log.e("isLikeComment", "좋아요초기화 실패");
                }
            });
        }


    }

    public FeedResponse.Comment getItem(int position){
        return data.get(position);
    }

}