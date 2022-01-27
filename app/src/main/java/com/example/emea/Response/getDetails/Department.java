package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class Department{

	@SerializedName("name")
	private String name;

	@SerializedName("_id")
	private String id;

	@SerializedName("shortName")
	private String shortName;

	@SerializedName("hod")
	private String hod;

	@SerializedName("phoneNo")
	private String phoneNo;

	@SerializedName("email")
	private String email;

	public String getName(){
		return name;
	}

	public String getId(){
		return id;
	}

	public String getShortName(){
		return shortName;
	}

	public String getHod(){
		return hod;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public String getEmail(){
		return email;
	}
}