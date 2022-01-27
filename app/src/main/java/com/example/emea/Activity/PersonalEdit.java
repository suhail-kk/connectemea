package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.PersonalDetails;
//import com.example.emea.Response.getDetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalEdit extends AppCompatActivity {

    String status;

    TextView dateofbirthedit, nameedit, admissionnoedit, Mobilenumber, Distance,emailField
    , yearofadmissionedit, religionedit, casteedit, identificationmark1edit, identificationmark2edit
    , permenentaddressedit, presentaddressedit;
    String dateOfBirtheditField, nameeditField, admissionNoeditField, rollNoeditField, yearOfAdmissioneditField, religioneditField, casteeditField
    , identificationMark1editField, identificationMark2editField, permenentAddresseditField, presentAddresseditField, textgender, textmarital, textadmcategory, textblood, textdepartment
    ,  textdistancekm, textresidingat;
    int textmobilenumber;
String emaileditField,authtoken;
    TextView textNav;
    ImageView addImage, prevPage;
    ApiCall apiCall;
    ProgressBar pgbar1;
    Button saveinfo;
    Data data;
    PersonalDetails personaldetails;

    AutoCompleteTextView bloodgroupdropdown;
    AutoCompleteTextView admissioncategorydropdown;
    AutoCompleteTextView genderdropdown;
    AutoCompleteTextView maritalstatusdropdown;
    AutoCompleteTextView departmentdropdown, residedropdown;


    ArrayAdapter<String> Blood;
    ArrayAdapter<String> Gender;
    ArrayAdapter<String> Admission;
    ArrayAdapter<String> Marital;
    ArrayAdapter<String> Department;
    ArrayAdapter<String> Reside;

    private static final int IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);

        pgbar1 = findViewById(R.id.progressBar1);

        String bloodgroup[] = {"A+", "B+"};
        String admission[] = {"management","merit"};
        String gender[] = {"male", "female"};
        String marital[] = {"married", "unmarried"};
        String department[] = {"Chemistry", "Geology", "CA"};
        String reside[] = {"home", "hostel"};

        prevPage = findViewById(R.id.backBtn);
        prevPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perIntent = new Intent(getApplicationContext(), HomePage.class);
                startActivity(perIntent);
            }
        });

        textNav = findViewById(R.id.title_nav);
        String getText = textNav.getText().toString();
        textNav.setText("Personal Details");


        saveinfo = findViewById(R.id.savepersonalinfo);
        addImage = findViewById(R.id.addimageview);

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgbar1.setVisibility(View.VISIBLE);

        Call<GetResponse> personalCall = apiCall.getDetailsView(authtoken);
        personalCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                pgbar1.setVisibility(View.GONE);
                data = response.body().getData();
                 personaldetails = data.getPersonalDetails();
                nameeditField = personaldetails.getName();
                nameedit =  findViewById(R.id.name);
                nameedit.setText(nameeditField);

                admissionNoeditField = personaldetails.getAdmissionNO();
                admissionnoedit =  findViewById(R.id.admn_number);
                admissionnoedit.setText(admissionNoeditField);

                emaileditField =personaldetails.getEmail();
                emailField =  findViewById(R.id.user_email);
                emailField.setText(emaileditField);

                dateOfBirtheditField = personaldetails.getDateOfBirth();
                dateofbirthedit =  findViewById(R.id.dateofbirth);
                dateofbirthedit.setText(dateOfBirtheditField);

                yearOfAdmissioneditField = personaldetails.getYearOfJoin();
                yearofadmissionedit =  findViewById(R.id.yearofadmission);
                yearofadmissionedit.setText(yearOfAdmissioneditField);

                religioneditField = personaldetails.getReligion();
                religionedit =  findViewById(R.id.religion);
                religionedit.setText(religioneditField);

                casteeditField = personaldetails.getCaste();
                casteedit =  findViewById(R.id.caste);
                casteedit.setText(casteeditField);

                textgender = personaldetails.getGender();
                genderdropdown =  findViewById(R.id.gender);
                genderdropdown.setText(textgender);

                textblood = personaldetails.getBloodGroup();
                bloodgroupdropdown = findViewById(R.id.bloodGroup);
                bloodgroupdropdown.setText(textblood);


                textmarital = personaldetails.getMaritalStatus();
                maritalstatusdropdown =  findViewById(R.id.maritalStatus);
                maritalstatusdropdown.setText(textmarital);


                textdistancekm = personaldetails.getDistanceFromCollege();
                Distance =  findViewById(R.id.distance);
                Distance.setText(textdistancekm);


                textresidingat = personaldetails.getResidence();
                residedropdown =  findViewById(R.id.residing);
                residedropdown.setText(textresidingat);

                textmobilenumber = (int) personaldetails.getMobileNo();
                Mobilenumber =  findViewById(R.id.mobileno);
                Mobilenumber.setText(String.valueOf(textmobilenumber));


                permenentAddresseditField = personaldetails.getPermanentAddress();
                permenentaddressedit =  findViewById(R.id.permenentaddress);
                permenentaddressedit.setText(permenentAddresseditField);

                presentAddresseditField = personaldetails.getPresentAddress();
                presentaddressedit =  findViewById(R.id.presentaddress);
                presentaddressedit.setText(presentAddresseditField);

                textadmcategory = personaldetails.getCategoryOfAdmission();
                admissioncategorydropdown = findViewById(R.id.admissioncategory);
                admissioncategorydropdown.setText(textadmcategory);


                identificationMark1editField = personaldetails.getIdentificationMarkOne();
                identificationmark1edit =  findViewById(R.id.identificationmark1);
                identificationmark1edit.setText(identificationMark1editField);

                identificationMark2editField = personaldetails.getIdentificationMarkTwo();
                identificationmark2edit =  findViewById(R.id.identificationmark2);
                identificationmark2edit.setText(identificationMark2editField);


                Blood = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgroup);
                bloodgroupdropdown.setAdapter(Blood);
                bloodgroupdropdown.setThreshold(1);
                Admission = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admission);
                admissioncategorydropdown.setAdapter(Admission);
                admissioncategorydropdown.setThreshold(1);
                Gender = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, gender);
                genderdropdown.setAdapter(Gender);
                genderdropdown.setThreshold(1);
                Marital = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, marital);
                maritalstatusdropdown.setAdapter(Marital);
                maritalstatusdropdown.setThreshold(1);

                Reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
                residedropdown.setAdapter(Reside);
                residedropdown.setThreshold(1);
                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
                pgbar1.setVisibility(View.GONE);
            }
        });


        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), PersonalDetailView.class);
                startActivity(myIntent);

                nameeditField = nameedit.getText().toString();
                emaileditField= emailField.getText().toString();
                admissionNoeditField = admissionnoedit.getText().toString();
                dateOfBirtheditField = dateofbirthedit.getText().toString();
                yearOfAdmissioneditField = yearofadmissionedit.getText().toString();
                religioneditField = religionedit.getText().toString();
                casteeditField = casteedit.getText().toString();
                permenentAddresseditField = permenentaddressedit.getText().toString();
                presentAddresseditField = presentaddressedit.getText().toString();
                identificationMark1editField = identificationmark1edit.getText().toString();
                identificationMark2editField = identificationmark2edit.getText().toString();
                textmobilenumber =Integer.parseInt(Mobilenumber.getText().toString());
                textresidingat = residedropdown.getText().toString();
                textdistancekm = Distance.getText().toString();
                textblood = bloodgroupdropdown.getText().toString();
                textadmcategory = admissioncategorydropdown.getText().toString();
                textgender = genderdropdown.getText().toString();
                textmarital = maritalstatusdropdown.getText().toString();
