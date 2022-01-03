package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class PersonalDetails{

	@SerializedName("yearOfJoin")
	private String yearOfJoin;

	@SerializedName("gender")
	private String gender;

	@SerializedName("identificationMarkTwo")
	private String identificationMarkTwo;

	@SerializedName("caste")
	private String caste;

	@SerializedName("permenentAddress")
	private String permenentAddress;

	@SerializedName("categoryOfAdmission")
	private String categoryOfAdmission;

	@SerializedName("dateOfBirth")
	private String dateOfBirth;

	@SerializedName("mobileNo")
	private long mobileNo;

	@SerializedName("distanceFromCollege")
	private String distanceFromCollege;

	@SerializedName("religion")
	private String religion;

	@SerializedName("bloodGroup")
	private String bloodGroup;

	@SerializedName("presentAddress")
	private String presentAddress;

	@SerializedName("admissionNO")
	private String admissionNO;

	@SerializedName("name")
	private String name;

	@SerializedName("identificationMarkOne")
	private String identificationMarkOne;

	@SerializedName("department")
	private String department;

	@SerializedName("residence")
	private String residence;

	@SerializedName("email")
	private String email;

	@SerializedName("maritalStatus")
	private String maritalStatus;

	public String getYearOfJoin(){
		return yearOfJoin;
	}

	public String getGender(){
		return gender;
	}

	public String getIdentificationMarkTwo(){
		return identificationMarkTwo;
	}

	public String getCaste(){
		return caste;
	}

	public String getPermenentAddress(){
		return permenentAddress;
	}

	public String getCategoryOfAdmission(){
		return categoryOfAdmission;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public long getMobileNo(){
		return mobileNo;
	}

	public String getDistanceFromCollege(){
		return distanceFromCollege;
	}

	public String getReligion(){
		return religion;
	}

	public String getBloodGroup(){
		return bloodGroup;
	}

	public String getPresentAddress(){
		return presentAddress;
	}

	public String getAdmissionNO(){
		return admissionNO;
	}

	public String getName(){
		return name;
	}

	public String getIdentificationMarkOne(){
		return identificationMarkOne;
	}

	public String getDepartment(){
		return department;
	}

	public String getResidence(){
		return residence;
	}

	public String getEmail(){
		return email;
	}

	public String getMaritalStatus(){
		return maritalStatus;
	}
}