package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.emea.Response.reset.ResetResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecoveryPassword extends AppCompatActivity {
    String inputPassword,inputConfirmPassword;
    ApiCall apiCall;
    EditText txtPassword,txtConfirm;
    Button btnReset;
    String message;
    String authentoken;
    TextView txtRecovery;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);
        Intent intent=getIntent();
        authentoken=intent.getStringExtra("token");

        Toast.makeText(this, authentoken, Toast.LENGTH_SHORT).show();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);


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

                }
                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getRegisterResponse(inputPassword);

            }
        });
    }

    public void getRegisterResponse(String inputPassword) {

        HashMap<String, String> params = new HashMap<>();

        params.put("password", inputPassword);
        params.put("token",authentoken);

        Call<ResetResponse> RecoveryCall = apiCall.getrecoveryToken(params,authentoken);
        RecoveryCall.enqueue(new Callback<ResetResponse>() {
            @Override
            public void onResponse(Call<ResetResponse> call, Response<ResetResponse> response) {

                if (response.body() != null) {
                    message = response.body().getMessage();
                    Toast.makeText(RecoveryPassword.this, message, Toast.LENGTH_SHORT).show();
            }
                else {
                    Toast.makeText(RecoveryPassword.this, "Register error.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResetResponse> call, Throwable t) {
                Toast.makeText(RecoveryPassword.this, "failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
}