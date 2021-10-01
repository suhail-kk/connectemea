package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class PlusTwoSubjectsItem{

	@SerializedName("subject")
	private String subject;

	@SerializedName("id")
	private String id;

	public String getSubject(){
		return subject;
	}

	public String getId(){
		return id;
	}
}