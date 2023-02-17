package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class FollowData {

    public FollowData(String senderId, String recipientId) {
        this.senderId = senderId;
        this.recipientId = recipientId;
    }

    @SerializedName("senderId")
    private String senderId;
    @SerializedName("recipientId")
    private String recipientId;




}
