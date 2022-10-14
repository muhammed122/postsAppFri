package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class Currency{

	@SerializedName("code")
	private String code;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}