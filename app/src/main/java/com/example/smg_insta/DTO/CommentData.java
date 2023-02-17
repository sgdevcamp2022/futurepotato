package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class CommentData {

    public CommentData(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    @SerializedName("comment")
    private String comment;


}
