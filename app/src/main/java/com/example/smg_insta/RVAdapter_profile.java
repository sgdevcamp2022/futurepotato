package com.example.smg_insta;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smg_insta.API.CrudService;
import com.example.smg_insta.DTO.MypageResponse;

import java.util.List;

public class RVAdapter_profile extends RecyclerView.Adapter<RVAdapter_profile.ViewHolder> {
    private Context context;
    private MypageResponse data;
    private CrudService dataService;
    private List<MypageResponse.MyImage> mMyImageList;

//    public RVAdapter_profile(MypageResponse data, Context context, CrudService dataService) {
//        this.data = data;
//        this.context = context;
//        this.dataService = dataService;
//    }


    @NonNull
    @Override
    public RVAdapter_profile.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view,parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter_profile.ViewHolder holder, int position) {
        holder.onBind(mMyImageList.get(position));
    }

    @Override
    public int getItemCount() {
        return data.getImageList().size();
    }

    public void setMyImageList(List<MypageResponse.MyImage> list) {
        this.mMyImageList = list;
        notifyDataSetChanged();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView info_private_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            info_private_image = itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 클릭시 post_item으로 확인할 수 있도록...
                }
            });
        }

        void onBind(MypageResponse.MyImage item){
            info_private_image.setImageURI(Uri.parse(item.getImage()));
        }
    }
}
