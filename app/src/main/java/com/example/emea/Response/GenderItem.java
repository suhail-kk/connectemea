package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class GenderItem{

	@SerializedName("gender")
	private String gender;

	@SerializedName("id")
	private String id;

	public String getGender(){
		return gender;
	}

	public String getId(){
		return id;
	}
}