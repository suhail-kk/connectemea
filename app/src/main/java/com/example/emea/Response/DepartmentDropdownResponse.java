package com.example.emea.Response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DepartmentDropdownResponse{

	@SerializedName("department")
	private ArrayList<DepartmentItem> department;

	public ArrayList<DepartmentItem> getDepartment(){
		return department;
	}
}