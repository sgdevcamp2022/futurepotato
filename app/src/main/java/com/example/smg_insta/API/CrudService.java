package com.example.smg_insta.API;

import com.example.smg_insta.DTO.MainPageResponse;
import com.example.smg_insta.DTO.UpdateProfileData;

import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public class CrudService {
    private String BASE_URL = "http://10.0.2.2:8000";

    Retrofit retrofitClient =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    public SelectFeedAPI select = retrofitClient.create(SelectFeedAPI.class);
    InsertFeedAPI insert = retrofitClient.create(InsertFeedAPI.class);
    public UpdateFeedAPI update = retrofitClient.create(UpdateFeedAPI.class);
    public DeleteFeedAPI delete = retrofitClient.create(DeleteFeedAPI.class);

    InsertFeedAPI insertFeed = retrofitClient.create(InsertFeedAPI.class);



    public SelectMainPageAPI selectMainPage = retrofitClient.create(SelectMainPageAPI.class);
    public SelectMyPageAPI selectMyPage = retrofitClient.create(SelectMyPageAPI.class);
    UpdateMyPageAPI updateMyPage = retrofitClient.create(UpdateMyPageAPI.class);
    InsertProfileImageAPI insertProfileImage = retrofitClient.create(InsertProfileImageAPI.class);
}

// 게시물 생성
interface InsertFeedAPI{
    @Multipart
    @POST("/feed/{accountId}/media")
    Call<ResponseBody> insertOne(@Path("accountId") String accountId, @Part String comment, @Part List<MultipartBody.Part> files);
}


// 프로필 편집
interface UpdateMyPageAPI {
    @PATCH("/feed/mypage/{accountId}")
    Call<ResponseBody> UpdateMyPage(@Path("accountId") String accountId, @Body UpdateProfileData updateProfile);
}
// 프로필 사진 업로드
interface InsertProfileImageAPI {
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


//---=--댓글--------
// 댓글 작성
interface InsertCommentAPI {
    @FormUrlEncoded
    @POST("/feed/{accountId}/{postId}/comment")
    Call<ResponseBody> InsertComment(@Path("accountId") String accountId, @Path("postId") String postId, @Field("comment") String comment);
}
// 댓글 삭제
interface DeleteCommentAPI {
    @POST("/feed/{accountId}/comment/{commentId}")
    Call<ResponseBody> DeleteComment(@Path("accountId") String accountId, @Path("commentId") String commentId);
}
// 대댓글 작성
interface InsertReplyAPI {
    @FormUrlEncoded
    @POST("/feed/{accountId}/{commentId}/reply")
    Call<ResponseBody> InsertComment(@Path("accountId") String accountId, @Path("commentId") String commentId, @Field("reply") String reply);
}
// 대댓글 삭제
interface DeleteReplyAPI {
    @POST("/feed/{accountId}/reply/{replyId}")
    Call<ResponseBody> DeleteComment(@Path("accountId") String accountId, @Path("replyId") String replyId);
}


