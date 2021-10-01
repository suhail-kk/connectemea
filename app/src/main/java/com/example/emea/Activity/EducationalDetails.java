package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Response.BloodGroupItem;
import com.example.emea.Response.DegreeCoursesItem;
import com.example.emea.Response.EducationDropdownResponse;
import com.example.emea.Response.EducationResponse;
import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.PersonalDropdownResponse;
import com.example.emea.Response.PlusTwoCoursesItem;
import com.example.emea.Response.PlusTwoSubjectsItem;
import com.example.emea.Response.UniversityItem;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationalDetails extends AppCompatActivity {

    TextView sslc, medium, markssslc,
            plustwo, marksplustwo, ugc, ugcmarks, anyotherqual,topNav,degreeCountView;
    String textschool, textmedium, textenglishsslcbox,
            textmathssslcbox, textsciencesslcbox, textsocialsslcbox,
            textschoolplustwo, textallsyllabus, textsub1box, textsub2box,
            textsub3box, textsub4box, textsub5box, textsub6box,
            textcollegename, textuniversity, textugccourse, textugcmainbox, textcoresub, textugcenglishbox,
            textugclangbox, textopencoursebox,textplustwoallsyllabus,textcoursename,
            qualcrse, qualtype, qualinstitu, qualuniversity,textcollegecourse,textcoursetype;
    TextInputEditText school, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, sub1box, sub2box, sub3box, sub4box, sub5box, sub6box,
            collegename, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox,
            coursename, coursetype, institution, university2;


    AutoCompleteTextView plustwoallsyllabus, sub1, sub2, sub3, sub4, sub5, sub6,collegeuniversity,collegecourse;
    Button adddegree, qualification, saveinfo,addqualification,deleteadddegree,degree;
    RadioButton radioeng;
    RadioButton radiomal;
    ApiCall apiCall;
    String apieducationlist;
    String authentoken;
    ImageView prevPage;
    LinearLayout add;
    int otherViewIdAboveV;
    int status;
    LinearLayout ll;
    Inflater inflater;
    Button addnewDegree,DeleteaddDegree,Remove;

//    ArrayList<String> arrayList_list;
//    ArrayAdapter<String> arrayAdapter_list;

    ArrayList<PlusTwoCoursesItem> plusTwoCoursesItems;
    ArrayList<String> plustwosyllabus;
    ArrayAdapter<String> plus2syllabus;

    ArrayList<PlusTwoSubjectsItem> plusTwoSubjectsItems;
    ArrayList<String> plustwosubjects;
    ArrayAdapter<String> plus2subjects;

    ArrayList<DegreeCoursesItem> degreeCoursesItems;
    ArrayList<String> degreecourses;
    ArrayAdapter<String> degreecourse;

    ArrayList<UniversityItem> universityItems;
    ArrayList<String> universities;
    ArrayAdapter<String> university;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);
       plustwosyllabus= new ArrayList<>();
        plustwosubjects= new ArrayList<>();
        degreecourses= new ArrayList<>();
        universities= new ArrayList<>();
//        ll = (LinearLayout) findViewById(R.id.Adddegree);

 //buttons
//        qualification = findViewById(R.id.addQualification);
        add= findViewById(R.id.newDegreeLayout2);
        saveinfo = findViewById(R.id.saveEduDetail);
        radioeng = findViewById(R.id.radioeng);
        radiomal = findViewById(R.id.radiomal);
        adddegree = findViewById(R.id.addDegree);
        addqualification = findViewById(R.id.addQualification);
//        deleteadddegree=findViewById(R.id.deleteaddDegree);
//        addnewDegree=findViewById(R.id.addNewDegree);
//        DeleteaddDegree=findViewById(R.id.deleteaddDegree);
        Remove=findViewById(R.id.remove);
        degree=findViewById(R.id.addbutton);

//sslc
        sslc = findViewById(R.id.sslc);
        school = findViewById(R.id.schoolname);
        medium = findViewById(R.id.medium);
        markssslc = findViewById(R.id.marks);
        englishsslcbox = findViewById(R.id.englishsslc);
        mathssslcbox = findViewById(R.id.mathssslc);
        sciencesslcbox = findViewById(R.id.sciencesslc);
        socialsciencesslcbox = findViewById(R.id.socialsslc);

