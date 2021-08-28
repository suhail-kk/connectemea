package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.emea.Fragments.HomePage;
import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.ForgotResponse;
import com.example.emea.Response.RegisterResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    EditText txtEmail, txtfullname;
    Button btnReset;
    String inputEmail, inputfullname;
    ApiCall apiCall;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String status;
    String authentoken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        txtEmail = findViewById(R.id.forgot_email);
        txtfullname = findViewById(R.id.forgotfullname);
        btnReset = findViewById(R.id.resetPassword);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 inputEmail = txtEmail.getText().toString();
               inputfullname = txtfullname.getText().toString();


        //        boolean check = ValidateInfo(inputEmail);

//                if (check == true) {
//                    Intent newIntent = new Intent(getApplicationContext(), HomePage.class);
//                    startActivity(newIntent);
//
//                }
                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
                getForgotList(inputEmail, inputfullname);
            }
        });
    }

//    private boolean ValidateInfo(String inputEmail) {
//        if (inputEmail.length() == 0) {
//            txtEmail.requestFocus();
//            txtEmail.setError("Field cannot be empty");
//            return false;
//        } else if (!inputEmail.matches(emailPattern)) {
//            txtEmail.requestFocus();
//            txtEmail.setError("Please enter a valid email address");
//            return false;
//        } else {
//            return true;
//        }
//    }


    public void getForgotList(String inputEmail, String inputfullname) {

//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        SharedPreferences.Editor editor = shared.edit();
//        editor.putString("token", authentoken);
//        editor.commit();
        HashMap<String, String> params = new HashMap<>();

        params.put("name", inputfullname);
        params.put("email", inputEmail);

        Call<ForgotResponse> ForgotCall = apiCall.getForgot(params);
        ForgotCall.enqueue(new Callback<ForgotResponse>() {
            @Override
            public void onResponse(Call<ForgotResponse> call, Response<ForgotResponse> response) {

             //   ForgotResponse forgotResponse = response.body();
//                authentoken = response.headers().get("token");
                if (response.body() != null) {
                    authentoken = response.headers().get("token");
                    SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                    SharedPreferences.Editor editor = shared.edit();
                    editor.putString("token", authentoken);
                    editor.commit();
                    Log.e("tokenTAG", "Token : " + authentoken);

                    Toast.makeText(ForgotPassword.this, "Added ", Toast.LENGTH_SHORT).show();

                        Intent newIntent = new Intent(getApplicationContext(),RecoveryPassword.class);
                        startActivity(newIntent);

                }
             //   Toast.makeText(context, ForgotPassword.getMessage() + "", Toast.LENGTH_SHORT).show();

//                if (response.body() != null) {
////
//
//                    status = response.body().getStatus();
//
//                    if (status.equals("success")) {
////                                            status = response.body().getStatus();
//
//
//                        Toast.makeText(ForgotPassword.this, "Added ", Toast.LENGTH_SHORT).show();
//
//                        Intent newIntent = new Intent(getApplicationContext(),RecoveryPassword.class);
//                        startActivity(newIntent);
//                    }
                    else {
                        Toast.makeText(ForgotPassword.this, "Register Failed.", Toast.LENGTH_SHORT).show();
                    }

//                } else {
//                    Toast.makeText(ForgotPassword.this, " error.", Toast.LENGTH_SHORT).show();
//                }
            }


            @Override
            public void onFailure(Call<ForgotResponse> call, Throwable t) {
                Toast.makeText(ForgotPassword.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}