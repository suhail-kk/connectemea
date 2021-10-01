package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class FamilyViewResponse {

    @SerializedName("official_address_guardian")
    private Object officialAddressGuardian;

    @SerializedName("guardian_name")
    private String guardianName;

    @SerializedName("mother_name")
    private String motherName;

    @SerializedName("student_id")
    private String studentId;

    @SerializedName("annual_income_father")
    private String annualIncomeFather;

    @SerializedName("occupation_mother")
    private String occupationMother;

    @SerializedName("annual_income_guardian")
    private String annualIncomeGuardian;

    @SerializedName("annual_income_mother")
    private String annualIncomeMother;

    @SerializedName("occupation_guardian")
    private String occupationGuardian;

    @SerializedName("occupation_father")
    private String occupationFather;

    @SerializedName("father_name")
    private String fatherName;

    @SerializedName("edu_qualification_guardian")
    private String eduQualificationGuardian;

    @SerializedName("id")
    private String id;

    @SerializedName("edu_qualification_father")
    private String eduQualificationFather;

    @SerializedName("edu_qualification_mother")
    private String eduQualificationMother;

    @SerializedName("official_address_father")
    private Object officialAddressFather;

    @SerializedName("official_address_mother")
    private Object officialAddressMother;

    public Object getOfficialAddressGuardian() {
        return officialAddressGuardian;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getAnnualIncomeFather() {
        return annualIncomeFather;
    }

    public String getOccupationMother() {
        return occupationMother;
    }

    public String getAnnualIncomeGuardian() {
        return annualIncomeGuardian;
    }

    public String getAnnualIncomeMother() {
        return annualIncomeMother;
    }

    public String getOccupationGuardian() {
        return occupationGuardian;
    }

    public String getOccupationFather() {
        return occupationFather;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getEduQualificationGuardian() {
        return eduQualificationGuardian;
    }

    public String getId() {
        return id;
    }

    public String getEduQualificationFather() {
        return eduQualificationFather;
    }

    public String getEduQualificationMother() {
        return eduQualificationMother;
    }

    public Object getOfficialAddressFather() {
        return officialAddressFather;
    }

    public Object getOfficialAddressMother() {
        return officialAddressMother;
    }
}
