package com.example.emea.Response.Login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("userToken")
	private String userToken;

	public String getUserToken(){
		return userToken;
	}
}