package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.emea.R;

public class SplashScreen extends AppCompatActivity {
    String authtoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (authtoken != "") {
                    Intent intent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }
}