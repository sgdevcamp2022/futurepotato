package com.example.smg_insta.DTO;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UpdateProfileData {

    @SerializedName("accountId")
    private String accountId;

    @SerializedName("accountName")
    private String accountName;

    public UpdateProfileData(String updateId, String updateName) {
        this.accountId = updateId;
        this.accountName = updateName;
    }
}

