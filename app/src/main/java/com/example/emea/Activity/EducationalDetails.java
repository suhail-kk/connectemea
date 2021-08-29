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
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationalDetails extends AppCompatActivity {

    //

    TextView sslc, medium, markssslc,
            plustwo, englishplustwo, marksplustwo;

    String textsslc, textschool, textmedium, textenglishsslcbox,
            textmathssslcbox, textsciencesslcbox, textsocialsslcbox,
            textschoolplustwo, textenglishplustwobox, textsub1box, textsub2box,
            textsub3box, textsub4box,
            textallsyllabus,
            textcollegename, textuniversity, textugccourse, textugcmainbox, textcoresub, textugcenglishbox,

    textugclangbox, textopencoursebox;
    TextInputEditText school, englishsslcbox, mathssslcbox, sciencesslcbox, socialsciencesslcbox,
            schoolplustwo, englishplustwobox, sub1box, sub2box, sub3box, sub4box, sub5box,
            collegename, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox,
            coursename, coursetype, institution, university2;
    AutoCompleteTextView sub1, sub2, sub3, sub4, sub5;

    Button qualification1, qualification2, saveinfo;

    RadioButton radioeng;
    RadioButton radiomal;

    ApiCall apiCall;
    String apieducationlist;
    String authentoken;

    int status;
    ArrayList<String> arrayList_list;
    ArrayAdapter<String> arrayAdapter_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details);


        //buttons
//        qualification1 = findViewById(R.id.addDegree);
//        qualification2 = findViewById(R.id.addQualification);
      //  saveinfo = findViewById(R.id.saveEduDetail);
        radioeng = findViewById(R.id.radioeng);
        radiomal = findViewById(R.id.radiomal);


        sslc = findViewById(R.id.sslc);
        textsslc = sslc.getText().toString();
        school = findViewById(R.id.schoolname);

        medium = findViewById(R.id.medium);

        markssslc = findViewById(R.id.marks);

        englishsslcbox = findViewById(R.id.englishsslc);

        mathssslcbox = findViewById(R.id.mathssslc);

        sciencesslcbox = findViewById(R.id.sciencesslc);

        socialsciencesslcbox = findViewById(R.id.socialsslc);


        plustwo = findViewById(R.id.hse);

        schoolplustwo = findViewById(R.id.hseschoolName);

        marksplustwo = findViewById(R.id.markshse);

        englishplustwo = findViewById(R.id.hsesubName1);

        englishplustwobox = findViewById(R.id.hsesubMark1);

        sub1 = findViewById(R.id.hsesubName2);
        sub1box = findViewById(R.id.hsesubMark2);

        sub2 = findViewById(R.id.hsesubName3);
        sub2box = findViewById(R.id.hsesubMark3);

        sub3 = findViewById(R.id.hsesubName4);
        sub3box = findViewById(R.id.hsesubMark4);
        sub4 = findViewById(R.id.hsesubName5);
        sub4box = findViewById(R.id.hsesubMark5);
        sub5 = findViewById(R.id.hsesubName6);
        sub5box = findViewById(R.id.hsesubMark6);

        arrayList_list = new ArrayList<>();
        arrayList_list.add("english");
        arrayList_list.add("hindi");
        arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayList_list);
        sub1.setAdapter(arrayAdapter_list);
        sub1.setThreshold(1);
//     final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.allsyllabus);
//        ImageView image = (ImageView) findViewById(R.id.allsyllabusimage);
        //      final AutoCompleteTextView actv2 = (AutoCompleteTextView) findViewById(R.id.hseSubName1);
//        ImageView image1 = (ImageView) findViewById(R.id.sub1image);
//        final AutoCompleteTextView actv3 = (AutoCompleteTextView) findViewById(R.id.sub2);
//        ImageView image2 = (ImageView) findViewById(R.id.sub2image);
//        final AutoCompleteTextView actv4 = (AutoCompleteTextView) findViewById(R.id.sub3);
//        ImageView image3 = (ImageView) findViewById(R.id.sub3image);
//        final AutoCompleteTextView actv5 = (AutoCompleteTextView) findViewById(R.id.sub4);
//        ImageView image4 = (ImageView) findViewById(R.id.sub4image);


//        collegename = findViewById(R.id.ugcollegeName);
//
//        ugcmainbox = findViewById(R.id.dgrsubCore);
//
//        ugcsubbox = findViewById(R.id.dgrsubComp);
//
//        ugcenglishbox = findViewById(R.id.dgrsubEng);
//
//        ugclangbox = findViewById(R.id.dgrsubLang);
//
//        opencoursebox = findViewById(R.id.dgrsubOpen);
//
//        coursename = findViewById(R.id.qualicrsName);
//
//        coursetype = findViewById(R.id.qualicrstype);
//
//        institution = findViewById(R.id.qualiIstnname);
//        university2 = findViewById(R.id.qualiuniversity);
    }
}



//Dropdown
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus);
//        actv1.setAdapter(adapter);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus1);
//        actv2.setAdapter(adapter1);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus2);
//        actv3.setAdapter(adapter2);
//        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus3);
//        actv4.setAdapter(adapter3);
//        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, syllabus4);
//        actv5.setAdapter(adapter4);
//        image.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actv1.showDropDown();
//            }
//        });
//
//        image1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actv2.showDropDown();
//            }
//        });
//
//        image2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actv3.showDropDown();
//            }
//        });
//
//        image3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actv4.showDropDown();
//            }
//        });
//
//        image4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                actv5.showDropDown();
//            }
//        });


