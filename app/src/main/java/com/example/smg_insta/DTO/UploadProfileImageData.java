package com.example.smg_insta.DTO;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import okhttp3.MultipartBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public class UploadProfileImageData {

    //? 타입...?
    @SerializedName("image")
    private Uri image;
}

