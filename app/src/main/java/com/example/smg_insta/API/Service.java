package com.example.smg_insta.API;

import com.example.smg_insta.DTO.CommentData;
import com.example.smg_insta.DTO.FeedResponse;
import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.DTO.MainPage_test_Response;
import com.example.smg_insta.DTO.NoticeResponse;
import com.example.smg_insta.DTO.StoryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class Service {
    // 에뮬레이터용
    private String BASE_URL = "http://10.0.2.2:8000";

    //안드로이드 폰 (오류...)
    //private String BASE_URL = "http://192.168.0.28:8000";

    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build();


    Retrofit retrofitClient =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


    //1. feed
    public FeedApi feed = retrofitClient.create(FeedApi.class);
    public FeedLikeAPI feedLike = retrofitClient.create(FeedLikeAPI.class);

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

    // 7. 팔로워/ 팔로우 목록 조회
    public GraphServerAPI graph = retrofitClient.create(GraphServerAPI.class);

    // 8. 검색 기능
    public SearchAPI search = retrofitClient.create(SearchAPI.class);

    // 9. 알림 기능
    public NoticeAPI notice = retrofitClient.create(NoticeAPI.class);


    public interface FeedApi {

        // 게시물 조회
        @GET("/feed/media/{postId}")
        Call<FeedResponse> selectOne(@Path("postId") int postId);

        @Multipart
        @POST("/feed/{accountId}/media")
        Call<ResponseBody> insertOne(@Path("accountId") String accountId, @Part List<MultipartBody.Part> multipartFile,  @Part("content") String content);

        @FormUrlEncoded
        @PATCH("/feed/{accountId}/media/{postId}")
        Call<ResponseBody> UpdateFeed(@Path("accountId") String accountId, @Path("postId") int postId, @Field("content") String content);

        @DELETE("/feed/{accountId}/media/{postId}")
        Call<ResponseBody> DeleteFeed(@Path("accountId") String accountId, @Path("postId") int postId);


        // 스토리 조회


    }



    public interface CommentApi {
        // 댓글 작성
//        @POST("/feed/{accountId}/{postId}/comment")
//        Call<ResponseBody> InsertComment(@Path("accountId") String accountId, @Path("postId") int postId, @Body CommentData comment);
        @FormUrlEncoded
        @POST("/feed/{accountId}/{postId}/comment")
        Call<ResponseBody> InsertComment(@Path("accountId") String accountId, @Path("postId") int postId, @Field("comment") String comment);


        // 댓글 삭제
        @DELETE("/feed/{accountId}/comment/{commentId}")
        Call<ResponseBody> DeleteComment(@Path("accountId") String accountId, @Path("commentId") int commentId);

        // 대댓글 작성
        @FormUrlEncoded
        @POST("/feed/{accountId}/{commentId}/reply")
        Call<ResponseBody> InsertReply(@Path("accountId") String accountId, @Path("commentId") int commentId, @Field("reply") String reply);

        // 대댓글 삭제
        @DELETE("/feed/{accountId}/reply/{replyId}")
        Call<ResponseBody> DeleteReply(@Path("accountId") String accountId, @Path("replyId") int replyId);

    }

    public interface StoryApi {

        @GET("/feed/story/{accountId}")
        Call<StoryResponse> SelectStory(@Path("accountId") String accountId);

        @Multipart
        @POST("/feed/{accountId}/story")
        Call<ResponseBody> InsertStory(@Path("accountId") String accountId, @Part("image") String image);

        @DELETE("/feed/{accountId}/story/{storyId}")
        Call<ResponseBody> DeleteStory(@Path("accountId") String accountId, @Path("storyId") int storyId);
    }

    //-----메인화면/마이페이지------
    // 메인화면 조회
    public interface SelectMainPageAPI {
        @GET("/feed/test/{accountId}/postList")
        Call<MainPage_test_Response> GetMainPost(@Path("accountId") String accountId);

        @GET("/feed/test/{accountId}/storyList")
        Call<List<MainPageResponse.Post>> GetMainStory(@Path("accountId") String accountId);
    }

//    public interface SelectMainPageAPI {
//        @GET("/feed/{accountId}")
//        Call<MainPageResponse> SelectMainPage(@Path("accountId") String accountId);
//    }




    public interface SearchAPI {
        @GET("/feed/users")
        Call<List<String>> searchUser(@Query("keyword") String keyword);

    }

    public interface NoticeAPI {
        @GET("/feed/alarm/{accountId}")
        Call<List<NoticeResponse>> getNoticeList (@Path("accountId") String accountId);
    }


}








