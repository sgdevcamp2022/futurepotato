package com.example.smg_insta.DTO;

import com.google.gson.annotations.SerializedName;

public class isFollowingResponse {

    @SerializedName("result")
    private boolean result;
    @SerializedName("error")
    private String error;

    public isFollowingResponse(boolean result, String error) {
        this.result = result;
        this.error = error;
    }
    public isFollowingResponse(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }

    public String getError() {
        return error;
    }
}
