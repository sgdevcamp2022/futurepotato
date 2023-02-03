package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

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
    private List<comment> commentList;

    @SerializedName("imageList")
    private Map<String, String> imageList;

    public Map<String, String> getImageList() {
        return imageList;
    }

    public void setImageList(Map<String, String> imageList) {
        this.imageList = imageList;
    }

    public boolean isMultyImage() {
        return isMultyImage;
    }

    public void setMultyImage(boolean multyImage) {
        isMultyImage = multyImage;
    }

    @SerializedName("isMultyImage")
    private boolean isMultyImage;

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

    public List<comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<comment> commentList) {
        this.commentList = commentList;
    }
}

class comment {
    @SerializedName("commentWriter")
    private String commentWriter;
    @SerializedName("Image")
    private String Image;
    @SerializedName("comment")
    private String comment;
    @SerializedName("likeCount")
    private int likeCount;
    @SerializedName("replyList")
    private List<reply> replyList;

    public String getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(String commentWriter) {
        this.commentWriter = commentWriter;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<reply> replyList) {
        this.replyList = replyList;
    }
}

class reply {
    @SerializedName("replyWriter")
    private String replyWriter;
    @SerializedName("reply")
    private String reply;
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

    public String getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(String createdDt) {
        this.createdDt = createdDt;
    }
}

