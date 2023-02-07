package com.example.smg_insta.API;

import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.DTO.JoinData;
import com.example.smg_insta.DTO.JoinResponse;
import com.example.smg_insta.DTO.LoginData;
import com.example.smg_insta.DTO.LoginResponse;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.DTO.StoryResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class Service {

    private String BASE_URL = "http://10.0.2.2:8003";

    Retrofit retrofitClient =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    //1. feed
    public FeedApi feed = retrofitClient.create(FeedApi.class);

    // 2. 스토리
    public StoryApi story = retrofitClient.create(StoryApi.class);


    // 3. 메인화면
    public SelectMainPageAPI selectMainPage = retrofitClient.create(SelectMainPageAPI.class);

    // 4. 마이페이지
    public SelectMyPageAPI selectMyPage = retrofitClient.create(SelectMyPageAPI.class);
    public UpdateProfileAPI updateProfile = retrofitClient.create(UpdateProfileAPI.class);
    public InsertProfileImageAPI insertProfileImage = retrofitClient.create(InsertProfileImageAPI.class);

    // 5. 댓글
    public CommentApi comment = retrofitClient.create(CommentApi.class);

    // 6. 로그인/회원가입
    public LoginApi login = retrofitClient.create(LoginApi.class);


    public interface FeedApi {

        @GET("/feed/media/{postId}")
        Call<FeedResponse> selectOne(@Path("postId") int postId);

        @Multipart
        @POST("/feed/{accountId}/media")
        Call<ResponseBody> insertOne(@Path("accountId") String accountId, @Part String comment, @Part List<MultipartBody.Part> files);

        @FormUrlEncoded
        @PATCH("/feed/{accountId}/media/{postId}")
        Call<ResponseBody> UpdateFeed(@Path("accountId") String accountId, @Path("postId") int postId, @Field("content") String content);

        @POST("/feed/{accountId}/media/{postId}")
        Call<ResponseBody> DeleteFeed(@Path("accountId") String accountId, @Path("postId") int postId);
    }




    public interface CommentApi {
        // 댓글 작성
        @FormUrlEncoded
        @POST("/feed/{accountId}/{postId}/comment")
        Call<ResponseBody> InsertComment(@Path("accountId") String accountId, @Path("postId") int postId, @Field("comment") String comment);


        // 댓글 삭제
        @POST("/feed/{accountId}/comment/{commentId}")
        Call<ResponseBody> DeleteComment(@Path("accountId") String accountId, @Path("commentId") int commentId);

        // 대댓글 작성
        @FormUrlEncoded
        @POST("/feed/{accountId}/{commentId}/reply")
        Call<ResponseBody> InsertReply(@Path("accountId") String accountId, @Path("commentId") String commentId, @Field("reply") String reply);

        // 대댓글 삭제
        @POST("/feed/{accountId}/reply/{replyId}")
        Call<ResponseBody> DeleteReply(@Path("accountId") String accountId, @Path("replyId") String replyId);

    }

    public interface StoryApi {

        @GET("/feed/story/{accountId}/{image}")
        Call<StoryResponse> SelectStory(@Path("accountId") String accountId, @Path("image") String image);

        @Multipart
        @POST("/feed/{accountId}/story")
        Call<ResponseBody> InsertStory(@Path("accountId") String accountId, @Part("image") String image);

        @DELETE("/feed/{accountId}/story/{storyId}")
        Call<ResponseBody> DeleteStory(@Path("accountId") String accountId, @Path("storyId") String storyId);
    }

    //-----메인화면/마이페이지------
    // 메인화면 조회
    public interface SelectMainPageAPI {
        @GET("/feed/{accountId}")
        Call<MainPageResponse> SelectMainPage(@Path("accountId") String accountId);
    }


}








