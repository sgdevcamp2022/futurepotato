package com.example.smg_insta.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

// 게시물 수정
public interface UpdateFeedAPI {
    @FormUrlEncoded
    @PATCH("/feed/{accountId}/media/{postId}")
    Call<ResponseBody> UpdateFeed(@Path("accountId") String accountId, @Path("postId") int postId, @Field("content") String content);
}
