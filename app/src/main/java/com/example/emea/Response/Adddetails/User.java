package com.example.emea.Response.Adddetails;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("upsertedId")
	private Object upsertedId;

	@SerializedName("upsertedCount")
	private int upsertedCount;

	@SerializedName("acknowledged")
	private boolean acknowledged;

	@SerializedName("modifiedCount")
	private int modifiedCount;

	@SerializedName("matchedCount")
	private int matchedCount;

	public Object getUpsertedId(){
		return upsertedId;
	}

	public int getUpsertedCount(){
		return upsertedCount;
	}

	public boolean isAcknowledged(){
		return acknowledged;
	}

	public int getModifiedCount(){
		return modifiedCount;
	}

	public int getMatchedCount(){
		return matchedCount;
	}
}