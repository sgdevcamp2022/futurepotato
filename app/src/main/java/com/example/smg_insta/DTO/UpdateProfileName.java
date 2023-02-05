package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class UpdateProfileName {
    @SerializedName("accountName")
    private String accountName;

    public UpdateProfileName(String updateName) {
        this.accountName = updateName;
    }
}
