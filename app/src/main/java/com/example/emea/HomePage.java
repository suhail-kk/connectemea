package com.example.emea;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {
    ApiCall apiCall;
    String studentName;
    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

//        apiCall = ApiClient.getRetrofit().create(ApiCall.class);
//
//        String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyIiwiZW1haWwiOiJsdW5hQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoibHVuYSIsInJlZ2lzdGVyZWQiOnRydWV9.-h25wAytDq3zqu3RPESwJ5QGfkJvncgSHBKWZoMERiI";
//
//        Call<StudentItem> studentCall = apiCall.getUser( authtoken);
//        studentCall.enqueue(new Callback<StudentItem>() {
//            @Override
//            public void onResponse(Call<StudentItem> call, Response<StudentItem> response) {
//
//                 studentName = response.body().getName();
//                Toast.makeText(HomePage.this, studentName, Toast.LENGTH_SHORT).show();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<StudentItem> call, Throwable t) {
////                Toast.makeText(HomeFragment.this, "Failed", Toast.LENGTH_SHORT).show();
////                Toast.makeText(HomeFragment, "Failed", Toast.LENGTH_SHORT).show();
//
//            }
//        });



        //assigning variable
        bottomNavigation=findViewById(R.id.bottom_navigation);
        //Add menu item
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_settings));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_notes));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_calendar));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.ic_user));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //initialising
                Fragment fragment = null;
                //Check condition
                switch (item.getId()){
                    case 1:
                        fragment = new SettingsFragment();
                        break;
                    case 2:
                        fragment = new AttendenceFragment();
                        break;
                    case 3:
                        fragment = new HomeFragment();
                        break;
                    case 4:
                        fragment = new CalenderFragment();
                        break;
                    case 5:
                        fragment = new UserFragment();
                        break;
                }
                loadFragment(fragment);
            }

        });

        //set home fragment initially selected
        bottomNavigation.show(3,true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomePage.this, "clicked" , Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomePage.this, "reselected" , Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout,fragment)
                .commit();
    }
}