package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.MenuItem;
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
import com.example.emea.Response.PersonalResponse;
import com.example.emea.Response.ResidingAtItem;
import com.google.android.material.textfield.TextInputEditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalDetails extends AppCompatActivity {

    private static final String TAG = "Personal Details";
    String dateOfBirth;
    String name;
    String admissionNo;
    String rollNo;
    String yearOfAdmission;
    String religion;
    String caste;
    String identificationMark1;
    String identificationMark2;
    String permenentAddress;
    String presentAddress;
    String blood_group;
    String admission_category;
    String gender_;
    String marital_status;
    String department_,reside_;
    String textMobilenumber,textResiding,textDistance;

    TextInputEditText dateOfBirthField, nameField, admissionNoField, rollNoField, yearOfAdmissionField,
            identificationMark1Field, identificationMark2Field, permenentAddressField, presentAddressField,
            religionField, casteField,Mobilenumber,Residing,Distance;
    ImageButton birth;
    TextView textNav;
    Button saveInfo;
    ImageView addImage, prevPage;
    ApiCall apiCall;
    String apiPersonalList;
    String authtoken;
    Bitmap bitmap;
    AutoCompleteTextView bloodgroupdropdown;
    AutoCompleteTextView admissioncategorydropdown;
    AutoCompleteTextView genderdropdown;
    AutoCompleteTextView maritalstatusdropdown;
    AutoCompleteTextView departmentdropdown,residedropdown;


    ArrayList<BloodGroupItem> bloodGroupItem;
    ArrayList<String> bloodgroups;
    ArrayAdapter<String> arrayAdapter_list;

    ArrayList<CategoryOfAdmissionItem> categoryOfAdmissionItem;
    ArrayList<String> admissioncategory;
    ArrayAdapter<String> arrayAdapter_admissioncategory;

    ArrayList<GenderItem> genderItem;
    ArrayList<String> gender;
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


    private static final int IMAGE = 100;

    int status;

    DatePickerDialog.OnDateSetListener DateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_activity_details);


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
//        departmentdropdowncall();

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        dropdowncall();
        departmentdropdowncall();


        bloodgroups = new ArrayList<>();
        admissioncategory = new ArrayList<>();
        gender = new ArrayList<>();
        maritalstatus = new ArrayList<>();
        department = new ArrayList<>();
        reside=new ArrayList<>();

        bloodgroupdropdown = findViewById(R.id.bloodGroup);
        admissioncategorydropdown = findViewById(R.id.admissioncategory);
        genderdropdown = findViewById(R.id.gender);
        maritalstatusdropdown = findViewById(R.id.maritalStatus);
        departmentdropdown = findViewById(R.id.department);
        residedropdown=findViewById(R.id.residing);


        nameField = findViewById(R.id.name);
        admissionNoField = findViewById(R.id.admissionno);
        rollNoField = findViewById(R.id.rollnumber);
        dateOfBirthField = findViewById(R.id.dateofbirth);
        yearOfAdmissionField = findViewById(R.id.yearofadmission);
        religionField = findViewById(R.id.religion);
        casteField = findViewById(R.id.caste);
        identificationMark1Field = findViewById(R.id.identificationmark1);
        identificationMark2Field = findViewById(R.id.identificationmark2);
        permenentAddressField = findViewById(R.id.permenentaddress);
        presentAddressField = findViewById(R.id.presentaddress);
        addImage = findViewById(R.id.addimageview);
        Mobilenumber=findViewById(R.id.mobileno);

        Distance=findViewById(R.id.distance);


        saveInfo = findViewById(R.id.savepersonalinfo);

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//        dropdowncall();

        arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgroups);
        bloodgroupdropdown.setAdapter(arrayAdapter_list);
        bloodgroupdropdown.setThreshold(1);

        arrayAdapter_admissioncategory = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admissioncategory);
        admissioncategorydropdown.setAdapter(arrayAdapter_admissioncategory);
        admissioncategorydropdown.setThreshold(1);

        arrayAdapter_gender = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, gender);
        genderdropdown.setAdapter(arrayAdapter_gender);
        genderdropdown.setThreshold(1);

        arrayAdapter_maritalstatus = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, maritalstatus);
        maritalstatusdropdown.setAdapter(arrayAdapter_maritalstatus);
        maritalstatusdropdown.setThreshold(1);

        arrayAdapter_department = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, department);
        departmentdropdown.setAdapter(arrayAdapter_department);
        departmentdropdown.setThreshold(1);

        arrayAdapter_reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
        residedropdown.setAdapter(arrayAdapter_reside);
        residedropdown.setThreshold(1);



        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameField.getText().toString();
