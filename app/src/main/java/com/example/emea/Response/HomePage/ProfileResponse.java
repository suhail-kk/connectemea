package com.example.emea.Response.HomePage;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private String message;

	public Data getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}
}