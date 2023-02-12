package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Comment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedResponse {

    @SerializedName("postId")
    private int postId;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("profileImage")
    private String profileImage;

    @SerializedName("content")
    private String content;

    @SerializedName("createdDt")
    private String createdDt;

    @SerializedName("modifiedDt")
    private String modifiedDt;

    @SerializedName("likeCount")
    private int likeCount;

    @SerializedName("likesCheck")
    private boolean likesCheck;

    @SerializedName("commentCount")
    private int commentCount;

    @SerializedName("commentList")
    private ArrayList<Comment> commentList;

    @SerializedName("imageList")
    private ArrayList<String> imageList;

    @SerializedName("isMultyImage")
    private boolean isMultyImage;

    public int getPostId() {return postId;}

    public void setPostId(int postId) {this.postId = postId;}

    public String getAccountId() {return accountId;}

    public void setAccountId(String accountId) {this.accountId = accountId;}

    public String getProfileImage() {return profileImage;}

    public void setProfileImage(String profileImage) {this.profileImage = profileImage;}

    public String getContent() {return content;}

    public void setContent(String content) {this.content = content;}

    public String getCreatedDt() {return createdDt;}

    public void setCreatedDt(String createdDt) {this.createdDt = createdDt;}

    public String getModifiedDt() {return modifiedDt;}

    public void setModifiedDt(String modifiedDt) {this.modifiedDt = modifiedDt;}

    public int getLikeCount() {return likeCount;}

    public void setLikeCount(int likeCount) {this.likeCount = likeCount;}

    public boolean isLikesCheck() {return likesCheck;}

    public void setLikesCheck(boolean likesCheck) {this.likesCheck = likesCheck;}

    public int getCommentCount() {return commentCount;}

    public void setCommentCount(int commentCount) {this.commentCount = commentCount;}

    public ArrayList<Comment> getCommentList() {return commentList;}

    public void setCommentList(ArrayList<Comment> commentList) {this.commentList = commentList;}

    public ArrayList<String> getImageList() {return imageList;}

    public void setImageList(ArrayList<String> imageList) {this.imageList = imageList;}

    public boolean isMultyImage() {return isMultyImage;}

    public void setMultyImage(boolean multyImage) {isMultyImage = multyImage;}

    public static class Comment {

        public Comment(String commentWriter, String image, String comment, int commentId, int likeCount, String createdDt, ArrayList<Reply> replyList) {
            this.commentWriter = commentWriter;
            this.image = image;
            this.comment = comment;
            this.commentId = commentId;
            this.likeCount = likeCount;
            this.createdDt = createdDt;
            this.replyList = replyList;
        }

        @SerializedName("commentWriter")
        private String commentWriter;
        @SerializedName("Image")
        private String image;
        @SerializedName("comment")
        private String comment;
        @SerializedName("commentId")
        private int commentId;
        @SerializedName("likeCount")
        private int likeCount;
        @SerializedName("createdDt")
        private String createdDt;
        @SerializedName("replyList")
        private ArrayList<Reply> replyList;


        public String getCommentWriter() {
            return commentWriter;
        }

        public void setCommentWriter(String commentWriter) {
            this.commentWriter = commentWriter;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            image = image;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getCommentId() {return commentId;}

        public void setCommentId(int commentId) {this.commentId = commentId;}

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
        }

        public String getCreatedDt() {
            return createdDt;
        }

        public void setCreatedDt(String createdDt) {
            this.createdDt = createdDt;
        }

        public ArrayList<Reply> getReplyList() {
            return replyList;
        }

        public void setReplyList(ArrayList<Reply> replyList) {
            this.replyList = replyList;
        }
    }

    public static class Reply {

        public Reply(int replyId, String replyWriter, String reply, String profileImage, String createdDt) {
            this.replyId = replyId;
            this.replyWriter = replyWriter;
            this.reply = reply;
            this.profileImage = profileImage;
            this.createdDt = createdDt;
        }

        @SerializedName("replyId")
        private int replyId;
        @SerializedName("replyWriter")
        private String replyWriter;
        @SerializedName("reply")
        private String reply;
        @SerializedName("profileImage")
        private String profileImage;
        @SerializedName("createdDt")
        private String createdDt;


        public int getReplyId() {return replyId;}

        public void setReplyId(int replyId) {this.replyId = replyId;}

        public String getReplyWriter() {
            return replyWriter;
        }

        public void setReplyWriter(String replyWriter) {
            this.replyWriter = replyWriter;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getProfileImage() {return profileImage;}

        public void setProfileImage(String profileImage) {this.profileImage = profileImage;}

        public String getImage() {return profileImage;}

        public void setImage(String profileImage) {this.profileImage = profileImage;}

        public String getCreatedDt() {
            return createdDt;
        }

        public void setCreatedDt(String createdDt) {
            this.createdDt = createdDt;
        }
    }
}



