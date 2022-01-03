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
import com.example.emea.Response.getDetails.Data;
import com.example.emea.Response.getDetails.GetResponse;
import com.example.emea.Response.getDetails.PersonalDetails;
import com.example.emea.Response.getDetails.Student;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PersonalEdit extends AppCompatActivity {

    String status;

    TextView dateofbirthedit;
    TextView nameedit;
    TextView admissionnoedit;
    TextView rollnoedit, Mobilenumber, Residing, Distance;
    TextView yearofadmissionedit, religionedit, casteedit;
    TextView identificationmark1edit, identificationmark2edit;
    TextView permenentaddressedit, presentaddressedit, admcategory, blood, department1;
    String dateOfBirtheditField, nameeditField, admissionNoeditField, rollNoeditField;
    String yearOfAdmissioneditField, religioneditField, casteeditField;
    String identificationMark1editField, identificationMark2editField, studentImage;
    String permenentAddresseditField, presentAddresseditField, textgender, textmarital, textadmcategory, textblood, textdepartment;
    String bloodgroupstring, admissioncategorystring, genderstring, maritalstatusstring, departmentstring;
    String textdistancekm;
    String textresidingat;
    String textjoining;
    int textmobilenumber;
    String textbloodgroupdropdownedit;
    String textadmissioncategorydropdownedit;
    String textgenderdropdownedit;
    String textmaritalstatusdropdownedit;
    String textdepartmentdropdownedit;
    String reside_;

    ImageButton birth;
    TextView textNav;
//    TextView gender;
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
    AutoCompleteTextView departmentdropdownedit, residedropdownedit;
//
//    ArrayList<BloodGroupItem> bloodGroupItem;
//    ArrayList<String> bloodgrp;
//    ArrayAdapter<String> arrayAdapter_list;
//
//    ArrayList<CategoryOfAdmissionItem> categoryOfAdmissionItem;
//    ArrayList<String> admissioncategory;
//    ArrayAdapter<String> arrayAdapter_admissioncategory;
//
//    ArrayList<GenderItem> genderItem;
//    ArrayList<String> gender2;
//    ArrayAdapter<String> arrayAdapter_gender;
//
//    ArrayList<MaritalStatusItem> maritalStatusItem;
//    ArrayList<String> maritalstatus;
//    ArrayAdapter<String> arrayAdapter_maritalstatus;
//
//    ArrayList<DepartmentItem> departmentDropdownResponseItem;
//    ArrayList<String> department;
//    ArrayAdapter<String> arrayAdapter_department;
//
//    ArrayList<ResidingAtItem> residingAtItems;
//    ArrayList<String> reside;
//    ArrayAdapter<String> arrayAdapter_reside;

    Button saveinfo;

    String mediaPath;
    Data data;
    Student student;
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
//        bloodgrp = new ArrayList<>();
//        admissioncategory = new ArrayList<>();
//        gender2 = new ArrayList<>();
//        maritalstatus = new ArrayList<>();
//        department = new ArrayList<>();
//        reside = new ArrayList<>();

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);


        SharedPreferences shared = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));
        pgbar1.setVisibility(View.VISIBLE);

        Call<GetResponse> personalCall = apiCall.getDetailsView(authtoken);
        personalCall.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {

                data = response.body().getData();
                 student = data.getStudent();
                 personaldetails = student.getPersonalDetails();
                pgbar1.setVisibility(View.GONE);
                nameeditField = personaldetails.getName();
                nameedit = (TextView) findViewById(R.id.name);
                nameedit.setText(nameeditField);

                textdepartment = personaldetails.getDepartment();
                departmentdropdown =findViewById(R.id.department);
                departmentdropdown.setText(textdepartment);

                admissionNoeditField = personaldetails.getAdmissionNO();
                admissionnoedit = (TextView) findViewById(R.id.admissionno);
                admissionnoedit.setText(admissionNoeditField);

                rollNoeditField =personaldetails.getEmail();
                rollnoedit = (TextView) findViewById(R.id.rollnumber);
                rollnoedit.setText(rollNoeditField);

                dateOfBirtheditField = personaldetails.getDateOfBirth();
                dateofbirthedit = (TextView) findViewById(R.id.dateofbirth);
                dateofbirthedit.setText(dateOfBirtheditField);

                yearOfAdmissioneditField = personaldetails.getYearOfJoin();
                yearofadmissionedit = (TextView) findViewById(R.id.yearofadmission);
                yearofadmissionedit.setText(yearOfAdmissioneditField);

                religioneditField = personaldetails.getReligion();
                religionedit = (TextView) findViewById(R.id.religion);
                religionedit.setText(religioneditField);

                casteeditField = personaldetails.getCaste();
                casteedit = (TextView) findViewById(R.id.caste);
                casteedit.setText(casteeditField);

                textgender = personaldetails.getGender();
                genderdropdown =  findViewById(R.id.gender);
                genderdropdown.setText(textgender);
//
                textblood = personaldetails.getBloodGroup();
                bloodgroupdropdown = findViewById(R.id.bloodGroup);
                bloodgroupdropdown.setText(textblood);


                textmarital = personaldetails.getMaritalStatus();
                maritalstatusdropdown =  findViewById(R.id.maritalStatus);
                maritalstatusdropdown.setText(textmarital);


                textdistancekm = personaldetails.getDistanceFromCollege();
                Distance = (TextView) findViewById(R.id.distance);
                Distance.setText(textdistancekm);


                textresidingat = personaldetails.getResidence();
                residedropdown =  findViewById(R.id.residing);
                residedropdown.setText(textresidingat);
//
//
//
                textmobilenumber = personaldetails.getMobileNo();
                Mobilenumber = (TextView) findViewById(R.id.mobileno);
                Mobilenumber.setText(String.valueOf(textmobilenumber));

//                textemail=response.body().getEmail();
//                email=(TextView)findViewById(R.id.emaildisplay);
//                email.setText(textemail);

                permenentAddresseditField = personaldetails.getPermenentAddress();
                permenentaddressedit = (TextView) findViewById(R.id.permenentaddress);
                permenentaddressedit.setText(permenentAddresseditField);

                presentAddresseditField = personaldetails.getPresentAddress();
                presentaddressedit = (TextView) findViewById(R.id.presentaddress);
                presentaddressedit.setText(presentAddresseditField);

                textadmcategory = personaldetails.getCategoryOfAdmission();
                admissioncategorydropdown = findViewById(R.id.admissioncategory);
                admissioncategorydropdown.setText(textadmcategory);

//                textmanagementreco=response.body().getFatherName();
//                managementreco=(TextView)findViewById(R.id.managementrecodisplay);
//                managementreco.setText(textmanagementreco);

                identificationMark1editField = personaldetails.getIdentificationMarkOne();
                identificationmark1edit = (TextView) findViewById(R.id.identificationmark1);
                identificationmark1edit.setText(identificationMark1editField);

                identificationMark2editField = personaldetails.getIdentificationMarkTwo();
                identificationmark2edit = (TextView) findViewById(R.id.identificationmark2);
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
                Department = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, department);
                departmentdropdown.setAdapter(Department);
                departmentdropdown.setThreshold(1);
                Reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
                residedropdown.setAdapter(Reside);
                residedropdown.setThreshold(1);

