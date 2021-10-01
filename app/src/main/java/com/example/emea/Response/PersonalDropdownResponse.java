package com.example.emea.Response;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PersonalDropdownResponse{

	@SerializedName("marital_status")
	private ArrayList<MaritalStatusItem> maritalStatus;

	@SerializedName("gender")
	private ArrayList<GenderItem> gender;

	@SerializedName("category_of_admission")
	private ArrayList<CategoryOfAdmissionItem> categoryOfAdmission;

	@SerializedName("blood_group")
	private ArrayList<BloodGroupItem> bloodGroup;

	@SerializedName("residing_at")
	private ArrayList<ResidingAtItem> residingAt;

	public ArrayList<MaritalStatusItem> getMaritalStatus(){
		return maritalStatus;
	}

	public ArrayList<GenderItem> getGender(){
		return gender;
	}

	public ArrayList<CategoryOfAdmissionItem> getCategoryOfAdmission(){
		return categoryOfAdmission;
	}

	public ArrayList<BloodGroupItem> getBloodGroup(){
		return bloodGroup;
	}

	public ArrayList<ResidingAtItem> getResidingAt(){
		return residingAt;
	}
}