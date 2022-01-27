package com.example.emea.Response.getDetails;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TwelthStd{

	@SerializedName("subMark")
	private List<String> subMark;

	@SerializedName("syllabus")
	private String syllabus;

	@SerializedName("sub")
	private List<String> sub;

	@SerializedName("course")
	private String course;

	@SerializedName("schoolName")
	private String schoolName;

	public List<String> getSubMark(){
		return subMark;
	}

	public String getSyllabus(){
		return syllabus;
	}

	public List<String> getSub(){
		return sub;
	}

	public String getCourse(){
		return course;
	}

	public String getSchoolName(){
		return schoolName;
	}
}