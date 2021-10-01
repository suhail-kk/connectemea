package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class EducationViewResponse{

	@SerializedName("educational_10th_details")
	private Educational10thDetails educational10thDetails;

	@SerializedName("marklist_12th")
	private Marklist12th marklist12th;

	@SerializedName("degree_details")
	private DegreeDetails degreeDetails;

	@SerializedName("marklist_10th")
	private Marklist10th marklist10th;

	@SerializedName("educational_12th_details")
	private Educational12thDetails educational12thDetails;

	@SerializedName("additional_course")
	private AdditionalCourse additionalCourse;

	@SerializedName("degree_mark_list")
	private DegreeMarkList degreeMarkList;

	@SerializedName("other_qualifications")
	private OtherQualifications otherQualifications;

	public Educational10thDetails getEducational10thDetails(){
		return educational10thDetails;
	}

	public Marklist12th getMarklist12th(){
		return marklist12th;
	}

	public DegreeDetails getDegreeDetails(){
		return degreeDetails;
	}

	public Marklist10th getMarklist10th(){
		return marklist10th;
	}

	public Educational12thDetails getEducational12thDetails(){
		return educational12thDetails;
	}

	public AdditionalCourse getAdditionalCourse(){
		return additionalCourse;
	}

	public DegreeMarkList getDegreeMarkList(){
		return degreeMarkList;
	}

	public OtherQualifications getOtherQualifications(){
		return otherQualifications;
	}
}