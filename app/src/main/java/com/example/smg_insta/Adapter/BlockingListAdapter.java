package com.example.smg_insta.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.FollowListResponse;
import com.example.smg_insta.PreferenceManager;
import com.example.smg_insta.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlockingListAdapter extends RecyclerView.Adapter<BlockingListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FollowListResponse.Follow> blockingList;
    private Service dataService;

    String accountId;

    public BlockingListAdapter(ArrayList<FollowListResponse.Follow> blockingList, Context context, Service dataService) {
        this.blockingList = blockingList;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        accountId = PreferenceManager.getString(context, "accountID");

        View view = inflater.inflate(R.layout.cardview_block, parent, false);
        BlockingListAdapter.ViewHolder vh = new BlockingListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull BlockingListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // 프로필 이미지
        if(blockingList.get(position).getProfileImage() == null) {
            Glide.with(context)
                    .load(R.drawable.user_default)
                    .into(holder.blockingProfile);
        } else {
            Glide.with(context)
                    .load(blockingList.get(position).getProfileImage())
                    .into(holder.blockingProfile);
        }
        // 차단된 계정 아이디
        holder.blockingId.setText(blockingList.get(position).getAccountId());
        
        // 차단 해제
        holder.cancelBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 차단 해제
                dataService.graph.unblock(accountId, blockingList.get(position).getAccountId()).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            Toast.makeText(context, "차단 해제 성공", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

    }


    @Override
    public int getItemCount() {
        return blockingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView blockingProfile;
        TextView blockingId;
        Button cancelBlock;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            blockingProfile = itemView.findViewById(R.id.civ_block_profile);
            blockingId = itemView.findViewById(R.id.tv_blockId);
            cancelBlock = itemView.findViewById(R.id.btn_unblock);
            cancelBlock.setVisibility(View.VISIBLE);

        }
    }
}