package com.example.emea.Response.Adddetails;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class EducationDetails{

	@SerializedName("additionalCourse")
	private List<Object> additionalCourse;

	@SerializedName("tenthStd")
	private TenthStd tenthStd;

	@SerializedName("twelthStd")
	private TwelthStd twelthStd;

	@SerializedName("degree")
	private List<Object> degree;

	@SerializedName("extraCurricular")
	private List<Object> extraCurricular;

	@SerializedName("otherQualifications")
	private List<Object> otherQualifications;

	public List<Object> getAdditionalCourse(){
		return additionalCourse;
	}

	public TenthStd getTenthStd(){
		return tenthStd;
	}

	public TwelthStd getTwelthStd(){
		return twelthStd;
	}

	public List<Object> getDegree(){
		return degree;
	}

	public List<Object> getExtraCurricular(){
		return extraCurricular;
	}

	public List<Object> getOtherQualifications(){
		return otherQualifications;
	}
}