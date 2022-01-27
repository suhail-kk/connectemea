package com.example.emea.Response.edit;

import com.google.gson.annotations.SerializedName;

public class EditResponse{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}