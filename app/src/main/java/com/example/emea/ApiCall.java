package com.example.emea;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface ApiCall {


    @GET("students/view/2")
    Call<StudentItem> getUser(@Header("token") String authtoken);


    @FormUrlEncoded
    @POST("users/login")

    Call<LoggingResponse> getLoginToken(@FieldMap HashMap<String,String> params);

//    @POST("users/register")
//    Call<RegisterResponse> getRegistrationStatus(@FieldMap HashMap<String,String> params);

    //educational details
    @FormUrlEncoded
    @POST("students/add_educational_details")
    Call<EducationResponse> getEducation(@FieldMap HashMap<String, String> params, @Header("token") String authentoken);

}







