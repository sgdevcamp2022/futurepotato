package com.example.smg_insta.API;

import com.example.smg_insta.DTO.MypageResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// 마이페이지 조회
public interface SelectMyPageAPI {
    @GET("/feed/mypage/{accountId}")
    Call<MypageResponse> SelectMyPage(@Path("accountId") String accountId);
}