//        qualification1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//
//        qualification2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        saveinfo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                textschool = school.getText().toString();
//                textenglishsslcbox = englishsslcbox.getText().toString();
//                textmathssslcbox = mathssslcbox.getText().toString();
//                textsciencesslcbox = sciencesslcbox.getText().toString();
//                textsocialsslcbox = socialsciencesslcbox.getText().toString();
//                textschoolplustwo = schoolplustwo.getText().toString();
////                textallsyllabus = actv1.getText().toString();
//                textenglishplustwobox = englishplustwobox.getText().toString();
//                textsub1box = sub1box.getText().toString();
//                textsub2box = sub2box.getText().toString();
//                textsub3box = sub3box.getText().toString();
////                textsub4box = sub4box.getText().toString();
////                textsub1 = actv2.getText().toString();
////                textsub2 = actv3.getText().toString();
////                textsub3 = actv4.getText().toString();
////                textsub4 = actv5.getText().toString();
//
//                textcollegename = collegename.getText().toString();
//                textuniversity = university.getText().toString();
//                textugccourse = ugccourse.getText().toString();
//                textugcmainbox = ugcmainbox.getText().toString();
//                textsubbox = ugcsubbox.getText().toString();
//                textugcenglishbox = ugcenglishbox.getText().toString();
//                textugclangbox = ugclangbox.getText().toString();
//                textopencoursebox = opencoursebox.getText().toString();
//                textcoursename = coursename.getText().toString();
//                textcoursetype = coursetype.getText().toString();
//                textinstitution = institution.getText().toString();
//                textuniversity2 = university2.getText().toString();
//
//
//                if (radioeng.isChecked()) {
//                     textmedium= radioeng.getText().toString() ;
//                }
//                else{
//                    textmedium= radiomal.getText().toString() ;
//                }
//
//                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//                getEducationList(textschool,textmedium, textenglishsslcbox, textmathssslcbox, textsciencesslcbox, textsocialsslcbox,textschoolplustwo,textallsyllabus,
//                        textenglishplustwobox,textsub1box,textsub2box,textsub3box,textsub4box,
//                        textugccourse,textcollegename,textuniversity,textugcmainbox,textcoresub,textugcenglishbox,textugclangbox,textopencoursebox);
//
//
//            }
//        });
//    }
//
//
////    private static final String[] syllabus = new String[]{"science", "commerce"};
////    private static final String[] syllabus1 = new String[]{"hin", "mal"};
////    private static final String[] syllabus2 = new String[]{"chem", "geo"};
////    private static final String[] syllabus3 = new String[]{"phy", "bio"};
////    private static final String[] syllabus4 = new String[]{"maths", "stati"};
//
//
//
//    public void onRadioButtonClicked(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.radioeng:
//               radiomal.setChecked(false);
//
//                    break;
//            case R.id.radiomal:
//                radioeng.setChecked(false);
//
//                    break;
//        }
//    }
//
//
//    public void getEducationList(String textschool, String textmedium, String textenglishsslcbox, String textmathssslcbox, String textsciencesslcbox, String textsocialsslcbox, String textschoolplustwo, String textallsyllabus,
//                                 String textenglishplustwobox, String textsub1box,String textsub2box,String textsub3box,String textsub4box,
//                                 String  textugccourse,String textcollegename,String textuniversity,String textugcmainbox,String textcoresub,
//                                String textugcenglishbox,String textugclangbox,String textopencoursebox ) {
//
//
//        HashMap<String, String> params = new HashMap<>();
//        params.put("high_school", textschool);
//        params.put("high_school_medium", textmedium);
//        params.put("high_school_english", textenglishsslcbox);
//        params.put("high_school_maths", textmathssslcbox);
//        params.put("high_school_science",textsciencesslcbox);
//        params.put("high_school_socialscience",textsocialsslcbox);
//       params.put("plus_two_syllabus", textallsyllabus);
//        params.put("higher_secondary_school", textschoolplustwo);
////        //  params.put("course_id", 1);
////        params.put("subject_id1", textenglishplustwobox);
////        params.put("subject_id2", textsub1box);
////        params.put("subject_id3", textsub2box);
////        params.put("subject_id4", textsub3box);
////        params.put("subject_id5", textsub4box);
//        params.put("higher_secondary_mark1", textenglishplustwobox);
//        params.put("higher_secondary_mark2", textsub1box);
//        params.put("higher_secondary_mark3", textsub2box);
//        params.put("higher_secondary_mark4", textsub3box);
//        params.put("higher_secondary_mark5", textsub4box);
//        params.put("course_name", textugccourse);
//        params.put("college_name", textcollegename);
//        params.put("university", textuniversity);
//        params.put("core_mark", textugcmainbox);
//        params.put("complementary", textcoresub);
//        params.put("common_english", textugcenglishbox);
//        params.put("common_language", textugclangbox);
//        params.put("open_mark", textopencoursebox);
////        //params.put("additional_courses_grade", textcoursename);
////        params.put("additional_courses_instiution", textinstitution);
////        params.put("additional_courses_recongnisation", textuniversity2);
////        params.put("additional_courses_course_type", textcoursetype);
////        params.put("other_qualification_course_name", textcoursename);
////        params.put("other_qualification_grade", textcoursename);
////        params.put(" other_qualification_instiution", textcoursename);
////        params.put("other_qualification_recongnisation", textcoursename);
//
//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authentoken = (shared.getString("token", ""));
//
//
//        Call<EducationResponse> educationCall = apiCall.getEducation(params, authentoken);
//
//        educationCall.enqueue(new Callback<EducationResponse>() {
//            @Override
//            public void onResponse(Call<EducationResponse> call, Response<EducationResponse> response) {
//
//                status = response.code();
//                if (status != 400) {
//                    apieducationlist = response.body().getStatus();
//
//                    Toast.makeText(EducationalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(EducationalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<EducationResponse> call, Throwable t) {
//                Toast.makeText(EducationalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//    }
//}
//












