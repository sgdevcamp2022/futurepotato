package com.example.smg_insta.API;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

// 프로필 사진 업로드
public interface InsertProfileImageAPI {
    @Multipart
    @POST("/feed/mypage/{accountId}")
        // 타입 불확실..
    Call<ResponseBody> InsertProfileImage(@Path("accountId") String accountId, @Part MultipartBody.Part file);

    // 옛시
    // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
    //RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), Uri filePath);

    // RequestBody로 Multipart.Part 객체 생성
    //MultipartBody.part filePart = Multipart.Part.createFormData("photo", "photo.jpg", fileBody);
}
