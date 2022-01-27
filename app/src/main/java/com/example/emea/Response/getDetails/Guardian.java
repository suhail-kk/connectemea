package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class Guardian{

	@SerializedName("occupation")
	private String occupation;

	@SerializedName("annualIncome")
	private String annualIncome;

	@SerializedName("name")
	private String name;

	@SerializedName("officialAddress")
	private String officialAddress;

	@SerializedName("educationQualification")
	private String educationQualification;

	public String getOccupation(){
		return occupation;
	}

	public String getAnnualIncome(){
		return annualIncome;
	}

	public String getName(){
		return name;
	}

	public String getOfficialAddress(){
		return officialAddress;
	}

	public String getEducationQualification(){
		return educationQualification;
	}
}