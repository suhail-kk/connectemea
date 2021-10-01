package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class OtherQualifications{

	@SerializedName("instiution")
	private String instiution;

	@SerializedName("course_type")
	private String courseType;

	@SerializedName("course_name")
	private String courseName;

	@SerializedName("recongnisation")
	private String recongnisation;

	@SerializedName("grade")
	private String grade;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private String id;

	public String getInstiution(){
		return instiution;
	}

	public String getCourseType(){
		return courseType;
	}

	public String getCourseName(){
		return courseName;
	}

	public String getRecongnisation(){
		return recongnisation;
	}

	public String getGrade(){
		return grade;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getId(){
		return id;
	}
}