package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class PersonalDetails extends AppCompatActivity {

    private static final String TAG = "Personal Details";
    String dateOfBirth;
    String name;
    String admissionNo;
    String email;
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
    String department_, reside_;
    String textMobilenumber, textResiding, textDistance;

    String mediaPath;

    TextInputEditText dateOfBirthField, nameField, admissionNoField, rollNoField, yearOfAdmissionField,
            identificationMark1Field, identificationMark2Field, permenentAddressField, presentAddressField,
            religionField, casteField, Mobilenumber, Residing, Distance
           ;
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
    AutoCompleteTextView departmentdropdown, residedropdown;


    ArrayAdapter<String> Blood;
    ArrayAdapter<String> Gender;
    ArrayAdapter<String> Admission;
    ArrayAdapter<String> Marital;
    ArrayAdapter<String> Department;
    ArrayAdapter<String> Reside;
//
//    ArrayList<BloodGroupItem> bloodGroupItem;
//    ArrayList<String> bloodgroups;
//    ArrayAdapter<String> arrayAdapter_list;
//
//    ArrayList<CategoryOfAdmissionItem> categoryOfAdmissionItem;
//    ArrayList<String> admissioncategory;
//    ArrayAdapter<String> arrayAdapter_admissioncategory;
//
//    ArrayList<GenderItem> genderItem;
//    ArrayList<String> gender;
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
//
//    ArrayList<ResidingAtItem> residingAtItems;
//    ArrayList<String> reside;
//    ArrayAdapter<String> arrayAdapter_reside;
//

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
//        dropdowncall();
//        departmentdropdowncall();


//        bloodgroups = new ArrayList<>();
//        admissioncategory = new ArrayList<>();
//        gender = new ArrayList<>();
//        maritalstatus = new ArrayList<>();
//        department = new ArrayList<>();
//        reside = new ArrayList<>();

        String bloodgroup[] = {"A+", "B+"};
        String admission[] = {"management","merit"};
        String gender[] = {"male", "female"};
        String marital[] = {"married", "unmarried"};
        String department[] = {"Chemistry", "Geology", "CA"};
        String reside[] = {"home", "hostel"};
//
        bloodgroupdropdown = findViewById(R.id.bloodGroup);
        admissioncategorydropdown = findViewById(R.id.admissioncategory);
        genderdropdown = findViewById(R.id.gender);
        maritalstatusdropdown = findViewById(R.id.maritalStatus);
        departmentdropdown = findViewById(R.id.department);
        residedropdown = findViewById(R.id.residing);


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
        Mobilenumber = findViewById(R.id.mobileno);

        Distance = findViewById(R.id.distance);


        saveInfo = findViewById(R.id.savepersonalinfo);


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
//        addImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectImage();
//            }
//        });
//        val items = arrayOf("NM", "NY", "NC", "ND");
//        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items);
//        bloodgroupdropdown.adapter = adapter;

//        arrayAdapter_list = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, bloodgroups);
//        bloodgroupdropdown.setAdapter(arrayAdapter_list);
//        bloodgroupdropdown.setThreshold(1);
//
//        arrayAdapter_admissioncategory = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, admissioncategory);
//        admissioncategorydropdown.setAdapter(arrayAdapter_admissioncategory);
//        admissioncategorydropdown.setThreshold(1);
//
//        arrayAdapter_gender = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, gender);
//        genderdropdown.setAdapter(arrayAdapter_gender);
//        genderdropdown.setThreshold(1);
//
//        arrayAdapter_maritalstatus = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, maritalstatus);
//        maritalstatusdropdown.setAdapter(arrayAdapter_maritalstatus);
//        maritalstatusdropdown.setThreshold(1);
//
//        arrayAdapter_department = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, department);
//        departmentdropdown.setAdapter(arrayAdapter_department);
//        departmentdropdown.setThreshold(1);
//
//        arrayAdapter_reside = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, reside);
//        residedropdown.setAdapter(arrayAdapter_reside);
//        residedropdown.setThreshold(1);



        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String name = nameField.getText().toString();
                String   blood_group = bloodgroupdropdown.getText().toString();
                String  admission_category = admissioncategorydropdown.getText().toString();
                String  gender_ = genderdropdown.getText().toString();
                String  marital_status = maritalstatusdropdown.getText().toString();
                String  department_ = departmentdropdown.getText().toString();
                String  reside_ = residedropdown.getText().toString();

                String     admissionNo = admissionNoField.getText().toString();
                String     email= rollNoField.getText().toString();
                String  dateOfBirth = dateOfBirthField.getText().toString();
                String    yearOfAdmission = yearOfAdmissionField.getText().toString();
//                Personal personal=new Personal(name,admissionNo,rollNo,yearOfAdmission);
                String   religion = religionField.getText().toString();
                String   caste = casteField.getText().toString();
              String  permenentAddress = permenentAddressField.getText().toString();
                String  presentAddress = presentAddressField.getText().toString();
                String  identificationMark1 = identificationMark1Field.getText().toString();
                String  identificationMark2 = identificationMark2Field.getText().toString();
             String   textMobilenumber = Mobilenumber.getText().toString();
              String  textDistance = Distance.getText().toString();


//                HashMap<String, String> personal = new HashMap<>();
//                personal.put("name",name);
////                personal.put("roll_no",rollNo);
//                personal.put("yearOfJoin",yearOfAdmission);
//                personal.put("admissionNO",admissionNo);

                HashMap<String, Object> personalDetails = new HashMap<>();
                personalDetails.put("name",name);
                personalDetails.put("email",email);
                personalDetails.put("yearOfJoin",yearOfAdmission);
                personalDetails.put("admissionNO",admissionNo);
                personalDetails.put("mobileNo",textMobilenumber);
                personalDetails.put("dateOfBirth",dateOfBirth);
                personalDetails.put("religion",religion);
                personalDetails.put("identificationMarkOne",identificationMark1);
                personalDetails.put("identificationMarkTwo",identificationMark2);
                personalDetails.put("presentAddress",presentAddress);
                personalDetails.put("permenentAddress",permenentAddress);
                personalDetails.put("department",department_);
                personalDetails.put("distanceFromCollege",textDistance);
                personalDetails.put("caste",caste);
                personalDetails.put("gender",gender_);
                personalDetails.put("bloodGroup",blood_group);
                personalDetails.put("maritalStatus",marital_status);
                personalDetails.put("categoryOfAdmission",admission_category);
                personalDetails.put("residence",reside_);





                Intent newIntent = new Intent(PersonalDetails.this, EducationalDetails.class);
        newIntent.putExtra("personalDetails", personalDetails);
                    startActivity(newIntent);
//
//                getPersonalList(name,admissionNo, rollNo, dateOfBirth, yearOfAdmission, religion, caste, permenentAddress, presentAddress,
//                        identificationMark1, identificationMark2, textMobilenumber, textDistance);

//                getPersonalList(name, blood_group, admission_category, gender_, marital_status, department_,
//                        admissionNo, rollNo, dateOfBirth, yearOfAdmission, religion, caste, permenentAddress, presentAddress,
//                        identificationMark1, identificationMark2, textMobilenumber, textResiding, textDistance, reside_);

            }
        });

    }

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
//                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

