package com.example.emea.Response.Adddetails;

import com.example.emea.Response.Adddetails.EducationDetails;
import com.example.emea.Response.Adddetails.FamilyDetails;
import com.example.emea.Response.Adddetails.PersonalDetails;
import com.google.gson.annotations.SerializedName;

public class Student{

	@SerializedName("educationDetails")
	private EducationDetails educationDetails;

	@SerializedName("sponsorId")
	private String sponsorId;

	@SerializedName("__v")
	private int V;

	@SerializedName("personalDetails")
	private PersonalDetails personalDetails;

	@SerializedName("_id")
	private String id;

	@SerializedName("familyDetails")
	private FamilyDetails familyDetails;

	@SerializedName("userId")
	private String userId;

	public EducationDetails getEducationDetails(){
		return educationDetails;
	}

	public String getSponsorId(){
		return sponsorId;
	}

	public int getV(){
		return V;
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

	public String getUserId(){
		return userId;
	}
}