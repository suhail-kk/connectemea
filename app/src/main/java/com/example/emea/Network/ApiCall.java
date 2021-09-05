package com.example.emea.Network;


import com.example.emea.Response.EducationResponse;
import com.example.emea.Response.EducationViewResponse;
import com.example.emea.Response.FamilyResponse;
import com.example.emea.Response.ForgotResponse;
import com.example.emea.Response.LoggingResponse;

import com.example.emea.Response.RecoveryResponse;
import com.example.emea.Response.RegisterResponse;

import com.example.emea.Response.PersonalResponse;

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

    @FormUrlEncoded
    @POST("users/register")
    Call<RegisterResponse> getRegisterToken(@FieldMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("students/add_details")
    Call<PersonalResponse> getPersonal(@FieldMap HashMap<String, String> params, @Header("token") String authentoken);


   
    @FormUrlEncoded
    @POST("students/add_family_details")
    Call<FamilyResponse> getFamily(@FieldMap HashMap<String, String> params, @Header("token") String authentoken);

    @FormUrlEncoded
    @POST("users/forgotpassword")
    Call<ForgotResponse> getForgot(@FieldMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("users/recoverpassword")
    Call<RecoveryResponse> getrecoveryToken(@FieldMap HashMap<String, String> params);

    @GET("students/get_educational_details")
    Call<EducationViewResponse> getEducationView(@Header("token") String authtoken);



}







