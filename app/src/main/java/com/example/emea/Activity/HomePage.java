package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
//import com.example.emea.Response.Adddetails.EducationDetails;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.PersonalDetails;
import com.example.emea.Response.getDetails.UserId;
import com.squareup.picasso.Picasso;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {

    LinearLayout linearLayoutPersonalDtls, linearLayoutEducaionDtls, linearLayoutFamilyDtls,linearLayoutExtraCurricular;

    ProgressBar pgBar;

    ApiCall apiCall;
    Data data;
    TextView displayName;
    TextView displayAdmission;
    String studentName,authtoken,studentAdmissionNo,studentImage,userid,studentimage;
    ImageView studentImageView;

    UserId user;

    PersonalDetails personalDetails;




    ImageView settings, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        getSupportActionBar();

       displayName = findViewById(R.id.studentnameview);
        displayAdmission = findViewById(R.id.studentadmissionview);
        studentImageView = findViewById(R.id.studentimageview);
       pgBar=findViewById(R.id.progressBarView);

        linearLayoutPersonalDtls = findViewById(R.id.linearLayoutPersonal);
        linearLayoutEducaionDtls = findViewById(R.id.linearLayoutEducation);
        linearLayoutFamilyDtls = findViewById(R.id.linearLayoutFamily);
        linearLayoutExtraCurricular=findViewById(R.id.linearLayoutextracirricular);


        settings = findViewById(R.id.more);
        logout = findViewById(R.id.logout);

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        getDetails();




        linearLayoutPersonalDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent perIntent = new Intent(getApplicationContext(), PersonalDetailView.class);
                startActivity(perIntent);

            }
        });

        linearLayoutEducaionDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eduIntent = new Intent(getApplicationContext(),  EducationDetailsView.class);
                startActivity(eduIntent);

            }
        });


        linearLayoutExtraCurricular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent extraIntent = new Intent(getApplicationContext(), ExtraCurricularActivityView.class);
                startActivity(extraIntent);

            }
        });


        linearLayoutFamilyDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent famIntent = new Intent(getApplicationContext(), FamilyDetailsView.class);
                startActivity(famIntent);

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.clear();
                editor.commit();


                Intent myIntent = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(myIntent);
                finish();

            }
        });


    }

    public void getDetails() {

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

      pgBar.setVisibility(View.VISIBLE);
        Call<GetResponse> studentCall = apiCall.getProfileView(authtoken);
        studentCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
              pgBar.setVisibility(View.GONE);

                if (response.body() != null) {
                    data = response.body().getData();
                    personalDetails=data.getPersonalDetails();

                    user = data.getUserId();
                    studentImage = user.getProfileImage();
                    studentAdmissionNo=personalDetails.getAdmissionNO();
                    studentName=personalDetails.getName();

                    displayName.setText(studentName);
                    displayAdmission.setText(studentAdmissionNo);
                    userid = data.getId();
                    Picasso.get().load("https://student-profile-api.herokuapp.com/upload/" + studentImage).into(studentImageView);
                    Log.e("_id", userid);
                    SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("_id", userid);
                    editor.commit();

                }
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(HomePage.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });
    }



}