//                textdepartment = departmentdropdown.getText().toString();
                getPersonalViewList( nameeditField,  rollNoeditField,  admissionNoeditField,
                         dateOfBirtheditField,  yearOfAdmissioneditField,  religioneditField,
                         casteeditField,  permenentAddresseditField,
                       presentAddresseditField,  identificationMark1editField,  identificationMark2editField,
                        textgender, textmarital, textdepartment,  textadmcategory,
                        textblood,  textmobilenumber,  textdistancekm,  textresidingat);
            }
        });
    }


    public void getPersonalViewList(String nameeditField, String rollNoeditField, String admissionNoeditField,
                                    String dateOfBirtheditField, String yearOfAdmissioneditField, String religioneditField,
                                    String casteeditField, String permenentAddresseditField,
                                    String presentAddresseditField, String identificationMark1editField, String identificationMark2editField,
                                    String textgender, String textmarital, String textdepartment, String textadmcategory,
                                    String textblood, int textmobilenumber, String textdistancekm, String textresidingat) {


        HashMap<String, Object> personalDetails = new HashMap<>();
        personalDetails.put("name",nameeditField);
        personalDetails.put("email",rollNoeditField);
        personalDetails.put("admissionNO",admissionNoeditField);
        personalDetails.put("dateOfBirth",dateOfBirtheditField);
        personalDetails.put("yearOfJoin",yearOfAdmissioneditField);
        personalDetails.put("religion",religioneditField);
        personalDetails.put("caste",casteeditField);
        personalDetails.put("permenentAddress",permenentAddresseditField);
        personalDetails.put("presentAddress",presentAddresseditField);
        personalDetails.put("identificationMarkOne",identificationMark1editField);
        personalDetails.put("identificationMarkTwo",identificationMark2editField);
        personalDetails.put("gender",textgender);
        personalDetails.put("maritalStatus",textmarital);
//        personalDetails.put("department",textdepartment);
        personalDetails.put("categoryOfAdmission",textadmcategory);
        personalDetails.put("bloodGroup",textblood);
        personalDetails.put("mobileNo",textmobilenumber);
        personalDetails.put("distanceFromCollege",textdistancekm);
        personalDetails.put("residence",textresidingat);

        HashMap<String,Object> personaledit = new HashMap<>();
        personaledit.put("personalDetails",personalDetails);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
        String userid = (pref.getString("_id", ""));

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);



        Call<EditResponse> personaleditCall = apiCall.getpersonalEdit(userid,personaledit,authtoken);
        personaleditCall.enqueue(new Callback<EditResponse>() {
            @Override
            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {


                Toast.makeText(PersonalEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(getApplicationContext(), PersonalDetailView.class);
                startActivity(newIntent);


            }

            @Override
            public void onFailure(Call<EditResponse> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}





