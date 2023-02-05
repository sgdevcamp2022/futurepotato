package com.example.smg_insta.DTO;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class JoinData {

    @SerializedName("email")
    private String email;

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountPw")
    private String accountPw;

    @Nullable
    @SerializedName("accountName")
    private String accountName;

    public JoinData(String email, String accountId, String accountPw, String accountName) {
        this.email = email;
        this.accountId = accountId;
        this.accountPw = accountPw;
        this.accountName = accountName;

    }

    public JoinData(String email, String accountId, String accountPw) {
        this.email = email;
        this.accountId = accountId;
        this.accountPw = accountPw;
    }
}
