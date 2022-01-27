package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class DegreeItem{

	@SerializedName("college")
	private String college;

	@SerializedName("core")
	private String core;

	@SerializedName("commonTwo")
	private String commonTwo;

	@SerializedName("university")
	private String university;

	@SerializedName("course")
	private String course;

	@SerializedName("commonOne")
	private String commonOne;

	@SerializedName("_id")
	private String id;

	@SerializedName("open")
	private String open;

	public String getCollege(){
		return college;
	}

	public String getCore(){
		return core;
	}

	public String getCommonTwo(){
		return commonTwo;
	}

	public String getUniversity(){
		return university;
	}

	public String getCourse(){
		return course;
	}

	public String getCommonOne(){
		return commonOne;
	}

	public String getId(){
		return id;
	}

	public String getOpen(){
		return open;
	}
}