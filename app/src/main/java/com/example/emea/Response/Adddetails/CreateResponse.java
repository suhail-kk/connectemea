package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class CreateResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}