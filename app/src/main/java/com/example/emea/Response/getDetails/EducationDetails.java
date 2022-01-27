package com.example.emea.Response.getDetails;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EducationDetails{

	@SerializedName("additionalCourse")
	private List<AdditionalCourseItem> additionalCourse;

	@SerializedName("tenthStd")
	private TenthStd tenthStd;

	@SerializedName("twelthStd")
	private TwelthStd twelthStd;

	@SerializedName("degree")
	private List<DegreeItem> degree;

	@SerializedName("extraCurricular")
	private List<ExtraCurricularItem> extraCurricular;

	@SerializedName("otherQualifications")
	private List<OtherQualificationsItem> otherQualifications;

	public List<AdditionalCourseItem> getAdditionalCourse(){
		return additionalCourse;
	}

	public TenthStd getTenthStd(){
		return tenthStd;
	}

	public TwelthStd getTwelthStd(){
		return twelthStd;
	}

	public List<DegreeItem> getDegree(){
		return degree;
	}

	public List<ExtraCurricularItem> getExtraCurricular(){
		return extraCurricular;
	}

	public List<OtherQualificationsItem> getOtherQualifications(){
		return otherQualifications;
	}
}