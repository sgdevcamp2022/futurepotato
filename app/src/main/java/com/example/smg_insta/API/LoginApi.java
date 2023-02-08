package com.example.smg_insta.API;

import com.example.smg_insta.DTO.JoinData;
import com.example.smg_insta.DTO.JoinResponse;
import com.example.smg_insta.DTO.LoginData;
import com.example.smg_insta.DTO.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST("/auth/signin")
    Call<LoginResponse> userLogin(@Body LoginData data);

    @POST("/auth/signup")
    //@POST("/signup")
    Call<JoinResponse> userJoin(@Body JoinData data);

}
