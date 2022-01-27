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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.DegreeItem;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.OtherQualificationsItem;
//import com.example.emea.Response.getDetails.Student;
import com.example.emea.Response.getDetails.TenthStd;
import com.example.emea.Response.getDetails.TwelthStd;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationDetailsView extends AppCompatActivity {

    ApiCall apiCall;
    ProgressBar pgBar;
    TextView school, medium, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, allsyllabus, sub1box, sub2box, sub3box, sub4box, topNav;
    String authtoken,textschool,textmedium,textschoolplustwo,textallsyllabus;
    int textenglishsslcbox,textmathssslcbox,textsciencesslcbox,textsocialsslcbox;
    List<String> textsub1box;
    List<String> textsub2box;
    List<String> textsub3box;
    List<String> textsub4box;
    List<String> textsub5box;
    EducationAdapter adapter1;
    EducationAdapterqual adapter2;
    RecyclerView recyclerView,recyclerView2;
    List<DegreeItem>degreeItem;
    List<OtherQualificationsItem> otherQualificationsItem;
    ImageView edit;
    TextView textNav;
    ImageView  prevPage;
    List<String> textsubid1;
    List<String> textsubid2;
    List<String> textsubid3;
    List<String> textsubid4;
    List<String> textsubid5;
    TextView subid1, subid2, subid3, subid4, subid5;
    TenthStd tenthstd;
    TwelthStd twelthstd;
    Data data;
    EducationDetails educationaldetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details_view);
      androidx.appcompat.widget.Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

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

                data = response.body().getData();
                 educationaldetails = data.getEducationDetails();
                 tenthstd = educationaldetails.getTenthStd();
                twelthstd = educationaldetails.getTwelthStd();
                degreeItem= educationaldetails.getDegree();
                otherQualificationsItem=educationaldetails.getOtherQualifications();

                textschool = tenthstd.getSchoolName();
                school = findViewById(R.id.schooldisplay);
                school.setText(textschool);
                textmedium = tenthstd.getSyllabus();
                medium =  findViewById(R.id.mediumDisplay);
                medium.setText(textmedium);
                textenglishsslcbox = tenthstd.getEnglish();
                englishsslcbox = findViewById(R.id.englishsslcdisplay);
                englishsslcbox.setText(String.valueOf(textenglishsslcbox));
                textmathssslcbox=tenthstd.getMaths();
                mathssslcbox=findViewById(R.id.mathssslcdisplay);
                mathssslcbox.setText(String.valueOf(textmathssslcbox));
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
                textsubid1 =twelthstd.getSub();
                subid1 =  findViewById(R.id.subid1);
                subid1.setText(textsubid1.get(0));
                textsub1box = twelthstd.getSubMark();
                sub1box = findViewById(R.id.sub1display);
                sub1box.setText( textsub1box.get(0));
                textsubid2 = twelthstd.getSub();
                subid2 =  findViewById(R.id.subid2);
                subid2.setText(textsubid2.get(1));
                textsub2box = twelthstd.getSubMark();
                sub2box = findViewById(R.id.sub2display);
                sub2box.setText(textsub2box.get(1));
                textsubid3 =twelthstd.getSub();
                subid3 =  findViewById(R.id.subid3);
                subid3.setText(textsubid3.get(2));
                textsub3box = twelthstd.getSubMark();
                sub3box = findViewById(R.id.sub3display);
                sub3box.setText(textsub3box.get(2));
                textsubid4 =twelthstd.getSub();
                subid4 =  findViewById(R.id.subid4);
                subid4.setText(textsubid4.get(3));
                textsub4box = twelthstd.getSubMark();
                sub4box = findViewById(R.id.sub4display);
                sub4box.setText(textsub4box.get(3));
                setupAdapter();
                setupAdapter2();
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(EducationDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void setupAdapter() {

        adapter1 = new EducationAdapter(getApplicationContext(),  degreeItem, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter1);

    }

    public void setupAdapter2() {
        adapter2 = new EducationAdapterqual(getApplicationContext(), otherQualificationsItem, this);
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


