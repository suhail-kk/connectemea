package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.EducationViewResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationDetailsView extends AppCompatActivity {

    String studentName;
    ApiCall apiCall;
    ProgressBar pgBar;
    TextView school;
    TextView medium;
    TextView englishsslcbox;
    TextView mathssslcbox;
    TextView sciencesslcbox;
    TextView socialsciencesslcbox;
    TextView schoolplustwo;
    TextView allsyllabus;
    TextView sub1box;
    TextView sub2box;
    TextView sub3box;
    TextView sub4box;
    TextView sub5box;
    TextView sub6box;
    TextView collegename;
    TextView universityugc;
    TextView courseugc;
    TextView ugcmainbox;
    TextView ugcsubbox;
    TextView ugcenglishbox;
    TextView ugclangbox;
    TextView opencoursebox;
    TextView coursename;
    TextView coursetype;
    TextView institution;
    TextView university2;
    String authtoken;
    String textschool;
    String textmedium;
    String textenglishsslcbox;
    String textmathssslcbox;
    String textsciencesslcbox;
    String textsocialsslcbox;
    String textschoolplustwo;
    String textallsyllabus;
    String textsub1box;
    String textsub2box;
    String textsub3box;
    String textsub4box;
    String textsub5box;
    String textsub6box;
    String textcollegename;
    String textuniversity;
    String textugccourse;
    String textugcmainbox;
    String textcoresub;
    String textugcenglishbox;
    String textugclangbox;
    String textopencoursebox;
    String qualcrse;
    String qualtype;
    String qualinstitu;
    String qualuniversity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details_view);
//        pgBar = findViewById(R.id.progressBarView);





        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

//        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
//        authtoken = (shared.getString("token", ""));

//        pgBar.setVisibility(View.VISIBLE);
        String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyMiIsImVtYWlsIjoiamFja0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImphY2siLCJyZWdpc3RlcmVkIjpmYWxzZX0.D_5yGA8kmjWnQ1YejAMsFlSWXmt-QE3NwAcOFT2LZeg";

        Call<EducationViewResponse> educationCall = apiCall.getEducationView(authtoken);
        educationCall.enqueue(new Callback<EducationViewResponse>() {
            @Override
            public void onResponse(Call<EducationViewResponse> call, Response<EducationViewResponse> response) {
//                pgBar.setVisibility(View.GONE);

                textmathssslcbox =  response.body().getMaths();
                mathssslcbox=(TextView)findViewById(R.id.mathssslcdisplay);
                mathssslcbox.setText(textmathssslcbox);

               textschool=response.body().getSchoolName();
                school=(TextView)findViewById(R.id.schooldisplay);

                school.setText(textschool);
                textmedium=response.body().getMedium();
                medium=(TextView)findViewById(R.id.mediumDisplay);
               medium.setText(textmedium);
                textenglishsslcbox=response.body().getEnglish();
               englishsslcbox=(TextView)findViewById(R.id.englishsslcdisplay);
                englishsslcbox.setText(textenglishsslcbox);
                textsciencesslcbox=response.body().getScience();
                  sciencesslcbox=(TextView)findViewById(R.id.sciencesslcdisplay);
                sciencesslcbox.setText(textsciencesslcbox);
                textsocialsslcbox=response.body().getSocialStudies();
                                socialsciencesslcbox=(TextView)findViewById(R.id.socialsslcdisplay);
               socialsciencesslcbox.setText(textsocialsslcbox);
                textschoolplustwo=response.body().getSchoolName();
               schoolplustwo=(TextView)findViewById(R.id.plustwoschooldisplay);
                schoolplustwo.setText(textschoolplustwo);
                textallsyllabus=response.body().getSyllabus();
                allsyllabus=(TextView)findViewById(R.id.plustwosyllabusdisplay);
                allsyllabus.setText(textallsyllabus);
                textsub1box=response.body().getEnglishMark();
                sub1box=(TextView)findViewById(R.id.sub1display);
                sub1box.setText(textsub1box);
                textsub2box=response.body().getSubject1Mark();
                sub2box=(TextView)findViewById(R.id.sub2display);
               sub2box.setText(textsub2box);
                textsub3box=response.body().getSubject2Mark();
                sub3box=(TextView)findViewById(R.id.sub3display);
                sub3box.setText(textsub3box);
                textsub4box=response.body().getSubject3Mark();
                sub4box=(TextView)findViewById(R.id.sub4display);
                sub4box.setText(textsub4box);
                textsub5box=response.body().getSubject4Mark();
                sub5box=(TextView)findViewById(R.id.sub5display);
                sub5box.setText(textsub5box);
                textsub6box=response.body().getSubject5Mark();
                sub6box=(TextView)findViewById(R.id.sub6display);
                sub6box.setText(textsub6box);


            }


            @Override
            public void onFailure(Call<EducationViewResponse> call, Throwable t) {
                Toast.makeText(EducationDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


//                collegename=(TextView)findViewById(R.id.coursedisplay);
//                collegename.setText(textcollegename);
//
//                universityugc=(TextView)findViewById(R.id.ugcuniversitydisplay);
//                universityugc.setText(textuniversity);
//
//                courseugc=(TextView)findViewById(R.id.ugccoursedisplay);
//               courseugc.setText(textugccourse);
//
//                ugcmainbox=(TextView)findViewById(R.id.ugccoredispaly);
//                ugcmainbox.setText(textugcmainbox);
//
//                ugcsubbox=(TextView)findViewById(R.id.ugccompldisplay);
//                ugcsubbox.setText(textcoresub);
//
//                ugcenglishbox=(TextView)findViewById(R.id.ugcengdispaly);
//                ugcenglishbox.setText(textugcenglishbox);
//
//               ugclangbox=(TextView)findViewById(R.id.langdisplay);
//                ugclangbox.setText(textugclangbox);
//
//                opencoursebox=(TextView)findViewById(R.id.opendisplay);
//                opencoursebox.setText(textopencoursebox);

