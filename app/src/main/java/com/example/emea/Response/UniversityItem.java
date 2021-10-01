package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class UniversityItem{

	@SerializedName("university")
	private String university;

	@SerializedName("id")
	private String id;

	public String getUniversity(){
		return university;
	}

	public String getId(){
		return id;
	}
}