//plustwo
        plustwo = findViewById(R.id.hse);
        schoolplustwo = findViewById(R.id.hseschoolName);
        marksplustwo = findViewById(R.id.markshse);
        plustwoallsyllabus=findViewById(R.id.hsesyllabus);
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

//degree
        ugc=findViewById(R.id.degree);
        collegename = findViewById(R.id.ugcollegeName);
        collegeuniversity=findViewById(R.id.degreeuniversity);
        collegecourse=findViewById(R.id.degreecourse);
        ugcmainbox = findViewById(R.id.dgrsubCore);
        ugcsubbox = findViewById(R.id.dgrsubComp);
        ugcenglishbox = findViewById(R.id.dgrsubEng);
        ugclangbox = findViewById(R.id.dgrsubLang);
        opencoursebox = findViewById(R.id.dgrsubOpen);

//otherqualifications
        anyotherqual=findViewById(R.id.otherqual);
        coursename = findViewById(R.id.qualicrsName);
        coursetype = findViewById(R.id.qualicrstype);
        institution = findViewById(R.id.qualiIstnname);
        university2 = findViewById(R.id.qualiuniversity);
        LinearLayout rt = (LinearLayout) findViewById(R.id.newDegreeLayout);

        androidx.appcompat.widget.Toolbar myToolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

//        topNav = findViewById(R.id.title_top_nav);
//        String getText = topNav.getText().toString();
//        topNav.setText("Educational Details");



        plus2syllabus = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosyllabus);
        plustwoallsyllabus.setAdapter(plus2syllabus);
        plustwoallsyllabus.setThreshold(1);

        plus2subjects = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosubjects);
        sub1.setAdapter(plus2subjects);
        sub1.setThreshold(1);

        degreecourse = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, degreecourses);
        collegecourse.setAdapter(degreecourse);
        collegecourse.setThreshold(1);


        university = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, universities);
        collegeuniversity.setAdapter(university);
        collegeuniversity.setThreshold(1);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        dropdowncall();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);
        getSupportActionBar();


//        topNav = findViewById(R.id.title_nav);
//        String getText = topNav.getText().toString();
//        topNav.setText("Educational Details");
//        backbutton = findViewById(R.id.backBtn);
//
//        backbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
//                startActivity(perIntent);
//
//            }
//        });


        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });


//        adddegree.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                add.setVisibility(View.VISIBLE);
//                Remove.setEnabled(true);
//                Remove.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        add.setVisibility(View.GONE);
//                    }
//                });
//
//            }


//            private void addView() {
//                LinearLayout item = (LinearLayout) findViewById(R.id.Adddegree);
//
////                getLayoutInflater().inflate(R.layout.adddegree, item);
//
//
//                 View addedView = getLayoutInflater().inflate(R.layout.adddegree,null);
//                item.addView(addedView);
////                deleteadddegree.setVisibility(View.VISIBLE);
//                deleteadddegree.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                       removeView();
//                    }
//                    private  void removeView(){
//
//                       item.removeView(addedView);
//
////                        LinearLayout.removeView((View) v.getParent());
////                        findViewById(R.id.Adddegree).setVisibility(View.INVISIBLE);
//                    }
//                });
//            }
//

//        });

//        deleteadddegree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                removeView();
//            }
//            private void removeView(){
//               item.removeView(addedView);
//
////                findViewById(R.id.Adddegree).setVisibility(View.INVISIBLE);
//            }
//        });
        adddegree.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        add.setVisibility(View.VISIBLE);
        Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add.setVisibility(View.GONE);

            }
        });
    }
});



