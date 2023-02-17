package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.MypageResponse;
import com.example.smg_insta.EditProfileFrag;
import com.example.smg_insta.MainActivity;
import com.example.smg_insta.MyPostFrag;
import com.example.smg_insta.R;

import java.util.List;

public class RVAdapter_profile extends RecyclerView.Adapter<RVAdapter_profile.ViewHolder> {
    private Context context;
    private Service dataService;
    private List<MypageResponse.MyImage> mMyImageList;

    public RVAdapter_profile(List<MypageResponse.MyImage> data, Context context, Service dataService) {
        this.mMyImageList = data;
        this.context = context;
        this.dataService = dataService;
    }


    @NonNull
    @Override
    public RVAdapter_profile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view, parent, false);
        return new RVAdapter_profile.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter_profile.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(mMyImageList.get(position));

        holder.info_private_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = (MainActivity) context;

                Bundle bundle = new Bundle();
                bundle.putString("postId", String.valueOf(mMyImageList.get(position).getPostId()));

                activity.FragmentViewAddBundle(1, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMyImageList.size();
    }

//    public void setMyImageList(List<MypageResponse.MyImage> list) {
//        this.mMyImageList = list;
//        notifyDataSetChanged();
//
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView info_private_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            info_private_image = itemView.findViewById(R.id.profile_image);
        }

        void onBind(MypageResponse.MyImage item){
            //info_private_image.setImageURI(Uri.parse(item.getImage()));
            Glide.with(context)
                    .load(item.getImage())
                    .into(info_private_image);
        }
    }


}
