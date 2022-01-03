package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class FamilyDetails{

	@SerializedName("mother")
	private Mother mother;

	@SerializedName("father")
	private Father father;

	@SerializedName("gardian")
	private Gardian gardian;

	public Mother getMother(){
		return mother;
	}

	public Father getFather(){
		return father;
	}

	public Gardian getGardian(){
		return gardian;
	}
}