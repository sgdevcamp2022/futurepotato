package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class JoinResponse {

    @SerializedName("token")
    private String token;

    @SerializedName("id")
    private String id;

    @SerializedName("email")
    private String email;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountPw")
    private String accountPw;

    @SerializedName("accountName")
    private String accountName;

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

}
