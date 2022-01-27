package com.example.emea.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.DepartmentDropdown.DataItem;
import com.example.emea.Response.DepartmentDropdown.DepartmentDropdownResponse;
import com.example.emea.Response.photo.PhotoResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;

public class PersonalDetails extends AppCompatActivity {

    private static final String TAG = "Personal Details";


    String mediaPath,photoResponse;
    TextInputEditText dateOfBirthField, nameField, admissionNoField, emailField, yearOfAdmissionField,
            identificationMark1Field, identificationMark2Field, permenentAddressField, presentAddressField,
            religionField, casteField, Mobilenumber,Distance;
    TextView textNav;
    Button saveInfo;
    ImageView addImage, prevPage;
    ApiCall apiCall;
    String authtoken;
    AutoCompleteTextView bloodgroupdropdown,admissioncategorydropdown,genderdropdown,maritalstatusdropdown,departmentdropdown,residedropdown;
    ArrayAdapter<String> Blood,Gender,Admission,Marital,Reside;
    ArrayAdapter<DepartmentList> Department;
    ArrayList<DepartmentList> departmentDropdowns = new ArrayList<>();
    List<DataItem> departments;
    private static final int REQUEST_CODE = 1;

    private static final int IMAGE = 100;
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

        bloodgroupdropdown = findViewById(R.id.bloodGroup);
        admissioncategorydropdown = findViewById(R.id.admissioncategory);
        genderdropdown = findViewById(R.id.gender);
        maritalstatusdropdown = findViewById(R.id.maritalStatus);
        departmentdropdown = findViewById(R.id.department);
        residedropdown = findViewById(R.id.residing);
        nameField = findViewById(R.id.name);
        admissionNoField = findViewById(R.id.admn_number);
        emailField = findViewById(R.id.user_email);
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

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        //dropdown
        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
        Call<DepartmentDropdownResponse> departmentDropdown = apiCall.getDepartmentDropdown(authtoken);
        departmentDropdown.enqueue(new Callback<DepartmentDropdownResponse>() {
            @Override
            public void onResponse(Call<DepartmentDropdownResponse> call, Response<DepartmentDropdownResponse> response) {
                departments = response.body().getData();



                for (int i = 0; i < departments.size(); i++) {
                    departmentDropdowns.add(new DepartmentList(departments.get(i).getId(), departments.get(i).getName()));
                }
            }

            @Override
            public void onFailure(Call<DepartmentDropdownResponse> call, Throwable t) {
                Toast.makeText(PersonalDetails.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });


        String[] bloodgroup = {"A+", "B+"};
        String[] admission = {"management", "merit"};
        String[] gender = {"male", "female"};
        String[] marital = {"married", "unmarried"};
//        String[] department = {"Chemistry", "Geology", "CA"};
        String[] reside = {"home", "hostel"};
        Blood = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, bloodgroup);
        bloodgroupdropdown.setAdapter(Blood);
        bloodgroupdropdown.setThreshold(1);
        Admission = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, admission);
        admissioncategorydropdown.setAdapter(Admission);
        admissioncategorydropdown.setThreshold(1);
        Gender = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, gender);
        genderdropdown.setAdapter(Gender);
        genderdropdown.setThreshold(1);
        Marital = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, marital);
        maritalstatusdropdown.setAdapter(Marital);
        maritalstatusdropdown.setThreshold(1);
        Department = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, departmentDropdowns);
        Department.setDropDownViewResource(R.layout.dropdown_item);
        departmentdropdown.setAdapter(Department);
        departmentdropdown.setThreshold(1);
        Reside = new ArrayAdapter<>(getApplicationContext(), R.layout.dropdown_item, reside);
        residedropdown.setAdapter(Reside);
        residedropdown.setThreshold(1);


        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyPermissions();
            }
        });


        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameField.getText().toString();
                String blood_group = bloodgroupdropdown.getText().toString();
                String admission_category = admissioncategorydropdown.getText().toString();
                String gender_ = genderdropdown.getText().toString();
                String marital_status = maritalstatusdropdown.getText().toString();
