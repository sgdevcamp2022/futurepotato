package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FollowListResponse {

    public FollowListResponse(String error, ArrayList<Follow> data) {
        this.error = error;
        this.data = data;
    }

    @SerializedName("error")
    private String error;

    @SerializedName("data")
    private ArrayList<Follow> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList<Follow> getData() {
        return data;
    }

    public void setData(ArrayList<Follow> data) {
        this.data = data;
    }

    public static class Follow {

        public Follow(int id, String accountId, String accountName, String profileImage) {
            this.id = id;
            this.accountId = accountId;
            this.accountName = accountName;
            this.profileImage = profileImage;
        }

        @SerializedName("id")
        private int id;
        @SerializedName("accountId")
        private String accountId;
        @SerializedName("accountName")
        private String accountName;
        @SerializedName("profileImage")
        private String profileImage;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }
    }
}
