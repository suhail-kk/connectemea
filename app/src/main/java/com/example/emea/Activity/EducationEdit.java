package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.Student;
import com.example.emea.Response.getDetails.TenthStd;
import com.example.emea.Response.getDetails.TwelthStd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationEdit extends AppCompatActivity {

    Button saveinfo,adddegree,Remove;
    ProgressBar pgBar;
    TextView school, medium, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo,  sub1box, sub2box, sub3box, sub4box, sub5box, sub6box,
            collegename, universityugc, courseugc, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox,
            coursename, coursetype, institution, university2,collegeuni,collegecou;
    String authtoken;
    AutoCompleteTextView allsyllabus,subid1,subid2,subid3,subid4,subid5;
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
    String textplustwoallsyllabus;
    String textcollegecourse;
    String textcollegeuniversity;
    String textcollegeuni;
    String textcollegecou;
    ApiCall apiCall;
    String apieducationlist;
    String status;
//    Educational10thDetails educational10thDetails;
//    Educational12thDetails educational12thDetails;
//    Marklist10th marklist10;
//    Marklist12th marklist12th;
//    DegreeDetails degreeDetails;
//    DegreeMarkList degreeMarkList;
//    OtherQualifications otherQualifications;
    List<Object> textsubid1;
    List<Object> textsubid2;
    List<Object> textsubid3;
    List<Object> textsubid4;
    List<Object> textsubid5;
//    TextView subid1,subid2,subid3,subid4,subid5;
    RadioButton radioeng;
    RadioButton radiomal;
    LinearLayout add;
//    AutoCompleteTextView plustwoallsyllabus, sub1, sub2, sub3, sub4, sub5, sub6,collegeuniversity,collegecourse;
//    ArrayList<PlusTwoCoursesItem> plusTwoCoursesItems;
//    ArrayList<String> plustwosyllabus;
//    ArrayAdapter<String> plus2syllabus;

//    ArrayList<PlusTwoSubjectsItem> plusTwoSubjectsItems;
//    ArrayList<String> plustwosubjects;
////    ArrayAdapter<String> plus2subjects;
//
//    ArrayList<DegreeCoursesItem> degreeCoursesItems;
//    ArrayList<String> degreecourses;
//    ArrayAdapter<String> degreecourse;
//
//    ArrayList<UniversityItem> universityItems;
//    ArrayList<String> universities;
//    ArrayAdapter<String> university;
    Data data;
    Student student;
    EducationDetails educationaldetails;
    TenthStd tenthstd;
    TwelthStd twelthstd;

    ArrayAdapter<String> plus2subjects;
    ArrayAdapter<String> english;
    ArrayAdapter<String> subject1;
    ArrayAdapter<String> subject2;
    ArrayAdapter<String> subject3;
    ArrayAdapter<String> subject4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);

        String plustwosyllabus[] = {"CBSE", "ICSE"};
        String English[] = {"English"};
        String hseSubject1[] = {"Biology", "Computer Science"};
        String hseSubject2[] = {"physics", "accounting","journalism"};
        String hseSubject3[] = {"Chemistry", "Geology","CA"};
        String hseSubject4[] = {"Mathematics", "Politic","sociology"};

//        plustwosyllabus= new ArrayList<>();
//        plustwosubjects= new ArrayList<>();
//        degreecourses= new ArrayList<>();
//        universities= new ArrayList<>();


        saveinfo = findViewById(R.id.saveEduDetail);
        radioeng = findViewById(R.id.radioeng);
        radiomal = findViewById(R.id.radiomal);
        pgBar=findViewById(R.id.progressBar2);
        adddegree = findViewById(R.id.addDegree);
        Remove=findViewById(R.id.remove);
        add= findViewById(R.id.newDegreeLayout2);
//        plustwoallsyllabus=findViewById(R.id.hsesyllabus);
//        sub1 = findViewById(R.id.hsesubName1);
////        sub1box = findViewById(R.id.hsesubMark1);
//        sub2 = findViewById(R.id.hsesubName2);
////        sub2box = findViewById(R.id.hsesubMark2);
//        sub3 = findViewById(R.id.hsesubName3);
////        sub3box = findViewById(R.id.hsesubMark3);
//        sub4 = findViewById(R.id.hsesubName4);
////        sub4box = findViewById(R.id.hsesubMark4);
//        sub5 = findViewById(R.id.hsesubName5);
//        sub5box = findViewById(R.id.hsesubMark5);

