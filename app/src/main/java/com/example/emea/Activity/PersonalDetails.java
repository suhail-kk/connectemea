package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.PersonalResponse;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDetails extends AppCompatActivity {

    private static final String TAG = "Personal Details";
    String dob,nmid,dptname,admsnno,rllnoid,yrfadm,idmrk1,idmrk2;

    EditText DisplayDate,nameid,coursename,admissionno,rollnoid,yrofadmission,idmark1,idmark2;
    TextView department;
    ImageButton birth;
    Button button1;

    ApiCall apiCall;
    String apiPersonalList;
    String authentoken;

    int status;

    DatePickerDialog.OnDateSetListener DateSetListener;


    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        DisplayDate = (EditText) findViewById(R.id.Birth);
       // name=findViewById(R.id.nametv);
        nameid=findViewById(R.id.name);
        department=findViewById(R.id.departmenttv);
        admissionno=findViewById(R.id.admissionno);
        rollnoid=findViewById(R.id.rollnumber);
        yrofadmission=findViewById(R.id.yearofadmission);
        idmark1=findViewById(R.id.identificationmark1);
        idmark2=findViewById(R.id.identificationmark2);
    //    button1=findViewById(R.id.Savepersonal);

button1=findViewById(R.id.uploadPersnnlDetls);

//drpodown
        final AutoCompleteTextView Gender = (AutoCompleteTextView) findViewById(R.id.gender);
        final AutoCompleteTextView BloodGroup = (AutoCompleteTextView) findViewById(R.id.bloodGroup);
        final AutoCompleteTextView MaritalStatus = (AutoCompleteTextView) findViewById(R.id.maritalStatus);
        final AutoCompleteTextView Religion = (AutoCompleteTextView) findViewById(R.id.religion);
        final AutoCompleteTextView Caste = (AutoCompleteTextView) findViewById(R.id.caste);

        //calendar

//        birth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog  dialog = new DatePickerDialog(
//                        PersonalDetails.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        DateSetListener,
//                        year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dob=DisplayDate.getText ().toString ();
                nmid=nameid.getText ().toString ();
//                dptname=coursename.getText ().toString ();
                admsnno=admissionno.getText ().toString ();
                rllnoid=rollnoid.getText ().toString ();
                yrfadm=yrofadmission.getText ().toString ();
                idmrk1=idmark1.getText ().toString ();
                idmrk2=idmark2.getText ().toString ();

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
                getPersonalList( dob,nmid,dptname,admsnno,rllnoid,yrfadm,idmrk1,idmrk2);



            }
        });
        DateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                DisplayDate.setText(date);
            }
        };


//dropdown

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (List<String>) Gender);
//        Gender.setAdapter(adapter);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (List<String>) BloodGroup);
//        BloodGroup.setAdapter(adapter1);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (List<String>) MaritalStatus);
//        MaritalStatus.setAdapter(adapter2);
//        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (List<String>) Caste);
//        Caste.setAdapter(adapter3);
//        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, (List<String>) Religion);
//        Religion.setAdapter(adapter4);
        Gender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gender.showDropDown();
            }
        });

        BloodGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BloodGroup.showDropDown();
            }
        });

        MaritalStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaritalStatus.showDropDown();
            }
        });

        Religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Religion.showDropDown();
            }
        });

        Caste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Caste.showDropDown();
            }
        });


    }

    private static final String[] Gender = new String[]{"Male", "Female"};
    private static final String[] BloodGroup = new String[]{"A+", "B+","o+","AB+", "A-","B-", "o-","AB-"};
    private static final String[] Marriage = new String[]{"single", "married"};
    private static final String[] Caste = new String[]{"OBC", "SC","ST"};
    private static final String[] Religion = new String[]{"Islam", "Hindu","Christian","Nil"};

    public void getPersonalList( String dob, String nmid, String dptname, String admsnno, String rllnoid, String yrfadm,String idmrk1,String idmrk2) {


        HashMap<String, String> params = new HashMap<>();
        params.put("name", this.nmid);
//        params.put("mobile", textmedium);
//        params.put("gender", this.);
        params.put("admission_no", this.admsnno);
        params.put("roll_no", this.rllnoid);
        params.put("date_of_birth", this.dob);
//        params.put("blood_group",this.)
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


        Call<PersonalResponse> PersonalCall = apiCall.getPersonal(params, authentoken);

        PersonalCall.enqueue(new Callback<PersonalResponse>() {
            @Override
            public void onResponse(Call<PersonalResponse> call, Response<PersonalResponse> response) {

                status = response.code();
                if (status != 400) {
                    apiPersonalList = response.body().getStatus();

                    Toast.makeText(PersonalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PersonalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PersonalResponse> call, Throwable t) {
                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}

