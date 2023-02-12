package com.example.smg_insta.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.StoryResponse;
import com.example.smg_insta.R;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StorySliderAdapter extends BaseAdapter {
    private static final String TAG = "SliderAdapter";
    Service dataService = new Service();
    LinearLayout layoutIndicator;

    private Context mContext;
    private List<StoryResponse.StoryList> sliderItems;
    private String userId;

    private int setting = 0;

    public StorySliderAdapter(Context context, StoryResponse sliderImage) {
        mContext = context;
        this.sliderItems = sliderImage.getStoryImage();
        userId = sliderImage.getAccountId();
    }

    @Override
    public int getCount() {
        return sliderItems.size();
    }

    @Override
    public Object getItem(int i) {
        return sliderItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return sliderItems.get(i).getStoryId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_slide_item, parent, false);

        View view2 = LayoutInflater.from(mContext)
                .inflate(R.layout.story, parent, false);
        AdapterViewFlipper viewFlipper = view2.findViewById(R.id.avf_story);

        layoutIndicator = view.findViewById(R.id.layoutIndicators_story);
        ImageView btn_more = view.findViewById(R.id.iv_btnMore);
        ImageView mImageView = view.findViewById(R.id.iv_storyImage);
        Glide.with(mContext)
                .load(sliderItems.get(i).getImage())
                .into(mImageView);

        setCurrentIndicator(i);
        setupIndicators(sliderItems.size(), i);



        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();

                //PopupMenu 객체 생성
                PopupMenu popup= new PopupMenu(mContext, btn_more); //팝업메뉴가 붙을 뷰
                popup.getMenuInflater().inflate(R.menu.story_popup, popup.getMenu());

                //팝업메뉴의 메뉴아이템을 선택하는 것을 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {

                        switch (menuItem.getItemId()){
                            case R.id.menu_delete:
                                // 스토리 삭제
                                dataService.story.DeleteStory(userId, (int)getItemId(i)).enqueue(new Callback<ResponseBody>() {
                                    @Override
                                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                        if(response.isSuccessful()) {
                                            Toast.makeText(mContext, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                                        t.printStackTrace();
                                    }
                                });

                                break;
                        }
                        return false;
                    }
                });
                popup.show();

            }
        });

        return view;

    }
    private void setupIndicators(int count, int position) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(mContext);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(mContext,
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(position);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_indicator_active_long
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        mContext,
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}
