package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class LoggingResponse{

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private String status;

	@SerializedName("token")
	private String token;

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}

	public String getToken(){
		return token;
	}
}