package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class NoticeResponse {

    @SerializedName("id")
    private int id;
    @SerializedName("sender")
    private String sender;
    @SerializedName("receiver")
    private String receiver;
    @SerializedName("place")
    private String place;
    @SerializedName("action")
    private String action;
    @SerializedName("actionMessage")
    private String actionMessage;

    public int getId() {return id;}

    public String getSender() {return sender;}

    public String getReceiver() {return receiver;}

    public String getPlace() {return place;}

    public String getAction() {return action;}

    public String getActionMessage() {return actionMessage;}
}
