package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class ExtraCurricularActivity extends AppCompatActivity {

    RecyclerView recyclerExtraCurricular;
    String textactivity, textprice, textyearofparticipation, textdetailsofexcellence;
    TextInputEditText activity, price, yearofparticipation, detailsofexcellence;
    Button addextraactivity, saveinfo;
    LinearLayout add;
    String authentoken;
    ApiCall apiCall;

//    Button Remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_extra_curricular_activity);

        Intent intent = getIntent();
        HashMap<String, Object> personalDetails = (HashMap<String, Object>) intent.getSerializableExtra("personalDetails");
        HashMap<String, Object> educationDetails = (HashMap<String, Object>) intent.getSerializableExtra("educationDetails");

        recyclerExtraCurricular = findViewById(R.id.extracurricularrecycler);
        saveinfo=findViewById(R.id.saveinfo);

        activity = findViewById(R.id.activityName);
        price = findViewById(R.id.priceActivity);
        yearofparticipation = findViewById(R.id.yearOfParicipation);
        detailsofexcellence = findViewById(R.id.detailsofexcellence);
        addextraactivity = findViewById(R.id.addExtraActivity);


//        addextraactivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                add.setVisibility(View.VISIBLE);
////                Remove.setOnClickListener(new View.OnClickListener() {
////                    @Override
////                    public void onClick(View v) {
////                        add.setVisibility(View.GONE);
////
////                    }
////                });
//            }
//        });

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textactivity = activity.getText().toString();
                textprice = price.getText().toString();
                textyearofparticipation = yearofparticipation.getText().toString();
                textdetailsofexcellence = detailsofexcellence.getText().toString();




                HashMap<String, Object> extraCurricular1 = new HashMap<>();
                extraCurricular1.put("activity", textactivity);
                extraCurricular1.put("yearOfParticipation", textyearofparticipation);
                extraCurricular1.put("Price", textprice);
                extraCurricular1.put("detailsOfExcellenceInPerformance", textdetailsofexcellence);
//

                Object[] extraCurricular = {extraCurricular1};
//
//
//                HashMap<String, Object> extraCurricular = new HashMap<>();
//                extraCurricular.put("extraCurricular",extraCurricular);
//
                educationDetails.put("extraCurricular",extraCurricular);
//
//


                Intent newIntent = new Intent(ExtraCurricularActivity.this, FamilyDetails.class);
//                newIntent.putExtra("personal",personal);
                newIntent.putExtra("personalDetails", personalDetails);
                newIntent.putExtra("educationDetails", educationDetails);
//                newIntent.putExtra("extraCurricular", extraCurricular);


                startActivity(newIntent);
            }
        });

    }
}
//    public void getExtraCurricularList (String textactivity, String textprice,
//                                        String textyearofparticipation, String textdetailsofexcellence) {
//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authentoken = (shared.getString("token", ""));
//    }
//}