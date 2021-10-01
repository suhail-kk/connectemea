package com.example.emea.Response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DepartmentDropdownResponse{

	@SerializedName("departments")
	private ArrayList<DepartmentsItem> departments;

	public ArrayList<DepartmentsItem> getDepartments(){
		return departments;
	}
}