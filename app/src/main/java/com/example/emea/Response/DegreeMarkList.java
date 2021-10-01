package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class DegreeMarkList{

	@SerializedName("sub_mark")
	private String subMark;

	@SerializedName("open_mark")
	private String openMark;

	@SerializedName("english_mark")
	private String englishMark;

	@SerializedName("student_id")
	private String studentId;

	@SerializedName("id")
	private String id;

	@SerializedName("core_mark")
	private String coreMark;

	@SerializedName("language_mark")
	private String languageMark;

	public String getSubMark(){
		return subMark;
	}

	public String getOpenMark(){
		return openMark;
	}

	public String getEnglishMark(){
		return englishMark;
	}

	public String getStudentId(){
		return studentId;
	}

	public String getId(){
		return id;
	}

	public String getCoreMark(){
		return coreMark;
	}

	public String getLanguageMark(){
		return languageMark;
	}
}