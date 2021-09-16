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

    String ftr,ftrname,ftredu,ftroccu,ftrinc;
    String mtr,mtrname,mtredu,mtroccu,mtrinc;
    String grd,grdname,grdedu,grdoccu,grdinc;
    ImageView prevPage;
    ScrollView scrollView;
    
    TextView father,mother,guardian,topNav;
    EditText fname,feducation,foccupation,fincome;
    EditText mname,meducation,moccupation,mincome;
    EditText gname,geducation,goccupation,gincome;
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
        fname = findViewById(R.id.fname);
//        ftrname = fname.getText().toString();
        feducation = findViewById(R.id.feducation);
//        ftredu = feducation.getText().toString();
        foccupation = findViewById(R.id.foccupation);
//        ftroccu = foccupation.getText().toString();
        fincome = findViewById(R.id.fincome);
//        ftrinc = fincome.getText().toString();

        mother =findViewById(R.id.mother);
//        mtr = mother.getText().toString();
        mname = findViewById(R.id.mname);
//        mtrname = mname.getText().toString();
        meducation = findViewById(R.id.meducation);
//        mtredu = meducation.getText().toString();
        moccupation = findViewById(R.id.moccupation);
//        mtroccu = moccupation.getText().toString();
        mincome = findViewById(R.id.mincome);
//        mtrinc = mincome.getText().toString();

        guardian = findViewById(R.id.guardian);
//        grd = guardian.getText().toString();
        gname = findViewById(R.id.gname);
//        grdname = gname.getText().toString();
        geducation = findViewById(R.id.geducation);
//        grdedu = geducation.getText().toString();
        goccupation = findViewById(R.id.goccupation);
//        grdoccu = goccupation.getText().toString();
        gincome = findViewById(R.id.gincome);
//        grdinc = gincome.getText().toString();

        save = findViewById(R.id.savefamily);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ftr = father.getText().toString();
                ftrname = fname.getText().toString();
                ftredu = feducation.getText().toString();
                ftroccu = foccupation.getText().toString();
                ftrinc = fincome.getText().toString();

//                mtr = mother.getText().toString();
                mtrname = mname.getText().toString();
                mtredu = meducation.getText().toString();
                mtroccu = moccupation.getText().toString();
                mtrinc = mincome.getText().toString();

//                grd = guardian.getText().toString();
                grdname = gname.getText().toString();
                grdedu = geducation.getText().toString();
                grdoccu = goccupation.getText().toString();
                grdinc = gincome.getText().toString();

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                getFamilyList(ftrname, ftredu, ftroccu, ftrinc, mtrname, mtredu, mtroccu, mtrinc, grdname, grdedu, grdoccu, grdinc);

            }
        });
    }

    public void getFamilyList(String ftrname,String ftredu,String ftroccu,String ftrinc,String mtrname,String mtredu,String mtroccu,String mtrinc,String grdname,String grdedu,String grdoccu,String grdinc){

        HashMap<String, String> params = new HashMap<>();
        params.put("father_name",this.ftrname);
        params.put("edu_qualification_father",this.ftredu);
        params.put("occupation_father",this.ftroccu);
        params.put("annual_income_father",this.ftrinc);
        params.put("mother_name",this.mtrname);
        params.put("edu_qualification_mother",this.mtredu);
        params.put("occupation_mother",this.mtroccu);
        params.put("annual_income_mother",this.mtrinc);
        params.put("guardian_name",this.grdname);
        params.put("edu_qualification_guardian",this.grdedu);
        params.put("occupation_guardian",this.grdoccu);
        params.put("annual_income_guardian",this.grdinc);


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