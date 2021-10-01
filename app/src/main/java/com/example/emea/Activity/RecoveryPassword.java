package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.RecoveryResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoveryPassword extends AppCompatActivity {
    String inputPassword,inputConfirmPassword;
    ApiCall apiCall;
    EditText txtPassword,txtConfirm;
    Button btnReset;
    String status;
    String authentoken;
    TextView txtRecovery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);


        txtRecovery = findViewById(R.id.changepassword);

        txtRecovery = findViewById(R.id.login);

//        Typeface typeface = ResourcesCompat.getFont(
//                this,
//                R.font.poppins_regular);
//        txtRecovery.setTypeface(typeface);


        txtPassword=findViewById(R.id.recovery_password);
        txtConfirm=findViewById(R.id.recovery_confirm_password);
        btnReset=findViewById(R.id.registerbutton);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputPassword = txtPassword.getText().toString();
                inputConfirmPassword = txtConfirm.getText().toString();
                if (!inputPassword.equals(inputConfirmPassword)) {
                    Toast.makeText(RecoveryPassword.this, "Password doesn't match.", Toast.LENGTH_SHORT).show();
                    //    return;
                }
                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getRegisterResponse(inputPassword);

            }
        });
    }

    public void getRegisterResponse(String inputPassword) {
        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authentoken = (shared.getString("token", ""));
        HashMap<String, String> params = new HashMap<>();

        params.put("password", inputPassword);
      params.put("token",authentoken);




        Call<RecoveryResponse> RecoveryCall = apiCall.getrecoveryToken(params);
        RecoveryCall.enqueue(new Callback<RecoveryResponse>() {
            @Override
            public void onResponse(Call<RecoveryResponse> call, Response<RecoveryResponse> response) {

                if (response.body() != null) {
                    status = response.body().getStatus();
                    if (status.equals("success")) {

                        Intent newIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(newIntent);

                    }
                    else {
                        Toast.makeText(RecoveryPassword.this, "Register Failed.", Toast.LENGTH_SHORT).show();
                    }
            }
                else {
                    Toast.makeText(RecoveryPassword.this, "Register error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RecoveryResponse> call, Throwable t) {
                Toast.makeText(RecoveryPassword.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}