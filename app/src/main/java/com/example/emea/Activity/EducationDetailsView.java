package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.DegreeDetails;
import com.example.emea.Response.DegreeMarkList;
import com.example.emea.Response.EducationViewResponse;
import com.example.emea.Response.Educational10thDetails;
import com.example.emea.Response.Educational12thDetails;
import com.example.emea.Response.Marklist10th;
import com.example.emea.Response.Marklist12th;
import com.example.emea.Response.OtherQualifications;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationDetailsView extends AppCompatActivity {

    ApiCall apiCall;
    ProgressBar pgBar;
    TextView school, medium, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, allsyllabus, sub1box, sub2box, sub3box, sub4box, sub5box, sub6box,
            collegename, universityugc, courseugc, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox,
            coursename, coursetype, institution, university2,topNav;
    String authtoken, textschool, textmedium, textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox,
            textschoolplustwo, textallsyllabus, textsub1box, textsub2box, textsub3box, textsub4box, textsub5box, textsub6box,
            textcollegename, textuniversity, textugccourse, textugcmainbox, textcoresub, textugcenglishbox, textugclangbox, textopencoursebox,
            qualcrse, qualtype, qualinstitu, qualuniversity;
    EducationAdapter adapter1;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    EducationAdapterqual adapter2;
    Educational10thDetails educational10thDetails;
    Educational12thDetails educational12thDetails;
    Marklist10th marklist10;
    Marklist12th marklist12th;
    DegreeDetails degreeDetails;
    DegreeMarkList degreeMarkList;
    ImageView edit;
    OtherQualifications otherQualifications;
    TextView textNav;
    ImageView  prevPage;
    String textsubid1, textsubid2, textsubid3, textsubid4, textsubid5;
    TextView subid1, subid2, subid3, subid4, subid5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details_view);
      androidx.appcompat.widget.Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

//        textNav = findViewById(R.id.title_nav);
//        String getText = textNav.getText().toString();
//        textNav.setText("Education Details");

        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });


//        pgBar = findViewById(R.id.progressBarView);

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), EducationEdit.class);
                startActivity(newIntent);


            }
        });


        recyclerView = findViewById(R.id.recycler_degree);
        recyclerView2 = findViewById(R.id.recycler_qualification);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

//        pgBar.setVisibility(View.VISIBLE);
//        String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyMiIsImVtYWlsIjoiamFja0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImphY2siLCJyZWdpc3RlcmVkIjpmYWxzZX0.D_5yGA8kmjWnQ1YejAMsFlSWXmt-QE3NwAcOFT2LZeg";

        Call<EducationViewResponse> educationCall = apiCall.getEducationView(authtoken);
        educationCall.enqueue(new Callback<EducationViewResponse>() {
            @Override
            public void onResponse(Call<EducationViewResponse> call, Response<EducationViewResponse> response) {
//                pgBar.setVisibility(View.GONE);


                educational10thDetails = response.body().getEducational10thDetails();
                educational12thDetails = response.body().getEducational12thDetails();
                degreeDetails = response.body().getDegreeDetails();
                degreeMarkList = response.body().getDegreeMarkList();
                otherQualifications = response.body().getOtherQualifications();
                marklist10 = response.body().getMarklist10th();
                marklist12th = response.body().getMarklist12th();


                textmathssslcbox = marklist10.getMaths();
                mathssslcbox = findViewById(R.id.mathssslcdisplay);
                mathssslcbox.setText(textmathssslcbox);
                textschool = educational10thDetails.getSchoolName();
                school = findViewById(R.id.schooldisplay);
                school.setText(textschool);
                textmedium = educational10thDetails.getMedium();
                medium = (TextView) findViewById(R.id.mediumDisplay);
                medium.setText(textmedium);
                textenglishsslcbox = marklist10.getEnglish();
                englishsslcbox = findViewById(R.id.englishsslcdisplay);
                englishsslcbox.setText(textenglishsslcbox);
                textsciencesslcbox = marklist10.getScience();
                sciencesslcbox = findViewById(R.id.sciencesslcdisplay);
                sciencesslcbox.setText(textsciencesslcbox);
                textsocialsslcbox = marklist10.getSocialStudies();
                socialsciencesslcbox = findViewById(R.id.socialsslcdisplay);
                socialsciencesslcbox.setText(textsocialsslcbox);
                textschoolplustwo = educational12thDetails.getSchoolName();
                schoolplustwo = findViewById(R.id.plustwoschooldisplay);
                schoolplustwo.setText(textschoolplustwo);
                textallsyllabus = educational12thDetails.getSyllabus();
                allsyllabus = findViewById(R.id.plustwosyllabusdisplay);
                allsyllabus.setText(textallsyllabus);
//                textsubid1 = marklist12th.getSubjectId1();
//                subid1 = (TextView) findViewById(R.id.subid1);
//                subid1.setText(textsubid1);
                textsub1box = marklist12th.getSubject1Mark();
                sub1box = findViewById(R.id.sub1display);
                sub1box.setText(textsub1box);
//                textsubid2 = marklist12th.getSubjectId2();
//                subid2 = (TextView) findViewById(R.id.subid2);
//                subid2.setText(textsubid2);
                textsub2box = marklist12th.getSubject2Mark();
                sub2box = findViewById(R.id.sub2display);
                sub2box.setText(textsub2box);
//                textsubid3 = marklist12th.getSubjectId3();
//                subid3 = (TextView) findViewById(R.id.subid3);
//                subid3.setText(textsubid3);
                textsub3box = marklist12th.getSubject3Mark();
                sub3box = findViewById(R.id.sub3display);
                sub3box.setText(textsub3box);
//                textsubid4 = marklist12th.getSubjectId4();
//                subid4 = (TextView) findViewById(R.id.subid4);
//                subid4.setText(textsubid4);
                textsub4box = marklist12th.getSubject4Mark();
                sub4box = findViewById(R.id.sub4display);
                sub4box.setText(textsub4box);
//                textsubid5 = marklist12th.getSubjectId5();
//                subid5 = (TextView) findViewById(R.id.subid5);
//                subid5.setText(textsubid5);
                textsub5box = marklist12th.getSubject5Mark();
                sub5box = findViewById(R.id.sub5display);
                sub5box.setText(textsub5box);
//
//textcollegename=degreeDetails.getCollegeName();
//collegename=findViewById(R.id.collegename);
//collegename.setText(textcollegename);


                setupAdapter();
                setupAdapter2();
            }

            @Override
            public void onFailure(Call<EducationViewResponse> call, Throwable t) {
                Toast.makeText(EducationDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });


//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public void setupAdapter() {
        adapter1 = new EducationAdapter(getApplicationContext(), degreeDetails, degreeMarkList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter1);


    }


    public void setupAdapter2() {
        adapter2 = new EducationAdapterqual(getApplicationContext(), otherQualifications, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter2);


    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}

