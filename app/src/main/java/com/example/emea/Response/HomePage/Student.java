package com.example.emea.Response.HomePage;

import com.google.gson.annotations.SerializedName;

public class Student{

	@SerializedName("sponsorId")
	private String sponsorId;

	@SerializedName("personalDetails")
	private PersonalDetails personalDetails;

	@SerializedName("_id")
	private String id;

	@SerializedName("userId")
	private UserId userId;

	public String getSponsorId(){
		return sponsorId;
	}

	public PersonalDetails getPersonalDetails(){
		return personalDetails;
	}

	public String getId(){
		return id;
	}

	public UserId getUserId(){
		return userId;
	}
}