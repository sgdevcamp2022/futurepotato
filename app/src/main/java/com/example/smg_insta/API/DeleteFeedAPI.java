package com.example.smg_insta.API;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

// 게시물 삭제
public interface DeleteFeedAPI {
    @POST("/feed/{accountId}/media/{postId}")
    Call<ResponseBody> DeleteFeed(@Path("accountId") String accountId, @Path("postId") int postId);
}
