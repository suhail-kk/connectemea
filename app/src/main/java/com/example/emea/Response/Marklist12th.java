package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class Marklist12th{

	@SerializedName("subject_2_mark")
	private String subject2Mark;

	@SerializedName("subject_4_mark")
	private String subject4Mark;

	@SerializedName("subject_id1")
	private String subjectId1;

	@SerializedName("subject_id2")
	private String subjectId2;

	@SerializedName("subject_1_mark")
	private String subject1Mark;

	@SerializedName("subject_5_mark")
	private String subject5Mark;

	@SerializedName("subject_id3")
	private String subjectId3;

	@SerializedName("subject_id4")
	private String subjectId4;

	@SerializedName("subject_id5")
	private String subjectId5;

	@SerializedName("subject_3_mark")
	private String subject3Mark;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private String id;

	public String getSubject2Mark(){
		return subject2Mark;
	}

	public String getSubject4Mark(){
		return subject4Mark;
	}

	public String getSubjectId1(){
		return subjectId1;
	}

	public String getSubjectId2(){
		return subjectId2;
	}

	public String getSubject1Mark(){
		return subject1Mark;
	}

	public String getSubject5Mark(){
		return subject5Mark;
	}

	public String getSubjectId3(){
		return subjectId3;
	}

	public String getSubjectId4(){
		return subjectId4;
	}

	public String getSubjectId5(){
		return subjectId5;
	}

	public String getSubject3Mark(){
		return subject3Mark;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getId(){
		return id;
	}
}