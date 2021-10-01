package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class DegreeCoursesItem{

	@SerializedName("course")
	private String course;

	@SerializedName("id")
	private String id;

	public String getCourse(){
		return course;
	}

	public String getId(){
		return id;
	}
}