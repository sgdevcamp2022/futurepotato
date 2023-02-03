package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class LoginData {

    @SerializedName("accountId")
    String accountId;

    @SerializedName("accountPw")
    String accountPw;

    public LoginData(String accountId, String accountPw) {
        this.accountId = accountId;
        this.accountPw = accountPw;
    }
}
