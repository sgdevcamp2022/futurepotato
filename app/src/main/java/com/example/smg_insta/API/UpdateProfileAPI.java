package com.example.smg_insta.API;

import com.example.smg_insta.DTO.UpdateProfileData;
import com.example.smg_insta.DTO.UpdateProfileId;
import com.example.smg_insta.DTO.UpdateProfileName;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

// 프로필 편집
public interface UpdateProfileAPI {
    @PATCH("/feed/mypage/{accountId}")
    Call<ResponseBody> UpdateProfile(@Path("accountId") String accountId, @Body UpdateProfileData updateProfile);

    @PATCH("/feed/mypage/{accountId}")
    Call<ResponseBody> UpdateProfile_id(@Path("accountId") String accountId, @Body UpdateProfileId UpdateProfileId);

    @PATCH("/feed/mypage/{accountId}")
    Call<ResponseBody> UpdateProfile_name(@Path("accountId") String accountId, @Body UpdateProfileName updateProfileName);
}