//        degree.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View v) {
//                addView();
//            }
//            private void addView() {
////                add.setVisibility(View.VISIBLE);
//                LinearLayout item = (LinearLayout) findViewById(R.id.Adddegree);
////                getLayoutInflater().inflate(R.layout.adddegree, item);
//                             View addedView = getLayoutInflater().inflate(R.layout.adddegree,null);
//                item.addView(addedView);
//
////                 Remove.setEnabled(true);
//                Remove.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        removeView();
//                    }
//                    private void removeView(){
////                        LinearLayout item = (LinearLayout) findViewById(R.id.Adddegree);
//               item.removeView(addedView);
//
////                        Remove.setEnabled(false);
////                        Remove.setEnabled(false);
////
//////                findViewById(R.id.Adddegree).setVisibility(View.INVISIBLE);
//            }
//
//                });
//
//            }
//
//        });


//
        addqualification.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                addView();
            }
            private void addView() {
                LinearLayout item = (LinearLayout) findViewById(R.id.Adddqualification);
                getLayoutInflater().inflate(R.layout.addqualification, item);
            }
        });


        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textschool = school.getText().toString();
                textenglishsslcbox = englishsslcbox.getText().toString();
                textmathssslcbox = mathssslcbox.getText().toString();
                textsciencesslcbox = sciencesslcbox.getText().toString();
                textsocialsslcbox = socialsciencesslcbox.getText().toString();
                textschoolplustwo = schoolplustwo.getText().toString();
//                textallsyllabus = actv1.getText().toString();

                textsub1box = sub1box.getText().toString();
                textsub2box = sub2box.getText().toString();
                textsub3box = sub3box.getText().toString();
                textsub4box = sub4box.getText().toString();
                textsub5box = sub5box.getText().toString();
                textsub6box = sub6box.getText().toString();
                textcollegecourse=collegecourse.getText().toString();
                textplustwoallsyllabus=plustwoallsyllabus.getText().toString();
//                textsub1 = actv2.getText().toString();
//                textsub2 = actv3.getText().toString();
//                textsub3 = actv4.getText().toString();
//                textsub4 = actv5.getText().toString();
                //                textsub4 = actv5.getText().toString();
                //                textsub4 = actv5.getText().toString();

                textcollegename = collegename.getText().toString();
                textuniversity = collegeuniversity.getText().toString();