//
//        plus2subjects = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosyllabus);
//        plustwoallsyllabus.setAdapter(plus2subjects);
//        plustwoallsyllabus.setThreshold(1);
//        english = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, English);
//        sub1.setAdapter(english);
//        sub1.setThreshold(1);
//        subject1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject1);
//        sub2.setAdapter(subject1);
//        sub2.setThreshold(1);
//        subject2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject2);
//        sub3.setAdapter(subject2);
//        sub3.setThreshold(1);
//        subject3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject3);
//        sub4.setAdapter(subject3);
//        sub4.setThreshold(1);
//        subject4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject4);
//        sub5.setAdapter(subject4);
//        sub5.setThreshold(1);

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


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        pgBar.setVisibility(View.VISIBLE);
//        String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyMiIsImVtYWlsIjoiamFja0BnbWFpbC5jb20iLCJ1c2VybmFtZSI6ImphY2siLCJyZWdpc3RlcmVkIjpmYWxzZX0.D_5yGA8kmjWnQ1YejAMsFlSWXmt-QE3NwAcOFT2LZeg";
        Call<GetResponse> educationCall = apiCall.getDetailsView(authtoken);
        educationCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                pgBar.setVisibility(View.GONE);

//                educational10thDetails = response.body().getEducational10thDetails();
//                educational12thDetails = response.body().getEducational12thDetails();
//                degreeDetails = response.body().getDegreeDetails();
//                degreeMarkList = response.body().getDegreeMarkList();
//                otherQualifications=response.body().getOtherQualifications();
//                marklist10=response.body().getMarklist10th();
//                marklist12th=response.body().getMarklist12th();
//                //sslc
//                textmathssslcbox = marklist10.getMaths();
//                mathssslcbox = findViewById(R.id.mathssslc);
//                mathssslcbox.setText(textmathssslcbox);
//                textschool = educational10thDetails.getSchoolName();
//                school = findViewById(R.id.schoolname);
//                school.setText(textschool);
//                textmedium = educational10thDetails.getMedium();
//
//                if(textmedium.equals("English")){
//                    radioeng.setChecked(true);
//                }else{
//                    radiomal.setChecked(true);
//                }
//
//                textenglishsslcbox = marklist10.getEnglish();
//                englishsslcbox = findViewById(R.id.englishsslc);
//                englishsslcbox.setText(textenglishsslcbox);
//                textsciencesslcbox = marklist10.getScience();
//                sciencesslcbox = findViewById(R.id.sciencesslc);
//                sciencesslcbox.setText(textsciencesslcbox);
//                textsocialsslcbox =  marklist10.getSocialStudies();
//                socialsciencesslcbox = findViewById(R.id.socialsslc);
//                socialsciencesslcbox.setText(textsocialsslcbox);
//                textschoolplustwo = educational12thDetails.getSchoolName();
//                //plustwo
//                schoolplustwo = findViewById(R.id.hseschoolName);
//                schoolplustwo.setText(textschoolplustwo);
//                textallsyllabus = educational12thDetails.getSyllabus();
//                allsyllabus = findViewById(R.id.hsesyllabus);
//                allsyllabus.setText(textallsyllabus);
//                textcollegeuni = degreeDetails.getUniversity();
//                collegeuni = findViewById(R.id.degreeuniversity);
//                collegeuni.setText(textcollegeuni );
//                textcollegecou = degreeDetails.getCourseName();
//                collegecou = findViewById(R.id.degreecourse);
//                collegecou.setText(textcollegecou );
//
//
//
//                textsubid1 = marklist12th.getSubjectId1();
//                subid1 = findViewById(R.id.hsesubName1);
//                subid1.setText(textsubid1);
//                textsub1box = marklist12th.getSubject1Mark();
//                sub1box = findViewById(R.id.hsesubMark1);
//                sub1box.setText(textsub1box);
//                textsubid2 = marklist12th.getSubjectId2();
//                subid2 = findViewById(R.id.hsesubName2);
//                subid2.setText(textsubid2);
//                textsub2box =  marklist12th.getSubject2Mark();
//                sub2box = findViewById(R.id.hsesubMark2);
//                sub2box.setText(textsub2box);
//                textsubid3 = marklist12th.getSubjectId3();
//                subid3 = findViewById(R.id.hsesubName3);
//                subid3.setText(textsubid3);
//                textsub3box = marklist12th.getSubject3Mark();
//                sub3box = findViewById(R.id.hsesubMark3);
//                sub3box.setText(textsub3box);
//                textsubid4 = marklist12th.getSubjectId4();
//                subid4 = findViewById(R.id.hsesubName4);
//                subid4.setText(textsubid4);
//                textsub4box =  marklist12th.getSubject4Mark();
//                sub4box = findViewById(R.id.hsesubMark4);
//                sub4box.setText(textsub4box);
//                textsubid5 = marklist12th.getSubjectId5();
//                subid5 = findViewById(R.id.hsesubName5);
//                subid5.setText(textsubid5);
//                textsub5box =  marklist12th.getSubject5Mark();
//                sub5box = findViewById(R.id.hsesubMark5);
//                sub5box.setText(textsub5box);
//
//
//
//
//                //degree
//                textcollegename=degreeDetails.getCollegeName();
//                collegename = findViewById(R.id.ugcollegeName);
//                collegename.setText(textcollegename);
//                textugcmainbox=degreeMarkList.getCoreMark();
//                ugcmainbox = findViewById(R.id.dgrsubCore);
//                ugcmainbox.setText(textugcmainbox);
//                textcoresub=degreeMarkList.getCoreMark();
//                ugcsubbox = findViewById(R.id.dgrsubComp);
//                ugcsubbox.setText(textcoresub);
//                textugcenglishbox=degreeMarkList.getEnglishMark();
//                ugcenglishbox = findViewById(R.id.dgrsubEng);
//                ugcenglishbox.setText(textugcenglishbox);
//                textugclangbox=degreeMarkList.getLanguageMark();
//                ugclangbox = findViewById(R.id.dgrsubLang);
//                ugclangbox.setText(textugclangbox);
//                textopencoursebox=degreeMarkList.getOpenMark();
//                opencoursebox = findViewById(R.id.dgrsubOpen);
//                opencoursebox.setText(textopencoursebox);
////otherqualifications
//                qualcrse=otherQualifications.getCourseName();
//                coursename = findViewById(R.id.qualicrsName);
//                coursename.setText(qualcrse);
//                qualtype=otherQualifications.getGrade();
//                coursetype = findViewById(R.id.qualicrstype);
//                coursetype.setText(qualtype);
//                qualinstitu=otherQualifications.getInstiution();
//                institution = findViewById(R.id.qualiIstnname);
//                institution.setText(qualinstitu);
//                qualuniversity=otherQualifications.getRecongnisation();
//                university2 = findViewById(R.id.qualiuniversity);
//                university2.setText(qualuniversity);
//
//                plustwoallsyllabus=findViewById(R.id.hsesyllabus);
//                plus2syllabus = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosyllabus);
//                plustwoallsyllabus.setAdapter(plus2syllabus);
//                plustwoallsyllabus.setThreshold(1);
//
////                plus2subjects = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosubjects);
////                sub1.setAdapter(plus2subjects);
////                sub1.setThreshold(1);
//
//                collegecourse=findViewById(R.id.degreecourse);
//                degreecourse = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, degreecourses);
//                collegecourse.setAdapter(degreecourse);
//                collegecourse.setThreshold(1);
//
//                collegeuniversity=findViewById(R.id.degreeuniversity);
//                university = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, universities);
//                collegeuniversity.setAdapter(university);
//                collegeuniversity.setThreshold(1);
//                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//                dropdowncall();



                data = response.body().getData();
                student = data.getStudent();
                educationaldetails = student.getEducationDetails();
                 tenthstd = educationaldetails.getTenthStd();
                 twelthstd = educationaldetails.getTwelthStd();

                textmathssslcbox=tenthstd.getMaths();
                mathssslcbox=findViewById(R.id.mathssslc);
                mathssslcbox.setText(String.valueOf(textmathssslcbox));

                textschool = tenthstd.getSchoolName();
                school = findViewById(R.id.schoolname);
                school.setText(textschool);
