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
import com.example.emea.Response.LoggingResponse;
import com.example.emea.Response.RegisterResponse;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPage extends AppCompatActivity {

    String inputUsername,inputEmail,inputPassword,inputConfirmPassword;
    ApiCall apiCall;
TextInputEditText username;
    TextInputEditText email;
    TextInputEditText password;
    TextInputEditText confirmpassword;
    Button btnregister;

    String status;
   String apiRegisterlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);


        username= findViewById(R.id.username);
        email=findViewById(R.id.email);
        btnregister=findViewById(R.id.button1);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmpassword);



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputUsername = username.getText().toString();
                inputEmail = email.getText().toString();
                inputPassword = password.getText().toString();
                inputConfirmPassword = confirmpassword.getText().toString();
                if (!inputPassword.equals(inputConfirmPassword)) {
                    Toast.makeText(RegisterPage.this, "Password doesn't match.", Toast.LENGTH_SHORT).show();
                //    return;
                }



                //api call

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getRegisterResponse(inputUsername,inputEmail,inputPassword);

            }
        });



    }

    public void getRegisterResponse( String inputEmail, String inputPassword, String inputUsername) {
        HashMap<String, String> params = new HashMap<>();
        params.put("email", inputEmail);
        params.put("password", inputPassword);
        params.put("name", inputUsername);
     //  params.put("confirmpassword", inputConfirmPassword);

     //   SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
                                 //    SharedPreferences.Editor editor = shared.edit();


        Call<RegisterResponse> RegisterCall = apiCall.getRegisterToken(params);
        RegisterCall.enqueue(new Callback<RegisterResponse>() {
                                 @Override
                                 public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                                     if (response.body() != null) {
//                                      //   authToken = response.body().getStatus();
//                                      //   Log.e("token", authToken);
//                                        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//                                         SharedPreferences.Editor editor = shared.edit();
//                                      //  editor.putString("token", authToken);
//                                        editor.commit();

                                         status = response.body().getStatus();
                                         //  status=response.toString();
                                         if (status == "success") {
                                             //   status = response.body().getStatus();
                                            //    apiRegisterlist = response.body().getStatus();

                                             Toast.makeText(RegisterPage.this, "Added Successfully.", Toast.LENGTH_SHORT).show();

                                             Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
                                             startActivity(newIntent);
                                         } else {
                                             Toast.makeText(RegisterPage.this, "Register Failed.", Toast.LENGTH_SHORT).show();
                                         }

                                     }else {
                                         Toast.makeText(RegisterPage.this, "Register error.", Toast.LENGTH_SHORT).show();
                                     }
                                 }


                                 @Override
                                 public void onFailure(Call<RegisterResponse> call, Throwable t) {
                                     Toast.makeText(RegisterPage.this, "failed", Toast.LENGTH_SHORT).show();

                                 }
                             });

                //   Toast.makeText(RegisterPage.this, "failed", Toast.LENGTH_SHORT).show();

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