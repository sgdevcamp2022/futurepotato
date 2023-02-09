package com.example.smg_insta.Adapter;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.CommentsActivity;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.Frag5;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RVAdapter_post extends RecyclerView.Adapter<RVAdapter_post.ViewHolder>{
    private Context context;
    private List<MainPageResponse.Post> data;
    private Service dataService;

    public RVAdapter_post(List<MainPageResponse.Post> data, Context context, Service dataService) {
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
//        Glide.with(context)
//                .load(data.get(position).get...)     // 해당 유저 프로필 사진 정보가 없음.
//                .into(holder.info_img_profile);
        holder.info_tv_userId.setText(data.get(position).getName());
        holder.info_explain_content.setText(data.get(position).getName() + " " + data.get(position).getContent());
        holder.info_likes.setText("좋아요 " + data.get(position).getLikeCount() + "개");
        holder.info_comment_count.setText("댓글 " + data.get(position).getCommentCount() + "개");

        // 1. 이미지들 가져오기 + 어뎁터 연결
        List<String> images = data.get(position).getImageList();
        holder.info_img_content.setOffscreenPageLimit(1);
        holder.info_img_content.setAdapter(new ImageSliderAdapter(context.getApplicationContext(), images));

        holder.info_img_content.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                holder.setCurrentIndicator(position);
            }
        });
        holder.setupIndicators(images.size());

        // 2. 좋아요 기능
        //
        // 좋아요 true이면
        if(data.get(position).isLikesCheck()) {
            holder.btn_like.setVisibility(View.VISIBLE);
            holder.btn_noLike.setVisibility(View.GONE);
        } else {
            holder.btn_like.setVisibility(View.GONE);
            holder.btn_noLike.setVisibility(View.VISIBLE);
        }


        // 3. 상단 메뉴 바 클릭 시...(수정/삭제 버튼)
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
                                dataService.feed.DeleteFeed(data.get(position).getName(), data.get(position).getId()).enqueue(new Callback<ResponseBody>() {
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

        // 4. 댓글
        holder.btn_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CommentsActivity.class);
                // myAccountId 랑 postId 가져와야함!!
                //intent.putExtra("accountId", );
                intent.putExtra("postId", data.get(position).getId());
                context.startActivity(intent);
            }
        });
        
        // 5. 프로필 사진 클릭시 유저 정보 확인
        holder.info_img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) context;
                Bundle bundle = new Bundle();
                bundle.putString("userId", data.get(position).getName());
                activity.FragmentViewAddBundle(0, bundle);
            }
        });

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView info_img_profile;
        ViewPager2 info_img_content;
        LinearLayout layoutIndicator;
        TextView info_tv_userId;
        TextView info_likes;
        TextView info_explain_content;
        TextView info_comment_count;
        ImageView btn_menu, btn_like, btn_noLike, btn_comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            info_img_profile = itemView.findViewById(R.id.civ_profile);
            info_tv_userId = (TextView) itemView.findViewById(R.id.tv_post_profile);
            info_likes = (TextView) itemView.findViewById(R.id.tv_like_count);
            info_explain_content = (TextView) itemView.findViewById(R.id.tv_explain);
            info_comment_count = itemView.findViewById(R.id.tv_comment_count);
            btn_menu = itemView.findViewById(R.id.iv_menu_bar);

            info_img_content = itemView.findViewById(R.id.sliderViewPager);
            layoutIndicator = itemView.findViewById(R.id.layoutIndicators);
            
            btn_comment = itemView.findViewById(R.id.iv_comment);


            // 좋아요 버튼! 클릭시 ...
            btn_like = itemView.findViewById(R.id.iv_btn_like);
            btn_noLike = itemView.findViewById(R.id.iv_btn_nolike);


        }

        private void setupIndicators(int count) {
            ImageView[] indicators = new ImageView[count];
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            params.setMargins(16, 8, 16, 8);

            for (int i = 0; i < indicators.length; i++) {
                indicators[i] = new ImageView(context.getApplicationContext());
                indicators[i].setImageDrawable(ContextCompat.getDrawable(context,
                        R.drawable.bg_indicator_inactive));
                indicators[i].setLayoutParams(params);
                layoutIndicator.addView(indicators[i]);
            }
            setCurrentIndicator(0);
        }

        private void setCurrentIndicator(int position) {
            int childCount = layoutIndicator.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
                if (i == position) {
                    imageView.setImageDrawable(ContextCompat.getDrawable(
                            context,
                            R.drawable.bg_indicator_active
                    ));
                } else {
                    imageView.setImageDrawable(ContextCompat.getDrawable(
                            context,
                            R.drawable.bg_indicator_inactive
                    ));
                }
            }
        }

    }



}
