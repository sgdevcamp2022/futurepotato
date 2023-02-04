package com.example.smg_insta.API;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class CrudService {

    private String BASE_URL = "http://10.0.2.2:8000";

    Retrofit retrofitClient =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    //1. feed
    public SelectFeedAPI select = retrofitClient.create(SelectFeedAPI.class);
    public InsertFeedAPI insert = retrofitClient.create(InsertFeedAPI.class);
    public UpdateFeedAPI update = retrofitClient.create(UpdateFeedAPI.class);
    public DeleteFeedAPI delete = retrofitClient.create(DeleteFeedAPI.class);

    // 2. 스토리



    // 3. 메인화면
    public SelectMainPageAPI selectMainPage = retrofitClient.create(SelectMainPageAPI.class);

    // 4. 마이페이지
    public SelectMyPageAPI selectMyPage = retrofitClient.create(SelectMyPageAPI.class);
    public UpdateProfileAPI updateProfile = retrofitClient.create(UpdateProfileAPI.class);
    public InsertProfileImageAPI insertProfileImage = retrofitClient.create(InsertProfileImageAPI.class);
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


