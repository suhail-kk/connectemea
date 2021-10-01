package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class AdditionalCourse{

	@SerializedName("instiution")
	private Object instiution;

	@SerializedName("course_type")
	private Object courseType;

	@SerializedName("recongnisation")
	private Object recongnisation;

	@SerializedName("grade")
	private Object grade;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("course")
	private String course;

	@SerializedName("id")
	private String id;

	public Object getInstiution(){
		return instiution;
	}

	public Object getCourseType(){
		return courseType;
	}

	public Object getRecongnisation(){
		return recongnisation;
	}

	public Object getGrade(){
		return grade;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getCourse(){
		return course;
	}

	public String getId(){
		return id;
	}
}