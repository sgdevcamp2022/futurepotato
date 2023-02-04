package com.example.smg_insta.API;

import com.example.smg_insta.DTO.LoginData;
import com.example.smg_insta.DTO.LoginResponse;
import com.example.smg_insta.DTO.StoryResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface StoryApi {

    @GET("/feed/story/{accountId}/{image}")
    Call<StoryResponse> SelectStory(@Path("accountId") String accountId, @Path("image") String image);

    @Multipart
    @POST("/feed/{accountId}/story")
    Call<ResponseBody> InsertStory(@Path("accountId") String accountId, @Part("image") String image);

    @DELETE("/feed/{accountId}/story/{storyId}")
    Call<ResponseBody> DeleteStory(@Path("accountId") String accountId, @Path("storyId") String storyId);
}
