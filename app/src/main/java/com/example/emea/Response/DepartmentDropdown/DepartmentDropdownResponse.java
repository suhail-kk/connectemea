package com.example.emea.Response.DepartmentDropdown;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DepartmentDropdownResponse{

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("message")
	private String message;

	public List<DataItem> getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}
}