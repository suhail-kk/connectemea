package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class StudentItem{

	@SerializedName("admission_category")
	private String admissionCategory;

	@SerializedName("identification_mark_1")
	private String identificationMark1;

	@SerializedName("identification_mark_2")
	private String identificationMark2;

	@SerializedName("present_address")
	private String presentAddress;

	@SerializedName("gender")
	private String gender;

	@SerializedName("date_of_birth")
	private String dateOfBirth;

	@SerializedName("permanent_address")
	private String permanentAddress;

	@SerializedName("profile_image")
	private String profileImage;

	@SerializedName("roll_no")
	private String rollNo;

	@SerializedName("staff_id")
	private Object staffId;

	@SerializedName("joining_year")
	private String joiningYear;

	@SerializedName("id")
	private String id;

	@SerializedName("department")
	private String department;

	@SerializedName("email")
	private String email;

	@SerializedName("caste")
	private String caste;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("distance_to_college")
	private String distanceToCollege;

	@SerializedName("career_plan")
	private Object careerPlan;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("religion")
	private String religion;

	@SerializedName("residing_at")
	private String residingAt;

	@SerializedName("marital_status")
	private String maritalStatus;

	@SerializedName("name")
	private String name;

	@SerializedName("blood_group")
	private String bloodGroup;

	@SerializedName("admission_no")
	private String admissionNo;

	public String getAdmissionCategory(){
		return admissionCategory;
	}

	public String getIdentificationMark1(){
		return identificationMark1;
	}

	public String getIdentificationMark2(){
		return identificationMark2;
	}

	public String getPresentAddress(){
		return presentAddress;
	}

	public String getGender(){
		return gender;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public String getPermanentAddress(){
		return permanentAddress;
	}

	public String getProfileImage(){
		return profileImage;
	}

	public String getRollNo(){
		return rollNo;
	}

	public Object getStaffId(){
		return staffId;
	}

	public String getJoiningYear(){
		return joiningYear;
	}

	public String getId(){
		return id;
	}

	public String getDepartment(){
		return department;
	}

	public String getEmail(){
		return email;
	}

	public String getCaste(){
		return caste;
	}

	public String getMobile(){
		return mobile;
	}

	public String getDistanceToCollege(){
		return distanceToCollege;
	}

	public Object getCareerPlan(){
		return careerPlan;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getReligion(){
		return religion;
	}

	public String getResidingAt(){
		return residingAt;
	}

	public String getMaritalStatus(){
		return maritalStatus;
	}

	public String getName(){
		return name;
	}

	public String getBloodGroup(){
		return bloodGroup;
	}

	public String getAdmissionNo(){
		return admissionNo;
	}
}