package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emea.Fragments.HomePage;
import com.example.emea.R;

public class ForgotPassword extends AppCompatActivity {
    EditText txtEmail;
    Button btnReset;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        txtEmail=findViewById(R.id.logginEmail);
        btnReset=findViewById(R.id.resetPassword);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputEmail = txtEmail.getText().toString();

                boolean check=ValidateInfo(inputEmail);

                if(check==true) {
                    Intent newIntent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(newIntent);
                }
            }
        });
    }
    private boolean ValidateInfo(String inputEmail) {
        if (inputEmail.length() == 0) {
            txtEmail.requestFocus();
            txtEmail.setError("Field cannot be empty");
            return false;
        } else if (!inputEmail.matches(emailPattern)) {
            txtEmail.requestFocus();
            txtEmail.setError("Please enter a valid email address");
            return false;
        }
        else {
            return true;
        }
    }
}