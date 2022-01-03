package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class TenthStd{

	@SerializedName("syllabus")
	private String syllabus;

	@SerializedName("maths")
	private int maths;

	@SerializedName("science")
	private int science;

	@SerializedName("english")
	private int english;

	@SerializedName("socialScience")
	private int socialScience;

	@SerializedName("schoolName")
	private String schoolName;

	public String getSyllabus(){
		return syllabus;
	}

	public int getMaths(){
		return maths;
	}

	public int getScience(){
		return science;
	}

	public int getEnglish(){
		return english;
	}

	public int getSocialScience(){
		return socialScience;
	}

	public String getSchoolName(){
		return schoolName;
	}
}