package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.Adddetails.CreateResponse;
import com.example.emea.Response.Adddetails.Data;
import com.example.emea.Response.Adddetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetails extends AppCompatActivity {

    String fathernamestring,fathereducationstring,fatheroccupationstring,fatherincomestring;
    String mothernamestring,mothereducationstring,motheroccupationstring,motherincomestring;
    String guardiannamestring,guardianeducationstring,guardianoccupationstring,guardianincomestring,
    textfoofficailaddress,textmofficaialadress,textgofficialaddres;
//    Data data;
    ImageView prevPage;
    ScrollView scrollView;
    String name, rollNo, yearOfAdmission, admissionNo,
            textschool, textsciencesslcbox, textsocialsslcbox, textsub1box,textcollegename,qualcrse
            ;
    TextView father,mother,guardian,topNav;
    EditText fathernameedittext,fathereducationedittext,fatheroccupationedittext,fatherincomeedittext;
    EditText mothernameedittext,mothereducationedittext,motheroccupationedittext,motherincomeedittext;
    EditText guardiannameedittext,guardianeducationedittext,guardianoccupationedittext,guardianincomeedittext,foofficailaddress,mofficaialadress,gofficialaddress;
    Student user;
    Button save;
    Data details;
    ApiCall apiCall;
    String userid;
    Data apifamilylist;
    String authentoken;
//FamilyDetails familyDetails;
    int status;
Personal personal;
Education education;
Family family;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);
        getSupportActionBar();
//        Personal personal= getIntent().getParcelableExtra("personal");
////        String name=personal.getName();
//        Education education= getIntent().getParcelableExtra("education");
////        String school=education.getSchool(); extraCurricular
        Intent intent = getIntent();
        HashMap<String, Object> personalDetails = (HashMap<String, Object>) intent.getSerializableExtra("personalDetails");
        HashMap<String, Object> educationDetails = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");
//        HashMap<String, Object> extraCurricular = (HashMap<String, Object>) intent.getSerializableExtra("extraCurricular");


//        Toast.makeText(FamilyDetails.this,  getIntent().getSerializableExtra("personalDetails").toString(),Toast.LENGTH_SHORT).show();


        topNav = findViewById(R.id.title_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");


        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });


        father = findViewById(R.id.father);
        fathernameedittext = findViewById(R.id.fname);
        fatheroccupationedittext=findViewById(R.id.foccupation);
        fathereducationedittext = findViewById(R.id.feducation);
        fatherincomeedittext = findViewById(R.id.fincome);
        mother =findViewById(R.id.mother);
        mothernameedittext = findViewById(R.id.mname);
        mothereducationedittext = findViewById(R.id.meducation);
        motheroccupationedittext = findViewById(R.id.moccupation);
        motherincomeedittext = findViewById(R.id.mincome);
        guardian = findViewById(R.id.guardian);
        guardiannameedittext = findViewById(R.id.gname);
        guardianeducationedittext = findViewById(R.id.geducation);
        guardianoccupationedittext = findViewById(R.id.goccupation);
        guardianincomeedittext = findViewById(R.id.gincome);
        foofficailaddress=findViewById(R.id.fofficailaaddress);
        mofficaialadress=findViewById(R.id.mofficailaaddress);
        gofficialaddress=findViewById(R.id.gofficailaaddress);

        save = findViewById(R.id.savefamily);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            fathernamestring = fathernameedittext.getText().toString();
                fathereducationstring = fathereducationedittext.getText().toString();
                fatheroccupationstring = fatheroccupationedittext.getText().toString();
                fatherincomestring = fatherincomeedittext.getText().toString();
//
//
                mothernamestring = mothernameedittext.getText().toString();
                mothereducationstring = mothereducationedittext.getText().toString();
                motheroccupationstring = motheroccupationedittext.getText().toString();
                motherincomestring = motherincomeedittext.getText().toString();
//
//
                guardiannamestring = guardiannameedittext.getText().toString();
                guardianeducationstring = guardianeducationedittext.getText().toString();
                guardianoccupationstring = guardianoccupationedittext.getText().toString();
                guardianincomestring = guardianincomeedittext.getText().toString();

                textfoofficailaddress=foofficailaddress.getText().toString();
                textmofficaialadress=mofficaialadress.getText().toString();

                textgofficialaddres=gofficialaddress.getText().toString();


