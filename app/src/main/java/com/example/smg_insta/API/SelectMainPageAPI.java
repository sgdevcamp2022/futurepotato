package com.example.smg_insta.API;

import com.example.smg_insta.DTO.MainPageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//-----메인화면/마이페이지------
// 메인화면 조회
public interface SelectMainPageAPI {
    @GET("/feed/{accountId}")
    Call<MainPageResponse> SelectMainPage(@Path("accountId") String accountId);
}