//                bloodgroupdropdownedit = findViewById(R.id.bloodGroup);

//                arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgrp);
//                bloodgroupdropdownedit.setAdapter(arrayAdapter_list);
//                bloodgroupdropdownedit.setThreshold(1);
//
//
//                admissioncategorydropdownedit = findViewById(R.id.admissioncategory);
//                arrayAdapter_admissioncategory = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admissioncategory);
//                admissioncategorydropdownedit.setAdapter(arrayAdapter_admissioncategory);
//                admissioncategorydropdownedit.setThreshold(1);
//
//
//                genderdropdownedit = findViewById(R.id.gender);
//                arrayAdapter_gender = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, gender2);
//                genderdropdownedit.setAdapter(arrayAdapter_gender);
//                genderdropdownedit.setThreshold(1);
//
//
//                maritalstatusdropdownedit = findViewById(R.id.maritalStatus);
//                arrayAdapter_maritalstatus = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, maritalstatus);
//                maritalstatusdropdownedit.setAdapter(arrayAdapter_maritalstatus);
//                maritalstatusdropdownedit.setThreshold(1);
//
//
//                departmentdropdownedit = findViewById(R.id.department);
//                arrayAdapter_department = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, department);
//                departmentdropdownedit.setAdapter(arrayAdapter_department);
//                departmentdropdownedit.setThreshold(1);
//
//                residedropdown = findViewById(R.id.residing);
//                arrayAdapter_reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
//                residedropdown.setAdapter(arrayAdapter_reside);
//                residedropdown.setThreshold(1);
//
//                studentImage = response.body().getProfileImage();
//                Picasso.get().load("http://172.16.0.181/studentsprofile/assets/images/students/" + studentImage).into(addImage);

