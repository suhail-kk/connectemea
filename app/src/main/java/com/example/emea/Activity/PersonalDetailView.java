package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.PersonalDetails;
//import com.example.emea.Response.getDetails.Student;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDetailView extends AppCompatActivity {

    TextView topNav;
    ApiCall apiCall;
    PersonalDetails personaldetails;
    TextView name,rollno, admno, dob, gender, blood, marital, religion, caste, email, permaddress, presaddress,admcategory,
            identification1, identification2, joining, mobilenumber, residingat, distancekm,image;
    String textname,textrollno, textadmno, textdob,textgender, textblood
   ,textmarital, textreligion, textcaste, textemail, textpermaddress, textpresaddress, textadmcategory,textidentification1,textidentification2
    , textjoining , textresidingat, textdistancekm, authtoken, userid,textimage;
    int textmobilenumber;
    Data data;
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

        SharedPreferences pref = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
         userid = (pref.getString("userId", ""));

        Call<GetResponse> personalCall = apiCall.getDetailsView(authtoken);
        personalCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

                data = response.body().getData();
                personaldetails=data.getPersonalDetails();



                textname = personaldetails.getName();
                name =  findViewById(R.id.namedisplay);
                name.setText(textname);

                textrollno = personaldetails.getEmail();
                rollno =  findViewById(R.id.rollnodisplay);
                rollno.setText(textrollno);

                textadmno = personaldetails.getAdmissionNO();
                admno =  findViewById(R.id.admnodisplay);
                admno.setText(textadmno);

                textdob = personaldetails.getDateOfBirth();
                dob =  findViewById(R.id.dobdisplay);
                dob.setText(textdob);

                textdistancekm = personaldetails.getDistanceFromCollege();
                distancekm =  findViewById(R.id.distancedisplay);
                distancekm.setText(textdistancekm);


                textresidingat = personaldetails.getResidence();
                residingat =  findViewById(R.id.residingdisplay);
                residingat.setText(textresidingat);

                textjoining =personaldetails.getYearOfJoin();
                joining =  findViewById(R.id.joindisplay);
                joining.setText(textjoining);

                textmobilenumber = (int) personaldetails.getMobileNo();
                mobilenumber =  findViewById(R.id.mobiledisplay);
                mobilenumber.setText(String.valueOf(textmobilenumber));

                textgender = personaldetails.getGender();
                gender =  findViewById(R.id.genderdisplay);
                gender.setText(textgender);

                textblood = personaldetails.getBloodGroup();
                blood =  findViewById(R.id.bloodgrpdisplay);
                blood.setText(textblood);

                textmarital = personaldetails.getMaritalStatus();
                marital =  findViewById(R.id.maritaldisplay);
                marital.setText(textmarital);

                textreligion = personaldetails.getReligion();
                religion =  findViewById(R.id.religiondisplay);
                religion.setText(textreligion);

                textcaste = personaldetails.getCaste();
                caste =  findViewById(R.id.castedisplay);
                caste.setText(textcaste);

                textemail =personaldetails.getEmail();
                email =  findViewById(R.id.emaildisplay);
                email.setText(textemail);

                textpermaddress =personaldetails.getPermanentAddress();
                permaddress =  findViewById(R.id.permenantaddressdisplay);
                permaddress.setText(textpermaddress);

                textpresaddress = personaldetails.getPresentAddress();
                presaddress =  findViewById(R.id.presentaddressdisplay);
                presaddress.setText(textpresaddress);

                textadmcategory = personaldetails.getCategoryOfAdmission();
                admcategory =  findViewById(R.id.admctgrydisplay);
                admcategory.setText(textadmcategory);

                textidentification1 = personaldetails.getIdentificationMarkOne();
                identification1 =  findViewById(R.id.identification1display);
                identification1.setText(textidentification1);

                textidentification2 = personaldetails.getIdentificationMarkTwo();
                identification2 =  findViewById(R.id.identification2display);
                identification2.setText(textidentification2);

            }
                @Override
                public void onFailure (Call < GetResponse > call, Throwable t){

                    Toast.makeText(PersonalDetailView.this, "Failed", Toast.LENGTH_SHORT).show();

                }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}





