package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.FamilyDetails;
import com.example.emea.Response.getDetails.Father;
import com.example.emea.Response.getDetails.Gardian;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.Mother;
import com.example.emea.Response.getDetails.Student;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetailsView extends AppCompatActivity {

    TextView topNav;

    ApiCall apiCall;

    TextView fathername, fathereducation, fatheroccupation, fatherincome;
    TextView mothername, mothereducation, motheroccupation, motherincome;
    TextView guardianname, guardianeducation, guardianoccupation, guardianincome;

    String textfathername;
    String textfathereducation;
    String textfatheroccupation;
    int textfatherincome;
    String textmothername;
    String textmothereducation;
    String textmotheroccupation;
    int textmotherincome;
    String textguardianname, textguardianeducation, textguardianoccupation, textguardianincome;
    String authtoken;

    ImageView editfamily;
    ImageView backbutton;
    Data data;
    Student student;
    FamilyDetails familyDetails;
    Father father;
    Mother mother;
    Gardian gardian;


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

        Call<GetResponse> familyCall = apiCall.getDetailsView(authtoken);
        familyCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

                data = response.body().getData();
                student = data.getStudent();
                familyDetails = student.getFamilyDetails();
                 father = familyDetails.getFather();
                mother=familyDetails.getMother();
                gardian=familyDetails.getGardian();
                textfathername = father.getName();
                fathername = (TextView) findViewById(R.id.ftrname);
                fathername.setText(textfathername);

                textfathereducation = father.getEducationQualification();
                fathereducation = (TextView) findViewById(R.id.ftredu);
                fathereducation.setText(textfathereducation);

                textfatheroccupation = father.getOccupation();
                fatheroccupation = (TextView) findViewById(R.id.ftroccu);
                fatheroccupation.setText(textfatheroccupation);

                textfatherincome = father.getAnnualIncome();
                fatherincome = (TextView) findViewById(R.id.ftrinc);
                fatherincome.setText(String.valueOf(textfatherincome));

                textmothername = mother.getName();
                mothername = (TextView) findViewById(R.id.mtrname);
                mothername.setText(textmothername);

                textmothereducation = mother.getEducationQualification();
                mothereducation = (TextView) findViewById(R.id.mtredu);
                mothereducation.setText(textmothereducation);

                textmotheroccupation = mother.getOccupation();
                motheroccupation = (TextView) findViewById(R.id.mtroccu);
                motheroccupation.setText(textmotheroccupation);

                textmotherincome = mother.getAnnualIncome();
                motherincome = (TextView) findViewById(R.id.mtrinc);
                motherincome.setText(String.valueOf(textmotherincome));

                textguardianname = gardian.getName();
                guardianname = (TextView) findViewById(R.id.grdname);
                guardianname.setText(textguardianname);

                textguardianeducation = gardian.getEducationQualification();
                guardianeducation = (TextView) findViewById(R.id.grdedu);
                guardianeducation.setText(textguardianeducation);

                textguardianoccupation = gardian.getOccupation();
                guardianoccupation = (TextView) findViewById(R.id.grdoccu);
                guardianoccupation.setText(textguardianoccupation);

                textguardianincome = gardian.getAnnualIncome();
                guardianincome = (TextView) findViewById(R.id.grdinc);
                guardianincome.setText(textguardianincome);

            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {

                Toast.makeText(FamilyDetailsView.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

}