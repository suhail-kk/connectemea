package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class SyllabusItem{

	@SerializedName("syllabus")
	private String syllabus;

	@SerializedName("id")
	private String id;

	public String getSyllabus(){
		return syllabus;
	}

	public String getId(){
		return id;
	}
}