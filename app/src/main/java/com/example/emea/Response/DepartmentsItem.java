package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class DepartmentsItem{

	@SerializedName("department_img")
	private Object departmentImg;

	@SerializedName("department_name")
	private String departmentName;

	@SerializedName("contact")
	private String contact;

	@SerializedName("short_form")
	private String shortForm;

	@SerializedName("id")
	private String id;

	@SerializedName("hod_name")
	private String hodName;

	public Object getDepartmentImg(){
		return departmentImg;
	}

	public String getDepartmentName(){
		return departmentName;
	}

	public String getContact(){
		return contact;
	}

	public String getShortForm(){
		return shortForm;
	}

	public String getId(){
		return id;
	}

	public String getHodName(){
		return hodName;
	}
}