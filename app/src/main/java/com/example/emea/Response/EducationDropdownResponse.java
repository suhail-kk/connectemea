package com.example.emea.Response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class EducationDropdownResponse{

	@SerializedName("plus_two_courses")
	private ArrayList<PlusTwoCoursesItem> plusTwoCourses;

	@SerializedName("plus_two_subjects")
	private ArrayList<PlusTwoSubjectsItem> plusTwoSubjects;

	@SerializedName("syllabus")
	private ArrayList<SyllabusItem> syllabus;

	@SerializedName("degree_courses")
	private ArrayList<DegreeCoursesItem> degreeCourses;

	@SerializedName("university")
	private ArrayList<UniversityItem> university;

	public ArrayList<PlusTwoCoursesItem> getPlusTwoCourses(){
		return plusTwoCourses;
	}

	public ArrayList<PlusTwoSubjectsItem> getPlusTwoSubjects(){
		return plusTwoSubjects;
	}

	public ArrayList<SyllabusItem> getSyllabus(){
		return syllabus;
	}

	public ArrayList<DegreeCoursesItem> getDegreeCourses(){
		return degreeCourses;
	}

	public ArrayList<UniversityItem> getUniversity(){
		return university;
	}
}