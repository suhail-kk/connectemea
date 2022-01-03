package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.Adddetails.EducationDetails;
import com.example.emea.Response.HomePage.Data;
import com.example.emea.Response.HomePage.ProfileResponse;
import com.example.emea.Response.HomePage.Student;
import com.example.emea.Response.HomePage.UserId;
import com.squareup.picasso.Picasso;


import java.util.List;

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
    String studentName;
    String authtoken;
    String studentAdmissionNo;
    String studentImage;
    ImageView studentImageView;
    Student student;
    String userid;



//    Data personalDetails;
com.example.emea.Response.HomePage.PersonalDetails personalDetails;




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


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(HomePage.this, settings);
                popup.getMenuInflater().inflate(R.menu.home_page, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.appInfo:
                                Intent newIntent = new Intent(getApplicationContext(), AppInfo.class);
                                startActivity(newIntent);
                                return true;
                            default:
                                return onOptionsItemSelected(item);
                        }
                    }
                });

                popup.show();//showing popup menu
            }
        });

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

                Intent eduIntent = new Intent(getApplicationContext(),  EducationalDetails.class);
                startActivity(eduIntent);

            }
        });

        linearLayoutExtraCurricular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent extraIntent = new Intent(getApplicationContext(), ExtraCurricularActivity.class);
                startActivity(extraIntent);

            }
        });


        linearLayoutFamilyDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent famIntent = new Intent(getApplicationContext(), FamilyDetails.class);
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


                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                finish();

            }
        });


    }

    public void getDetails() {

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

//      pgBar.setVisibility(View.VISIBLE);
        Call<ProfileResponse> studentCall = apiCall.getProfileView(authtoken);
        studentCall.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(Call<ProfileResponse> call, Response<ProfileResponse> response) {
//              pgBar.setVisibility(View.GONE);

                if (response.body() != null) {




                    data = response.body().getData();
                    student=data.getStudent();
                    personalDetails=student.getPersonalDetails();
                    studentName=personalDetails.getName();
                    studentAdmissionNo=personalDetails.getAdmissionNO();

                    displayName.setText(studentName);
                    displayAdmission.setText(studentAdmissionNo);

                    userid = student.getId();
//                    Picasso.get().load("http://172.16.0.220/studentsprofile/assets/images/students/" + studentImage).into(studentImageView);
                    Log.e("_id", userid);

                    SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("_id", userid);
                    editor.commit();

                }
            }

            @Override
            public void onFailure(Call<ProfileResponse> call, Throwable t) {
                Toast.makeText(HomePage.this, "Failed", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

}