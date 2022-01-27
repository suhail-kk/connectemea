package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class FamilyDetails{

	@SerializedName("mother")
	private Mother mother;

	@SerializedName("father")
	private Father father;

	@SerializedName("guardian")
	private Guardian guardian;

	public Mother getMother(){
		return mother;
	}

	public Father getFather(){
		return father;
	}

	public Guardian getGuardian(){
		return guardian;
	}
}