package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class EducationalDetails2 extends AppCompatActivity {

    TextView ugc, anyotherqual;
    TextInputEditText collegename,ugcmainbox;
    AutoCompleteTextView collegecourse,collegeuniversity;
    TextInputEditText ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox, coursename, coursetype, institution, university2;
String textcollegename,textcollegecourse,textuniversity,textugcmainbox,textugcsubbox,textugcenglishbox,textugclangbox,textopencoursebox,textcoursename,textcoursetype,textinstitution,textuniversity2;
    LinearLayout itemdegree,itemqualification;
    RecyclerView recyclerView;
    Button adddegree,addqualification,save;
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
        HashMap<String, Object> personalDetails = (HashMap<String, Object>) intent.getSerializableExtra("personalDetails");
        HashMap<String, Object> educationDetails = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");

// degree
       ugc = findViewById(R.id.degree);
        collegename = findViewById(R.id.ugcollegeName);
        collegeuniversity=findViewById(R.id.degreeuniversity);
        collegecourse=findViewById(R.id.degreecourse);
        ugcmainbox = findViewById(R.id.dgrsubCore);
        ugcsubbox = findViewById(R.id.dgrsubComp);
        ugcenglishbox = findViewById(R.id.dgrsubEng);
        ugclangbox = findViewById(R.id.dgrsubLang);
        opencoursebox = findViewById(R.id.dgrsubOpen);

//otherqualifications
        anyotherqual=findViewById(R.id.otherqual);
        coursename = findViewById(R.id.qualicrsName);
        coursetype = findViewById(R.id.qualicrstype);
        institution = findViewById(R.id.qualiIstnname);
        university2 = findViewById(R.id.qualiuniversity);

        adddegree = findViewById(R.id.addDegree);
        itemdegree = findViewById(R.id.newDegreeLayout);
        recyclerView = findViewById(R.id.recycler_degree);
        itemqualification=findViewById(R.id.newQualifiactionLayout);

        save=findViewById(R.id.saveEduDetail);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textcollegename = collegename.getText().toString();
                textuniversity=collegeuniversity.getText().toString();
                textcollegecourse = collegecourse.getText().toString();
                textugcmainbox = ugcmainbox.getText().toString();
                textugcsubbox = ugcsubbox.getText().toString();
                textugcenglishbox = ugcenglishbox.getText().toString();
                textugclangbox = ugclangbox.getText().toString();
                textopencoursebox = opencoursebox.getText().toString();


                textcoursename=coursename.getText().toString();
                textcoursetype=coursetype.getText().toString();
                textinstitution=institution.getText().toString();
                textuniversity2=university2.getText().toString();

                HashMap<String, Object> degree = new HashMap<>();
                degree.put("college", textcollegename);
                degree.put("university", textuniversity);
                degree.put("course", textcollegecourse);
                degree.put("core", textugcmainbox);
                degree.put("complementry", textugcsubbox);
                degree.put("commonOne", textugcenglishbox);
                degree.put("commonTwo", textugclangbox);
                degree.put("open",textopencoursebox );
                Object[] Degree = {degree};


                HashMap<String, Object> qualification = new HashMap<>();
                qualification.put("institutionName", textcoursename);
                qualification.put("courseType", textcoursetype);
                qualification.put("Grade", textinstitution);
                qualification.put("university", textuniversity2);
                Object[] Qualification = {qualification};

                educationDetails.put("degree",Degree);
                educationDetails.put("otherQualifications",Qualification);

                Intent newIntent = new Intent(EducationalDetails2.this, ExtraCurricularActivity.class);
                newIntent.putExtra("personalDetails", personalDetails);
                newIntent.putExtra("educationDetails", educationDetails);

                startActivity(newIntent);
            }
        });

    }
}