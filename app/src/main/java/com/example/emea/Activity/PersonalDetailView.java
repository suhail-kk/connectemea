package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.PersonalViewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDetailView extends AppCompatActivity {

    TextView topNav;

    ApiCall apiCall;

    TextView name,course,rollno,admno,dob,age,gender,blood,marital,religion,caste,email,permaddress,presaddress;
    TextView admcategory,managementreco,identification1,identification2,joining,mobilenumber,residingat,distancekm;

    String textname,textcourse,textrollno,textadmno,textdob,textage,textgender,textblood;
    String textmarital,textreligion,textcaste,textemail,textpermaddress,textpresaddress,textadmcategory;
    String textmanagementreco,textidentification1,textidentification2,textjoining,textmobilenumber,textresidingat,textdistancekm;
    String authtoken;

    ImageView edit;
    ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail_view);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Personal Details");

        edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent perIntent = new Intent(getApplicationContext(), PersonalEdit.class);
                startActivity(perIntent);

            }
        });

        backbutton = findViewById(R.id.backBtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);

            }
        });

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        Call<PersonalViewResponse> personalCall = apiCall.getPersonalView(authtoken);
        personalCall.enqueue(new Callback<PersonalViewResponse>() {
            @Override
            public void onResponse(Call<PersonalViewResponse> call, Response<PersonalViewResponse> response) {

                textname = response.body().getName();
                name = (TextView) findViewById(R.id.namedisplay);
                name.setText(textname);

                textcourse = response.body().getDepartment();
                course = (TextView) findViewById(R.id.classdisplay);
                course.setText(textcourse);

                textrollno = response.body().getRollNo();
                rollno = (TextView) findViewById(R.id.rollnodisplay);
                rollno.setText(textrollno);

                textadmno = response.body().getAdmissionNo();
                admno = (TextView) findViewById(R.id.admnodisplay);
                admno.setText(textadmno);

                textdob = response.body().getDateOfBirth();
                dob = (TextView) findViewById(R.id.dobdisplay);
                dob.setText(textdob);

                textdistancekm = response.body().getDistanceToCollege();
                distancekm = (TextView) findViewById(R.id.distancedisplay);
                distancekm.setText(textdistancekm);


                textresidingat = response.body().getResidingAt();
                residingat = (TextView) findViewById(R.id.residingdisplay);
                residingat.setText(textresidingat);

                textjoining = response.body().getJoiningYear();
                joining = (TextView) findViewById(R.id.joindisplay);
                joining.setText(textjoining);

                textmobilenumber = response.body().getMobile();
                mobilenumber = (TextView) findViewById(R.id.mobiledisplay);
                mobilenumber.setText(textmobilenumber);

//                textage=response.body().getFatherName();
//                age=(TextView)findViewById(R.id.agedisplay);
//                age.setText(textage);

                textgender = response.body().getGender();
                gender = (TextView) findViewById(R.id.genderdisplay);
                gender.setText(textgender);

                textblood = response.body().getBloodGroup();
                blood = (TextView) findViewById(R.id.bloodgrpdisplay);
                blood.setText(textblood);

                textmarital = response.body().getMaritalStatus();
                marital = (TextView) findViewById(R.id.maritaldisplay);
                marital.setText(textmarital);

                textreligion = response.body().getReligion();
                religion = (TextView) findViewById(R.id.religiondisplay);
                religion.setText(textreligion);

                textcaste = response.body().getCaste();
                caste = (TextView) findViewById(R.id.castedisplay);
                caste.setText(textcaste);

                textemail = response.body().getEmail();
                email = (TextView) findViewById(R.id.emaildisplay);
                email.setText(textemail);

                textpermaddress = response.body().getPermanentAddress();
                permaddress = (TextView) findViewById(R.id.permenantaddressdisplay);
                permaddress.setText(textpermaddress);

                textpresaddress = response.body().getPresentAddress();
                presaddress = (TextView) findViewById(R.id.presentaddressdisplay);
                presaddress.setText(textpresaddress);

                textadmcategory = response.body().getAdmissionCategory();
                admcategory = (TextView) findViewById(R.id.admctgrydisplay);
                admcategory.setText(textadmcategory);

//                textmanagementreco=response.body().getFatherName();
//                managementreco=(TextView)findViewById(R.id.managementrecodisplay);
//                managementreco.setText(textmanagementreco);

                textidentification1 = response.body().getIdentificationMark1();
                identification1 = (TextView) findViewById(R.id.identification1display);
                identification1.setText(textidentification1);

                textidentification2 = response.body().getIdentificationMark2();
                identification2 = (TextView) findViewById(R.id.identification2display);
                identification2.setText(textidentification2);

            }

            @Override
            public void onFailure(Call<PersonalViewResponse> call, Throwable t) {

                Toast.makeText(PersonalDetailView.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

        //   setContentView(R.layout.activity_personal_detail_view);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}