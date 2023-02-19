package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainPage_test_Response {

    @SerializedName("postList")
    private List<Post_test> postList;

    @SerializedName("storyList")
    private List<Story_test> storyList;

    public List<Post_test> getPostList() {return postList;}

    public List<Story_test> getStoryList() {return storyList;}


    public class Post_test {

        @SerializedName("postId")
        private int postId;
        @SerializedName("content")
        private String content;
        @SerializedName("accountId")
        private String accountId;
        @SerializedName("profileImage")
        private String profileImage;
        @SerializedName("createdDt")
        private String createdDt;
        @SerializedName("modifiedDt")
        private String modifiedDt;
        @SerializedName("likeCount")
        private int likeCount;
        @SerializedName("commentCount")
        private int commentCount;
        @SerializedName("imageList")
        private List<String> imageList;
        @SerializedName("commentList")
        private List<Object> commentList;
        @SerializedName("multyImage")
        private Boolean multyImage;
        //@SerializedName("likesCheck")
        //private Boolean likesCheck;

        public int getPostId() {return postId;}

        public String getContent() {return content;}

        public String getAccountId() {return accountId;}

        public String getProfileImage() {return profileImage;}

        public String getCreatedDt() {return createdDt;}

        public String getModifiedDt() {return modifiedDt;}

        public int getLikeCount() {return likeCount;}

        public int getCommentCount() {return commentCount;}

        public List<String> getImageList() {return imageList;}

        public List<Object> getCommentList() {
            return commentList;
        }

        public Boolean getMultyImage() {
            return multyImage;
        }

        //public Boolean getLikesCheck() {return likesCheck;}
    }




    public class Story_test {

        @SerializedName("accountId")
        private String accountId;
        @SerializedName("profileImage")
        private String profileImage;

        public String getAccountId() {
            return accountId;
        }

        public String getProfileImage() {
            return profileImage;
        }
    }
}
