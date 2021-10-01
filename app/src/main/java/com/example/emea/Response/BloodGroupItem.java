package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class BloodGroupItem{

	@SerializedName("blood_group")
	private String bloodGroup;

	@SerializedName("id")
	private String id;

	public String getBloodGroup(){
		return bloodGroup;
	}

	public String getId(){
		return id;
	}
}