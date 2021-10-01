package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class DegreeDetails{

	@SerializedName("college_name")
	private String collegeName;

	@SerializedName("course_name")
	private String courseName;

	@SerializedName("university")
	private String university;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private String id;

	public String getCollegeName(){
		return collegeName;
	}

	public String getCourseName(){
		return courseName;
	}

	public String getUniversity(){
		return university;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getId(){
		return id;
	}
}