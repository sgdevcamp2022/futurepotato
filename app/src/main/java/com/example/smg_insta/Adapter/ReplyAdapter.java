package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

        View view = inflater.inflate(R.layout.reply_item, parent, false);
        ReplyAdapter.ViewHolder vh = new ReplyAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReplyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bindReply(replyList.get(position));

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
                                accountId = PreferenceManager.getString(context, "accountID");
                                dataService.comment.DeleteReply(accountId, replyList.get(position).getReplyId()).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        // 성공
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
