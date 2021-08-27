package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.emea.R;

public class FamilyDetails extends AppCompatActivity {

    String ftr,ftrname,ftredu,ftroccu,ftrinc;
    String mtr,mtrname,mtredu,mtroccu,mtrinc;
    String grd,grdname,grdedu,grdoccu,grdinc;

    ScrollView scrollView;
    
    TextView father,mother,guardian;
    EditText fname,feducation,foccupation,fincome;
    EditText mname,meducation,moccupation,mincome;
    EditText gname,geducation,goccupation,gincome;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_details);

        scrollView = findViewById(R.id.FOccupation);

        father = findViewById(R.id.father);
        ftr = father.getText().toString();
        fname = findViewById(R.id.fname);
        ftrname = fname.getText().toString();
        feducation = findViewById(R.id.feducation);
        ftredu = feducation.getText().toString();
        foccupation = findViewById(R.id.foccupation);
        ftroccu = foccupation.getText().toString();
        fincome = findViewById(R.id.fincome);
        ftrinc = fincome.getText().toString();

        mother =findViewById(R.id.mother);
        mtr = mother.getText().toString();
        mname = findViewById(R.id.mname);
        mtrname = mname.getText().toString();
        meducation = findViewById(R.id.meducation);
        mtredu = meducation.getText().toString();
        moccupation = findViewById(R.id.moccupation);
        mtroccu = moccupation.getText().toString();
        mincome = findViewById(R.id.mincome);
        mtrinc = mincome.getText().toString();

        guardian = findViewById(R.id.guardian);
        grd = guardian.getText().toString();
        gname = findViewById(R.id.gname);
        grdname = gname.getText().toString();
        geducation = findViewById(R.id.geducation);
        grdedu = geducation.getText().toString();
        goccupation = findViewById(R.id.goccupation);
        grdoccu = goccupation.getText().toString();
        gincome = findViewById(R.id.gincome);
        grdinc = gincome.getText().toString();

        save = findViewById(R.id.save);

    }
}