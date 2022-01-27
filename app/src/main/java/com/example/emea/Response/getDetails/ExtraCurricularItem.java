package com.example.emea.Response.getDetails;

import com.google.gson.annotations.SerializedName;

public class ExtraCurricularItem{

	@SerializedName("yearOfParticipation")
	private String yearOfParticipation;

	@SerializedName("activity")
	private String activity;

	@SerializedName("Price")
	private String price;

	@SerializedName("_id")
	private String id;

	@SerializedName("detailsOfExcellenceInPerformance")
	private String detailsOfExcellenceInPerformance;

	public String getYearOfParticipation(){
		return yearOfParticipation;
	}

	public String getActivity(){
		return activity;
	}

	public String getPrice(){
		return price;
	}

	public String getId(){
		return id;
	}

	public String getDetailsOfExcellenceInPerformance(){
		return detailsOfExcellenceInPerformance;
	}
}