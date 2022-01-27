package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class UserId{

	@SerializedName("_id")
	private String id;

	@SerializedName("profileImage")
	private String profileImage;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	@SerializedName("status")
	private String status;

	public String getId(){
		return id;
	}

	public String getProfileImage(){
		return profileImage;
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