//                textugccourse = ugccourse.getText().toString();
                textugcmainbox = ugcmainbox.getText().toString();
                textcoresub = ugcsubbox.getText().toString();
                textugcenglishbox = ugcenglishbox.getText().toString();
                textugclangbox = ugclangbox.getText().toString();
                textopencoursebox = opencoursebox.getText().toString();
                qualcrse = coursename.getText().toString();
                qualtype = coursetype.getText().toString();
               qualinstitu = institution.getText().toString();
               qualuniversity = university2.getText().toString();


                if (radioeng.isChecked()) {
                    textmedium = radioeng.getText().toString();
                } else {
                    textmedium = radiomal.getText().toString();
                }

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getEducationList(textschool, textmedium, textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox, textschoolplustwo, textallsyllabus,
                        textsub1box, textsub2box, textsub3box, textsub4box, textsub5box, textsub6box,
                        textallsyllabus, textcollegename, textuniversity, textugcmainbox, textcoresub, textugcenglishbox, textugclangbox, textopencoursebox,textcollegecourse,textplustwoallsyllabus,textcoursetype
                ,textcoursename,qualtype,qualcrse,qualinstitu, qualuniversity);


            }
        });
    }

    private void dropdowncall() {
        Call<EducationDropdownResponse> dropdownResponseCall = apiCall.geteducationDropdown();
        dropdownResponseCall.enqueue(new Callback<EducationDropdownResponse>() {
            @Override
            public void onResponse(Call<EducationDropdownResponse> call, Response<EducationDropdownResponse> response) {
                plusTwoCoursesItems = response.body().getPlusTwoCourses();
                for (PlusTwoCoursesItem item : plusTwoCoursesItems) {
                    plustwosyllabus.add(item.getCourseName());
                }


                plusTwoSubjectsItems = response.body().getPlusTwoSubjects();
                for (PlusTwoSubjectsItem item1 : plusTwoSubjectsItems) {
                    plustwosubjects.add(item1.getSubject());
                }


                degreeCoursesItems = response.body().getDegreeCourses();
                for (DegreeCoursesItem item2 : degreeCoursesItems) {
                    degreecourses.add(item2.getCourse());
                }


                universityItems = response.body().getUniversity();
                for (UniversityItem item3 : universityItems) {
                    universities.add(item3.getUniversity());
                }
            }


            @Override
            public void onFailure(Call<EducationDropdownResponse> call, Throwable t) {

            }
        });
    }



    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioeng:
                radiomal.setChecked(false);

                break;
            case R.id.radiomal:
                radioeng.setChecked(false);

                break;
        }
    }

        public void getEducationList (String textschool, String textmedium, String
        textenglishsslcbox, String textmathssslcbox, String textsciencesslcbox, String
        textsocialsslcbox, String textschoolplustwo, String textallsyllabus,
                String textsub1box, String textsub2box, String textsub3box, String
        textsub4box, String textsub5box, String textsub6box,
                String textugccourse, String textcollegename, String textuniversity, String
        textugcmainbox, String textcoresub,
                String textugcenglishbox, String textugclangbox, String textopencoursebox ,String textcollegecourse,String textplustwoallsyllabus,
                                      String textcoursetype,String textcoursename,String qualtype,String qualcrse,
                                      String qualinstitu,String  qualuniversity){

            SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
            authentoken = (shared.getString("token", ""));
            HashMap<String, String> params = new HashMap<>();
            params.put("high_school", textschool);
            params.put("high_school_medium", textmedium);
            params.put("high_school_english", textenglishsslcbox);
            params.put("high_school_maths", textmathssslcbox);
            params.put("high_school_science", textsciencesslcbox);
            params.put("high_school_socialscience", textsocialsslcbox);
            params.put("plus_two_syllabus", textplustwoallsyllabus);
            params.put("higher_secondary_school", textschoolplustwo);
//        //  params.put("course_id", 1);
//        params.put("higher_secondary_subject1",textsub1box );
//        params.put("higher_secondary_subject2", textsub2box);
//        params.put("higher_secondary_subject3", textsub3box);
//        params.put("higher_secondary_subject4", textsub4box);
//        params.put("higher_secondary_subject5", textsub5box);
//            params.put("higher_secondary_subject6", textsub6box);
//        params.put("higher_secondary_mark1", textsub1box);
//            params.put("higher_secondary_mark2", textsub2box);
//            params.put("higher_secondary_mark3", textsub3box);
//            params.put("higher_secondary_mark4", textsub4box);
//            params.put("higher_secondary_mark5", textsub5box);
            params.put("course_name", textcollegecourse);
            params.put("college_name", textcollegename);
            params.put("university", textuniversity);
            params.put("core_mark", textugcmainbox);
            params.put("complementary", textcoresub);
            params.put("common_english", textugcenglishbox);
            params.put("common_language", textugclangbox);
            params.put("open_mark", textopencoursebox);
//        //params.put("additional_courses_grade", textcoursename);
//        params.put("additional_courses_instiution", textinstitution);
//        params.put("additional_courses_recongnisation", textuniversity2);
//        params.put("additional_courses_course_type", qualtype);
        params.put("other_qualification_course_name", qualcrse);
        params.put("other_qualification_grade", qualtype);
        params.put("other_qualification_instiution", qualinstitu);
        params.put("other_qualification_recongnisation",  qualuniversity);




            Call<EducationResponse> educationCall = apiCall.getEducation(params, authentoken);

            educationCall.enqueue(new Callback<EducationResponse>() {
                @Override
                public void onResponse(Call<EducationResponse> call, Response<EducationResponse> response) {

                    status = response.code();
                    if (status != 400) {
                        apieducationlist = response.body().getStatus();

                        Toast.makeText(EducationalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                        Intent newIntent = new Intent(getApplicationContext(), FamilyDetails.class);
                        startActivity(newIntent);
                        finish();
                    } else {
                        Toast.makeText(EducationalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<EducationResponse> call, Throwable t) {
                    Toast.makeText(EducationalDetails.this, "Failed", Toast.LENGTH_SHORT).show();

                }
            });

        }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


}
















