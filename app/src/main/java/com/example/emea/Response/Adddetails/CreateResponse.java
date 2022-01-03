package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class CreateResponse{

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