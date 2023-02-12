package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryResponse {

    @SerializedName("accountId")
    private String accountId;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("storyImage")
    private List<StoryList> storyImage;

    public String getName() {
        return accountId;
    }

    public void setName(String accountId) {
        this.accountId = accountId;
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

        public StoryList(int storyId, String storedStoryImage, String createdDt) {
            this.storyId = storyId;
            this.storedStoryImage = storedStoryImage;
            this.createdDt = createdDt;
        }

        @SerializedName("storyId")
        private int storyId;
        @SerializedName("storedStoryImage")
        private String storedStoryImage;
        @SerializedName("createdDt")
        private String createdDt;


        public int getStoryId() {
            return storyId;
        }

        public void setStoryId(int storyId) {
            this.storyId = storyId;
        }

        public String getImage() {
            return storedStoryImage;
        }

        public void setImage(String storedStoryImage) {
            this.storedStoryImage = storedStoryImage;
        }

        public String getCreatedDate() {
            return createdDt;
        }

        public void setCreatedDate(String createdDt) {
            this.createdDt = createdDt;
        }
    }
}