//                textmedium = tenthstd.getSyllabus();
//                medium = (TextView) findViewById(R.id.mediumDisplay);
//                medium.setText(textmedium);
                textenglishsslcbox = tenthstd.getEnglish();
                englishsslcbox = findViewById(R.id.englishsslc);
                englishsslcbox.setText(String.valueOf(textenglishsslcbox));
                textsciencesslcbox = tenthstd.getScience();
                sciencesslcbox = findViewById(R.id.sciencesslc);
                sciencesslcbox.setText(String.valueOf(textsciencesslcbox));
                textsocialsslcbox = tenthstd.getSocialScience();
                socialsciencesslcbox = findViewById(R.id.socialsslc);
                socialsciencesslcbox.setText(String.valueOf(textsocialsslcbox));
                textschoolplustwo = twelthstd.getSchoolName();
                schoolplustwo = findViewById(R.id.hseschoolName);
                schoolplustwo.setText(textschoolplustwo);
                textallsyllabus = twelthstd.getSyllabus();
                allsyllabus = findViewById(R.id.hsesyllabus);
                allsyllabus.setText(textallsyllabus);
                textsubid1 = twelthstd.getSub();
                subid1 =  findViewById(R.id.hsesubName1);
                subid1.setText(String.valueOf(textsubid1.get(0)));

                textsub1box = twelthstd.getSubMark();
                sub1box = findViewById(R.id.hsesubMark1);
                sub1box.setText(String.valueOf( textsub1box.get(0)));
                textsubid2 =  twelthstd.getSub();
                subid2 = findViewById(R.id.hsesubName2);
                subid2.setText(String.valueOf(textsubid2.get(1)));
