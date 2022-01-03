package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class UserId{

	@SerializedName("_id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public String getId(){
		return id;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}

	public String getStatus(){
		return status;
	}
}