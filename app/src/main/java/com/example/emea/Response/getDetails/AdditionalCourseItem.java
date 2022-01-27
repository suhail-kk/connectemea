package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class AdditionalCourseItem{

	@SerializedName("courseName")
	private String courseName;

	@SerializedName("university")
	private String university;

	@SerializedName("institutionName")
	private String institutionName;

	@SerializedName("_id")
	private String id;

	@SerializedName("cgp")
	private int cgp;

	public String getCourseName(){
		return courseName;
	}

	public String getUniversity(){
		return university;
	}

	public String getInstitutionName(){
		return institutionName;
	}

	public String getId(){
		return id;
	}

	public int getCgp(){
		return cgp;
	}
}