//
                textsub2box =twelthstd.getSubMark();
                sub2box = findViewById(R.id.hsesubMark2);
                sub2box.setText(String.valueOf(textsub2box.get(1)));
                textsubid3 = twelthstd.getSub();
                subid3 =  findViewById(R.id.hsesubName3);
                subid3.setText(String.valueOf(textsubid3.get(2)));
                textsub3box = twelthstd.getSubMark();
                sub3box = findViewById(R.id.hsesubMark3);
                sub3box.setText(String.valueOf(textsub3box.get(2)));
                textsubid4 = twelthstd.getSub();
                subid4 =  findViewById(R.id.hsesubName4);
                subid4.setText(String.valueOf(textsubid4.get(3)));
                textsub4box = twelthstd.getSubMark();
                sub4box = findViewById(R.id.hsesubMark4);
                sub4box.setText(String.valueOf(textsub4box.get(3)));
                textsubid5 =twelthstd.getSub();
                subid5 =  findViewById(R.id.hsesubName5);
                subid5.setText(String.valueOf(textsubid5.get(4)));
                textsub5box = twelthstd.getSubMark();
                sub5box = findViewById(R.id.hsesubMark5);
                sub5box.setText(String.valueOf(textsub5box.get(4)));




                plus2subjects = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, plustwosyllabus);
                allsyllabus.setAdapter(plus2subjects);
                allsyllabus.setThreshold(1);
                english = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, English);
                subid1.setAdapter(english);
                subid1.setThreshold(1);
                subject1 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject1);
                subid2.setAdapter(subject1);
                subid2.setThreshold(1);
                subject2 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject2);
                subid3.setAdapter(subject2);
                subid3.setThreshold(1);
                subject3 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject3);
                subid4.setAdapter(subject3);
                subid4.setThreshold(1);
                subject4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject4);
                subid5.setAdapter(subject4);
                subid5.setThreshold(1);


            }
            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                pgBar.setVisibility(View.GONE);
                Toast.makeText(EducationEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });



        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







                textschool = school.getText().toString();
                textenglishsslcbox = Integer.parseInt(englishsslcbox.getText().toString());
                textmathssslcbox = Integer.parseInt(mathssslcbox.getText().toString());
                textsciencesslcbox = Integer.parseInt(sciencesslcbox.getText().toString());
                textsocialsslcbox = Integer.parseInt(socialsciencesslcbox.getText().toString());
                textschoolplustwo = schoolplustwo.getText().toString();
//                textallsyllabus = actv1.getText().toString();
                textallsyllabus=allsyllabus.getText().toString();
                textsubid1= Collections.singletonList(subid1.getText().toString());
                textsubid2= Collections.singletonList(subid2.getText().toString());
                textsubid3= Collections.singletonList(subid3.getText().toString());
                textsubid4= Collections.singletonList(subid4.getText().toString());
                textsubid5= Collections.singletonList(subid5.getText().toString());
                textsub1box = Collections.singletonList(Integer.parseInt(sub1box.getText().toString()));
                textsub2box = Collections.singletonList(Integer.parseInt(sub2box.getText().toString()));
                textsub3box = Collections.singletonList(Integer.parseInt(sub3box.getText().toString()));
                textsub4box = Collections.singletonList(Integer.parseInt(sub4box.getText().toString()));
                textsub5box = Collections.singletonList(Integer.parseInt(sub5box.getText().toString()));