//
                apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//                dropdowncall();
//                departmentdropdowncall();
//            }
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
                pgbar1.setVisibility(View.GONE);
            }
        });


//
//        addImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectImage();
//            }
//        });

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(getApplicationContext(), PersonalDetailView.class);
                startActivity(myIntent);

                nameeditField = nameedit.getText().toString();
                rollNoeditField = rollnoedit.getText().toString();
                admissionNoeditField = admissionnoedit.getText().toString();
                dateOfBirtheditField = dateofbirthedit.getText().toString();
                yearOfAdmissioneditField = yearofadmissionedit.getText().toString();
                religioneditField = religionedit.getText().toString();
                casteeditField = casteedit.getText().toString();
                permenentAddresseditField = permenentaddressedit.getText().toString();
                presentAddresseditField = presentaddressedit.getText().toString();
//                textmanagementreco = managementreco.getText().toString();
                identificationMark1editField = identificationmark1edit.getText().toString();
                identificationMark2editField = identificationmark2edit.getText().toString();
                textmobilenumber =Integer.parseInt(Mobilenumber.getText().toString());
                reside_ = residedropdownedit.getText().toString();
                textdistancekm = Distance.getText().toString();
                textbloodgroupdropdownedit = bloodgroupdropdownedit.getText().toString();
                textadmissioncategorydropdownedit = admissioncategorydropdownedit.getText().toString();
                textgenderdropdownedit = genderdropdownedit.getText().toString();
                textmaritalstatusdropdownedit = maritalstatusdropdownedit.getText().toString();
                textdepartmentdropdownedit = departmentdropdownedit.getText().toString();

                getPersonalViewList( nameeditField,  rollNoeditField,  admissionNoeditField,
                         dateOfBirtheditField,  yearOfAdmissioneditField,  religioneditField,
                         casteeditField,  permenentAddresseditField,
                       presentAddresseditField,  identificationMark1editField,  identificationMark2editField,
                        genderstring, maritalstatusstring, departmentstring,  admissioncategorystring,
                         bloodgroupstring,  textmobilenumber,  textdistancekm,  textresidingat);
            }
        });
    }

