package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("student")
	private Student student;

	@SerializedName("user")
	private User user;

	public Student getStudent(){
		return student;
	}

	public User getUser(){
		return user;
	}
}