package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.GetResponse;
//import com.example.emea.Response.getDetails.Student;
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

    Button saveinfo, adddegree, Remove;
    ProgressBar pgBar;
    TextView school, medium, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, sub1box, sub2box, sub3box, sub4box, sub5box;
    String authtoken, textschool, textmedium;
    AutoCompleteTextView allsyllabus, subid1, subid2, subid3, subid4, subid5,course;
    int textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox;
    String textschoolplustwo, textallsyllabus, textplustwoallsyllabus,textcourse;
    List<String> textsub1box, textsub2box, textsub3box, textsub4box, textsub5box;
    ApiCall apiCall;
    List<String> textsubid1;
    List<String> textsubid2;
    List<String> textsubid3;
    List<String> textsubid4;
    List<String> textsubid5;
    LinearLayout add;
    Data data;
    EducationDetails educationaldetails;
    TenthStd tenthstd;
    TwelthStd twelthstd;
    String userid;

    ArrayAdapter<String> plus2subjects;
    ArrayAdapter<String> english;
    ArrayAdapter<String> subject1;
    ArrayAdapter<String> subject2;
    ArrayAdapter<String> subject3;
    ArrayAdapter<String> subject4;
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

        String plustwosyllabus[] = {"CBSE", "ICSE"};
        String English[] = {"English"};
        String hseSubject1[] = {"Biology", "Computer Science"};
        String hseSubject2[] = {"physics", "accounting", "journalism"};
        String hseSubject3[] = {"Chemistry", "Geology", "CA"};
        String hseSubject4[] = {"Mathematics", "Politic", "sociology"};

        saveinfo = findViewById(R.id.saveinfo);
        pgBar = findViewById(R.id.progressBar2);
        adddegree = findViewById(R.id.addDegree);
        add = findViewById(R.id.newDegreeLayout2);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgBar.setVisibility(View.VISIBLE);
        Call<GetResponse> educationCall = apiCall.getDetailsView(authtoken);
        educationCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                pgBar.setVisibility(View.GONE);
                data = response.body().getData();
                educationaldetails = data.getEducationDetails();
                tenthstd = educationaldetails.getTenthStd();
                twelthstd = educationaldetails.getTwelthStd();
                textschool = tenthstd.getSchoolName();
                school = findViewById(R.id.schoolname);
                school.setText(textschool);
                textmedium=tenthstd.getSyllabus();
                medium=findViewById(R.id.user_medium);
                medium.setText(textmedium);
                textmathssslcbox = tenthstd.getMaths();
                mathssslcbox = findViewById(R.id.mathssslc);
                mathssslcbox.setText(String.valueOf(textmathssslcbox));
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
                textcourse=twelthstd.getCourse();
                course=findViewById(R.id.hsecourse);
                course.setText(textcourse);
                textsubid1 = twelthstd.getSub();
                subid1 = findViewById(R.id.hsesubName1);
                subid1.setText(textsubid1.get(0));
                textsub1box = twelthstd.getSubMark();
                sub1box = findViewById(R.id.hsesubMark1);
                sub1box.setText(textsub1box.get(0));
                textsubid2 = twelthstd.getSub();
                subid2 = findViewById(R.id.hsesubName2);
                subid2.setText(textsubid2.get(1));
                textsub2box = twelthstd.getSubMark();
                sub2box = findViewById(R.id.hsesubMark2);
                sub2box.setText(textsub2box.get(1));
                textsubid3 = twelthstd.getSub();
                subid3 = findViewById(R.id.hsesubName3);
                subid3.setText(textsubid3.get(2));
                textsub3box = twelthstd.getSubMark();
                sub3box = findViewById(R.id.hsesubMark3);
                sub3box.setText(textsub3box.get(2));
                textsubid4 = twelthstd.getSub();
                subid4 = findViewById(R.id.hsesubName4);
                subid4.setText(textsubid4.get(3));
                textsub4box = twelthstd.getSubMark();
                sub4box = findViewById(R.id.hsesubMark4);
                sub4box.setText(textsub4box.get(3));
//                textsubid5 =twelthstd.getSub();
//                subid5 =  findViewById(R.id.hsesubName5);
//                subid5.setText(textsubid5.get(4));
//                textsub5box = twelthstd.getSubMark();
//                sub5box = findViewById(R.id.hsesubMark5);
//                sub5box.setText(textsub5box.get(4));

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
//                subject4 = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, hseSubject4);
//                subid5.setAdapter(subject4);
//                subid5.setThreshold(1);


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
                textallsyllabus = allsyllabus.getText().toString();
                textsubid1 = Collections.singletonList(subid1.getText().toString());
                textsubid2 = Collections.singletonList(subid2.getText().toString());
                textsubid3 = Collections.singletonList(subid3.getText().toString());
                textsubid4 = Collections.singletonList(subid4.getText().toString());
//                textsubid5 = Collections.singletonList(subid5.getText().toString());
                textsub1box = Collections.singletonList(sub1box.getText().toString());
                textsub2box = Collections.singletonList(sub2box.getText().toString());
                textsub3box = Collections.singletonList(sub3box.getText().toString());
                textsub4box = Collections.singletonList(sub4box.getText().toString());
//                textsub5box = Collections.singletonList(sub5box.getText().toString());

                String sub[] = {textsubid1.get(0), textsubid2.get(0), textsubid3.get(0), textsubid4.get(0)};
                String subMark[] = {textsub1box.get(0), textsub2box.get(0), textsub3box.get(0), textsub4box.get(0)};

                HashMap<String, Object> tenthStd = new HashMap<>();
                tenthStd.put("schoolName", textschool);
                tenthStd.put("science", textsciencesslcbox);
                tenthStd.put("syllabus", textmedium);
                tenthStd.put("english", textenglishsslcbox);
                tenthStd.put("maths", textmathssslcbox);
                tenthStd.put("socialScience", textsocialsslcbox);

                HashMap<String, Object> twelthStd = new HashMap<>();
                twelthStd.put("schoolName", textschoolplustwo);
                twelthStd.put("syllabus", textallsyllabus);
                twelthStd.put("course", textcourse);
                twelthStd.put("sub", sub);
                twelthStd.put("subMark", subMark);


//                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
                Intent newIntent = new Intent(EducationEdit.this, EducationEdit2.class);
                newIntent.putExtra("educationDetails", tenthStd);
                newIntent.putExtra("educationDetails", twelthStd);
                startActivity(newIntent);
            }
        });
    }
}
//                getEditList(tenthStd, twelthStd);
//
//            }
//                private void getEditList(HashMap<String, Object> tenthStd, HashMap<String, Object> twelthStd ) {
//
//                    HashMap<String, Object> educationDetails = new HashMap<>();
//                    educationDetails.put("tenthStd",tenthStd);
//                    educationDetails.put("twelthStd",twelthStd);
//
//                    HashMap<String,Object> editeducation = new HashMap<>();
//                    editeducation.put("educationDetails",educationDetails);
//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authtoken = (shared.getString("token", ""));
//
//        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
//                 userid = (pref.getString("_id", ""));
//
//
//        Call<EditResponse> educationeditCall = apiCall.geteducationEdit(userid,editeducation,authtoken);
//        educationeditCall.enqueue(new Callback<EditResponse>() {
//            @Override
//            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {
//
//                Toast.makeText(EducationEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                Intent newIntent = new Intent(getApplicationContext(), EducationalDetails2.class);
//                startActivity(newIntent);
//
//            }
//
//            @Override
//            public void onFailure(Call<EditResponse> call, Throwable t) {
//                Toast.makeText(EducationEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//            }
//        });
//    }

//    }