//    private void dropdowncall() {
//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//        Call<PersonalDropdownResponse> dropdownResponseCall = apiCall.getPersonalDropdown();
//        dropdownResponseCall.enqueue(new Callback<PersonalDropdownResponse>() {
//            @Override
//            public void onResponse(Call<PersonalDropdownResponse> call, Response<PersonalDropdownResponse> response) {
//                bloodGroupItem = response.body().getBloodGroup();
//                for (BloodGroupItem item : bloodGroupItem) {
//                    bloodgrp.add(item.getBloodGroup());
//                }
//
//                categoryOfAdmissionItem = response.body().getCategoryOfAdmission();
//                for (CategoryOfAdmissionItem item : categoryOfAdmissionItem) {
//                    admissioncategory.add(item.getAdmissionCategory());
//                }
//
//                genderItem = response.body().getGender();
//                for (GenderItem item : genderItem) {
//                    gender2.add(item.getGender());
//                }
//
//                maritalStatusItem = response.body().getMaritalStatus();
//                for (MaritalStatusItem item : maritalStatusItem) {
//                    maritalstatus.add(item.getMaritalStatus());
//                }
//                residingAtItems = response.body().getResidingAt();
//                for (ResidingAtItem item : residingAtItems) {
//                    reside.add(item.getResiding());
//                }
//
//
//            }
//
//            @Override
//            public void onFailure(Call<PersonalDropdownResponse> call, Throwable t) {
//
//            }
//        });
//    }
//
//    private void departmentdropdowncall() {
//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//        Call<DepartmentDropdownResponse> departmentDropdownResponseCall = apiCall.getDepartmentDropdown();
//        departmentDropdownResponseCall.enqueue(new Callback<DepartmentDropdownResponse>() {
//            @Override
//            public void onResponse(Call<DepartmentDropdownResponse> call, Response<DepartmentDropdownResponse> response) {
//                departmentDropdownResponseItem = response.body().getDepartment();
//                for (DepartmentItem item : departmentDropdownResponseItem) {
//                    department.add(item.getDepartmentName());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DepartmentDropdownResponse> call, Throwable t) {
//                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void selectImage() {
//        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(galleryIntent, 0);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        try {
//            // When an Image is picked
//            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
//
//                // Get the Image from data
//                Uri selectedImage = data.getData();
//                String[] filePathColumn = {MediaStore.Images.Media.DATA};
//
//                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
//                assert cursor != null;
//                cursor.moveToFirst();
//
//                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                mediaPath = cursor.getString(columnIndex);
////                str1.setText(mediaPath);
//                // Set the Image in ImageView for Previewing the Media
//                addImage.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
//                cursor.close();
//
//
//            } else {
//                Toast.makeText(this, "You haven't picked Image/Video", Toast.LENGTH_LONG).show();
//            }
//        } catch (Exception e) {
//            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
//        }
//
//    }
//
    public void getPersonalViewList(String nameeditField, String rollNoeditField, String admissionNoeditField,
                                    String dateOfBirtheditField, String yearOfAdmissioneditField, String religioneditField,
                                    String casteeditField, String permenentAddresseditField,
                                    String presentAddresseditField, String identificationMark1editField, String identificationMark2editField,
                                    String genderstring, String maritalstatusstring, String departmentstring, String admissioncategorystring,
                                    String bloodgroupstring, int textmobilenumber, String textdistancekm, String textresidingat) {

//        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
//        authtoken = (shared.getString("token", ""));



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
        personalDetails.put("gender",genderstring);
        personalDetails.put("maritalStatus",maritalstatusstring);
        personalDetails.put("department",departmentstring);
        personalDetails.put("categoryOfAdmission",admissioncategorystring);
        personalDetails.put("bloodGroup",bloodgroupstring);

        personalDetails.put("mobileNo",textmobilenumber);




        personalDetails.put("distanceFromCollege",textdistancekm);




        personalDetails.put("residence",textresidingat);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        SharedPreferences pref = getSharedPreferences("My PREF_NAME", MODE_PRIVATE);
        String userid = (pref.getString("_id", ""));

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

//        Call<EditResponse> familyeditCall = apiCall.getEdit(personalDetails,userid,authtoken);
//        familyeditCall.enqueue(new Callback<EditResponse>() {
//            @Override
//            public void onResponse(Call<EditResponse> call, Response<EditResponse> response) {
//
////                status = response.body().getStatus();
//                if(response.body()!=null) {
//
//                    Toast.makeText(PersonalEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                }
////                    Toast.makeText(FamilyEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<EditResponse> call, Throwable t) {
//                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}




//        // Map is used to multipart the file using okhttp3.RequestBody
//        File file = new File(mediaPath);
//
//
//        // Parsing any Media type file
//        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
//        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
//        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
//
//        HashMap<String, RequestBody> params = new HashMap<>();
//        params.put("name", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(nameeditField)));
//        params.put("blood", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textbloodgroupdropdownedit)));
//        params.put("adm_no", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(admissionNoeditField)));
//        params.put("roll_no", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(rollNoeditField)));
//        params.put("joining_date", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(yearOfAdmissioneditField)));
//        params.put("admission_cat", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textadmissioncategorydropdownedit)));
//        params.put("department", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textdepartmentdropdownedit)));
//        params.put("gender", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textgenderdropdownedit)));
//        params.put("dob", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(dateOfBirtheditField)));
//        params.put("marital_status", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textmaritalstatusdropdownedit)));
//        params.put("religion", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(religioneditField)));
//        params.put("caste", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(casteeditField)));
//        params.put("permanent_address", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(permenentAddresseditField)));
//        params.put("present_address", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(presentAddresseditField)));
//        params.put("identification_mark_1", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(identificationMark1editField)));
//        params.put("identification_mark_2", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(identificationMark2editField)));
//        params.put("mobile", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textmobilenumber)));
//        params.put("distance_to_college", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textdistancekm)));
//        params.put("residing_at", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(reside_)));
//
//
//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//        Call<PersonalEditResponse> personaleditCall = apiCall.getPersonalEdit(fileToUpload, filename, params, authtoken);
//        personaleditCall.enqueue(new Callback<PersonalEditResponse>() {
//            @Override
//            public void onResponse(Call<PersonalEditResponse> call, Response<PersonalEditResponse> response) {
//
//                status = response.body().getStatus();
//
//                if (status.equals("Success")) {
//                    Toast.makeText(PersonalEdit.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(PersonalEdit.this, "Already registered.", Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<PersonalEditResponse> call, Throwable t) {
//                Toast.makeText(PersonalEdit.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }


