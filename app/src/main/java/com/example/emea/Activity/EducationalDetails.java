package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Response.EducationResponse;
import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationalDetails extends AppCompatActivity {

    //

    TextView sslc, medium, markssslc, englishsslc, mathssslc, sciencesslc, socialsciencesslc,
            plustwo, englishplustwo, marksplustwo,
            ugc, marksugc, coremain, coresub, commonenglish, commonlang, opencourse,
            otherqual;
    String textsslc, textschool, textmedium, textmarkssslc, textenglishsslc, textenglishsslcbox,
            textmathssslc, textmathssslcbox, textsciencesslc, textsciencesslcbox, textsocialsslc, textsocialsslcbox,
            textplustwo, textschoolplustwo, textmarkplustwo, textenglishplustwo, textenglishplustwobox, textsub1box, textsub2box,
            textsub3box, textsub4box,
            textallsyllabus, textsub1, textsub2, textsub3, textsub4,
            textugc, textcollegename, textuniversity, textugccourse, textmarksugc, textcoremain, textugcmainbox, textcoresub, textsubbox, textcommonenglish, textugcenglishbox,
            textcommonlang, textugclangbox, textopencourse, textopencoursebox, textotherqual, textcoursename, textcoursetype, textinstitution, textuniversity2;
    EditText school, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, englishplustwobox, sub1box, sub2box, sub3box, sub4box,
            collegename, university, ugccourse, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox,
            coursename, coursetype, institution, university2;

    Button qualification1, qualification2, saveinfo;

    RadioButton radioeng;
    RadioButton radiomal;

    ApiCall apiCall;
    String apieducationlist;
    String authentoken;

    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);

        //
        //buttons
        qualification1 = findViewById(R.id.addqualification);
        qualification2 = findViewById(R.id.addqualification2);
        saveinfo = findViewById(R.id.saveinfo);
        radioeng = findViewById(R.id.radioeng);
        radiomal = findViewById(R.id.radiomal);


        sslc = findViewById(R.id.sslc);
        textsslc = sslc.getText().toString();
        school = findViewById(R.id.schoolname);
        //  textschool = school.getText().toString();
        medium = findViewById(R.id.medium);
        //   textmedium = medium.getText().toString();
        //  englishmedium = findViewById(R.id.english);
        //    textenglishmedium = englishmedium.getText().toString();
        //    checkBoxeng = findViewById(R.id.engcheck);
        //   malayalammedium = findViewById(R.id.malayalam);
        //    textmalayalammedium = malayalammedium.getText().toString();
        //    checkBoxmal = (CheckBox) findViewById(R.id.mlcheck);

        markssslc = findViewById(R.id.marks);
        textmarkssslc = markssslc.getText().toString();

        englishsslc = findViewById(R.id.englishmark);
        textenglishsslc = englishsslc.getText().toString();
        englishsslcbox = findViewById(R.id.englishmarkb2);
        //  textenglishsslcbox = englishsslcbox.getText().toString();

        mathssslc = findViewById(R.id.mathsmark);
        textmathssslc = mathssslc.getText().toString();
        mathssslcbox = findViewById(R.id.mathsmarkb2);
        //  textmathssslcbox = mathssslcbox.getText().toString();

        sciencesslc = findViewById(R.id.sciencemark);
        textsciencesslc = sciencesslc.getText().toString();
        sciencesslcbox = findViewById(R.id.sciencemarkb2);
        //    textsciencesslcbox = sciencesslcbox.getText().toString();

        socialsciencesslc = findViewById(R.id.ssmark);
        textsocialsslc = socialsciencesslc.getText().toString();
        socialsciencesslcbox = findViewById(R.id.ssmarkb2);
        //   textsocialsslcbox = socialsciencesslcbox.getText().toString();


        plustwo = findViewById(R.id.plus2);
        textplustwo = plustwo.getText().toString();
        schoolplustwo = findViewById(R.id.schoolname2);
        //  textschoolplustwo = schoolplustwo.getText().toString();
        marksplustwo = findViewById(R.id.marks2);
        textmarkplustwo = marksplustwo.getText().toString();
        englishplustwo = findViewById(R.id.english2);
        textenglishplustwo = englishplustwo.getText().toString();
        englishplustwobox = findViewById(R.id.english2b2);
        //   textenglishplustwobox = englishplustwobox.getText().toString();
        sub1box = findViewById(R.id.sub1b2);
        //    textsub1box = sub1box.getText().toString();
        sub2box = findViewById(R.id.sub2b2);
        //   textsub2box = sub2box.getText().toString();
        sub3box = findViewById(R.id.sub3b2);
        //     textsub3box = sub3box.getText().toString();
        sub4box = findViewById(R.id.sub4b2);
        //     textsub4box = sub4box.getText().toString();


        final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.allsyllabus);
        ImageView image = (ImageView) findViewById(R.id.allsyllabusimage);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView) findViewById(R.id.sub1);
        ImageView image1 = (ImageView) findViewById(R.id.sub1image);
        final AutoCompleteTextView actv3 = (AutoCompleteTextView) findViewById(R.id.sub2);
        ImageView image2 = (ImageView) findViewById(R.id.sub2image);
        final AutoCompleteTextView actv4 = (AutoCompleteTextView) findViewById(R.id.sub3);
        ImageView image3 = (ImageView) findViewById(R.id.sub3image);
        final AutoCompleteTextView actv5 = (AutoCompleteTextView) findViewById(R.id.sub4);
        ImageView image4 = (ImageView) findViewById(R.id.sub4image);


//checkbox
//        checkBoxeng = findViewById(R.id.engcheck);

//        checkBoxmal = (CheckBox) findViewById(R.id.mlcheck);

//RadioButton

        radioeng = findViewById(R.id.radioeng);
        radiomal = findViewById(R.id.radiomal);

        ugc = findViewById(R.id.ugc);
        textugc = ugc.getText().toString();
        collegename = findViewById(R.id.collegename);
        //  textcollegename = collegename.getText().toString();
        university = findViewById(R.id.university);
        //  textuniversity = university.getText().toString();
        ugccourse = findViewById(R.id.course);
        //  textugccourse = ugccourse.getText().toString();
        marksugc = findViewById(R.id.marks3);
        textmarksugc = marksugc.getText().toString();
        coremain = findViewById(R.id.coremainmark);
        textcoremain = coremain.getText().toString();
        ugcmainbox = findViewById(R.id.coremainmarkb2);
        //  textugcmainbox = ugcmainbox.getText().toString();
        coresub = findViewById(R.id.compsubmark);
        textcoresub = coresub.getText().toString();
        ugcsubbox = findViewById(R.id.compsubmarkb2);
        //    textsubbox = ugcsubbox.getText().toString();

        commonenglish = findViewById(R.id.commonengmark);
        textcommonenglish = commonenglish.getText().toString();

        ugcenglishbox = findViewById(R.id.commonengmarkb2);
        //  textugcenglishbox = ugcenglishbox.getText().toString();

        commonlang = findViewById(R.id.commonlangmark);
        textcommonlang = commonlang.getText().toString();
        ugclangbox = findViewById(R.id.commonlangmarkb2);
        //  textugclangbox = ugclangbox.getText().toString();
        opencourse = findViewById(R.id.openmark);
        textopencourse = opencourse.getText().toString();
        opencoursebox = findViewById(R.id.openmarkb2);
        //    textopencoursebox = opencoursebox.getText().toString();

        otherqual = findViewById(R.id.otherqual);
        textotherqual = otherqual.getText().toString();
        coursename = findViewById(R.id.coursename);
        //    textcoursename = coursename.getText().toString();
        coursetype = findViewById(R.id.coursetype);
        //    textcoursetype = coursetype.getText().toString();
        institution = findViewById(R.id.institutionname);
        //     textinstitution= institution.getText().toString();
        university2 = findViewById(R.id.universityname);
        //   textuniversity2 = university2.getText().toString();


//Dropdown

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus);
        actv1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus1);
        actv2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus2);
        actv3.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus3);
        actv4.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus4);
        actv5.setAdapter(adapter4);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv1.showDropDown();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv2.showDropDown();
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv3.showDropDown();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv4.showDropDown();
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv5.showDropDown();
            }
        });


        qualification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        qualification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                textallsyllabus = actv1.getText().toString();
                textenglishplustwobox = englishplustwobox.getText().toString();
                textsub1box = sub1box.getText().toString();
                textsub2box = sub2box.getText().toString();
                textsub3box = sub3box.getText().toString();
                textsub4box = sub4box.getText().toString();
                textsub1 = actv2.getText().toString();
                textsub2 = actv3.getText().toString();
                textsub3 = actv4.getText().toString();
                textsub4 = actv5.getText().toString();

                textcollegename = collegename.getText().toString();
                textuniversity = university.getText().toString();
                textugccourse = ugccourse.getText().toString();
                textugcmainbox = ugcmainbox.getText().toString();
                textsubbox = ugcsubbox.getText().toString();
                textugcenglishbox = ugcenglishbox.getText().toString();
                textugclangbox = ugclangbox.getText().toString();
                textopencoursebox = opencoursebox.getText().toString();
                textcoursename = coursename.getText().toString();
                textcoursetype = coursetype.getText().toString();
                textinstitution = institution.getText().toString();
                textuniversity2 = university2.getText().toString();

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getEducationList(textschool, textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox);


            }
        });
    }


    private static final String[] syllabus = new String[]{"science", "commerce"};
    private static final String[] syllabus1 = new String[]{"hin", "mal"};
    private static final String[] syllabus2 = new String[]{"chem", "geo"};
    private static final String[] syllabus3 = new String[]{"phy", "bio"};
    private static final String[] syllabus4 = new String[]{"maths", "stati"};


//    public void onCheckboxClicked(View view) {

//        switch(view.getId()) {

//            case R.id.engcheck:

//                checkBoxmal.setChecked(false);


//                break;

//            case R.id.mlcheck:

//                checkBoxeng.setChecked(false);


//                break;

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioeng:
                if (checked)
                    break;
            case R.id.radiomal:
                if (checked)
                    break;
        }
    }


    public void getEducationList(String textschool, String textenglishsslcbox, String textmathssslcbox, String textsciencesslcbox, String textsocialsslcbox) {


        HashMap<String, String> params = new HashMap<>();
        params.put("10th_school_name", this.textschool);
        params.put("10th_medium", textmedium);
        params.put("english", this.textenglishsslcbox);
        params.put("maths", this.textmathssslcbox);
        params.put("science", this.textsciencesslcbox);
        params.put("social_studies", this.textsocialsslcbox);
//        params.put("syllabus", textallsyllabus);
//        params.put("12th_school_name", textschoolplustwo);
//        //  params.put("course_id", 1);
//        params.put("subject_id1", textenglishplustwobox);
//        params.put("subject_id2", textsub1box);
//        params.put("subject_id3", textsub2box);
//        params.put("subject_id4", textsub3box);
//        params.put("subject_id5", textsub4box);
//        params.put("subject_1_mark", textenglishplustwobox);
//        params.put("subject_2_mark", textsub1box);
//        params.put("subject_3_mark", textsub2box);
//        params.put("subject_4_mark", textsub3box);
//        params.put("subject_5_mark", textsub4box);
//        params.put("course_name", textugccourse);
//        params.put("college_name", textcollegename);
//        params.put("university", textuniversity);
//        params.put("core_mark", textugcmainbox);
//        params.put("sub_mark", textcoresub);
//        params.put("english_mark", textugcenglishbox);
//        params.put("language_mark", textugclangbox);
//        params.put("open_mark", textopencoursebox);
//        //params.put("additional_courses_grade", textcoursename);
//        params.put("additional_courses_instiution", textinstitution);
//        params.put("additional_courses_recongnisation", textuniversity2);
//        params.put("additional_courses_course_type", textcoursetype);
//        params.put("other_qualification_course_name", textcoursename);
//        params.put("other_qualification_grade", textcoursename);
//        params.put(" other_qualification_instiution", textcoursename);
//        params.put("other_qualification_recongnisation", textcoursename);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authentoken = (shared.getString("token", ""));


        Call<EducationResponse> educationCall = apiCall.getEducation(params, authentoken);

        educationCall.enqueue(new Callback<EducationResponse>() {
            @Override
            public void onResponse(Call<EducationResponse> call, Response<EducationResponse> response) {

                status = response.code();
                if (status != 400) {
                    apieducationlist = response.body().getStatus();

                    Toast.makeText(EducationalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EducationalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<EducationResponse> call, Throwable t) {
                Toast.makeText(EducationalDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
//      educationCall.enqueue(new Callback<EducationResponse>() {
//            @Override
//            public void onResponse(Call<EducationResponse> call, Response<EducationResponse> response) {
//                status = response.code();
//                if (status != 400) {
//                    apieducationlist = response.body().getStatus();
//
//                    Toast.makeText(EducationalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(EducationalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<EducationResponse> call, Throwable t) {
//                Toast.makeText(EducationalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
    }
}













