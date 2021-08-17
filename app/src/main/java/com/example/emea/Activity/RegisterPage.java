package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.emea.Network.ApiCall;
import com.example.emea.R;

public class RegisterPage extends AppCompatActivity {

    EditText RegisterEmail, RegisterPassword, RegisterConfirmPassword;
    ApiCall apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


    }
}