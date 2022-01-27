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
//import com.example.emea.Response.Adddetails.Data;
//import com.example.emea.Response.Adddetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetails extends AppCompatActivity {

    String fathernamestring,fathereducationstring,fatheroccupationstring,fatherincomestring,fatherphonenumberstring
    , mothernamestring,mothereducationstring,motheroccupationstring,motherincomestring,motherphonenumberstring
    , guardiannamestring,guardianeducationstring,guardianoccupationstring,guardianincomestring,guardianphonenumberstring,
    textfoofficailaddress,textmofficaialadress,textgofficialaddres;
    ImageView prevPage;
    TextView father,mother,guardian,topNav;
    EditText fathernameedittext,fathereducationedittext,fatheroccupationedittext,fatherincomeedittext,fatherphonenumber
    , mothernameedittext,mothereducationedittext,motheroccupationedittext,motherincomeedittext,motherphonenumber
    , guardiannameedittext,guardianeducationedittext,guardianoccupationedittext,guardianincomeedittext,foofficailaddress,mofficaialadress,gofficialaddress,guardianphonenumber;
    Button save;
    ApiCall apiCall;
    String authentoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);
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
        HashMap<String, Object> educationDetails = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");

        topNav = findViewById(R.id.title_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");




        father = findViewById(R.id.father);
        fathernameedittext = findViewById(R.id.fname);
        fatheroccupationedittext=findViewById(R.id.foccupation);
        fathereducationedittext = findViewById(R.id.feducation);
        fatherincomeedittext = findViewById(R.id.fincome);
        fatherphonenumber=findViewById(R.id.fphone_number);
        mother =findViewById(R.id.mother);
        mothernameedittext = findViewById(R.id.mname);
        mothereducationedittext = findViewById(R.id.meducation);
        motheroccupationedittext = findViewById(R.id.moccupation);
        motherincomeedittext = findViewById(R.id.moincome);
        motherphonenumber=findViewById(R.id.mphone_number);
        guardian = findViewById(R.id.guardian);
        guardiannameedittext = findViewById(R.id.gname);
        guardianeducationedittext = findViewById(R.id.geducation);
        guardianoccupationedittext = findViewById(R.id.goccupation);
        guardianincomeedittext = findViewById(R.id.gincome);
        foofficailaddress=findViewById(R.id.fofficailaaddress);
        mofficaialadress=findViewById(R.id.mofficialAddress);
        gofficialaddress=findViewById(R.id.gofficailaaddress);
        guardianphonenumber=findViewById(R.id.gphone_number);
        save = findViewById(R.id.savefamily);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            fathernamestring = fathernameedittext.getText().toString();
                fathereducationstring = fathereducationedittext.getText().toString();
                fatheroccupationstring = fatheroccupationedittext.getText().toString();
                fatherincomestring = fatherincomeedittext.getText().toString();
                fatherphonenumberstring=fatherphonenumber.getText().toString();

                mothernamestring = mothernameedittext.getText().toString();
                mothereducationstring = mothereducationedittext.getText().toString();
                motheroccupationstring = motheroccupationedittext.getText().toString();
                motherincomestring = motherincomeedittext.getText().toString();
                motherphonenumberstring=motherphonenumber.getText().toString();

                guardiannamestring = guardiannameedittext.getText().toString();
                guardianeducationstring = guardianeducationedittext.getText().toString();
                guardianoccupationstring = guardianoccupationedittext.getText().toString();
                guardianincomestring = guardianincomeedittext.getText().toString();
                guardianphonenumberstring=guardianphonenumber.getText().toString();

                textfoofficailaddress=foofficailaddress.getText().toString();
                textmofficaialadress=mofficaialadress.getText().toString();

                textgofficialaddres=gofficialaddress.getText().toString();


                HashMap<String, Object> familyDetails = new HashMap<>();
                HashMap<String, Object> father = new HashMap<>();
                father.put("name", fathernamestring);
                father.put("educationQualification", fathereducationstring);
                father.put("annualIncome", fatherincomestring);
                father.put("number",fatherphonenumberstring);
                father.put("occupation", fatheroccupationstring);
                father.put("officialAddress", textfoofficailaddress);


                familyDetails.put("father",father);

                HashMap<String, Object> mother = new HashMap<>();
                mother.put("name", mothernamestring);
                mother.put("educationQualification", mothereducationstring);
                mother.put("annualIncome", motherincomestring);
                mother.put("number",motherphonenumberstring);
                mother.put("occupation", motheroccupationstring);
                mother.put("officialAddress", textmofficaialadress);
                familyDetails.put("mother",mother);

                HashMap<String, Object> guardian = new HashMap<>();
                guardian.put("name", guardiannamestring);
                guardian.put("educationQualification", guardianeducationstring);
                guardian.put("annualIncome", guardianincomestring);
                guardian.put("number",guardianphonenumberstring);
                guardian.put("occupation", guardianoccupationstring);
                guardian.put("officialAddress", textgofficialaddres);
                familyDetails.put("guardian",guardian);


                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getFamilyList(personalDetails,educationDetails,familyDetails);


            }
        });
    }

    private void getFamilyList(HashMap<String, Object> personalDetails, HashMap<String, Object> educationDetails, HashMap<String, Object> familyDetails) {


            HashMap<String, Object> data = new HashMap<>();


        data.put("personalDetails",personalDetails);
        data.put("educationDetails",educationDetails);
        data.put("familyDetails",familyDetails);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authentoken = (shared.getString("token", ""));

        Call<CreateResponse> familyCall = apiCall.getFamily(data, authentoken);

        familyCall.enqueue(new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {

                if (response.body() != null) {

                    Toast.makeText(FamilyDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();

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