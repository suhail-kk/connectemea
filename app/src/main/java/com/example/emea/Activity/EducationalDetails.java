package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class EducationalDetails extends AppCompatActivity {

    TextView sslc,  markssslc,
            plustwo, marksplustwo,topNav;
    String textschool, textmedium, textenglishsslcbox,
            textmathssslcbox, textsciencesslcbox, textsocialsslcbox,
            textschoolplustwo, textCousre, textsub1box, textsub2box,
            textsub3box, textsub4box, textsub5box,
           textplustwoallsyllabus, textsub1, textsub2, textsub3, textsub4, textsub5;
    TextInputEditText school, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, sub1box, sub2box, sub3box, sub4box, sub5box, sub6box;
    AutoCompleteTextView plustwoallsyllabus, sub1, sub2, sub3, sub4, sub5, sub6,Course,medium;
    Button  saveinfo;
    ArrayAdapter<String> plus2subjects;
    ArrayAdapter<String> english;
    ArrayAdapter<String> subject1;
    ArrayAdapter<String> subject2;
    ArrayAdapter<String> subject3;
    ArrayAdapter<String> subject4;
    ArrayAdapter<String> Medium;
    ArrayAdapter<String> HSEcourse;

    ImageView prevPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);
        getSupportActionBar();

        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });
        Intent intent = getIntent();
        HashMap<String, Object> personalDetails = (HashMap<String, Object>) intent.getSerializableExtra("personalDetails");


//buttons
        saveinfo = findViewById(R.id.saveinfo);

//sslc
        sslc = findViewById(R.id.sslc);
        school = findViewById(R.id.schoolname);
        medium = findViewById(R.id.user_medium);
        markssslc = findViewById(R.id.marks);
        englishsslcbox = findViewById(R.id.englishsslc);
        mathssslcbox = findViewById(R.id.mathssslc);
        sciencesslcbox = findViewById(R.id.sciencesslc);
        socialsciencesslcbox = findViewById(R.id.socialsslc);

//plustwo
        plustwo = findViewById(R.id.hse);
        schoolplustwo = findViewById(R.id.hseschoolName);
        Course = findViewById(R.id.hsecourse);
        marksplustwo = findViewById(R.id.markshse);
        plustwoallsyllabus = findViewById(R.id.hsesyllabus);
        sub1 = findViewById(R.id.hsesubName1);
        sub1box = findViewById(R.id.hsesubMark1);
        sub2 = findViewById(R.id.hsesubName2);
        sub2box = findViewById(R.id.hsesubMark2);
        sub3 = findViewById(R.id.hsesubName3);
        sub3box = findViewById(R.id.hsesubMark3);
        sub4 = findViewById(R.id.hsesubName4);
        sub4box = findViewById(R.id.hsesubMark4);
        sub5 = findViewById(R.id.hsesubName5);
        sub5box = findViewById(R.id.hsesubMark5);
        sub6 = findViewById(R.id.hsesubName6);
        sub6box = findViewById(R.id.hsesubMark6);
        //dropdown

        String[] plustwosyllabus = {"CBSE", "ICSE"};
        String[] English = {"English"};
        String[] hseSubject1 = {"Biology", "Computer Science"};
        String[] hseSubject2 = {"physics", "accounting", "journalism"};
        String[] hseSubject3 = {"Chemistry", "Geology", "CA"};
        String[] hseSubject4 = {"Mathematics", "Politic", "sociology"};
        String[] sslcmedium ={"english","malayalam"};
        String[] hsecourse ={"biology","commerce"};

        HSEcourse=new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, hsecourse);
        Course.setAdapter(HSEcourse);
        Course.setThreshold(1);
        Medium=new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, sslcmedium);
        medium.setAdapter(Medium);
        medium.setThreshold(1);
        plus2subjects = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, plustwosyllabus);
        plustwoallsyllabus.setAdapter(plus2subjects);
        plustwoallsyllabus.setThreshold(1);
        english = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, English);
        sub1.setAdapter(english);
        sub1.setThreshold(1);
        subject1 = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, hseSubject1);
        sub2.setAdapter(subject1);
        sub2.setThreshold(1);
        subject2 = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, hseSubject2);
        sub3.setAdapter(subject2);
        sub3.setThreshold(1);
        subject3 = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, hseSubject3);
        sub4.setAdapter(subject3);
        sub4.setThreshold(1);
        subject4 = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, hseSubject4);
        sub5.setAdapter(subject4);
        sub5.setThreshold(1);


        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textschool = school.getText().toString();
                textenglishsslcbox = englishsslcbox.getText().toString();
                textmathssslcbox = mathssslcbox.getText().toString();
                textsciencesslcbox = sciencesslcbox.getText().toString();
                textsocialsslcbox = socialsciencesslcbox.getText().toString();
                textmedium=medium.getText().toString();
                textschoolplustwo = schoolplustwo.getText().toString();
                                textCousre=Course.getText().toString();
                                textsub1=sub1.getText().toString();
                textsub2=sub2.getText().toString();
                textsub3=sub3.getText().toString();
                textsub4=sub4.getText().toString();
                textsub5=sub5.getText().toString();
                String[] sub = {textsub1,textsub2,textsub3,textsub4,textsub5};
                textsub1box = sub1box.getText().toString();
                textsub2box = sub2box.getText().toString();
                textsub3box = sub3box.getText().toString();
                textsub4box = sub4box.getText().toString();
                textsub5box = sub5box.getText().toString();
                String[] subMark = {textsub1box,textsub2box,textsub3box,textsub4box,textsub5box};
                textplustwoallsyllabus=plustwoallsyllabus.getText().toString();

                HashMap<String, Object> educationDetails = new HashMap<>();
                HashMap<String, Object> tenthStd = new HashMap<>();
                tenthStd.put("schoolName", textschool);
                tenthStd.put("science", textsciencesslcbox);
                tenthStd.put("syllabus", textmedium);
                tenthStd.put("english", textenglishsslcbox);
                tenthStd.put("maths", textmathssslcbox);
                tenthStd.put("socialScience", textsocialsslcbox);
                educationDetails.put("tenthStd",tenthStd);

                HashMap<String, Object> twelthStd = new HashMap<>();
                twelthStd.put("schoolName",textschoolplustwo);
                twelthStd.put("syllabus",textplustwoallsyllabus);
                twelthStd.put("sub",sub);
                twelthStd.put("subMark",subMark);
                twelthStd.put("course",textCousre);
                educationDetails.put("twelthStd",twelthStd);

                Intent newIntent = new Intent(EducationalDetails.this, EducationalDetails2.class);
                newIntent.putExtra("personalDetails", personalDetails);
                newIntent.putExtra("educationDetails", educationDetails);
                startActivity(newIntent);
            }
        });
    }
    }


















