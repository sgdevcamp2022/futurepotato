package com.example.smg_insta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.CrudService;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.DTO.MainPageResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.Path;

public class RVAdapter_post extends RecyclerView.Adapter<RVAdapter_post.ViewHolder>{
    private Context context;
    private List<MainPageResponse.Post> data;
    private CrudService dataService;

    RVAdapter_post(List<MainPageResponse.Post> data, Context context, CrudService dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public RVAdapter_post.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.post_item, parent, false);
        RVAdapter_post.ViewHolder vh = new RVAdapter_post.ViewHolder(view);
        return vh;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull RVAdapter_post.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //holder.info_img_profile.setImageBitmap();
        holder.info_tv_userId.setText(data.get(position).getName());

        //이미지 어케 가져올지 생각...
        List<Uri> images = data.get(position).getImageList();
        // 여기서 다시 리싸이클러뷰 연결해야되나?!?!?!?!?
        //holder.info_img_content.setImageBitmap(data.get(position).getImageList());


        holder.info_explain_content.setText(data.get(position).getName() + " " + data.get(position).getContent());
        holder.info_likes.setText("좋아요 " + data.get(position).getLikeCount() + "개");
        holder.info_comment_count.setText("댓글 " + data.get(position).getCommentCount() + "개");


        // 좋아요 true이면
        if(data.get(position).isLikesCheck()) {
            holder.btn_like.setVisibility(View.VISIBLE);
            holder.btn_noLike.setVisibility(View.GONE);
        } else {
            holder.btn_like.setVisibility(View.GONE);
            holder.btn_noLike.setVisibility(View.VISIBLE);
        }

        // 상단 메뉴 바 클릭 시...(수정/삭제 버튼)
        holder.btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(context.getApplicationContext(), holder.btn_menu); //두 번째 파라미터가 팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.post_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 게시물 삭제 시도
                                dataService.delete.DeleteFeed(data.get(position).getName(), data.get(position).getId()).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        Toast.makeText(context.getApplicationContext(), "삭제 되었습니다.", Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        t.printStackTrace();
                                        Toast.makeText(context.getApplicationContext(), "삭제 권한이 없습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                                break;

                            case R.id.menu_modify:
                                Toast.makeText(context.getApplicationContext(), "MODIFY", Toast.LENGTH_SHORT).show();

                                // 게시물 수정 시도
                                //dataService.update.UpdateFeed(data.get(position).getName(), data.get(position).getId(), /*수정 내용*/)
                                // 수정 내용을 받을 화면 필요..!

                                break;
                        }

                        return false;
                    }
                });

                popup.show();


            }
        });

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView info_img_profile, info_img_content;
        TextView info_tv_userId;
        TextView info_likes;
        TextView info_explain_content;
        TextView info_comment_count;
        ImageView btn_menu, btn_like, btn_noLike, btn_comment;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            info_img_profile = (ImageView) itemView.findViewById(R.id.img_post_profile);
            info_tv_userId = (TextView) itemView.findViewById(R.id.tv_post_profile);
            info_img_content = (ImageView) itemView.findViewById(R.id.img_post_content);
            info_likes = (TextView) itemView.findViewById(R.id.tv_like_count);
            info_explain_content = (TextView) itemView.findViewById(R.id.tv_explain);
            info_comment_count = itemView.findViewById(R.id.tv_comment_count);
            btn_menu = itemView.findViewById(R.id.iv_menu_bar);
            
            btn_comment = itemView.findViewById(R.id.iv_comment);
            // 댓글 버튼 클릭하면
            btn_comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activity = (MainActivity) itemView.getContext();// 프래그먼트에서 메인엑티비티 접근
                    activity.FragmentView(0);
                }
            });

            // 좋아요 버튼! 클릭시 ...
            btn_like = itemView.findViewById(R.id.iv_btn_like);
            btn_noLike = itemView.findViewById(R.id.iv_btn_nolike);


        }

    }

}