//                departmentdropdown = department.getText ().toString ();
                blood_group = bloodgroupdropdown.getText().toString();
                admission_category = admissioncategorydropdown.getText().toString();
                gender_ = genderdropdown.getText().toString();
                marital_status = maritalstatusdropdown.getText().toString();
                department_ = departmentdropdown.getText().toString();
                reside_=residedropdown.getText().toString();

                admissionNo = admissionNoField.getText().toString();
                rollNo = rollNoField.getText().toString();
                dateOfBirth = dateOfBirthField.getText().toString();
                yearOfAdmission = yearOfAdmissionField.getText().toString();
                religion = religionField.getText().toString();
                caste = casteField.getText().toString();
                permenentAddress = permenentAddressField.getText().toString();
                presentAddress = presentAddressField.getText().toString();
                identificationMark1 = identificationMark1Field.getText().toString();
                identificationMark2 = identificationMark2Field.getText().toString();
                textMobilenumber=Mobilenumber.getText().toString();
                textResiding=Residing.getText().toString();
                textDistance=Distance.getText().toString();


                getPersonalList(name, blood_group, admission_category, gender_, marital_status, department_,
                        admissionNo, rollNo, dateOfBirth, yearOfAdmission, religion, caste, permenentAddress, presentAddress,
                        identificationMark1, identificationMark2,textMobilenumber,textResiding,textDistance,reside_);

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
                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
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
                    bloodgroups.add(item.getBloodGroup());
                }

                categoryOfAdmissionItem = response.body().getCategoryOfAdmission();
                for (CategoryOfAdmissionItem item : categoryOfAdmissionItem) {
                    admissioncategory.add(item.getAdmissionCategory());
                }

                genderItem = response.body().getGender();
                for (GenderItem item : genderItem) {
                    gender.add(item.getGender());
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
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] imgByte = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(imgByte, Base64.DEFAULT);
        }
        return "";
    }


    public void getPersonalList(String name, String blood_group, String admission_category, String gender_, String marital_status, String department_, String admissionNo, String rollNo, String dateOfBirth, String yearOfAdmission, String religion, String caste, String permenentAddress, String presentAddress, String identificationMark1, String identificationMark2, String textMobilenumber, String textResiding, String textDistance,String reside_) {

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        String image = convertToString();


        HashMap<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("blood_group", blood_group);
        params.put("admission_no", admissionNo);
        params.put("roll_no", rollNo);
        params.put("joining_year", yearOfAdmission);
        params.put("image", image);
        params.put("admission_category", admission_category);
        params.put("department", department_);
        params.put("gender", gender_);
        params.put("date_of_birth", dateOfBirth);
        params.put("marital_status", marital_status);
        params.put("religion", religion);
        params.put("caste", caste);
        params.put("permanent_address", permenentAddress);
        params.put("present_address", presentAddress);
        params.put("identification_mark_1", identificationMark1);
        params.put("identification_mark_2", identificationMark2);
        params.put("mobile", textMobilenumber);

        params.put("distance_to_college", textDistance);
        params.put("residing_at", reside_);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);


        Call<PersonalResponse> PersonalCall = apiCall.getPersonal(params, authtoken);

        PersonalCall.enqueue(new Callback<PersonalResponse>() {
            @Override
            public void onResponse(Call<PersonalResponse> call, Response<PersonalResponse> response) {

                status = response.code();
                if (status != 400) {
                    apiPersonalList = response.body().getStatus();

                    Toast.makeText(PersonalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
                    Intent newIntent = new Intent(getApplicationContext(), EducationalDetails.class);
                    startActivity(newIntent);
                    finish();
                } else {
                    Toast.makeText(PersonalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<PersonalResponse> call, Throwable t) {
                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}