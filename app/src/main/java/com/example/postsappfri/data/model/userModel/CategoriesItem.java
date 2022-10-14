package com.example.postsappfri.data.model.userModel;

import com.google.gson.annotations.SerializedName;

public class CategoriesItem{

	@SerializedName("image")
	private String image;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	@SerializedName("drop_shadow")
	private String dropShadow;

	public String getImage(){
		return image;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public String getType(){
		return type;
	}

	public String getDropShadow(){
		return dropShadow;
	}
}