//                Family family= new Family(fathernamestring,mothernamestring,guardiannamestring);

//                ArrayList<HashMap<String, String>> family = new ArrayList<HashMap<String, String>>();
//                HashMap<String, String> father = new HashMap<String, String>();
//                father.put("name", fathernamestring);
//                family.add(father);
//
//                HashMap<String, String> mother = new HashMap<String, String>();
//                mother.put("name", mothernamestring);
//                family.add(mother);
//
//                HashMap<String, String> gardian = new HashMap<String, String>();
//                gardian.put("name", guardiannamestring);
//                family.add(gardian);


//            HashMap<String, String> family = new HashMap<>();
//        family.put("father_name", fathernamestring);
//        family.put("mother_name", mothernamestring);
//        family.put("guardian_name", guardiannamestring);
                HashMap<String, Object> familyDetails = new HashMap<>();
                HashMap<String, Object> father = new HashMap<>();
                father.put("name", fathernamestring);
                father.put("educationQualification", fathereducationstring);
                father.put("annualIncome", fatherincomestring);

                father.put("occupation", fatheroccupationstring);
                father.put("officialAddress", textfoofficailaddress);



//        family.add(father);
                familyDetails.put("father",father);

                HashMap<String, Object> mother = new HashMap<>();
                mother.put("name", mothernamestring);
                mother.put("educationQualification", mothereducationstring);
                mother.put("annualIncome", motherincomestring);

                mother.put("occupation", motheroccupationstring);
                mother.put("officialAddress", textmofficaialadress);
                familyDetails.put("mother",mother);

//        family.add(mother);

                HashMap<String, Object> gardian = new HashMap<>();
                gardian.put("name", guardiannamestring);
                gardian.put("educationQualification", guardianeducationstring);
                gardian.put("annualIncome", guardianincomestring);

                gardian.put("occupation", guardianoccupationstring);
                gardian.put("officialAddress", textgofficialaddres);
                familyDetails.put("gardian",gardian);


                apiCall = ApiClient.getRetrofit().create(ApiCall.class);


//                getFamilyList(name, rollNo, yearOfAdmission, admissionNo,
//                        textschool, textsciencesslcbox, textsocialsslcbox, textsub1box,textcollegename,qualcrse,
//                        fathernamestring, mothernamestring, guardiannamestring);

                getFamilyList(personalDetails,educationDetails,familyDetails);





