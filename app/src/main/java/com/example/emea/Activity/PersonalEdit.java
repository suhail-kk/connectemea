package com.example.emea.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
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
import com.example.emea.Response.BloodGroupItem;
import com.example.emea.Response.CategoryOfAdmissionItem;
import com.example.emea.Response.DepartmentDropdownResponse;
import com.example.emea.Response.DepartmentItem;
import com.example.emea.Response.GenderItem;
import com.example.emea.Response.MaritalStatusItem;
import com.example.emea.Response.PersonalDropdownResponse;
import com.example.emea.Response.PersonalEditResponse;
import com.example.emea.Response.PersonalViewResponse;
import com.example.emea.Response.ResidingAtItem;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalEdit extends AppCompatActivity {

    //    ApiCall apiCall;
//
//    TextView name,course,rollno,admno,dob,age,marital,religion,caste,email,permaddress,presaddress;
//    TextView admcategory,managementreco,identification1,identification2;
////    EditText name;
//
//    String textname,textcourse,textrollno,textadmno,textdob,textage;
//    String textmarital,textreligion,textcaste,textemail,textpermaddress,textpresaddress,textadmcategory;
//    String textmanagementreco,textidentification1,textidentification2;
//    String authtoken;
    String status;

    TextView dateofbirthedit;
    TextView nameedit;
    TextView admissionnoedit;
    TextView rollnoedit,Mobilenumber,Residing,Distance;
    TextView yearofadmissionedit,religionedit,casteedit;
    TextView identificationmark1edit, identificationmark2edit;
    TextView permenentaddressedit, presentaddressedit,marital,admcategory,blood,department1;
    String dateOfBirtheditField, nameeditField, admissionNoeditField, rollNoeditField;
    String yearOfAdmissioneditField,religioneditField,casteeditField;
    String identificationMark1editField, identificationMark2editField;
    String permenentAddresseditField, presentAddresseditField,textgender,textmarital,textadmcategory,textblood,textdepartment;
    String bloodgroupstring,admissioncategorystring,genderstring,maritalstatusstring,departmentstring;
    String textdistancekm,textresidingat,textjoining,textmobilenumber,textbloodgroupdropdownedit,
    textadmissioncategorydropdownedit,
            textgenderdropdownedit,
    textmaritalstatusdropdownedit,
            textdepartmentdropdownedit,reside_;       ;
    ImageButton birth;
    TextView textNav;
    TextView gender;
    Button saveInfo;
    ImageView addImage, prevPage;
    ApiCall apiCall;
    String apiPersonalList;
    String authtoken;
    Bitmap bitmap;
ProgressBar pgbar1;
    AutoCompleteTextView bloodgroupdropdownedit;
    AutoCompleteTextView admissioncategorydropdownedit;
    AutoCompleteTextView genderdropdownedit;
    AutoCompleteTextView maritalstatusdropdownedit;
    AutoCompleteTextView departmentdropdownedit,residedropdown;

    ArrayList<BloodGroupItem> bloodGroupItem;
    ArrayList<String> bloodgrp;
    ArrayAdapter<String> arrayAdapter_list;

    ArrayList<CategoryOfAdmissionItem> categoryOfAdmissionItem;
    ArrayList<String> admissioncategory;
    ArrayAdapter<String> arrayAdapter_admissioncategory;

    ArrayList<GenderItem> genderItem;
    ArrayList<String> gender2;
    ArrayAdapter<String> arrayAdapter_gender;

    ArrayList<MaritalStatusItem> maritalStatusItem;
    ArrayList<String> maritalstatus;
    ArrayAdapter<String> arrayAdapter_maritalstatus;

    ArrayList<DepartmentItem> departmentDropdownResponseItem;
    ArrayList<String> department;
    ArrayAdapter<String> arrayAdapter_department;

    ArrayList<ResidingAtItem> residingAtItems;
    ArrayList<String> reside;
    ArrayAdapter<String> arrayAdapter_reside;

    Button saveinfo;

    private static final int IMAGE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);

        pgbar1=findViewById(R.id.progressBar1);

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

//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//        dropdowncall();
//        departmentdropdowncall();

        saveinfo = findViewById(R.id.savepersonalinfo);

        bloodgrp = new ArrayList<>();
        admissioncategory = new ArrayList<>();
        gender2 = new ArrayList<>();
        maritalstatus = new ArrayList<>();
        department = new ArrayList<>();
        reside=new ArrayList<>();

//        bloodgroupdropdownedit = findViewById(R.id.bloodGroup);
//        admissioncategorydropdownedit = findViewById(R.id.admissioncategory);
//        genderdropdownedit = findViewById(R.id.gender);
//        maritalstatusdropdownedit = findViewById(R.id.maritalStatus);
//        departmentdropdownedit = findViewById(R.id.department);

