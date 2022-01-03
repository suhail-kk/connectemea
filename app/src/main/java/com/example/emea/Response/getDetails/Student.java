package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class Student{

	@SerializedName("educationDetails")
	private EducationDetails educationDetails;

	@SerializedName("sponsorId")
	private String sponsorId;

	@SerializedName("personalDetails")
	private PersonalDetails personalDetails;

	@SerializedName("_id")
	private String id;

	@SerializedName("familyDetails")
	private FamilyDetails familyDetails;

	@SerializedName("userId")
	private UserId userId;

	public EducationDetails getEducationDetails(){
		return educationDetails;
	}

	public String getSponsorId(){
		return sponsorId;
	}

	public PersonalDetails getPersonalDetails(){
		return personalDetails;
	}

	public String getId(){
		return id;
	}

	public FamilyDetails getFamilyDetails(){
		return familyDetails;
	}

	public UserId getUserId(){
		return userId;
	}
}