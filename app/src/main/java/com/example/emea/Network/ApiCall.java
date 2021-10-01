package com.example.emea.Network;


import com.example.emea.Response.DepartmentDropdownResponse;
import com.example.emea.Response.EducationDropdownResponse;
import com.example.emea.Response.EducationResponse;
import com.example.emea.Response.EducationViewResponse;
//import com.example.emea.Response.EducationeditResponse;
import com.example.emea.Response.EducationeditResponse;
import com.example.emea.Response.FamilyEditResponse;
import com.example.emea.Response.FamilyResponse;
import com.example.emea.Response.FamilyViewResponse;
import com.example.emea.Response.ForgotResponse;
import com.example.emea.Response.LoggingResponse;
import com.example.emea.Response.PersonalDropdownResponse;
import com.example.emea.Response.PersonalEditResponse;
import com.example.emea.Response.PersonalResponse;
import com.example.emea.Response.PersonalViewResponse;
import com.example.emea.Response.RecoveryResponse;
import com.example.emea.Response.RegisterResponse;
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

//     @FormUrlEncoded
//    @POST("students/add_details")
//    Call<PersonalResponse> uploadImage(@Field("userfile") String image, @Header("token") String authentoken);
   
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

    @FormUrlEncoded
    @POST("students/edit_educational_details")
    Call<EducationeditResponse> getEducationEdit(@FieldMap HashMap<String, String> params, @Header("token") String authtoken);

    @GET("students/get_family_details")
    Call<FamilyViewResponse> getFamilyView(@Header("token") String authtoken);

    @FormUrlEncoded
    @POST("students/edit_family_details")
    Call<FamilyEditResponse> getFamilyEdit(@FieldMap HashMap<String, String> params, @Header("token") String authtoken);



    @FormUrlEncoded
    @POST("students/edit_personal_details")
    Call<PersonalEditResponse> getPersonalEdit(@FieldMap HashMap<String, String> params, @Header("token") String authtoken);


    @GET("students/get_personal_dropdowns")
    Call<PersonalDropdownResponse> getPersonalDropdown();

    @GET("students/get_educational_dropdowns")
    Call<EducationDropdownResponse> geteducationDropdown();




    @GET("students/get_department_dropdown")
    Call<DepartmentDropdownResponse> getDepartmentDropdown();



    @GET("students/view/id")
    Call<PersonalViewResponse> getPersonalView(@Header("token") String authtoken);




}







