package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.emea.R;

import java.util.Calendar;

public class PersonalDetails extends AppCompatActivity {

    private static final String TAG = "Personal Details";

    EditText DisplayDate;
    ImageButton imageButton;
    DatePickerDialog.OnDateSetListener DateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        DisplayDate = (EditText) findViewById(R.id.Birth);
        imageButton=findViewById(R.id.Birthi);
//drpodown

        final AutoCompleteTextView actv1 = (AutoCompleteTextView) findViewById(R.id.Gender);
        ImageView image = (ImageView) findViewById(R.id.Genderi);
        final AutoCompleteTextView actv2 = (AutoCompleteTextView) findViewById(R.id.Bloodgroup);
        ImageView image1 = (ImageView) findViewById(R.id.Bloodi);
        final AutoCompleteTextView actv3 = (AutoCompleteTextView) findViewById(R.id.Marriage);
        ImageView image2 = (ImageView) findViewById(R.id.Marriagei);
        final AutoCompleteTextView actv4 = (AutoCompleteTextView) findViewById(R.id.Caste);
        ImageView image3 = (ImageView) findViewById(R.id.Castei);
        final AutoCompleteTextView actv5 = (AutoCompleteTextView) findViewById(R.id.Religion);
        ImageView image4 = (ImageView) findViewById(R.id.Religioni);

        //calendar

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog  dialog = new DatePickerDialog(
                        PersonalDetails.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        DateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        DateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                DisplayDate.setText(date);
            }
        };


//dropdown

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Gender);
        actv1.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,BloodGroup);
        actv2.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Marriage);
        actv3.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Caste);
        actv4.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,Religion);
        actv5.setAdapter(adapter4);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv1.showDropDown();
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv2.showDropDown();
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv3.showDropDown();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv4.showDropDown();
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actv5.showDropDown();
            }
        });


    }

    private static final String[] Gender = new String[]{"Male", "Female"};
    private static final String[] BloodGroup = new String[]{"A+", "B+","o+","AB+", "A-","B-", "o-","AB-"};
    private static final String[] Marriage = new String[]{"single", "married"};
    private static final String[] Caste = new String[]{"OBC", "SC","ST"};
    private static final String[] Religion = new String[]{"Islam", "Hindu","Christian","Nil"};


}
