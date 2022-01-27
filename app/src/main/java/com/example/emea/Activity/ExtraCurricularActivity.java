package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.HashMap;

public class ExtraCurricularActivity extends AppCompatActivity {

    String textactivity, textprice, textyearofparticipation, textdetailsofexcellence;
    TextInputEditText activity, price, yearofparticipation, detailsofexcellence, courseName, institutionName, cgp, university;
    Button addextraactivity, saveinfoextra, addadditional;
    String textcourse, textinstitution, textuniversity, textcgp;
    LinearLayout itemextra, itemadditional;
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

        Intent intent = getIntent();
        HashMap<String, Object> personalDetails = (HashMap<String, Object>) intent.getSerializableExtra("personalDetails");
        HashMap<String, Object> educationDetails = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");

        saveinfoextra = findViewById(R.id.saveExtraDetail);

        activity = findViewById(R.id.course_name);
        price = findViewById(R.id.institution_name);
        yearofparticipation = findViewById(R.id.addCourseUniversity);
        detailsofexcellence = findViewById(R.id.course_mark);


        courseName = findViewById(R.id.course_name1);
        institutionName = findViewById(R.id.institution_name1);
        university = findViewById(R.id.addCourseUniversity1);

        cgp = findViewById(R.id.course_mark1);


        itemextra = findViewById(R.id.newExtraLayout);

        itemadditional = findViewById(R.id.newAdditionalLayout);




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
                textcgp = cgp.getText().toString();


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
                educationDetails.put("extraCurricular", extraCurricular);
                educationDetails.put("additionalCourse", additional1);

                Intent newIntent = new Intent(ExtraCurricularActivity.this, FamilyDetails.class);

                newIntent.putExtra("personalDetails", personalDetails);
                newIntent.putExtra("educationDetails", educationDetails);

                startActivity(newIntent);
            }
        });

    }

}