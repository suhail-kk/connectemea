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
import com.example.emea.Response.edit.EditResponse;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.FamilyDetails;
import com.example.emea.Response.getDetails.Father;
import com.example.emea.Response.getDetails.Gardian;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.Mother;
import com.example.emea.Response.getDetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyEdit extends AppCompatActivity {

    ApiCall apiCall;
    ProgressBar pgBar;
    TextView fathername, fathereducation, fatheroccupation, fatherincome,fatherofficial;
    TextView mothername, mothereducation, motheroccupation, motherincome,motherofficial;
    TextView guardianname, guardianeducation, guardianoccupation, guardianincome,gardianofficial;
String textfatherofficialaddress,textmotherofficialaddress,textgardianofficialaddress;
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
    String status;
    Data data;
    Student student;
    FamilyDetails familyDetails;
    Father father;
    Mother mother;
    Gardian gardian;
    String userid;
    boolean details;
com.example.emea.Response.edit.Data data1;
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
//        pgBar.setVisibility(View.VISIBLE);
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
                fathername = (TextView) findViewById(R.id.fname);
                fathername.setText(textfathername);

                textfathereducation = father.getEducationQualification();
                fathereducation = (TextView) findViewById(R.id.feducation);
                fathereducation.setText(textfathereducation);

                textfatheroccupation = father.getOccupation();
                fatheroccupation = (TextView) findViewById(R.id.foccupation);
                fatheroccupation.setText(textfatheroccupation);

                textfatherofficialaddress = father.getOfficialAddress();
                fatherofficial = (TextView) findViewById(R.id.fofficailaaddress);
                fatherofficial.setText(textfatherofficialaddress);

                textfatherincome = father.getAnnualIncome();
                fatherincome = (TextView) findViewById(R.id.fincome);
                fatherincome.setText(String.valueOf(textfatherincome));

                textmothername = mother.getName();
                mothername = (TextView) findViewById(R.id.mname);
                mothername.setText(textmothername);

                textmothereducation = mother.getEducationQualification();
                mothereducation = (TextView) findViewById(R.id.meducation);
                mothereducation.setText(textmothereducation);

                textmotheroccupation = mother.getOccupation();
                motheroccupation = (TextView) findViewById(R.id.moccupation);
                motheroccupation.setText(textmotheroccupation);

                textmotherincome = mother.getAnnualIncome();
                motherincome = (TextView) findViewById(R.id.mincome);
                motherincome.setText(String.valueOf(textmotherincome));

                textmotherofficialaddress = father.getOfficialAddress();
                motherofficial = (TextView) findViewById(R.id.mofficailaaddress);
                motherofficial.setText(textmotherofficialaddress);

                textguardianname = gardian.getName();
                guardianname = (TextView) findViewById(R.id.gname);
                guardianname.setText(textguardianname);

                textguardianeducation = gardian.getEducationQualification();
                guardianeducation = (TextView) findViewById(R.id.geducation);
                guardianeducation.setText(textguardianeducation);

                textguardianoccupation = gardian.getOccupation();
                guardianoccupation = (TextView) findViewById(R.id.goccupation);
                guardianoccupation.setText(textguardianoccupation);

                textguardianincome = gardian.getAnnualIncome();
                guardianincome = (TextView) findViewById(R.id.gincome);
                guardianincome.setText(textguardianincome);

                textgardianofficialaddress = father.getOfficialAddress();
                gardianofficial = (TextView) findViewById(R.id.gofficailaaddress);
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
                textfatherofficialaddress=fatherofficial.getText().toString();

                textmothername = mothername.getText().toString();
                textmothereducation = mothereducation.getText().toString();
                textmotheroccupation = motheroccupation.getText().toString();
                textmotherincome = Integer.parseInt(motherincome.getText().toString());
                textmotherofficialaddress=motherofficial.getText().toString();

                textguardianname = guardianname.getText().toString();
                textguardianeducation = guardianeducation.getText().toString();
                textguardianoccupation = guardianoccupation.getText().toString();
                textguardianincome = guardianincome.getText().toString();
                textgardianofficialaddress=gardianofficial.getText().toString();


//                getFamilyViewList(textfathername,textfathereducation,textfatheroccupation,textfatherincome,
//                        textmothername,textmothereducation,textmotheroccupation,textmotherincome,
//                        textguardianname,textguardianeducation,textguardianoccupation,textguardianincome
//                       ,textfatherofficialaddress,textgardianofficialaddress,textmotherofficialaddress);
//
//            }
//        });
//
//    }
//
//    public void getFamilyViewList(String textfathername,String textfathereducation,String textfatheroccupation,
//                                  int textfatherincome, String textmothername,String textmothereducation,
//                                  String textmotheroccupation,int textmotherincome, String textguardianname,
//                                  String textguardianeducation,String textguardianoccupation,String textguardianincome,String textfatherofficialaddress,
//                                  String textgardianofficialaddress,String textmotherofficialaddress){

//        HashMap<String, String> params = new HashMap<>();
//        params.put("father_name",textfathername);
//        params.put("edu_qualification_father",textfathereducation);
//        params.put("occupation_father",textfatheroccupation);
//        params.put("annual_income_father",textfatherincome);
//        params.put("mother_name",textmothername);
//        params.put("edu_qualification_mother",textmothereducation);
//        params.put("occupation_mother",textmotheroccupation);
//        params.put("annual_income_mother",textmotherincome);
//        params.put("guardian_name",textguardianname);
//        params.put("edu_qualification_guardian",textguardianeducation);
//        params.put("occupation_guardian",textguardianoccupation);
//        params.put("annual_income_guardian",textguardianincome);

//        HashMap<String, Object> familyDetails = new HashMap<>();
        HashMap<String, Object> father = new HashMap<>();
        father.put("name", textfathername);
        father.put("educationQualification", textfathereducation);
        father.put("annualIncome", textfatherincome);
        father.put("occupation", textfatheroccupation);
        father.put("officialAddress", textfatherofficialaddress);



//        family.add(father);
//        familyDetails.put("father",father);

        HashMap<String, Object> mother = new HashMap<>();
        mother.put("name", textmothername);
        mother.put("educationQualification", textmothereducation);
        mother.put("annualIncome", textmotherincome);
        mother.put("occupation", textmotheroccupation);
        mother.put("officialAddress", textmotherofficialaddress);
//        familyDetails.put("mother",mother);

//        family.add(mother);

        HashMap<String, Object> gardian = new HashMap<>();
        gardian.put("name", textguardianname);
        gardian.put("educationQualification", textguardianeducation);
        gardian.put("annualIncome", textguardianincome);
        gardian.put("occupation", textguardianoccupation);
        gardian.put("officialAddress", textgardianofficialaddress);
//        familyDetails.put("gardian",gardian);

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);



                getEditList(father,mother,gardian);
            }
        });
    }

    private void getEditList(HashMap<String, Object> father, HashMap<String, Object> mother, HashMap<String, Object> gardian ) {

        HashMap<String, Object> familyDetails = new HashMap<>();


        familyDetails.put("father",father);
        familyDetails.put("mother",mother);
        familyDetails.put("gardian",gardian);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

//        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
//         userid = (pref.getString("_id", ""));


        Call<EditResponse> familyeditCall = apiCall.getEdit(userid,familyDetails,authtoken);
        familyeditCall.enqueue(new Callback<EditResponse>() {
            @Override
            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {

//                status = response.body().getStatus();

                    Toast.makeText(FamilyEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                    Intent newIntent = new Intent(getApplicationContext(), FamilyDetailsView.class);
                    startActivity(newIntent);

//                    Toast.makeText(FamilyEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onFailure(Call<EditResponse> call, Throwable t) {
                Toast.makeText(FamilyEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
