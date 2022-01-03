package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("student")
	private Student student;

	public Student getStudent(){
		return student;
	}
}