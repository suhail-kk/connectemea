package com.example.emea.Response;

import com.google.gson.annotations.SerializedName;

public class EducationResponse {

    @SerializedName("status")
    private String status;

    public String getStatus(){
        return status;
    }
}
