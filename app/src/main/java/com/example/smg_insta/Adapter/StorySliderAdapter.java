package com.example.smg_insta.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.DTO.StoryResponse;
import com.example.smg_insta.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StorySliderAdapter extends RecyclerView.Adapter<StorySliderAdapter.SliderViewHolder>{
    private static final String TAG = "SliderAdapter";

    private Context mContext;
    private List<StoryResponse.StoryList> sliderItems;

    public StorySliderAdapter(Context context, List<StoryResponse.StoryList> sliderImage) {
        mContext = context;
        this.sliderItems = sliderImage;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.story_slide_item, parent, false);
        return new StorySliderAdapter.SliderViewHolder((ImageView) view);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.bind(sliderItems.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    class SliderViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.tv_storyImage);
        }

        void bind(String sliderItem) {
            try {
                Glide.with(mContext).load(sliderItem).into(mImageView);
            } catch (Exception e) {
                Log.d(TAG, "ERROR: " + e.getMessage());
            }
        }
    }
}
