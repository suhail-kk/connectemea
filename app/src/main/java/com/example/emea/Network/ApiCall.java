package com.example.emea.Network;


import com.example.emea.Response.Adddetails.CreateResponse;
//import com.example.emea.Response.EducationeditResponse;
import com.example.emea.Response.HomePage.ProfileResponse;
//import com.example.emea.Response.Homepage.ProfileResponse;
import com.example.emea.Response.Login.LoginResponse;
import com.example.emea.Response.Register.RegisterResponse1;

import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.forgotpackage.ForgotResponse;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.reset.ResetResponse;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;

public interface ApiCall {


//    @GET("students/view")
//    Call<StudentItem> getUser(@Header("token") String authtoken);


//    @FormUrlEncoded
    @POST("user/login")
    Call<LoginResponse> getLoginToken(@Body HashMap<String, String> params);



//    @FormUrlEncoded
    @PATCH("user/register")
    Call<RegisterResponse1> getRegisterToken(@Body HashMap<String, String> params);


//     @FormUrlEncoded
//    @POST("students/add_details")
//    Call<PersonalResponse> uploadImage(@Field("userfile") String image, @Header("token") String authentoken);

//    @FormUrlEncoded
//    @POST("students/")
//    Call<FamilyResponse> getFamily(@FieldMap HashMap<String, String> params, @Header("token") String authentoken);



    @POST("student/")
    Call<CreateResponse> getFamily(@Body HashMap<String, Object> data, @Header("token") String authentoken);
//    @FormUrlEncoded
//    @POST("users/forgotpassword")
//    Call<ForgotResponse> getForgot(@FieldMap HashMap<String, String> params);

//    @FormUrlEncoded
    @POST("user/forgot")
    Call<ForgotResponse> getForgot(@Body HashMap<String, String> params);

//    @FormUrlEncoded
//    @POST("users/recoverpassword")
//    Call<RecoveryResponse> getrecoveryToken(@FieldMap HashMap<String, String> params);


    @PATCH("user/reset")
    Call<ResetResponse> getrecoveryToken(@Body HashMap<String, String> params, @Header("token") String authentoken);




    @GET("student/me")
    Call<ProfileResponse> getProfileView(@Header("token") String authtoken);

//    @PATCH("student/61ce9695021f72f46fbfd7ca")
//    Call<EditResponse> getEdit(@Body HashMap<String, Object> familyDetails, @Header("token") String authtoken);

    @PATCH("student/{userid}")
    Call<EditResponse> getEdit(@Path(value="userid", encoded = true)  String userid,@Body HashMap<String, Object> familyDetails,@Header("token") String authtoken);
//

//    @PATCH("student/{61ce9695021f72f46fbfd7ca}")
//    Call<EditResponse> getEdit( @Body HashMap<String, Object> familyDetails,@Header("token") String authtoken);

    @GET("student/me")
    Call<GetResponse> getDetailsView(@Header("token") String authtoken);

//    Call<Users> getUsers(@Path(value = "fullUrl", encoded = true) String fullUrl);


}







