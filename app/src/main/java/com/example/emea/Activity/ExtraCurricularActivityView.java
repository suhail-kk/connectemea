package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.getDetails.AdditionalCourseItem;
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.DegreeItem;
import com.example.emea.Response.getDetails.EducationDetails;
import com.example.emea.Response.getDetails.ExtraCurricularItem;
import com.example.emea.Response.getDetails.GetResponse;
//import com.example.emea.Response.getDetails.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtraCurricularActivityView extends AppCompatActivity {

    ImageView editextracurricular, backbutton;
    ImageView edit;
    TextView topNav;
    RecyclerView recyclerView,recyclerView2;
    ApiCall apiCall;
    String authtoken;
    Data data;
    EducationDetails educationaldetails;
    List<ExtraCurricularItem> extraCurricularItem;
    ExtracurricularAdapter adapter1;
    List<AdditionalCourseItem> additionalCourseItem;
    AdditionalCourseAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curricular_view);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        topNav = findViewById(R.id.title_top_nav);
        String getText = topNav.getText().toString();
        topNav.setText("Extra Curricular Activities");

        editextracurricular = findViewById(R.id.edit);

        edit = findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent perIntent = new Intent(getApplicationContext(), PersonalEdit.class);
                startActivity(perIntent);

            }
        });

        backbutton = findViewById(R.id.backBtn);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent depIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(depIntent);

            }
        });

        edit = findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent newIntent = new Intent(getApplicationContext(), EducationEdit.class);
                startActivity(newIntent);


            }
        });


        recyclerView2 = findViewById(R.id.recycler_additional);
        recyclerView=findViewById(R.id.recycler_extra);
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));


        Call<GetResponse> educationCall = apiCall.getDetailsView(authtoken);
        educationCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

                data = response.body().getData();
                 educationaldetails = data.getEducationDetails();
                extraCurricularItem= educationaldetails.getExtraCurricular();
                additionalCourseItem=educationaldetails.getAdditionalCourse();

                setupAdapter();
                setupAdapter2();
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(ExtraCurricularActivityView.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void setupAdapter() {

        adapter1 = new ExtracurricularAdapter(getApplicationContext(),  extraCurricularItem, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter1);


    }
    public void setupAdapter2() {
        adapter2 = new AdditionalCourseAdapter(getApplicationContext(), additionalCourseItem, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapter2);


    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}




