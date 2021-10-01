package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class PlusTwoCoursesItem{

	@SerializedName("course_name")
	private String courseName;

	@SerializedName("id")
	private String id;

	public String getCourseName(){
		return courseName;
	}

	public String getId(){
		return id;
	}
}