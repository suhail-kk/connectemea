package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}
}