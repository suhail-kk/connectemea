package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.emea.R;

public class FamilyDetailsView extends AppCompatActivity {

    TextView topNav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details_view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");

    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
//        startActivityForResult(myIntent, 0);
//        return true;
//    }
}