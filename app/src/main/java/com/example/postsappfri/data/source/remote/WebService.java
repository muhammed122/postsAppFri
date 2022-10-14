package com.example.postsappfri.data.source.remote;

import com.example.postsappfri.data.model.comment.CommentResponseItem;
import com.example.postsappfri.data.model.post.PostResponseItem;
import com.example.postsappfri.data.model.userModel.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebService {


    @GET("posts")
    Call<List<PostResponseItem>> getPosts();

    @POST("posts")
    Call<PostResponseItem> addPost(@Body PostResponseItem post );

    @GET("posts/{id}")
    Call<PostResponseItem> getPost(@Path("id") int id);


    @GET("comments")
    Call<List<CommentResponseItem>> getPostComments(@Query("postId") int postId);


    @POST("api/login")
    @FormUrlEncoded
    Call<UserResponse> testLogin(@Field("email") String email, @Field("password") String password);

}
