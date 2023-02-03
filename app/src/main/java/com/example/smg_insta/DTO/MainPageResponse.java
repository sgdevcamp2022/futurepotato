package com.example.smg_insta.DTO;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class MainPageResponse {

    @SerializedName("storyList")
    private List<Story> storyList;
    @SerializedName("postList")
    private List<Post> postList;
    @SerializedName("limit")
    private int limit;
    @SerializedName("prePost")
    private int prePost;
    @SerializedName("nextPost")
    private boolean nextPost;

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPrePost() {
        return prePost;
    }

    public void setPrePost(int prePost) {
        this.prePost = prePost;
    }

    public boolean isNextPost() {
        return nextPost;
    }

    public void setNextPost(boolean nextPost) {
        this.nextPost = nextPost;
    }

    public class Story {
        @SerializedName("name")
        private String name;
        @SerializedName("profileImage")
        private String profileImage;
        @SerializedName("image")
        private String image;

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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public class Post {
        @SerializedName("Id")
        private int Id;
        @SerializedName("name")
        private String name;
        @SerializedName("content")
        private String content;
        @SerializedName("createdDate")
        private String createdDate;
        @SerializedName("modifiedDate")
        private String modifiedDate;
        @SerializedName("likeCount")
        private int likeCount;
        @SerializedName("likesCheck")
        private boolean likesCheck;
        @SerializedName("commentCount")
        private int commentCount;
        @SerializedName("imageList")
        private List<Uri> imageList;
        // Uri로 받아오 되나??


        public int getId() {
            return Id;
        }

        public void setId(int id) {
            Id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public boolean isLikesCheck() {
            return likesCheck;
        }

        public void setLikesCheck(boolean likesCheck) {
            this.likesCheck = likesCheck;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public List<Uri> getImageList() {
            return imageList;
        }

        public void setImageList(List<Uri> imageList) {
            this.imageList = imageList;
        }
    }
}
