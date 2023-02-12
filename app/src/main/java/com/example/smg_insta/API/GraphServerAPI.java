package com.example.smg_insta.API;

import com.example.smg_insta.DTO.FollowListResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GraphServerAPI {

    // 팔로워 목록 조회
    @GET("/graph/{accountId}/followers")
    Call<FollowListResponse> readFollower(@Path("accountId") String accountId);

    // 팔로잉 목록 조회
    @GET("/graph/{accountId}/following")
    Call<FollowListResponse> readFollowing(@Path("accountId") String accountId);

    // 팔로우 등록
    @FormUrlEncoded
    @POST("/graph/follow")
    Call<ResponseBody> follow(@Field("senderId") String senderId, @Field("recipientId") String recipientId);

    // 팔로우 취소
    @FormUrlEncoded
    @DELETE("/graph/follow")
    Call<ResponseBody> unfollow(@Field("senderId") String senderId, @Field("recipientId") String recipientId);

    // 차단
    @FormUrlEncoded
    @POST("/graph/block")
    Call<ResponseBody> block(@Field("senderId") String senderId, @Field("recipientId") String recipientId);

    // 차단 해제
    @FormUrlEncoded
    @DELETE("/graph/block")
    Call<ResponseBody> unblock(@Field("senderId") String senderId, @Field("recipientId") String recipientId);

    // blocker 목록 조회
    // FollowListResponse랑 Request Body형식이 같아서 그대로 사용함.
    @GET("/graph/{accountId}/blocker")
    Call<FollowListResponse> getBlockerList(@Path("accountId") String accountId);

    // blocking 목록 조회
    @GET("/graph/{accountId}/blocking")
    Call<FollowListResponse> getBlockingList(@Path("accountId") String accountId);

    // 팔로우 여부 조회
    @GET("/graph/isFollowing")
    Call<Boolean> isFollowing(@Query("senderId") String senderId, @Query("recipientId") String recipientId);

    // 차단여부 조회
    @GET("/graph/isBlocking")
    Call<Boolean> isBlocking(@Query("senderId") String senderId, @Query("recipientId") String recipientId);

}
