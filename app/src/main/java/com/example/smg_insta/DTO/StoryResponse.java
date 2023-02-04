package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("storyImage")
    private List<StoryList> storyImage;




    private class StoryList {
        @SerializedName("image")
        private String image;
        @SerializedName("createdDate")
        private String createdDate;
    }
}
