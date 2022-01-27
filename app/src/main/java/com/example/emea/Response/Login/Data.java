package com.example.emea.Response.Login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("type")
	private String type;

	@SerializedName("token")
	private String token;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public String getType(){
		return type;
	}

	public String getToken(){
		return token;
	}

	public String getUsername(){
		return username;
	}

	public String getStatus(){
		return status;
	}
}