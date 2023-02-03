package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class JoinResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("accountId")
    private String accountId;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }


    @SerializedName("error")
    private String error;

    public String getError() {
        return error;
    }
}
