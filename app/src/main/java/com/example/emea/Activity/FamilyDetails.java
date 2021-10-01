package com.example.emea.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.FamilyResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamilyDetails extends AppCompatActivity {

    String fathernamestring,fathereducationstring,fatheroccupationstring,fatherincomestring;
    String mothernamestring,mothereducationstring,motheroccupationstring,motherincomestring;
    String guardiannamestring,guardianeducationstring,guardianoccupationstring,guardianincomestring;

    ImageView prevPage;
    ScrollView scrollView;
    
    TextView father,mother,guardian,topNav;
    EditText fathernameedittext,fathereducationedittext,fatheroccupationedittext,fatherincomeedittext;
    EditText mothernameedittext,mothereducationedittext,motheroccupationedittext,motherincomeedittext;
    EditText guardiannameedittext,guardianeducationedittext,guardianoccupationedittext,guardianincomeedittext;

    Button save;

    ApiCall apiCall;
    String apifamilylist;
    String authentoken;

    int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);
        getSupportActionBar();

        topNav = findViewById(R.id.title_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Family Details");

        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });


      //  scrollView = findViewById(R.id.FOccupation);

        father = findViewById(R.id.father);
//        ftr = father.getText().toString();
        fathernameedittext = findViewById(R.id.fname);
//        ftrname = fname.getText().toString();
        fathereducationedittext = findViewById(R.id.feducation);
//        ftredu = feducation.getText().toString();
        fatheroccupationedittext = findViewById(R.id.foccupation);
//        ftroccu = foccupation.getText().toString();
        fatherincomeedittext = findViewById(R.id.fincome);
//        ftrinc = fincome.getText().toString();

        mother =findViewById(R.id.mother);
//        mtr = mother.getText().toString();
        mothernameedittext = findViewById(R.id.mname);
//        mtrname = mname.getText().toString();
        mothereducationedittext = findViewById(R.id.meducation);
//        mtredu = meducation.getText().toString();
        motheroccupationedittext = findViewById(R.id.moccupation);
//        mtroccu = moccupation.getText().toString();
        motherincomeedittext = findViewById(R.id.mincome);
//        mtrinc = mincome.getText().toString();

        guardian = findViewById(R.id.guardian);
//        grd = guardian.getText().toString();
        guardiannameedittext = findViewById(R.id.gname);
//        grdname = gname.getText().toString();
        guardianeducationedittext = findViewById(R.id.geducation);
//        grdedu = geducation.getText().toString();
        guardianoccupationedittext = findViewById(R.id.goccupation);
//        grdoccu = goccupation.getText().toString();
        guardianincomeedittext = findViewById(R.id.gincome);
//        grdinc = gincome.getText().toString();

        save = findViewById(R.id.savefamily);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ftr = father.getText().toString();
                fathernamestring = fathernameedittext.getText().toString();
                fathereducationstring = fathereducationedittext.getText().toString();
                fatheroccupationstring = fatheroccupationedittext.getText().toString();
                fatherincomestring = fatherincomeedittext.getText().toString();

//                mtr = mother.getText().toString();
                mothernamestring = mothernameedittext.getText().toString();
                mothereducationstring = mothereducationedittext.getText().toString();
                motheroccupationstring = motheroccupationedittext.getText().toString();
                motherincomestring = motherincomeedittext.getText().toString();

//                grd = guardian.getText().toString();
                guardiannamestring = guardiannameedittext.getText().toString();
                guardianeducationstring = guardianeducationedittext.getText().toString();
                guardianoccupationstring = guardianoccupationedittext.getText().toString();
                guardianincomestring = guardianincomeedittext.getText().toString();

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getFamilyList(fathernamestring, fathereducationstring, fatheroccupationstring, fatherincomestring,
                        mothernamestring, mothereducationstring, motheroccupationstring, motherincomestring,
                        guardiannamestring, guardianeducationstring, guardianoccupationstring, guardianincomestring);

            }
        });
    }

    public void getFamilyList( String fathernamestring, String fathereducationstring, String fatheroccupationstring,
                               String fatherincomestring, String mothernamestring, String mothereducationstring,
                               String motheroccupationstring, String motherincomestring,String guardiannamestring,
                               String guardianeducationstring, String guardianoccupationstring, String guardianincomestring){

        HashMap<String, String> params = new HashMap<>();
        params.put("father_name",this.fathernamestring);
        params.put("edu_qualification_father",this.fathereducationstring);
        params.put("occupation_father",this.fatheroccupationstring);
        params.put("annual_income_father",this.fatherincomestring);
        params.put("mother_name",this.mothernamestring);
        params.put("edu_qualification_mother",this.mothereducationstring);
        params.put("occupation_mother",this.motheroccupationstring);
        params.put("annual_income_mother",this.motherincomestring);
        params.put("guardian_name",this.guardiannamestring);
        params.put("edu_qualification_guardian",this.guardianeducationstring);
        params.put("occupation_guardian",this.guardianoccupationstring);
        params.put("annual_income_guardian",this.guardianincomestring);;


        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authentoken = (shared.getString("token", ""));

        Call<FamilyResponse> familyCall = apiCall.getFamily(params, authentoken);

        familyCall.enqueue(new Callback<FamilyResponse>() {
            @Override
            public void onResponse(Call<FamilyResponse> call, Response<FamilyResponse> response) {
                status = response.code();
                if (status != 400) {
                    apifamilylist = response.body().getStatus();

                    Toast.makeText(FamilyDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                    Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                    startActivity(perIntent);
                    finish();
                } else {
                    Toast.makeText(FamilyDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FamilyResponse> call, Throwable t) {

                Toast.makeText(FamilyDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}