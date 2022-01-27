package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.forgotpackage.Data;
import com.example.emea.Response.forgotpackage.ForgotResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    EditText txtEmail, txtfullname;
    Button btnforgot;
    String inputEmail, inputfullname;
    ApiCall apiCall;
    String authentoken;
    TextView txtForgot;
    Data data;
    String authToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        txtForgot = findViewById(R.id.forgot);

        Typeface typeface = ResourcesCompat.getFont(
                this,
                R.font.poppins_regular);
        txtForgot.setTypeface(typeface);


        txtEmail = findViewById(R.id.forgot_email);
        txtfullname = findViewById(R.id.forgotfullname);
       btnforgot = findViewById(R.id.resetPassword);
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 inputEmail = txtEmail.getText().toString();
               inputfullname = txtfullname.getText().toString();

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
                getForgotList(inputEmail, inputfullname);
            }
        });
    }



    public void getForgotList(String inputEmail, String inputfullname) {

        HashMap<String, String> params = new HashMap<>();

        params.put("username", inputfullname);
        params.put("email", inputEmail);

        Call<ForgotResponse> ForgotCall = apiCall.getForgot(params);
        ForgotCall.enqueue(new Callback<ForgotResponse>() {
            @Override
            public void onResponse(Call<ForgotResponse> call, Response<ForgotResponse> response) {

                if (response.body() != null) {

                    data = response.body().getData();
                    authentoken=data.getUserToken();
                    Toast.makeText(ForgotPassword.this, authentoken, Toast.LENGTH_SHORT).show();


                    Toast.makeText(ForgotPassword.this, "Added ", Toast.LENGTH_SHORT).show();

                        Intent newIntent = new Intent(getApplicationContext(),RecoveryPassword.class);
                    newIntent.putExtra("token", authentoken);
                        startActivity(newIntent);

                }

                    else {
                        Toast.makeText(ForgotPassword.this, "Register Failed.", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onFailure(Call<ForgotResponse> call, Throwable t) {
                Toast.makeText(ForgotPassword.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}