//        nameedit = findViewById(R.id.name);
//        admissionnoedit = findViewById(R.id.admissionno);
//        rollnoedit = findViewById(R.id.rollnumber);
//        dateofbirthedit = findViewById(R.id.dateofbirth);
//        yearofadmissionedit = findViewById(R.id.yearofadmission);
//        religionedit = findViewById(R.id.religion);
//        casteedit = findViewById(R.id.caste);
//        identificationmark1edit = findViewById(R.id.identificationmark1);
//        identificationmark2edit = findViewById(R.id.identificationmark2);
//        permenentaddressedit = findViewById(R.id.permenentaddress);
//        presentaddressedit = findViewById(R.id.presentaddress);
//
//        Mobilenumber=findViewById(R.id.mobileno);
//        Residing=findViewById(R.id.residing);
//        Distance=findViewById(R.id.distance);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

//        arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgrp);
//        bloodgroupdropdownedit.setAdapter(arrayAdapter_list);
//        bloodgroupdropdownedit.setThreshold(1);
//
//
//
//        arrayAdapter_admissioncategory = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admissioncategory);
//        admissioncategorydropdownedit.setAdapter(arrayAdapter_admissioncategory);
//        admissioncategorydropdownedit.setThreshold(1);
//
////        arrayAdapter_gender = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, gender);
////        genderdropdownedit.setAdapter(arrayAdapter_gender);
////        genderdropdownedit.setThreshold(1);
//
//        arrayAdapter_maritalstatus = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, maritalstatus);
//        maritalstatusdropdownedit.setAdapter(arrayAdapter_maritalstatus);
//        maritalstatusdropdownedit.setThreshold(1);
//
//        arrayAdapter_department = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, department);
//        departmentdropdownedit.setAdapter(arrayAdapter_department);
//        departmentdropdownedit.setThreshold(1);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgbar1.setVisibility(View.VISIBLE);

        Call<PersonalViewResponse> personalCall = apiCall.getPersonalView(authtoken);
        personalCall.enqueue(new Callback<PersonalViewResponse>() {


            @Override
            public void onResponse(Call<PersonalViewResponse> call, Response<PersonalViewResponse> response) {
                pgbar1.setVisibility(View.GONE);
                nameeditField = response.body().getName();
                nameedit = (TextView) findViewById(R.id.name);
                nameedit.setText(nameeditField);

                textdepartment = response.body().getDepartment();
                department1 = (TextView) findViewById(R.id.department);
                department1.setText(textdepartment);

                admissionNoeditField = response.body().getAdmissionNo();
                admissionnoedit = (TextView) findViewById(R.id.admissionno);
                admissionnoedit.setText(admissionNoeditField);

                rollNoeditField = response.body().getRollNo();
                rollnoedit = (TextView) findViewById(R.id.rollnumber);
                rollnoedit.setText(rollNoeditField);

                dateOfBirtheditField = response.body().getDateOfBirth();
                dateofbirthedit = (TextView) findViewById(R.id.dateofbirth);
                dateofbirthedit.setText(dateOfBirtheditField);

                yearOfAdmissioneditField = response.body().getJoiningYear();
                yearofadmissionedit = (TextView) findViewById(R.id.yearofadmission);
                yearofadmissionedit.setText(yearOfAdmissioneditField);

                religioneditField = response.body().getReligion();
                religionedit = (TextView) findViewById(R.id.religion);
                religionedit.setText(religioneditField);

                casteeditField = response.body().getCaste();
                casteedit = (TextView) findViewById(R.id.caste);
                casteedit.setText(casteeditField);

                textgender = response.body().getGender();
                gender = (TextView) findViewById(R.id.gender);
                gender.setText(textgender);
//
                textblood = response.body().getBloodGroup();
                blood = (TextView) findViewById(R.id.bloodGroup);
                blood.setText(textblood);



                textmarital = response.body().getMaritalStatus();
                marital = (TextView) findViewById(R.id.maritalStatus);
                marital.setText(textmarital);


                textdistancekm = response.body().getDistanceToCollege();
                Distance = (TextView) findViewById(R.id.distance);
                Distance.setText(textdistancekm);


                textresidingat = response.body().getResidingAt();
                Residing = (TextView) findViewById(R.id.residing);
                Residing.setText(textresidingat);
//
//
//
                textmobilenumber = response.body().getMobile();
                Mobilenumber = (TextView) findViewById(R.id.mobileno);
                Mobilenumber.setText(textmobilenumber);

//                textemail=response.body().getEmail();
//                email=(TextView)findViewById(R.id.emaildisplay);
//                email.setText(textemail);

                permenentAddresseditField = response.body().getPermanentAddress();
                permenentaddressedit = (TextView) findViewById(R.id.permenentaddress);
                permenentaddressedit.setText(permenentAddresseditField);

                presentAddresseditField = response.body().getPresentAddress();
                presentaddressedit = (TextView) findViewById(R.id.presentaddress);
                presentaddressedit.setText(presentAddresseditField);

                textadmcategory = response.body().getAdmissionCategory();
                admcategory = (TextView) findViewById(R.id.admissioncategory);
                admcategory.setText(textadmcategory);

//                textmanagementreco=response.body().getFatherName();
//                managementreco=(TextView)findViewById(R.id.managementrecodisplay);
//                managementreco.setText(textmanagementreco);

                identificationMark1editField = response.body().getIdentificationMark1();
                identificationmark1edit = (TextView) findViewById(R.id.identificationmark1);
                identificationmark1edit.setText(identificationMark1editField);

                identificationMark2editField = response.body().getIdentificationMark2();
                identificationmark2edit = (TextView) findViewById(R.id.identificationmark2);
                identificationmark2edit.setText(identificationMark2editField);



                bloodgroupdropdownedit = findViewById(R.id.bloodGroup);

                arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgrp);
                bloodgroupdropdownedit.setAdapter(arrayAdapter_list);
                bloodgroupdropdownedit.setThreshold(1);


                admissioncategorydropdownedit = findViewById(R.id.admissioncategory);
                arrayAdapter_admissioncategory = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admissioncategory);
                admissioncategorydropdownedit.setAdapter(arrayAdapter_admissioncategory);
                admissioncategorydropdownedit.setThreshold(1);


                genderdropdownedit = findViewById(R.id.gender);
        arrayAdapter_gender = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, gender2);
        genderdropdownedit.setAdapter(arrayAdapter_gender);
        genderdropdownedit.setThreshold(1);


                maritalstatusdropdownedit = findViewById(R.id.maritalStatus);
                arrayAdapter_maritalstatus = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, maritalstatus);
                maritalstatusdropdownedit.setAdapter(arrayAdapter_maritalstatus);
                maritalstatusdropdownedit.setThreshold(1);


                departmentdropdownedit = findViewById(R.id.department);
                arrayAdapter_department = new ArrayAdapter<>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, department);
                departmentdropdownedit.setAdapter(arrayAdapter_department);
                departmentdropdownedit.setThreshold(1);

                residedropdown=findViewById(R.id.residing);
                arrayAdapter_reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
                residedropdown.setAdapter(arrayAdapter_reside);
                residedropdown.setThreshold(1);

                apiCall = ApiClient.getRetrofit().create(ApiCall.class);

                dropdowncall();
                departmentdropdowncall();
            }

            @Override
            public void onFailure(Call<PersonalViewResponse> call, Throwable t) {
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
//                textcourse = course.getText().toString();
                rollNoeditField = rollnoedit.getText().toString();
                admissionNoeditField = admissionnoedit.getText().toString();
                dateOfBirtheditField = dateofbirthedit.getText().toString();
                yearOfAdmissioneditField = yearofadmissionedit.getText().toString();
                religioneditField = religionedit.getText().toString();
                casteeditField = casteedit.getText().toString();
//                genderstring = genderdropdownedit.getText().toString();
//                bloodgroupstring = bloodgroupdropdownedit.getText().toString();
//                maritalstatusstring = maritalstatusdropdownedit.getText().toString();
//                admissioncategorystring = admissioncategorydropdownedit.getText().toString();
//                departmentstring = departmentdropdownedit.getText().toString();
//                textemail = email.getText().toString();
                permenentAddresseditField = permenentaddressedit.getText().toString();
                presentAddresseditField = presentaddressedit.getText().toString();
//                textadmcategory = admcategory.getText().toString();
//                textmanagementreco = managementreco.getText().toString();
                identificationMark1editField = identificationmark1edit.getText().toString();
                identificationMark2editField = identificationmark2edit.getText().toString();
                textmobilenumber=Mobilenumber.getText().toString();
                reside_=residedropdown.getText().toString();
//                textresidingat=Residing.getText().toString();
                textdistancekm=Distance.getText().toString();
                textbloodgroupdropdownedit = bloodgroupdropdownedit.getText().toString();
                textadmissioncategorydropdownedit=admissioncategorydropdownedit.getText().toString();
                textgenderdropdownedit =genderdropdownedit.getText().toString();
                textmaritalstatusdropdownedit  =maritalstatusdropdownedit.getText().toString();
                textdepartmentdropdownedit = departmentdropdownedit.getText().toString();

                getPersonalViewList(nameeditField,rollNoeditField,admissionNoeditField,dateOfBirtheditField,yearOfAdmissioneditField,
                        religioneditField,casteeditField, permenentAddresseditField,presentAddresseditField,
                        identificationMark1editField,identificationMark2editField,
                        genderstring,bloodgroupstring,maritalstatusstring,admissioncategorystring,departmentstring,textmobilenumber,textdistancekm,textresidingat,
                        textadmissioncategorydropdownedit,textdepartmentdropdownedit,textbloodgroupdropdownedit,textgenderdropdownedit,textmaritalstatusdropdownedit,reside_);

            }
        });
    }

    private void dropdowncall() {
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        Call<PersonalDropdownResponse> dropdownResponseCall = apiCall.getPersonalDropdown();
        dropdownResponseCall.enqueue(new Callback<PersonalDropdownResponse>() {
            @Override
            public void onResponse(Call<PersonalDropdownResponse> call, Response<PersonalDropdownResponse> response) {
                bloodGroupItem = response.body().getBloodGroup();
                for (BloodGroupItem item : bloodGroupItem) {
                    bloodgrp.add(item.getBloodGroup());
                }

                categoryOfAdmissionItem = response.body().getCategoryOfAdmission();
                for (CategoryOfAdmissionItem item : categoryOfAdmissionItem) {
                    admissioncategory.add(item.getAdmissionCategory());
                }

                genderItem = response.body().getGender();
                for (GenderItem item : genderItem) {
                    gender2.add(item.getGender());
                }

                maritalStatusItem = response.body().getMaritalStatus();
                for (MaritalStatusItem item : maritalStatusItem) {
                    maritalstatus.add(item.getMaritalStatus());
                }
                residingAtItems = response.body().getResidingAt();
                for (ResidingAtItem item : residingAtItems) {
                    reside.add(item.getResiding());
                }



            }

            @Override
            public void onFailure(Call<PersonalDropdownResponse> call, Throwable t) {

            }
        });
    }

    private void departmentdropdowncall() {
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        Call<DepartmentDropdownResponse> departmentDropdownResponseCall = apiCall.getDepartmentDropdown();
        departmentDropdownResponseCall.enqueue(new Callback<DepartmentDropdownResponse>() {
            @Override
            public void onResponse(Call<DepartmentDropdownResponse> call, Response<DepartmentDropdownResponse> response) {
                departmentDropdownResponseItem = response.body().getDepartment();
                for (DepartmentItem item : departmentDropdownResponseItem) {
                    department.add(item.getDepartmentName());
                }
            }

            @Override
            public void onFailure(Call<DepartmentDropdownResponse> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                addImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String convertToString() {
        if(bitmap !=  null){
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] imgByte = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(imgByte, Base64.DEFAULT);
        }
        return "";
    }

    public void getPersonalViewList(String nameeditField, String rollNoeditField, String admissionNoeditField,
                                    String dateOfBirtheditField,String yearOfAdmissioneditField,String religioneditField,
                                    String casteeditField, String permenentAddresseditField,
                                    String presentAddresseditField, String identificationMark1editField, String identificationMark2editField,
                                    String genderstring, String maritalstatusstring, String departmentstring, String admissioncategorystring,
                                    String bloodgroupstring,String textmobilenumber,String textdistancekm,String textresidingat,String textadmissioncategorydropdownedit,
                                    String textdepartmentdropdownedit,String textbloodgroupdropdownedit,String textgenderdropdownedit,String textmaritalstatusdropdownedi,
                                    String reside_){

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        String image = convertToString();

        HashMap<String, String> params = new HashMap<>();
        params.put("name", nameeditField);
        params.put("blood", textbloodgroupdropdownedit);
        params.put("adm_no", admissionNoeditField);
        params.put("roll_no", rollNoeditField);
        params.put("joining_date", yearOfAdmissioneditField);
        params.put("image", image);
        params.put("admission_cat", textadmissioncategorydropdownedit);
        params.put("department", textdepartmentdropdownedit);
        params.put("gender", textgenderdropdownedit);
        params.put("dob", dateOfBirtheditField);
        params.put("marital_status", textmaritalstatusdropdownedit);
        params.put("religion", religioneditField);
        params.put("caste", casteeditField);
        params.put("permanent_address", permenentAddresseditField);
        params.put("present_address", presentAddresseditField);
        params.put("identification_mark_1", identificationMark1editField);
        params.put("identification_mark_2", identificationMark2editField);
        params.put("mobile", textmobilenumber);
//        params.put("residing_at", textresidingat);
        params.put("dist_to_college", textdistancekm);
        params.put("residing_at", reside_);
//
//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authtoken = (shared.getString("token", ""));

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        Call<PersonalEditResponse> personaleditCall = apiCall.getPersonalEdit(params,authtoken);
        personaleditCall.enqueue(new Callback<PersonalEditResponse>() {
            @Override
            public void onResponse(Call<PersonalEditResponse> call, Response<PersonalEditResponse> response) {

                status = response.body().getStatus();

                if (status.equals("Success")) {
                    Toast.makeText(PersonalEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PersonalEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PersonalEditResponse> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

