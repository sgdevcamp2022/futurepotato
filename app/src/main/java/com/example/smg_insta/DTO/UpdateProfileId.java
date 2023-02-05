package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class UpdateProfileId {
    @SerializedName("accountId")
    private String accountId;

    public UpdateProfileId(String updateId) {
        this.accountId = updateId;
    }
}
