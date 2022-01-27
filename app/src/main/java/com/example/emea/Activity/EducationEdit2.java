package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.DegreeItem;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.OtherQualificationsItem;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EducationEdit2 extends AppCompatActivity {

    TextView ugc, anyotherqual;
    TextInputEditText collegename,ugcmainbox;
    AutoCompleteTextView collegecourse,collegeuniversity;
    TextInputEditText ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox, coursename, coursetype, institution, university2;
    String textcollegename,textcollegecourse,textcollegeuniversity,textugcmainbox,textugcsubbox,textugcenglishbox,textugclangbox,textopencoursebox,textcoursename,textcoursetype,textinstitution,textuniversity2;
    Button save;
    ApiCall apiCall;
    String authtoken;
    Data data;
    EducationDetails educationaldetails;
    List<DegreeItem> degree;
    List<OtherQualificationsItem> qualification;
    String userid;
    ProgressBar pgBar;
    ImageView prevPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_details2);

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
        HashMap<String, Object> tenthStd = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");
        HashMap<String, Object> twelthStd = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");
        pgBar=findViewById(R.id.progressBar2);

        save=findViewById(R.id.saveEduDetail);
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
                degree =  educationaldetails.getDegree();
                qualification= educationaldetails.getOtherQualifications();



                textcollegename = degree.get(0).getCollege();
                collegename=findViewById(R.id.ugcollegeName);
                collegename.setText(textcollegename);
                textcollegeuniversity=degree.get(0).getUniversity();
                collegeuniversity=findViewById(R.id.degreeuniversity);
                collegeuniversity.setText(textcollegeuniversity);
                textcollegecourse = degree.get(0).getCourse();
                collegecourse=findViewById(R.id.degreecourse);
                collegecourse.setText(textcollegecourse);
                textugcmainbox = degree.get(0).getCore();
                ugcmainbox=findViewById(R.id.dgrsubCore);
                ugcmainbox.setText(textugcmainbox);
                textugcsubbox = degree.get(0).getCommonOne();
                ugcsubbox=findViewById(R.id.dgrsubComp);
                ugcsubbox.setText(textugcsubbox);
                textugcenglishbox = degree.get(0).getCommonTwo();
                ugcenglishbox=findViewById(R.id.dgrsubEng);
                ugcenglishbox.setText(textugcenglishbox);
//                textugclangbox = degree.get(0).g;
//                ugclangbox=findViewById(R.id.dgrsubLang);
//                ugclangbox.setText(textugclangbox);
                textopencoursebox = degree.get(0).getOpen();
                opencoursebox=findViewById(R.id.dgrsubOpen);
                opencoursebox.setText(textopencoursebox);
                textcoursename = qualification.get(0).getUniversity();
                coursename=findViewById(R.id.qualicrsName);
                coursename.setText(textcoursename);
                textcoursetype = qualification.get(0).getCourseType();
                coursetype=findViewById(R.id.qualicrstype);
                coursetype.setText(textcoursetype);
                textinstitution = qualification.get(0).getInstitutionName();
                institution=findViewById(R.id.qualiIstnname);
                institution.setText(textinstitution);
                textuniversity2 = qualification.get(0).getGrade();
                university2=findViewById(R.id.qualiuniversity);
                university2.setText(textuniversity2);


            }
            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
//                pgBar.setVisibility(View.GONE);
                Toast.makeText(EducationEdit2.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textcollegename = collegename.getText().toString();
                textcollegeuniversity=collegeuniversity.getText().toString();
                textcollegecourse = collegecourse.getText().toString();
                textugcmainbox = ugcmainbox.getText().toString();
                textugcsubbox = ugcsubbox.getText().toString();
                textugcenglishbox = ugcenglishbox.getText().toString();
//                textugclangbox = ugclangbox.getText().toString();
                textopencoursebox = opencoursebox.getText().toString();


                textcoursename=coursename.getText().toString();
                textcoursetype=coursetype.getText().toString();
                textinstitution=institution.getText().toString();
                textuniversity2=university2.getText().toString();

                HashMap<String, Object> degree = new HashMap<>();
                degree.put("college", textcollegename);
                degree.put("university", textcollegeuniversity);
                degree.put("course", textcollegecourse);
                degree.put("core", textugcmainbox);
//                degree.put("complementry", textugcsubbox);
                degree.put("commonOne", textugcenglishbox);
                degree.put("commonTwo", textugcsubbox);
                degree.put("open",textopencoursebox );
                Object[] Degree = {degree};


                HashMap<String, Object> qualification = new HashMap<>();
                qualification.put("institutionName", textcoursename);
                qualification.put("courseType", textcoursetype);
                qualification.put("Grade", textinstitution);
                qualification.put("university", textuniversity2);
                Object[] Qualification = {qualification};


                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getEditList(Degree, Qualification,tenthStd,twelthStd);

            }
            private void getEditList(Object[] Degree, Object[] Qualification, HashMap<String, Object> tenthStd, HashMap<String, Object> twelthStd) {

                HashMap<String, Object> educationDetails = new HashMap<>();
                educationDetails.put("tenthStd",tenthStd);
                educationDetails.put("twelthStd",twelthStd);
                educationDetails.put("degree",Degree);
                educationDetails.put("otherQualifications",Qualification);




                HashMap<String,Object> editeducation = new HashMap<>();
                editeducation.put("educationDetails",educationDetails);
                SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                authtoken = (shared.getString("token", ""));

                SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
                userid = (pref.getString("_id", ""));


                Call<EditResponse> educationeditCall = apiCall.geteducationEdit(userid,editeducation,authtoken);
                educationeditCall.enqueue(new Callback<EditResponse>() {
                    @Override
                    public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {

                        Toast.makeText(EducationEdit2.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                        Intent newIntent = new Intent(getApplicationContext(), EducationDetailsView.class);
                        startActivity(newIntent);

                    }

                    @Override
                    public void onFailure(Call<EditResponse> call, Throwable t) {
                        Toast.makeText(EducationEdit2.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }

     }