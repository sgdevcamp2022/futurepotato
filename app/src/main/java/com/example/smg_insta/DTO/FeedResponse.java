package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

import org.w3c.dom.Comment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FeedResponse {

    @SerializedName("Id")
    private int id; // int형 맞는지 확인

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

    @SerializedName("commentList")
    private ArrayList<Comment> commentList;

    @SerializedName("imageList")
    private ArrayList<String> imageList;

    @SerializedName("isMultyImage")
    private boolean isMultyImage;

    public ArrayList<String> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    public boolean isMultyImage() {
        return isMultyImage;
    }

    public void setMultyImage(boolean multyImage) {
        isMultyImage = multyImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }


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

        public Reply(String replyWriter, String reply, String image, String createdDt) {
            this.replyWriter = replyWriter;
            this.reply = reply;
            this.image = image;
            this.createdDt = createdDt;
        }

        @SerializedName("replyWriter")
        private String replyWriter;
        @SerializedName("reply")
        private String reply;
        @SerializedName("image")
        private String image;
        @SerializedName("createdDt")
        private String createdDt;


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

        public String getImage() {return image;}

        public void setImage(String image) {this.image = image;}

        public String getCreatedDt() {
            return createdDt;
        }

        public void setCreatedDt(String createdDt) {
            this.createdDt = createdDt;
        }
    }
}



