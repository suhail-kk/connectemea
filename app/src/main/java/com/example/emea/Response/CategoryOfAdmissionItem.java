package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class CategoryOfAdmissionItem{

	@SerializedName("admission_category")
	private String admissionCategory;

	@SerializedName("id")
	private String id;

	public String getAdmissionCategory(){
		return admissionCategory;
	}

	public String getId(){
		return id;
	}
}