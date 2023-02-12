package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class StoryResponse {

    public StoryResponse(String accountId, String profileImage, ArrayList<StoryList> storyImage) {
        this.accountId = accountId;
        this.profileImage = profileImage;
        this.storyImage = storyImage;
    }

    @SerializedName("accountId")
    private String accountId;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("storyImage")
    private ArrayList<StoryList> storyImage;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public ArrayList<StoryList> getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(ArrayList<StoryList> storyImage) {
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