//


                String sub[] = {String.valueOf(textsubid1), String.valueOf(textsubid2), String.valueOf(textsubid3), String.valueOf(textsubid4), String.valueOf(textsubid5)};
                String subMark[] = {String.valueOf(textsub1box), String.valueOf(textsub2box), String.valueOf(textsub3box), String.valueOf(textsub4box), String.valueOf(textsub4box)};

//                textcollegename = collegename.getText().toString();
//                textcollegecourse=collegecourse.getText().toString();
//                textcollegeuniversity=collegeuniversity.getText().toString();
////                textuniversity = university.getText().toString();
////                textugccourse = ugccourse.getText().toString();
//                textugcmainbox = ugcmainbox.getText().toString();
//                textcoresub = ugcsubbox.getText().toString();
//                textugcenglishbox = ugcenglishbox.getText().toString();
//                textugclangbox = ugclangbox.getText().toString();
//                textopencoursebox = opencoursebox.getText().toString();
//                qualcrse = coursename.getText().toString();
//                qualtype = coursetype.getText().toString();
//                qualinstitu = institution.getText().toString();
//                qualuniversity = university2.getText().toString();
//                if (radioeng.isChecked()) {
//                    textmedium = radioeng.getText().toString();
//                } else {
//                    textmedium = radiomal.getText().toString();
//                }
//
//
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
//                twelthStd.put("course",textCousre);
                educationDetails.put("twelthStd",twelthStd);


//                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//
//
//                getEditList(father,mother,gardian);
//            }
//        });
//    }
//
//    private void getEditList(HashMap<String, Object> father, HashMap<String, Object> mother, HashMap<String, Object> gardian ) {
//
//        HashMap<String, Object> familyDetails = new HashMap<>();
//
//
//        familyDetails.put("father",father);
//        familyDetails.put("mother",mother);
//        familyDetails.put("gardian",gardian);
//
//
//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//
//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authtoken = (shared.getString("token", ""));
//
////        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
////         userid = (pref.getString("_id", ""));
//
//
//        Call<EditResponse> familyeditCall = apiCall.getEdit(userid,familyDetails,authtoken);
//        familyeditCall.enqueue(new Callback<EditResponse>() {
//            @Override
//            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {
//
////                status = response.body().getStatus();
//
//                Toast.makeText(FamilyEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                Intent newIntent = new Intent(getApplicationContext(), FamilyDetailsView.class);
//                startActivity(newIntent);
//
////                    Toast.makeText(FamilyEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<EditResponse> call, Throwable t) {
//                Toast.makeText(FamilyEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//}


//                getEducationViewList(textschool, textmedium, textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox, textschoolplustwo, textallsyllabus,
//                        textsub1box, textsub2box, textsub3box, textsub4box, textsub5box, textsub6box,
//                        textallsyllabus, textcollegename, textuniversity, textugcmainbox, textcoresub, textugcenglishbox, textugclangbox, textopencoursebox,
//                        textsubid1,textsubid2,textsubid3,textsubid4,textsubid5,textplustwoallsyllabus,textcollegeuniversity,textcollegecourse
//                ,qualinstitu,qualuniversity,qualcrse,qualtype);
            }
        });
    }

//    private void dropdowncall() {
//        Call<EducationDropdownResponse> dropdownResponseCall = apiCall.geteducationDropdown();
//        dropdownResponseCall.enqueue(new Callback<EducationDropdownResponse>() {
//            @Override
//            public void onResponse(Call<EducationDropdownResponse> call, Response<EducationDropdownResponse> response) {
//                plusTwoCoursesItems = response.body().getPlusTwoCourses();
//                for (PlusTwoCoursesItem item : plusTwoCoursesItems) {
//                    plustwosyllabus.add(item.getCourseName());
//                }
//
//
//                plusTwoSubjectsItems = response.body().getPlusTwoSubjects();
//                for (PlusTwoSubjectsItem item1 : plusTwoSubjectsItems) {
//                    plustwosubjects.add(item1.getSubject());
//                }
//
//
//                degreeCoursesItems = response.body().getDegreeCourses();
//                for (DegreeCoursesItem item2 : degreeCoursesItems) {
//                    degreecourses.add(item2.getCourse());
//                }
//
//
//                universityItems = response.body().getUniversity();
//                for (UniversityItem item3 : universityItems) {
//                    universities.add(item3.getUniversity());
//                }
//            }


