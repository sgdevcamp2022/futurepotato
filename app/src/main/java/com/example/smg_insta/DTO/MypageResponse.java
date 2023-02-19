package com.example.smg_insta.DTO;

import android.media.Image;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MypageResponse {

    @SerializedName("accountName")
    private String accountName;
    @SerializedName("accountId")
    private String accountId;
    @SerializedName("profileImage")
    private String profileImage;
    @SerializedName("followerCount")
    private int followerCount;
    @SerializedName("followingCount")
    private int followingCount;
    @SerializedName("postCount")
    private int postCount;
    @SerializedName("mypagePostDtos")
    private List<MyImage> mypagePostDtos;


    public String getName() {
        return accountName;
    }

    public void setName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProfileImage() {return profileImage;}

    public void setProfileImage(String profileImage) {this.profileImage = profileImage;}

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(int followingCount) {
        this.followingCount = followingCount;
    }

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public List<MyImage> getImageList() {
        return mypagePostDtos;
    }

    public void setImageList(List<MyImage> mypagePostDtos) {
        this.mypagePostDtos = mypagePostDtos;
    }

    public static class MyImage {

        public MyImage(String storedUrl, int postId, boolean isMultyImage) {
            this.storedUrl = storedUrl;
            this.postId = postId;
            this.isMultyImage = isMultyImage;
        }

        @SerializedName("storedUrl")
        private String storedUrl;
        @SerializedName("postId")
        private int postId;
        @SerializedName("isMultyImage")
        private boolean isMultyImage;
        @SerializedName("multyImage")
        private boolean multyImage;


        public String getImage() {
            return storedUrl;
        }

        public void setImage(String storedUrl) {this.storedUrl = storedUrl;}

        public int getPostId() {return postId;}

        public void setPostId(int postId) {this.postId = postId;}

        public boolean isMultyImage() {
            return isMultyImage;
        }

        public void setMultyImage(boolean multyImage) {
            isMultyImage = multyImage;
        }
    }
}
