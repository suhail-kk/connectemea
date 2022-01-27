package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.getDetails.AdditionalCourseItem;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.ExtraCurricularItem;
import com.example.emea.Response.getDetails.GetResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtraCurricularEdit extends AppCompatActivity {

    String textactivity, textprice, textyearofparticipation, textdetailsofexcellence,textcourseName,textinstitutionName;
    TextInputEditText activity, price, yearofparticipation, detailsofexcellence, courseName, institutionName, cgp, university;
    Button saveinfoextra;
    String textcourse;
    String textinstitution;
    String textuniversity;
    int textcgp;

ApiCall apiCall;
String authtoken;
Data data;
EducationDetails educationaldetails;
ExtraCurricularItem extraCurricularItem;
AdditionalCourseItem additionalCourseItem;
String userid;
ImageView prevPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curricular);
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

        saveinfoextra = findViewById(R.id.saveExtraDetail);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));


        Call<GetResponse> extracurricularCall = apiCall.getDetailsView(authtoken);
        extracurricularCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

                data = response.body().getData();
                educationaldetails = data.getEducationDetails();
                extraCurricularItem= (ExtraCurricularItem) educationaldetails.getExtraCurricular();
                additionalCourseItem= (AdditionalCourseItem) educationaldetails.getAdditionalCourse();

                activity = findViewById(R.id.course_name);
                price = findViewById(R.id.institution_name);
                yearofparticipation = findViewById(R.id.addCourseUniversity);
                detailsofexcellence = findViewById(R.id.course_mark);


                courseName = findViewById(R.id.course_name1);
                institutionName = findViewById(R.id.institution_name1);
                university = findViewById(R.id.addCourseUniversity1);

                cgp = findViewById(R.id.course_mark1);

                textactivity = extraCurricularItem.getActivity();
                activity = findViewById(R.id.course_name);
                activity.setText(textactivity);

                textprice = extraCurricularItem.getPrice();
                price = findViewById(R.id.institution_name);
                price.setText(textprice);

                textyearofparticipation = extraCurricularItem.getYearOfParticipation();
                yearofparticipation = findViewById(R.id.addCourseUniversity);
                yearofparticipation.setText(textyearofparticipation);

                textdetailsofexcellence = extraCurricularItem.getDetailsOfExcellenceInPerformance();
                detailsofexcellence = findViewById(R.id.course_mark);
                detailsofexcellence.setText(textdetailsofexcellence);

                textcourseName = additionalCourseItem.getCourseName();
                courseName = findViewById(R.id.course_name1);
                courseName.setText(textcourseName);

                textinstitutionName = additionalCourseItem.getInstitutionName();
                institutionName = findViewById(R.id.institution_name1);
                institutionName.setText(textinstitutionName);

                textuniversity = additionalCourseItem.getUniversity();
                university = findViewById(R.id.addCourseUniversity1);
                university.setText(textuniversity);

                textcgp = additionalCourseItem.getCgp();
                cgp = findViewById(R.id.course_mark1);
                cgp.setText(textcgp);







            }
            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
//                pgBar.setVisibility(View.GONE);
                Toast.makeText(ExtraCurricularEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        saveinfoextra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textactivity = activity.getText().toString();
                textprice = price.getText().toString();
                textyearofparticipation = yearofparticipation.getText().toString();
                textdetailsofexcellence = detailsofexcellence.getText().toString();

                textcourse = courseName.getText().toString();
                textinstitution = institutionName.getText().toString();
                textuniversity = university.getText().toString();
                textcgp = Integer.parseInt(cgp.getText().toString());


                HashMap<String, Object> extraCurricular1 = new HashMap<>();
                extraCurricular1.put("activity", textactivity);
                extraCurricular1.put("yearOfParticipation", textyearofparticipation);
                extraCurricular1.put("Price", textprice);
                extraCurricular1.put("detailsOfExcellenceInPerformance", textdetailsofexcellence);

                Object[] extraCurricular = {extraCurricular1};


                HashMap<String, Object> additional = new HashMap<>();
                additional.put("courseName", textcourse);
                additional.put("institutionName", textinstitution);
                additional.put("university", textuniversity);
                additional.put("cgp", textcgp);
                Object[] additional1 = {additional};


                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getEditList(extraCurricular, additional1);

            }
            private void getEditList(Object[] extraCurricular, Object[] additional1 ) {

                HashMap<String, Object> educationDetails = new HashMap<>();


                educationDetails.put("extraCurricular", extraCurricular);
                educationDetails.put("additionalCourse", additional1);

                HashMap<String,Object> editeducation = new HashMap<>();
                editeducation.put("educationDetails",educationDetails);
                SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                authtoken = (shared.getString("token", ""));

                SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
                userid = (pref.getString("_id", ""));


                Call<EditResponse> educationeditCall = apiCall.getextracurricularEdit(userid,editeducation,authtoken);
                educationeditCall.enqueue(new Callback<EditResponse>() {
                    @Override
                    public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {

                        Toast.makeText(ExtraCurricularEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                        Intent newIntent = new Intent(getApplicationContext(), EducationDetailsView.class);
                        startActivity(newIntent);

                    }

                    @Override
                    public void onFailure(Call<EditResponse> call, Throwable t) {
                        Toast.makeText(ExtraCurricularEdit.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
            }
        }


