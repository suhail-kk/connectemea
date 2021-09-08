package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.emea.R;

public class Help extends AppCompatActivity {


    TextView contactUs,AppInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        contactUs = findViewById(R.id.contactUs);
        AppInfo = findViewById(R.id.appInfo);

        contactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent=new Intent(getApplicationContext(), AppInfo.class);
                startActivity(newIntent);
            }
        });

        AppInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(newIntent);

            }
        });
    }
}