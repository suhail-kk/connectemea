package com.example.emea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import java.util.HashMap;

import retrofit2.Call;

public class RegisterPage extends AppCompatActivity {

    EditText RegisterEmail, RegisterPassword, RegisterConfirmPassword;
    ApiCall apiCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


    }
}