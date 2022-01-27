package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class OtherQualificationsItem{

	@SerializedName("courseType")
	private String courseType;

	@SerializedName("university")
	private String university;

	@SerializedName("institutionName")
	private String institutionName;

	@SerializedName("Grade")
	private String grade;

	@SerializedName("_id")
	private String id;

	public String getCourseType(){
		return courseType;
	}

	public String getUniversity(){
		return university;
	}

	public String getInstitutionName(){
		return institutionName;
	}

	public String getGrade(){
		return grade;
	}

	public String getId(){
		return id;
	}
}