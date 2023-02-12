package com.example.smg_insta.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.MypageResponse;
import com.example.smg_insta.DTO.NoticeResponse;
import com.example.smg_insta.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.ViewHolder>{

    private List<NoticeResponse> data;
    private Context context;
    private Service dataService;
    private String senderId;
    public NoticeAdapter(List<NoticeResponse> data, Context context, Service dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public NoticeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.cardview_notice, parent, false);
        NoticeAdapter.ViewHolder vh = new NoticeAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeAdapter.ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {return data.size();}

    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView profile;
        TextView message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.civ_notice_profile);
            message = itemView.findViewById(R.id.tv_notice_message);
        }

        void bind(NoticeResponse item) {

            // 프로필 이미지연결
            senderId = item.getSender();
            dataService.selectMyPage.SelectMyPage(senderId).enqueue(new Callback<MypageResponse>() {
                @Override
                public void onResponse(Call<MypageResponse> call, Response<MypageResponse> response) {
                    if(response.isSuccessful()) {
                        Glide.with(context).load(response.body().getProfileImage()).into(profile);
                    }
                    else {
                        Toast.makeText(context, "errorCode: " + response.code(), Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<MypageResponse> call, Throwable t) {
                    t.printStackTrace();
                }
            });

            // 메시지 연결
            message.setText(item.getActionMessage());
        }
    }
}
