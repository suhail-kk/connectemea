package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.Student;
import com.example.emea.Response.getDetails.TenthStd;
import com.example.emea.Response.getDetails.TwelthStd;

import java.util.List;

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
    String authtoken;
    String textschool;
    String textmedium;
    int textenglishsslcbox;
    int textmathssslcbox;
    int textsciencesslcbox;
    int textsocialsslcbox;
    String textschoolplustwo;
    String textallsyllabus;
    List<Object> textsub1box;
    List<Object> textsub2box;
    List<Object> textsub3box;
    List<Object> textsub4box;
    List<Object> textsub5box;
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
//    EducationAdapter adapter1;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
//    EducationAdapterqual adapter2;
//    Educational10thDetails educational10thDetails;
//    Educational12thDetails educational12thDetails;
//    Marklist10th marklist10;
//    Marklist12th marklist12th;
//    DegreeDetails degreeDetails;
//    DegreeMarkList degreeMarkList;
    ImageView edit;
//    OtherQualifications otherQualifications;
    TextView textNav;
    ImageView  prevPage;
    List<Object> textsubid1;
    List<Object> textsubid2;
    List<Object> textsubid3;
    List<Object> textsubid4;
    List<Object> textsubid5;
    TextView subid1, subid2, subid3, subid4, subid5;
    TenthStd tenthstd;
    TwelthStd twelthstd;
    Data data;
    Student student;
    EducationDetails educationaldetails;
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


        Call<GetResponse> educationCall = apiCall.getDetailsView(authtoken);
        educationCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

//                educational10thDetails = response.body().getEducational10thDetails();
//                educational12thDetails = response.body().getEducational12thDetails();
//                degreeDetails = response.body().getDegreeDetails();
//                degreeMarkList = response.body().getDegreeMarkList();
//                otherQualifications = response.body().getOtherQualifications();
//                marklist10 = response.body().getMarklist10th();
//                marklist12th = response.body().getMarklist12th();


                data = response.body().getData();
                student = data.getStudent();
                 educationaldetails = student.getEducationDetails();
                 tenthstd = educationaldetails.getTenthStd();
                twelthstd = educationaldetails.getTwelthStd();

                textmathssslcbox=tenthstd.getMaths();
                mathssslcbox=findViewById(R.id.mathssslcdisplay);
                mathssslcbox.setText(String.valueOf(textmathssslcbox));

                textschool = tenthstd.getSchoolName();
                school = findViewById(R.id.schooldisplay);
                school.setText(textschool);
                textmedium = tenthstd.getSyllabus();
                medium = (TextView) findViewById(R.id.mediumDisplay);
                medium.setText(textmedium);
                textenglishsslcbox = tenthstd.getEnglish();
                englishsslcbox = findViewById(R.id.englishsslcdisplay);
                englishsslcbox.setText(String.valueOf(textenglishsslcbox));
                textsciencesslcbox = tenthstd.getScience();
                sciencesslcbox = findViewById(R.id.sciencesslcdisplay);
                sciencesslcbox.setText(String.valueOf(textsciencesslcbox));
                textsocialsslcbox = tenthstd.getSocialScience();
                socialsciencesslcbox = findViewById(R.id.socialsslcdisplay);
                socialsciencesslcbox.setText(String.valueOf(textsocialsslcbox));
                textschoolplustwo = twelthstd.getSchoolName();
                schoolplustwo = findViewById(R.id.plustwoschooldisplay);
                schoolplustwo.setText(textschoolplustwo);
                textallsyllabus = twelthstd.getSyllabus();
                allsyllabus = findViewById(R.id.plustwosyllabusdisplay);
                allsyllabus.setText(textallsyllabus);
                textsubid1 = twelthstd.getSub();
                subid1 = (TextView) findViewById(R.id.subid1);
                subid1.setText(String.valueOf( textsubid1.get(0)));

                textsub1box = twelthstd.getSubMark();
                sub1box = findViewById(R.id.sub1display);
                sub1box.setText(String.valueOf( textsub1box.get(0)));
                textsubid2 =  twelthstd.getSub();
                subid2 = (TextView) findViewById(R.id.subid2);
                subid2.setText(String.valueOf(textsubid2.get(1)));

                textsub2box =twelthstd.getSubMark();
                sub2box = findViewById(R.id.sub2display);
                sub2box.setText(String.valueOf(textsub2box.get(1)));
                textsubid3 = twelthstd.getSub();
                subid3 = (TextView) findViewById(R.id.subid3);
                subid3.setText(String.valueOf(textsubid3.get(2)));
                textsub3box = twelthstd.getSubMark();
                sub3box = findViewById(R.id.sub3display);
                sub3box.setText(String.valueOf(textsub3box.get(2)));
                textsubid4 = twelthstd.getSub();
                subid4 = (TextView) findViewById(R.id.subid4);
                subid4.setText(String.valueOf(textsubid4.get(3)));
                textsub4box = twelthstd.getSubMark();
                sub4box = findViewById(R.id.sub4display);
                sub4box.setText(String.valueOf(textsub4box.get(3)));
                textsubid5 =twelthstd.getSub();
                subid5 = (TextView) findViewById(R.id.subid5);
                subid5.setText(String.valueOf(textsubid5.get(4)));
                textsub5box = twelthstd.getSubMark();
                sub5box = findViewById(R.id.sub5display);
                sub5box.setText(String.valueOf(textsub5box.get(4)));



//                setupAdapter();
//                setupAdapter2();
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(EducationDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });



    }

//    public void setupAdapter() {
//        adapter1 = new EducationAdapter(getApplicationContext(), degreeDetails, degreeMarkList, this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter1);
//
//
//    }
//
//
//    public void setupAdapter2() {
//        adapter2 = new EducationAdapterqual(getApplicationContext(), otherQualifications, this);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
//        recyclerView2.setLayoutManager(layoutManager);
//        recyclerView2.setAdapter(adapter2);
//
//
//    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}

