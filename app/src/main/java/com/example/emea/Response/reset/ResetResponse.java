package com.example.emea.Response.reset;

import com.google.gson.annotations.SerializedName;

public class ResetResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}