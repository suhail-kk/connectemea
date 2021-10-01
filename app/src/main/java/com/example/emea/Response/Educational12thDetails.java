package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class Educational12thDetails {

	@SerializedName("syllabus")
	private String syllabus;

	@SerializedName("course_id")
	private String courseId;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("school_name")
	private String schoolName;

	@SerializedName("id")
	private String id;

	@SerializedName("medium")
	private String medium;

	public String getSyllabus() {
		return syllabus;
	}

	public String getCourseId() {
		return courseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getId() {
		return id;
	}

	public String getMedium() {
		return medium;
	}
}