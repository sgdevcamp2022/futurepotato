package com.example.smg_insta.API;

import com.example.smg_insta.DTO.FollowData;
import com.example.smg_insta.DTO.FollowListResponse;
import com.example.smg_insta.DTO.isFollowingResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GraphServerAPI {

    // 팔로워 목록 조회
    @GET("/graph/{accountId}/follower")
    Call<FollowListResponse> readFollower(@Path("accountId") String accountId);

    // 팔로잉 목록 조회
    @GET("/graph/{accountId}/following")
    Call<FollowListResponse> readFollowing(@Path("accountId") String accountId);

    // 팔로우 등록
    @POST("/graph/{senderId}/follow/{recipientId}")
    Call<ResponseBody> follow(@Path("senderId") String senderId, @Path("recipientId") String recipientId);

    // 팔로우 취소
    @DELETE("/graph/{senderId}/follow/{recipientId}")
    Call<ResponseBody> unfollow(@Path("senderId") String senderId, @Path("recipientId") String recipientId);

    // 차단
    @POST("/graph/{senderId}/block/{recipientId}")
    Call<ResponseBody> block(@Path("senderId") String senderId, @Path("recipientId") String recipientId);

    // 차단 해제
    @DELETE("/graph/{senderId}/block/{recipientId}")
    Call<ResponseBody> unblock(@Path("senderId") String senderId, @Path("recipientId") String recipientId);

    // blocker 목록 조회
    // FollowListResponse랑 Request Body형식이 같아서 그대로 사용함.
    @GET("/graph/{accountId}/blocker")
    Call<FollowListResponse> getBlockerList(@Path("accountId") String accountId);

    // blocking 목록 조회
    @GET("/graph/{accountId}/blocking")
    Call<FollowListResponse> getBlockingList(@Path("accountId") String accountId);

    // 팔로우 여부 조회
    @GET("/graph/{senderId}/isFollowing/{recipientId}")
    Call<Boolean> isFollowing(@Path("senderId") String senderId, @Path("recipientId") String recipientId);


    // 차단여부 조회
    @GET("/graph/{senderId}/isBlocking/{recipientId}")
    Call<Boolean> isBlocking(@Path("senderId") String senderId, @Path("recipientId") String recipientId);

}

