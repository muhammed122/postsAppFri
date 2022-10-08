package com.example.postsappfri.data.source.remote;

import com.example.postsappfri.data.model.PostResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebService {


    @GET("posts")
    Call<List<PostResponseItem>> getPosts();

    @GET("posts/{id}")
    Call<PostResponseItem> getPost(@Path("id") int id);

}
