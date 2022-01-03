package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class PhotoUploadResponse{

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public boolean isSuccess(){
		return success;
	}

	public String getMessage(){
		return message;
	}
}