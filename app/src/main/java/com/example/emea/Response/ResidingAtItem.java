package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class ResidingAtItem{

	@SerializedName("residing")
	private String residing;

	@SerializedName("id")
	private String id;

	public String getResiding(){
		return residing;
	}

	public String getId(){
		return id;
	}
}