//                String department_ = departmentdropdown.getText().toString();
                departmentdropdown.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String selection = (String) parent.getItemAtPosition(position);
                        String num = selection;
                    }
                });
                String reside_ = residedropdown.getText().toString();
                String admissionNo = admissionNoField.getText().toString();
                String email = emailField.getText().toString();
                String dateOfBirth = dateOfBirthField.getText().toString();
                String yearOfAdmission = yearOfAdmissionField.getText().toString();
                String religion = religionField.getText().toString();
                String caste = casteField.getText().toString();
                String permenentAddress = permenentAddressField.getText().toString();
                String presentAddress = presentAddressField.getText().toString();
                String identificationMark1 = identificationMark1Field.getText().toString();
                String identificationMark2 = identificationMark2Field.getText().toString();
                String textMobilenumber = Mobilenumber.getText().toString();
                String textDistance = Distance.getText().toString();

                HashMap<String, Object> personalDetails = new HashMap<>();
                personalDetails.put("name", name);
                personalDetails.put("email", email);
                personalDetails.put("yearOfJoin", yearOfAdmission);
                personalDetails.put("admissionNO", admissionNo);
                personalDetails.put("mobileNo", textMobilenumber);
                personalDetails.put("dateOfBirth", dateOfBirth);
                personalDetails.put("religion", religion);
                personalDetails.put("identificationMarkOne", identificationMark1);
                personalDetails.put("identificationMarkTwo", identificationMark2);
                personalDetails.put("presentAddress", presentAddress);
                personalDetails.put("permanentAddress", permenentAddress);
//                personalDetails.put("department", department_);
                personalDetails.put("distanceFromCollege", textDistance);
                personalDetails.put("caste", caste);
                personalDetails.put("gender", gender_);
                personalDetails.put("bloodGroup", blood_group);
                personalDetails.put("maritalStatus", marital_status);
                personalDetails.put("categoryOfAdmission", admission_category);
                personalDetails.put("residence", reside_);

                if(mediaPath!=null && !mediaPath.isEmpty()){
                    Photocall(personalDetails);
                }else {
                    Intent newIntent = new Intent(PersonalDetails.this, EducationalDetails.class);
                    newIntent.putExtra("personalDetails", personalDetails);
                    startActivity(newIntent);
                }


            }
        });
    }


    private void verifyPermissions(){
        Log.d(TAG, "verifyPermissions: asking user for permissions");
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                };

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[1]) == PackageManager.PERMISSION_GRANTED
               ){
            selectImage();
        }else{
            ActivityCompat.requestPermissions(PersonalDetails.this,
                    permissions,
                    REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }

    private void selectImage() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {

                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                mediaPath = cursor.getString(columnIndex);
//                str1.setText(mediaPath);
                // Set the Image in ImageView for Previewing the Media
                addImage.setImageBitmap(BitmapFactory.decodeFile(mediaPath));
                cursor.close();


            } else {
                Toast.makeText(this, "You haven't picked Image/Video", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show();
        }

    }


    private void Photocall(HashMap<String, Object> personalDetails) {
        File file = new File(mediaPath);

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("profile", file.getName(), requestBody);
//        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = getSharedPreferences("PREF_NAME", MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        Call<PhotoResponse> photoResponseCall = apiCall.getPhoto(fileToUpload,authtoken);
        photoResponseCall.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
//                photoResponse = response.body().getMessage();
                Toast.makeText(PersonalDetails.this, photoResponse, Toast.LENGTH_SHORT).show();

                Intent newIntent = new Intent(PersonalDetails.this, EducationalDetails.class);
                newIntent.putExtra("personalDetails", personalDetails);
                startActivity(newIntent);

            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(PersonalDetails.this, "Upload failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class DepartmentList  {
        public String _id, name;

        public DepartmentList() {

        }


        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public DepartmentList(String _id, String name) {
            this._id = _id;
            this.name = name;

        }



        @Override
        public String toString() {
            return name;
        }

    }


}