//                Intent newIntent = new Intent(EducationalDetails.this, FamilyDetails.class);
//                newIntent.putExtra("personal",personal);
//                newIntent.putExtra("education", education);
//                startActivity(newIntent);
            }
        });
    }

    private void getFamilyList(HashMap<String, Object> personalDetails, HashMap<String, Object> educationDetails, HashMap<String, Object> familyDetails) {



//    private void getFamilyList(String name, String rollNo, String yearOfAdmission, String admissionNo, String textschool, String textsciencesslcbox, String textsocialsslcbox, String textsub1box,
//                               String textcollegename,String qualcrse,String fathernamestring, String mothernamestring, String guardiannamestring) {
//

    //    public void getFamilyList( String fathernamestring, String fathereducationstring, String fatheroccupationstring,
//                               String fatherincomestring, String mothernamestring, String mothereducationstring,
//                               String motheroccupationstring, String motherincomestring,String guardiannamestring,
//                               String guardianeducationstring, String guardianoccupationstring, String guardianincomestring) {


//        HashMap<String, String> params = new HashMap<>();
//        params.put("father_name", this.fathernamestring);
//        params.put("edu_qualification_father", this.fathereducationstring);
//        params.put("occupation_father", this.fatheroccupationstring);
//        params.put("annual_income_father", this.fatherincomestring);
//        params.put("mother_name", this.mothernamestring);
//        params.put("edu_qualification_mother", this.mothereducationstring);
//        params.put("occupation_mother", this.motheroccupationstring);
//        params.put("annual_income_mother", this.motherincomestring);
//        params.put("guardian_name", this.guardiannamestring);
//        params.put("edu_qualification_guardian", this.guardianeducationstring);
//        params.put("occupation_guardian", this.guardianoccupationstring);
//        params.put("annual_income_guardian", this.guardianincomestring);
//        ;
//
//        HashMap<String, String> father = new HashMap<>();
//        father.put("name",fathernamestring);
//        father.put("educationQualification",fathereducationstring);
//        father.put("annualIncome",fatherincomestring);
//        father.put("occupation",fatheroccupationstring);
////        father.put("officialAddress",)
//
//        HashMap<String, String> mother = new HashMap<>();
//        mother.put("name",mothernamestring);
//        mother.put("educationQualification",mothereducationstring);
//        mother.put("annualIncome",motherincomestring);
//        mother.put("occupation",motheroccupationstring);
//
//        HashMap<String, String> guardian = new HashMap<>();
//        guardian.put("name",guardiannamestring);
//        guardian.put("educationQualification",guardianeducationstring);
//        guardian.put("annualIncome",guardianincomestring);
//        guardian.put("occupation",guardianoccupationstring);

//        HashMap<String, Object> family = new HashMap<>();
//        family.put("father",father);
//        family.put("mother",mother);
//        family.put("gardian",guardian);

//            HashMap<String, String> personal = new HashMap<>();
//            personal.put("name",name);
//            personal.put("roll_no",rollNo);
//            personal.put("yearOfJoin",yearOfAdmission);
//            personal.put("admissionNO",admissionNo);
//
//            HashMap<String, String> education = new HashMap<>();
//            education.put("high_school", textschool);
//            education.put("high_school_science", textsciencesslcbox);
//            education.put("high_school_socialscience", textsocialsslcbox);
//            education.put("higher_secondary_mark1", textsub1box);
//        education.put("college_name", textcollegename);
//            education.put("other_qualification_course_name", qualcrse);
//
//            HashMap<String, String> family = new HashMap<>();
//        family.put("father_name", fathernamestring);
//        family.put("mother_name", mothernamestring);
//        family.put("guardian_name", guardiannamestring);


//        HashMap<String, Object> data = new HashMap<>();
//        HashMap<String, Object> personalDetails = new HashMap<>();
//        personalDetails.put("name",name);
////                personal.put("roll_no",rollNo);
//        personalDetails.put("yearOfJoin",yearOfAdmission);
//        personalDetails.put("admissionNO",admissionNo);
//        HashMap<String, Object> educationDetails = new HashMap<>();
//        HashMap<String, Object> tenthStd = new HashMap<>();
//        tenthStd.put("schoolName", textschool);
//        tenthStd.put("science", textsciencesslcbox);
//        tenthStd.put("socialScience", textsocialsslcbox);
//
//        HashMap<String, Object> familyDetails = new HashMap<>();
//        HashMap<String, Object> father = new HashMap<>();
//        father.put("name", fathernamestring);
////        family.add(father);
//
//        HashMap<String, Object> mother = new HashMap<>();
//        mother.put("name", mothernamestring);
////        family.add(mother);
//
//        HashMap<String, Object> gardian = new HashMap<>();
//        gardian.put("name", guardiannamestring);
//        family.add(gardian);




            HashMap<String, Object> data = new HashMap<>();


        data.put("personalDetails",personalDetails);
        data.put("educationDetails",educationDetails);
//        data.put("extraCurricular",extraCurricular);

        data.put("familyDetails",familyDetails);





        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authentoken = (shared.getString("token", ""));

        Call<CreateResponse> familyCall = apiCall.getFamily(data, authentoken);

        familyCall.enqueue(new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
//                status = response.code();

//                if (status != 400) {
                if (response.body() != null) {
//                    data = response.body().getData();
//                    apifamilylist = response.body().getData();
                     details = response.body().getData();
                    user=details.getStudent();
                     userid = user.getId();
                    Toast.makeText(FamilyDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();

//                    Log.e("_id", userid);
//
//                    SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
//                    SharedPreferences.Editor editor = pref.edit();
//
//                    editor.putString("_id", userid);
//                    editor.commit();


//                    Toast.makeText(FamilyDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                    Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(perIntent);
                    finish();
                } else {
                    Toast.makeText(FamilyDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CreateResponse> call, Throwable t) {

                Toast.makeText(FamilyDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }




    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}