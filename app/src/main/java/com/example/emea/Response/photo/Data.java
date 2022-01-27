package com.example.emea.Response.photo;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("filepath")
	private String filepath;

	public String getFilepath(){
		return filepath;
	}
}