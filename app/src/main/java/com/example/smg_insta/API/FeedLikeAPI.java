package com.example.smg_insta.API;

import com.example.smg_insta.DTO.FollowListResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FeedLikeAPI {


    // 게시물 좋아요
    @POST("/feed/{accountId}/likePost/{postId}")
    Call<ResponseBody> likeFeed(@Path("accountId") String accountId, @Path("postId") long postId);

    // 게시물 좋아요 취소
    @DELETE("/feed/{accountId}/likePost/{postId}")
    Call<ResponseBody> unlikeFeed(@Path("accountId") String accountId, @Path("postId") long postId);

    // 스토리 좋아요
    @POST("/feed/{accountId}/likeStory/{storyId}")
    Call<ResponseBody> likeStory(@Path("accountId") String accountId, @Path("storyId") long postId);

    // 스토리 좋아요 취소
    @DELETE("/feed/{accountId}/likeStory/{storyId}")
    Call<ResponseBody> unlikeStory(@Path("accountId") String accountId, @Path("storyId") long postId);

    // 댓글 좋아요
    @POST("/feed/{accountId}/likeComment/{commentId}")
    Call<ResponseBody> likeComment(@Path("accountId") String accountId, @Path("commentId") long commentId);

    // 댓글 좋아요 취소
    @DELETE("/feed/{accountId}/likeComment/{commentId}")
    Call<ResponseBody> unlikeComment(@Path("accountId") String accountId, @Path("commentId") long commentId);

    // 대댓글 좋아요
    @POST("/feed/{accountId}/likeReply/{replyId}")
    Call<ResponseBody> likeReply(@Path("accountId") String accountId, @Path("replyId") long replyId);

    // 대댓글 좋아요 취소
    @DELETE("/feed/{accountId}/likeReply/{replyId}")
    Call<ResponseBody> unlikeReply(@Path("accountId") String accountId, @Path("replyId") long replyId);



    // 게시글 좋아요 여부
    @GET("/feed/{accountId}/isLikePost/{postId}")
    Call<Boolean> isLikePost(@Path("accountId") String accountId, @Path("postId") long postId);
    // 스토리 좋아요 여부
    @GET("/feed/{accountId}/isLikeStory/{storyId}")
    Call<Boolean> isLikeStory(@Path("accountId") String accountId, @Path("storyId") long storyId);
    // 댓글 좋아요 여부
    @GET("/feed/{accountId}/isLikeComment/{commentId}")
    Call<Boolean> isLikeComment(@Path("accountId") String accountId, @Path("commentId") long commentId);
    // 대댓글 좋아요 여부
    @GET("/feed/{accountId}/isLikeReply/{replyId}")
    Call<Boolean> isLikeReply(@Path("accountId") String accountId, @Path("replyId") long replyId);





}
