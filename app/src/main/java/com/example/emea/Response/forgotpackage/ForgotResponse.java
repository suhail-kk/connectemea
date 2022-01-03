package com.example.emea.Response.forgotpackage;

import com.google.gson.annotations.SerializedName;

public class ForgotResponse{

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