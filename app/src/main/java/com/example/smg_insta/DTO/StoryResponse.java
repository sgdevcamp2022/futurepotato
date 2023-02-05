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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<StoryList> getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(List<StoryList> storyImage) {
        this.storyImage = storyImage;
    }

    public static class StoryList {

        public StoryList(int storyId, String image, String createdDate) {
            this.storyId = storyId;
            this.image = image;
            this.createdDate = createdDate;
        }

        @SerializedName("storyId")
        private int storyId;
        @SerializedName("image")
        private String image;
        @SerializedName("createdDate")
        private String createdDate;


        public int getStoryId() {
            return storyId;
        }

        public void setStoryId(int storyId) {
            this.storyId = storyId;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }
    }
}
