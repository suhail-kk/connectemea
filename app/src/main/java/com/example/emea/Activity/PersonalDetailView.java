package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.emea.R;

public class PersonalDetailView extends AppCompatActivity {

    TextView topNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Personal Details");

     //   setContentView(R.layout.activity_personal_detail_view);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}