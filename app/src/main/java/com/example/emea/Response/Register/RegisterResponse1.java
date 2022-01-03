package com.example.emea.Response.Register;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse1{

	@SerializedName("message")
	private String message;

	public String getMessage(){
		return message;
	}
}