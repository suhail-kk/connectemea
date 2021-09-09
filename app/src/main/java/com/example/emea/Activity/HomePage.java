package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.emea.R;

public class HomePage extends AppCompatActivity {

    LinearLayout linearLayoutPersonalDtls,linearLayoutEducaionDtls,linearLayoutFamilyDtls;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);

        linearLayoutPersonalDtls = findViewById(R.id.linearLayoutPersonal);
        linearLayoutEducaionDtls = findViewById(R.id.linearLayoutEducation);
        linearLayoutFamilyDtls = findViewById(R.id.linearLayoutFamily);

        linearLayoutPersonalDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), PersonalDetails.class);
                startActivity(newIntent);

            }
        });

        linearLayoutEducaionDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), EducationalDetails.class);
                startActivity(newIntent);

            }
        });

        linearLayoutFamilyDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), FamilyDetails.class);
                startActivity(newIntent);

            }
        });
    }
}