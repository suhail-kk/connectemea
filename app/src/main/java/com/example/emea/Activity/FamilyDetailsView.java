package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.FamilyViewResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetailsView extends AppCompatActivity {

    TextView topNav;

    ApiCall apiCall;

    TextView fathername, fathereducation, fatheroccupation, fatherincome;
    TextView mothername, mothereducation, motheroccupation, motherincome;
    TextView guardianname, guardianeducation, guardianoccupation, guardianincome;

    String textfathername, textfathereducation, textfatheroccupation, textfatherincome;
    String textmothername, textmothereducation, textmotheroccupation, textmotherincome;
    String textguardianname, textguardianeducation, textguardianoccupation, textguardianincome;
    String authtoken;

    ImageView editfamily;
    ImageView backbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details_view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");

        editfamily = findViewById(R.id.edit);

        editfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent famIntent = new Intent(getApplicationContext(), FamilyEdit.class);
                startActivity(famIntent);

            }
        });

        backbutton = findViewById(R.id.backBtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent famIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(famIntent);

            }
        });

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        Call<FamilyViewResponse> familyCall = apiCall.getFamilyView(authtoken);
        familyCall.enqueue(new Callback<FamilyViewResponse>() {
            @Override
            public void onResponse(Call<FamilyViewResponse> call, Response<FamilyViewResponse> response) {

                textfathername = response.body().getFatherName();
                fathername = (TextView) findViewById(R.id.ftrname);
                fathername.setText(textfathername);

                textfathereducation = response.body().getEduQualificationFather();
                fathereducation = (TextView) findViewById(R.id.ftredu);
                fathereducation.setText(textfathereducation);

                textfatheroccupation = response.body().getOccupationFather();
                fatheroccupation = (TextView) findViewById(R.id.ftroccu);
                fatheroccupation.setText(textfatheroccupation);

                textfatherincome = response.body().getAnnualIncomeFather();
                fatherincome = (TextView) findViewById(R.id.ftrinc);
                fatherincome.setText(textfatherincome);

                textmothername = response.body().getMotherName();
                mothername = (TextView) findViewById(R.id.mtrname);
                mothername.setText(textmothername);

                textmothereducation = response.body().getEduQualificationMother();
                mothereducation = (TextView) findViewById(R.id.mtredu);
                mothereducation.setText(textmothereducation);

                textmotheroccupation = response.body().getOccupationMother();
                motheroccupation = (TextView) findViewById(R.id.mtroccu);
                motheroccupation.setText(textmotheroccupation);

                textmotherincome = response.body().getAnnualIncomeMother();
                motherincome = (TextView) findViewById(R.id.mtrinc);
                motherincome.setText(textmotherincome);

                textguardianname = response.body().getGuardianName();
                guardianname = (TextView) findViewById(R.id.grdname);
                guardianname.setText(textguardianname);

                textguardianeducation = response.body().getEduQualificationGuardian();
                guardianeducation = (TextView) findViewById(R.id.grdedu);
                guardianeducation.setText(textguardianeducation);

                textguardianoccupation = response.body().getOccupationGuardian();
                guardianoccupation = (TextView) findViewById(R.id.grdoccu);
                guardianoccupation.setText(textguardianoccupation);

                textguardianincome = response.body().getAnnualIncomeGuardian();
                guardianincome = (TextView) findViewById(R.id.grdinc);
                guardianincome.setText(textguardianincome);

            }

            @Override
            public void onFailure(Call<FamilyViewResponse> call, Throwable t) {

                Toast.makeText(FamilyDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }
//    public boolean onOptionsItemSelected(MenuItem item){
//        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
//        startActivityForResult(myIntent, 0);
//        return true;
//    }
}