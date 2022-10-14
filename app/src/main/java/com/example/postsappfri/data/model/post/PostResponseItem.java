package com.example.postsappfri.data.model.post;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PostResponseItem implements Serializable {

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String postTitle;

	@SerializedName("body")
	private String body;

	@SerializedName("userId")
	private int userId;

	public int getId(){
		return id;
	}

	public String getTitle(){
		return postTitle;
	}

	public String getBody(){
		return body;
	}

	public int getUserId(){
		return userId;
	}
}