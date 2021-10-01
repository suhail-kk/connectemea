package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class MaritalStatusItem{

	@SerializedName("marital_status")
	private String maritalStatus;

	@SerializedName("id")
	private String id;

	public String getMaritalStatus(){
		return maritalStatus;
	}

	public String getId(){
		return id;
	}
}