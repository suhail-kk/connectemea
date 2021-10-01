package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.FamilyEditResponse;
import com.example.emea.Response.FamilyViewResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyEdit extends AppCompatActivity {

    ApiCall apiCall;
    ProgressBar pgBar;
    TextView fathername, fathereducation, fatheroccupation, fatherincome;
    TextView mothername, mothereducation, motheroccupation, motherincome;
    TextView guardianname, guardianeducation, guardianoccupation, guardianincome;

    String textfathername, textfathereducation, textfatheroccupation, textfatherincome;
    String textmothername, textmothereducation, textmotheroccupation, textmotherincome;
    String textguardianname, textguardianeducation, textguardianoccupation, textguardianincome;
    String authtoken;
    String status;

    Button saveinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);

        saveinfo = findViewById(R.id.savefamily);
        pgBar=findViewById(R.id.progressBar3);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgBar.setVisibility(View.VISIBLE);
        Call<FamilyViewResponse> familyCall = apiCall.getFamilyView(authtoken);
        familyCall.enqueue(new Callback<FamilyViewResponse>() {
            @Override
            public void onResponse(Call<FamilyViewResponse> call, Response<FamilyViewResponse> response) {
                pgBar.setVisibility(View.GONE);
                textfathername = response.body().getFatherName();
                fathername = (TextView) findViewById(R.id.fname);
                fathername.setText(textfathername);

                textfathereducation = response.body().getEduQualificationFather();
                fathereducation = (TextView) findViewById(R.id.feducation);
                fathereducation.setText(textfathereducation);

                textfatheroccupation = response.body().getOccupationFather();
                fatheroccupation = (TextView) findViewById(R.id.foccupation);
                fatheroccupation.setText(textfatheroccupation);

                textfatherincome = response.body().getAnnualIncomeFather();
                fatherincome = (TextView) findViewById(R.id.fincome);
                fatherincome.setText(textfatherincome);

                textmothername = response.body().getMotherName();
                mothername = (TextView) findViewById(R.id.mname);
                mothername.setText(textmothername);

                textmothereducation = response.body().getEduQualificationMother();
                mothereducation = (TextView) findViewById(R.id.meducation);
                mothereducation.setText(textmothereducation);

                textmotheroccupation = response.body().getOccupationMother();
                motheroccupation = (TextView) findViewById(R.id.moccupation);
                motheroccupation.setText(textmotheroccupation);

                textmotherincome = response.body().getAnnualIncomeMother();
                motherincome = (TextView) findViewById(R.id.mincome);
                motherincome.setText(textmotherincome);

                textguardianname = response.body().getGuardianName();
                guardianname = (TextView) findViewById(R.id.gname);
                guardianname.setText(textguardianname);

                textguardianeducation = response.body().getEduQualificationGuardian();
                guardianeducation = (TextView) findViewById(R.id.geducation);
                guardianeducation.setText(textguardianeducation);

                textguardianoccupation = response.body().getOccupationGuardian();
                guardianoccupation = (TextView) findViewById(R.id.goccupation);
                guardianoccupation.setText(textguardianoccupation);

                textguardianincome = response.body().getAnnualIncomeGuardian();
                guardianincome = (TextView) findViewById(R.id.gincome);
                guardianincome.setText(textguardianincome);

            }

            @Override
            public void onFailure(Call<FamilyViewResponse> call, Throwable t) {
                pgBar.setVisibility(View.GONE);
                Toast.makeText(FamilyEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), FamilyDetailsView.class);
                startActivity(myIntent);

                textfathername = fathername.getText().toString();
                textfathereducation = fathereducation.getText().toString();
                textfatheroccupation = fatheroccupation.getText().toString();
                textfatherincome = fatherincome.getText().toString();

                textmothername = mothername.getText().toString();
                textmothereducation = mothereducation.getText().toString();
                textmotheroccupation = motheroccupation.getText().toString();
                textmotherincome = motherincome.getText().toString();

                textguardianname = guardianname.getText().toString();
                textguardianeducation = guardianeducation.getText().toString();
                textguardianoccupation = guardianoccupation.getText().toString();
                textguardianincome = guardianincome.getText().toString();

                getFamilyViewList(textfathername,textfathereducation,textfatheroccupation,textfatherincome,
                        textmothername,textmothereducation,textmotheroccupation,textmotherincome,
                        textguardianname,textguardianeducation,textguardianoccupation,textguardianincome);

            }
        });

    }

    public void getFamilyViewList(String textfathername,String textfathereducation,String textfatheroccupation,
                                  String textfatherincome, String textmothername,String textmothereducation,
                                  String textmotheroccupation,String textmotherincome, String textguardianname,
                                  String textguardianeducation,String textguardianoccupation,String textguardianincome){

        HashMap<String, String> params = new HashMap<>();
        params.put("father_name",textfathername);
        params.put("edu_qualification_father",textfathereducation);
        params.put("occupation_father",textfatheroccupation);
        params.put("annual_income_father",textfatherincome);
        params.put("mother_name",textmothername);
        params.put("edu_qualification_mother",textmothereducation);
        params.put("occupation_mother",textmotheroccupation);
        params.put("annual_income_mother",textmotherincome);
        params.put("guardian_name",textguardianname);
        params.put("edu_qualification_guardian",textguardianeducation);
        params.put("occupation_guardian",textguardianoccupation);
        params.put("annual_income_guardian",textguardianincome);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        Call<FamilyEditResponse> familyeditCall = apiCall.getFamilyEdit(params,authtoken);
        familyeditCall.enqueue(new Callback<FamilyEditResponse>() {
            @Override
            public void onResponse(Call<FamilyEditResponse> call, Response<FamilyEditResponse> response) {

                status = response.body().getStatus();

                if (status.equals("Success")) {
                    Toast.makeText(FamilyEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FamilyEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<FamilyEditResponse> call, Throwable t) {
                Toast.makeText(FamilyEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
