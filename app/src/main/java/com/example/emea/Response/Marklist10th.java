package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class Marklist10th{

	@SerializedName("maths")
	private String maths;

	@SerializedName("science")
	private String science;

	@SerializedName("social_studies")
	private String socialStudies;

	@SerializedName("english")
	private String english;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private String id;

	public String getMaths(){
		return maths;
	}

	public String getScience(){
		return science;
	}

	public String getSocialStudies(){
		return socialStudies;
	}

	public String getEnglish(){
		return english;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getId(){
		return id;
	}
}