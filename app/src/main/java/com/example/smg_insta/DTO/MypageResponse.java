package com.example.smg_insta.DTO;

import android.media.Image;
import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MypageResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("image")
    private String image;
    @SerializedName("int")
    private int followerCount;
    @SerializedName("followingCount")
    private int followingCount;
    @SerializedName("postCount")
    private int postCount;
    @SerializedName("imageList")
    private List<MyImage> imageList;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
        return imageList;
    }

    public void setImageList(List<MyImage> imageList) {
        this.imageList = imageList;
    }

    public class MyImage {
        @SerializedName("image")
        private String image;
        @SerializedName("isMultyImage")
        private boolean isMultyImage;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public boolean isMultyImage() {
            return isMultyImage;
        }

        public void setMultyImage(boolean multyImage) {
            isMultyImage = multyImage;
        }
    }
}
