package com.example.smg_insta.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.DTO.StoryResponse;
import com.example.smg_insta.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StorySliderAdapter extends BaseAdapter {
    private static final String TAG = "SliderAdapter";

    private Context mContext;
    private List<StoryResponse.StoryList> sliderItems;

    public StorySliderAdapter(Context context, List<StoryResponse.StoryList> sliderImage) {
        mContext = context;
        this.sliderItems = sliderImage;
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
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_slide_item, parent, false);

        ImageView mImageView = view.findViewById(R.id.iv_storyImage);
        Glide.with(mContext)
                .load(sliderItems.get(i).getImage())
                .into(mImageView);
        return view;
    }
}
