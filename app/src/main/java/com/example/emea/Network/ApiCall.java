package com.example.emea.Network;


import com.example.emea.Response.EducationResponse;
import com.example.emea.Response.LoggingResponse;
import com.example.emea.Response.StudentItem;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiCall {


    @GET("students/view")
    Call<StudentItem> getUser(@Header("token") String authtoken);


    @FormUrlEncoded
    @POST("users/login")
    Call<LoggingResponse> getLoginToken(@FieldMap HashMap<String, String> params);

//    @POST("users/register")
//    Call<RegisterResponse> getRegistrationStatus(@FieldMap HashMap<String,String> params);

    //educational details
    @FormUrlEncoded
    @POST("students/add_educational_details")
    Call<EducationResponse> getEducation(@FieldMap HashMap<String, String> params, @Header("token") String authentoken);

}







