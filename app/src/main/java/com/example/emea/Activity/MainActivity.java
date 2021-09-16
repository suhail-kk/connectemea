package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Response.LoggingResponse;
import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    TextInputEditText txtEmail, txtPassword;
Button btnLogin;
TextView btnforgot,btnregister,loginText;
    ProgressBar pgBar;
  //  TextView txtForgot;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String inputEmail;
    String inputPassword;
    ApiCall apiCall;
    String authToken;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);





        loginText = findViewById(R.id.login);
        Typeface typeface = ResourcesCompat.getFont(
                this,
                R.font.poppins_regular);
        loginText.setTypeface(typeface);



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



//                boolean check=ValidateInfo(inputEmail, inputPassword);


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

//        txtForgot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent newIntent = new Intent(getApplicationContext(), ForgotPassword.class);
//                startActivity(newIntent);
//            }
//        });
    }


    public void getLoginList(String inputEmail, String inputPassword) {
        HashMap<String, String> params = new HashMap<>();
        params.put("email", inputEmail);
        params.put("password", inputPassword);

        pgBar.setVisibility(View.VISIBLE);

        Call<LoggingResponse> logResponseCall = apiCall.getLoginToken(params);
        logResponseCall.enqueue(new Callback<LoggingResponse>() {
            @Override
            public void onResponse(Call<LoggingResponse> call, Response<LoggingResponse> response) {
                pgBar.setVisibility(View.GONE);

                if (response.body() != null) {
                    authToken = response.body().getToken();
                    Log.e("token", authToken);
                    SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("token", authToken);
                    editor.commit();

                    Intent newIntent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(newIntent);
                    

                } else {

                    Toast.makeText(MainActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoggingResponse> call, Throwable t) {

                pgBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });


//    public Boolean ValidateInfo(String inputEmail, String inputPassword) {
//        if (inputEmail.length() == 0) {
//            txtEmail.requestFocus();
//            txtEmail.setError("Field cannot be empty");
//            return false;
//        } else if (!inputEmail.matches(emailPattern)) {
//            txtEmail.requestFocus();
//            txtEmail.setError("Please enter a valid email address");
//            return false;
//        } else if (inputPassword.length() == 0) {
//            txtPassword.requestFocus();
//            txtPassword.setError("Field cannot be empty");
//            return false;
//        }
//        else {
//            return true;
//        }

    }
}
