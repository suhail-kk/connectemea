package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class Educational10thDetails{

	@SerializedName("syllabus")
	private Object syllabus;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("school_name")
	private String schoolName;

	@SerializedName("id")
	private String id;

	@SerializedName("medium")
	private String medium;

	public Object getSyllabus(){
		return syllabus;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getSchoolName(){
		return schoolName;
	}

	public String getId(){
		return id;
	}

	public String getMedium(){
		return medium;
	}
}