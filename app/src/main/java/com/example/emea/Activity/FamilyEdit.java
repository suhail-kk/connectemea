package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.FamilyDetails;
import com.example.emea.Response.getDetails.Father;
//import com.example.emea.Response.getDetails.Gardian;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.Guardian;
import com.example.emea.Response.getDetails.Mother;
//import com.example.emea.Response.getDetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyEdit extends AppCompatActivity {

    ApiCall apiCall;
    ProgressBar pgBar;
    TextView fathername, fathereducation, fatheroccupation, fatherincome, fatherofficial,
            mothername, mothereducation, motheroccupation, motherincome, motherofficial,
            guardianname, guardianeducation, guardianoccupation, guardianincome, gardianofficial,topNav;
    String textfatherofficialaddress, textmotherofficialaddress, textgardianofficialaddress,
            textfathername, textfathereducation, textfatheroccupation, textmothername, textmothereducation, textmotheroccupation, textguardianname,
            textguardianeducation, textguardianoccupation, textguardianincome, authtoken;

    int textmotherincome, textfatherincome;

    Data data;
    FamilyDetails familyDetails;
    Father father;
    ImageView backbutton;
    ImageView prevPage;
    Mother mother;
    Guardian guardian;
    String userid;
    Button saveinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);
        getSupportActionBar();

        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });
        topNav = findViewById(R.id.title_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");


        saveinfo = findViewById(R.id.savefamily);
        pgBar = findViewById(R.id.progressBar3);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgBar.setVisibility(View.VISIBLE);
        Call<GetResponse> familyCall = apiCall.getDetailsView(authtoken);
        familyCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                pgBar.setVisibility(View.GONE);
                data = response.body().getData();
                familyDetails = data.getFamilyDetails();
                father = familyDetails.getFather();
                mother = familyDetails.getMother();
                guardian = familyDetails.getGuardian();
                textfathername = father.getName();
                fathername = findViewById(R.id.fname);
                fathername.setText(textfathername);

                textfathereducation = father.getEducationQualification();
                fathereducation = findViewById(R.id.feducation);
                fathereducation.setText(textfathereducation);

                textfatheroccupation = father.getOccupation();
                fatheroccupation = findViewById(R.id.foccupation);
                fatheroccupation.setText(textfatheroccupation);

                textfatherofficialaddress = father.getOfficialAddress();
                fatherofficial = findViewById(R.id.fofficailaaddress);
                fatherofficial.setText(textfatherofficialaddress);

                textfatherincome = father.getAnnualIncome();
                fatherincome = findViewById(R.id.fincome);
                fatherincome.setText(String.valueOf(textfatherincome));

                textmothername = mother.getName();
                mothername = findViewById(R.id.mname);
                mothername.setText(textmothername);

                textmothereducation = mother.getEducationQualification();
                mothereducation = findViewById(R.id.meducation);
                mothereducation.setText(textmothereducation);

                textmotheroccupation = mother.getOccupation();
                motheroccupation = findViewById(R.id.moccupation);
                motheroccupation.setText(textmotheroccupation);

                textmotherincome = mother.getAnnualIncome();
                motherincome = findViewById(R.id.moincome);
                motherincome.setText(String.valueOf(textmotherincome));

                textmotherofficialaddress = mother.getOfficialAddress();
                motherofficial = findViewById(R.id.mofficialAddress);
                motherofficial.setText(textmotherofficialaddress);

                textguardianname = guardian.getName();
                guardianname = findViewById(R.id.gname);
                guardianname.setText(textguardianname);

                textguardianeducation = guardian.getEducationQualification();
                guardianeducation = findViewById(R.id.geducation);
                guardianeducation.setText(textguardianeducation);

                textguardianoccupation = guardian.getOccupation();
                guardianoccupation = findViewById(R.id.goccupation);
                guardianoccupation.setText(textguardianoccupation);

                textguardianincome = guardian.getAnnualIncome();
                guardianincome = findViewById(R.id.gincome);
                guardianincome.setText(textguardianincome);

                textgardianofficialaddress = guardian.getOfficialAddress();
                gardianofficial = findViewById(R.id.gofficailaaddress);
                gardianofficial.setText(textgardianofficialaddress);


            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {

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
                textfatherincome = Integer.parseInt(fatherincome.getText().toString());
                textfatherofficialaddress = fatherofficial.getText().toString();


                textmothername = mothername.getText().toString();
                textmothereducation = mothereducation.getText().toString();
                textmotheroccupation = motheroccupation.getText().toString();
                textmotherincome = Integer.parseInt(motherincome.getText().toString());
                textmotherofficialaddress = motherofficial.getText().toString();

                textguardianname = guardianname.getText().toString();
                textguardianeducation = guardianeducation.getText().toString();
                textguardianoccupation = guardianoccupation.getText().toString();
                textguardianincome = guardianincome.getText().toString();
                textgardianofficialaddress = gardianofficial.getText().toString();



                HashMap<String, Object> father = new HashMap<>();
                father.put("name", textfathername);
                father.put("educationQualification", textfathereducation);
                father.put("annualIncome", textfatherincome);
                father.put("occupation", textfatheroccupation);
                father.put("officialAddress", textfatherofficialaddress);


                HashMap<String, Object> mother = new HashMap<>();
                mother.put("name", textmothername);
                mother.put("educationQualification", textmothereducation);
                mother.put("annualIncome", textmotherincome);
                mother.put("occupation", textmotheroccupation);
                mother.put("officialAddress", textmotherofficialaddress);


                HashMap<String, Object> guardian = new HashMap<>();
                guardian.put("name", textguardianname);
                guardian.put("educationQualification", textguardianeducation);
                guardian.put("annualIncome", textguardianincome);
                guardian.put("occupation", textguardianoccupation);
                guardian.put("officialAddress", textgardianofficialaddress);

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getEditList(father, mother, guardian);
            }
        });
    }

    private void getEditList(HashMap<String, Object> father, HashMap<String, Object> mother, HashMap<String, Object> guardian) {

        HashMap<String, Object> familyDetails = new HashMap<>();


        familyDetails.put("father", father);
        familyDetails.put("mother", mother);
        familyDetails.put("guardian", guardian);

        HashMap<String, Object> editfamily = new HashMap<>();
        editfamily.put("familyDetails", familyDetails);

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
        userid = (pref.getString("_id", ""));


        Call<EditResponse> familyeditCall = apiCall.getfamilyedit(userid, editfamily, authtoken);
        familyeditCall.enqueue(new Callback<EditResponse>() {
            @Override
            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {
                Toast.makeText(FamilyEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(getApplicationContext(), FamilyDetailsView.class);
                startActivity(newIntent);
            }

            @Override
            public void onFailure(Call<EditResponse> call, Throwable t) {
                Toast.makeText(FamilyEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
