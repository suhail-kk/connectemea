package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emea.R;

public class ExtraCurricularActivityView extends AppCompatActivity {

    ImageView editextracurricular, backbutton;

    TextView topNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curricular_view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Extra Curricular Activities");

        editextracurricular = findViewById(R.id.edit);

//        editextracurricular.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent depIntent = new Intent(getApplicationContext(), LearningDependenciesEdit.class);
//                startActivity(depIntent);
//
//            }
//        });

        backbutton = findViewById(R.id.backBtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent depIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(depIntent);

            }
        });
    }
}
