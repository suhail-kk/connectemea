package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class GetResponse{

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