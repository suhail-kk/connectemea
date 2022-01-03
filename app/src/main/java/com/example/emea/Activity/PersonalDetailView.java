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
import com.example.emea.Response.getDetails.Student;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDetailView extends AppCompatActivity {

    TextView topNav;

    ApiCall apiCall;
    //    Data data;
    PersonalDetails personaldetails;
    TextView name, course, rollno, admno, dob, age, gender, blood, marital, religion, caste, email, permaddress, presaddress;
    TextView admcategory, managementreco, identification1, identification2, joining, mobilenumber, residingat, distancekm;

    String textname, textcourse, textrollno, textadmno, textdob, textage, textgender, textblood;
    String textmarital, textreligion, textcaste, textemail, textpermaddress, textpresaddress, textadmcategory;
    String textmanagementreco;
    String textidentification1;
    String textidentification2;
    String textjoining;
    int textmobilenumber;
    String textresidingat;
    String textdistancekm;
    String authtoken;
    String authToken;
    String userid;
    Data data;
    Student student;


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
//
        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        SharedPreferences pref = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
         userid = (pref.getString("userId", ""));

        Call<GetResponse> personalCall = apiCall.getDetailsView(authtoken);
        personalCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
//                 data = response.body().getData();
////                authToken=data.getPersonalDetails();
//                personaldetails = data.getPersonalDetails();
                data = response.body().getData();
                 student = data.getStudent();
                personaldetails=student.getPersonalDetails();


                textname = personaldetails.getName();
                name = (TextView) findViewById(R.id.namedisplay);
                name.setText(textname);

//                textcourse = personaldetails.get
//                course = (TextView) findViewById(R.id.classdisplay);
//                course.setText(textcourse);

                textrollno = personaldetails.getEmail();
                rollno = (TextView) findViewById(R.id.rollnodisplay);
                rollno.setText(textrollno);

                textadmno = personaldetails.getAdmissionNO();
                admno = (TextView) findViewById(R.id.admnodisplay);
                admno.setText(textadmno);

                textdob = personaldetails.getDateOfBirth();
                dob = (TextView) findViewById(R.id.dobdisplay);
                dob.setText(textdob);

                textdistancekm = personaldetails.getDistanceFromCollege();
                distancekm = (TextView) findViewById(R.id.distancedisplay);
                distancekm.setText(textdistancekm);


                textresidingat = personaldetails.getResidence();
                residingat = (TextView) findViewById(R.id.residingdisplay);
                residingat.setText(textresidingat);

                textjoining =personaldetails.getYearOfJoin();
                joining = (TextView) findViewById(R.id.joindisplay);
                joining.setText(textjoining);

                textmobilenumber = personaldetails.getMobileNo();
                mobilenumber = (TextView) findViewById(R.id.mobiledisplay);
                mobilenumber.setText(String.valueOf(textmobilenumber));

                textgender = personaldetails.getGender();
                gender = (TextView) findViewById(R.id.genderdisplay);
                gender.setText(textgender);

                textblood = personaldetails.getBloodGroup();
                blood = (TextView) findViewById(R.id.bloodgrpdisplay);
                blood.setText(textblood);

                textmarital = personaldetails.getMaritalStatus();
                marital = (TextView) findViewById(R.id.maritaldisplay);
                marital.setText(textmarital);

                textreligion = personaldetails.getReligion();
                religion = (TextView) findViewById(R.id.religiondisplay);
                religion.setText(textreligion);

                textcaste = personaldetails.getCaste();
                caste = (TextView) findViewById(R.id.castedisplay);
                caste.setText(textcaste);

                textemail =personaldetails.getEmail();
                email = (TextView) findViewById(R.id.emaildisplay);
                email.setText(textemail);

                textpermaddress =personaldetails.getPermenentAddress();
                permaddress = (TextView) findViewById(R.id.permenantaddressdisplay);
                permaddress.setText(textpermaddress);

                textpresaddress = personaldetails.getPresentAddress();
                presaddress = (TextView) findViewById(R.id.presentaddressdisplay);
                presaddress.setText(textpresaddress);

                textadmcategory = personaldetails.getCategoryOfAdmission();
                admcategory = (TextView) findViewById(R.id.admctgrydisplay);
                admcategory.setText(textadmcategory);

//                textmanagementreco=response.body().getFatherName();
//                managementreco=(TextView)findViewById(R.id.managementrecodisplay);
//                managementreco.setText(textmanagementreco);

                textidentification1 = personaldetails.getIdentificationMarkOne();
                identification1 = (TextView) findViewById(R.id.identification1display);
                identification1.setText(textidentification1);

                textidentification2 = personaldetails.getIdentificationMarkTwo();
                identification2 = (TextView) findViewById(R.id.identification2display);
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





