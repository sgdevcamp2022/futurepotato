package com.example.smg_insta.DTO;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class UpdateProfileData {

    @Nullable
    @SerializedName("accountId")
    private String accountId;

    @Nullable
    @SerializedName("accountName")
    private String accountName;

}
