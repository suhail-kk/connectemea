package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.example.emea.Response.StudentItem;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {

    LinearLayout linearLayoutPersonalDtls, linearLayoutEducaionDtls, linearLayoutFamilyDtls;

    ProgressBar pgBar;

    ApiCall apiCall;

    TextView displayName, displayAdmission;
    String studentName, authtoken, studentAdmissionNo, studentImage;
    ImageView studentImageView;

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

                Intent perIntent = new Intent(getApplicationContext(),PersonalDetailView.class);
                startActivity(perIntent);

            }
        });

        linearLayoutEducaionDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eduIntent = new Intent(getApplicationContext(), EducationDetailsView.class);
                startActivity(eduIntent);

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
        Call<StudentItem> studentCall = apiCall.getUser(authtoken);
        studentCall.enqueue(new Callback<StudentItem>() {
            @Override
            public void onResponse(Call<StudentItem> call, Response<StudentItem> response) {
//              pgBar.setVisibility(View.GONE);

                if (response.body() != null) {
                    studentName = response.body().getName();
                    studentAdmissionNo = response.body().getAdmissionNo();
                    studentImage = response.body().getProfileImage();

                    displayName.setText(studentName);
                    displayAdmission.setText(studentAdmissionNo);
                    Picasso.get().load("http://172.20.10.4/studentsprofile/assets/images/students/" + studentImage).into(studentImageView);


                }
            }

            @Override
            public void onFailure(Call<StudentItem> call, Throwable t) {
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