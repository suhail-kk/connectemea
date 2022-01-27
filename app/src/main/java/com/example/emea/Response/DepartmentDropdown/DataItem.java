package com.example.emea.Response.DepartmentDropdown;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("createdBy")
	private String createdBy;

	@SerializedName("__v")
	private int V;

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

	public String getCreatedAt(){
		return createdAt;
	}

	public String getCreatedBy(){
		return createdBy;
	}

	public int getV(){
		return V;
	}

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