//            @Override
//            public void onFailure(Call<EducationDropdownResponse> call, Throwable t) {
//                Toast.makeText(EducationEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }



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


    public void getEducationViewList(String textschool, String textmedium, String textenglishsslcbox, String textmathssslcbox, String textsciencesslcbox, String textsocialsslcbox, String textschoolplustwo, String textallsyllabus,
                                     String textsub1box, String textsub2box, String textsub3box, String textsub4box, String textsub5box, String textsub6box,
                                     String textugccourse, String textcollegename, String textuniversity, String textugcmainbox, String textcoresub,
                                     String textugcenglishbox, String textugclangbox, String textopencoursebox,String textsubid1,String textsubid2,String textsubid3,
                                     String textsubid4,String textsubid5,String textplustwoallsyllabus,String textcollegeuniversity,String textcollegecourse,String qualinstitu
    ,String qualuniversity,String qualcrse,String qualtype) {


        HashMap<String, String> params = new HashMap<>();
        params.put("high_school", textschool);
        params.put("high_school_medium", textmedium);
        params.put("high_school_english", textenglishsslcbox);
        params.put("high_school_maths", textmathssslcbox);
        params.put("high_school_science", textsciencesslcbox);
        params.put("high_school_socialscience", textsocialsslcbox);
        params.put("plus_two_syllabus", textplustwoallsyllabus);
//        params.put("plus_two_syllabus", textallsyllabus);
        params.put("higher_secondary_school", textschoolplustwo);
        //  params.put("course_id", 1);
//        params.put("subject_id1", textsubid1);
//        params.put("subject_id2", textsubid2);
//        params.put("subject_id3", textsubid3);
//        params.put("subject_id4", textsubid4);
//        params.put("subject_id5", textsubid5);
//        params.put("higher_secondary_mark1", textsub1box);
//        params.put("higher_secondary_mark2", textsub2box);
//        params.put("higher_secondary_mark3", textsub3box);
//        params.put("higher_secondary_mark4", textsub4box);
//        params.put("higher_secondary_mark5", textsub5box);
//        params.put("course_name", textugccourse);
        params.put("college_name", textcollegename);
        params.put("university", textcollegeuniversity);
        params.put("course_name", textcollegecourse);
        params.put("core", textugcmainbox);
        params.put("complementary", textcoresub);
        params.put("common_english", textugcenglishbox);
        params.put("common_language", textugclangbox);
        params.put("open", textopencoursebox);
        //params.put("additional_courses_grade", textcoursename);
//        params.put("additional_courses_instiution", textinstitution);
//        params.put("additional_courses_recongnisation", textuniversity2);
//        params.put("additional_courses_course_type", textcoursetype);
//        params.put("other_qualification_course_name", textcoursename);
//        params.put("other_qualification_grade", textcoursename);
//        params.put(" other_qualification_instiution", textcoursename);
//        params.put("other_qualification_recongnisation", textcoursename);
        params.put("other_qualification_course_name", qualcrse);
        params.put("additional_course_percentage", qualtype);
        params.put("additional_course", qualinstitu);
        params.put("additional_course_university",  qualuniversity);

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));



//        Call<EducationeditResponse> educationeditCall = apiCall.getEducationEdit(params, authtoken);
//
//        educationeditCall.enqueue(new Callback<EducationeditResponse>() {
//            @Override
//            public void onResponse(Call<EducationeditResponse> call, Response<EducationeditResponse> response) {
//                status = response.body().getStatus();
//
//                if (status.equals("Success")) {
//                    Toast.makeText(EducationEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                    Intent newIntent = new Intent(getApplicationContext(), EducationDetailsView.class);
//                    startActivity(newIntent);
//                    finish();
//                } else {
//                    Toast.makeText(EducationEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//
//            @Override
//            public void onFailure(Call<EducationeditResponse> call, Throwable t) {
//                Toast.makeText(EducationEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

}