//    private void dropdowncall() {
//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//        Call<PersonalDropdownResponse> dropdownResponseCall = apiCall.getPersonalDropdown();
//        dropdownResponseCall.enqueue(new Callback<PersonalDropdownResponse>() {
//            @Override
//            public void onResponse(Call<PersonalDropdownResponse> call, Response<PersonalDropdownResponse> response) {
//                bloodGroupItem = response.body().getBloodGroup();
//                for (BloodGroupItem item : bloodGroupItem) {
//                    bloodgroups.add(item.getBloodGroup());
//                }
//
//                categoryOfAdmissionItem = response.body().getCategoryOfAdmission();
//                for (CategoryOfAdmissionItem item : categoryOfAdmissionItem) {
//                    admissioncategory.add(item.getAdmissionCategory());
//                }
//
//                genderItem = response.body().getGender();
//                for (GenderItem item : genderItem) {
//                    gender.add(item.getGender());
//                }
//
//                maritalStatusItem = response.body().getMaritalStatus();
//                for (MaritalStatusItem item : maritalStatusItem) {
//                    maritalstatus.add(item.getMaritalStatus());
//                }
//
//                residingAtItems = response.body().getResidingAt();
//                for (ResidingAtItem item : residingAtItems) {
//                    reside.add(item.getResiding());
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<PersonalDropdownResponse> call, Throwable t) {
//
//            }
//        });
//    }

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
//
//    public void getPersonalList(String name, String blood_group, String admission_category, String gender_, String marital_status, String department_, String admissionNo, String rollNo, String dateOfBirth, String yearOfAdmission, String religion, String caste, String permenentAddress) {
//
//
//        // Map is used to multipart the file using okhttp3.RequestBody
//        File file = new File(mediaPath);
//
//        // Parsing any Media type file
//        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
//        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
//        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
////
//
//        HashMap<String, RequestBody > personalDetails = new HashMap<>();
//        personalDetails.put("name", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(name)));
//        personalDetails.put("bloodGroup", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(blood_group)));
//        personalDetails.put("admissionNO", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(admissionNo)));
////        params.put("roll_no", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(rollNo)));
//        personalDetails.put("yearOfJoin", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(yearOfAdmission)));
//        personalDetails.put("categoryOfAdmission", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(admission_category)));
//        personalDetails.put("department", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(department_)));
//        personalDetails.put("gender", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(gender_)));
//        personalDetails.put("dateOfBirth", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(dateOfBirth)));
//        personalDetails.put("maritalStatus", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(marital_status)));
//        personalDetails.put("religion", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(religion)));
//        personalDetails.put("cast", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(caste)));
//        personalDetails.put("permenentAddress", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(permenentAddress)));
//        personalDetails.put("presentAddress", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(presentAddress)));
//        personalDetails.put("identificationMarkOne", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(identificationMark1)));
//        personalDetails.put("identificationMarkTwo", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(identificationMark2)));
//        personalDetails.put("mobileNo", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textMobilenumber)));
//
//        personalDetails.put("distanceFromCollege", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(textDistance)));
//        personalDetails.put("residence", RequestBody.create(MediaType.parse("text/plain"), String.valueOf(reside_)));
//
//
////        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
////        authtoken = (shared.getString("token", ""));
////
////
////        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
////
////
////        Call<PersonalResponse> PersonalCall = apiCall.getPersonal(fileToUpload, filename, params, authtoken);
////
////        PersonalCall.enqueue(new Callback<PersonalResponse>() {
////            @Override
////            public void onResponse(Call<PersonalResponse> call, Response<PersonalResponse> response) {
////
////                status = response.code();
////                if (status != 400) {
////                    apiPersonalList = response.body().getStatus();
////
////                    Toast.makeText(PersonalDetails.this, "Added Successfully.", Toast.LENGTH_SHORT).show();
////                    Intent newIntent = new Intent(getApplicationContext(), EducationalDetails.class);
////                    startActivity(newIntent);
////                    finish();
////                } else {
////                    Toast.makeText(PersonalDetails.this, "Already registered.", Toast.LENGTH_SHORT).show();
////                }
////
////            }
////
////            @Override
////            public void onFailure(Call<PersonalResponse> call, Throwable t) {
////                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
////
////            }
////        });
//
//        // Map is used to multipart the file using okhttp3.RequestBody
////        File file = new File(mediaPath);
////
////        // Parsing any Media type file
////        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
////        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
////        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());
////
////        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
////        Call<PhotoUploadResponse> call = apiCall.getPersonal(fileToUpload, filename);
////        call.enqueue(new Callback<PhotoUploadResponse>() {
////            @Override
////            public void onResponse(Call<PhotoUploadResponse> call, Response<PhotoUploadResponse> response) {
////                Toast.makeText(PersonalDetails.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFailure(Call<PhotoUploadResponse> call, Throwable t) {
////                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();
////            }
////        });
//
//        Intent newIntent = new Intent(getApplicationContext(), EducationalDetails.class);
//        newIntent.putExtra("MyClass", personalDetails);
//                    startActivity(newIntent);
//
//
//    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), HomePage.class);
        startActivityForResult(myIntent, 0);
        return true;
    }
}