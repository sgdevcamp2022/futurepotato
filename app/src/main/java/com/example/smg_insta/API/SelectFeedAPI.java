package com.example.smg_insta.API;

import com.example.smg_insta.DTO.FeedResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

// 게시물 조회
public interface SelectFeedAPI {
    @GET("/feed/media/{postId}")
    Call<FeedResponse> selectOne(@Path("postId") int postId);
}
