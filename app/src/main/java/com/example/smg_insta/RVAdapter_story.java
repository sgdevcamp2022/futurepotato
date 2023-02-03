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
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.DTO.MypageResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter_story extends RecyclerView.Adapter<RVAdapter_story.ViewHolder> {
    Context context;
    private List<MainPageResponse.Story> data;
    private CrudService dataService;

    public RVAdapter_story(List<MainPageResponse.Story> data, Context context, CrudService dataService) {
        this.data = data;
        this.context = context;
        this.dataService = dataService;
    }

    @NonNull
    @Override
    public RVAdapter_story.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.story_item, parent, false);
        RVAdapter_story.ViewHolder vh = new RVAdapter_story.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAdapter_story.ViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView storyImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            storyImage = itemView.findViewById(R.id.iv_storyImage);
        }

        void onBind(MainPageResponse.Story item){
            storyImage.setImageURI(Uri.parse(item.getImage()));
        }
    }
}
