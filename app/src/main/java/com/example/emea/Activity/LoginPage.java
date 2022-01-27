package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.example.emea.Fragments.HomePage;
import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.Login.Data;
import com.example.emea.Response.Login.LoginResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPage extends AppCompatActivity {
    TextInputEditText txtEmail, txtPassword;
    Button btnLogin;
    TextView btnforgot,btnregister;
    ProgressBar pgBar;
    //  TextView txtForgot;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String inputEmail;
    String inputPassword;
    String status;
    ApiCall apiCall;
    Data data;
    String authToken;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        btnforgot=findViewById((R.id.forgotpass));
        btnregister=findViewById((R.id.registernew));

        txtEmail = findViewById(R.id.Emaillogin);
        txtPassword = findViewById(R.id.loggin_Password);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        btnLogin = findViewById(R.id.loginbutton);
        pgBar = findViewById(R.id.progressBar);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEmail = txtEmail.getText().toString();
                inputPassword = txtPassword.getText().toString();

                getLoginList(inputEmail, inputPassword);



            }
        });
        btnforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent newIntent = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(newIntent);

            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(newIntent);

            }
        });

    }


    public void getLoginList(String inputEmail, String inputPassword) {
        HashMap<String, String> params = new HashMap<>();
        params.put("email", inputEmail);
        params.put("password", inputPassword);

        pgBar.setVisibility(View.VISIBLE);

        Call<LoginResponse> logResponseCall = apiCall.getLoginToken(params);
        logResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                pgBar.setVisibility(View.GONE);

                if (response.body() != null) {
                    data = response.body().getData();
                    authToken=data.getToken();
                    status = data.getStatus();
                    Toast.makeText(LoginPage.this, authToken, Toast.LENGTH_SHORT).show();

//                    Log.e("token", authToken);
                    SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("token", authToken);
                    editor.commit();

                    Intent newIntent;
                    if(status.equals("filled")){

                        newIntent = new Intent(getApplicationContext(), HomePage.class);
                    }else {
                        newIntent = new Intent(getApplicationContext(), PersonalDetails.class);
                    }
                    startActivity(newIntent);

                } else {

                    Toast.makeText(LoginPage.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                pgBar.setVisibility(View.GONE);
                Toast.makeText(LoginPage.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
