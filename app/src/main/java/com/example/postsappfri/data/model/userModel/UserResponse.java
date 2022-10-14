package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class UserResponse{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("error")
	private int error;

	@SerializedName("message")
	private String message;

	public Payload getPayload(){
		return payload;
	}

	public int getError(){
		return error;
	}

	public String getMessage(){
		return message;
	}
}