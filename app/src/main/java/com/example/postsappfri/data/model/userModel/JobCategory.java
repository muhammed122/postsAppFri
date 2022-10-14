package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class JobCategory{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}
}