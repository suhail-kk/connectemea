package com.example.emea.Fragments;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.emea.Network.ApiCall;
import com.example.emea.R;

public class HomePage extends AppCompatActivity {
    ApiCall apiCall;
    String studentName;
    MeowBottomNavigation bottomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);




        //assigning variable
        bottomNavigation = findViewById(R.id.bottom_navigation);
        //Add menu item
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_settings));
//        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_notes));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_home));
//        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_calendar));
        bottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_user));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                //initialising
                Fragment fragment = null;
                //Check condition
                switch (item.getId()) {
                    case 1:
                        fragment = new SettingsFragment();
                        break;
//                    case 2:
//                        fragment = new AttendenceFragment();
//                        break;
                    case 2:
                        fragment = new HomeFragment();
                        break;
//                    case 4:
//                        fragment = new CalenderFragment();
//                        break;
                    case 3:
                        fragment = new UserFragment();
                        break;
                }
                loadFragment(fragment);
            }

        });

        //set home fragment initially selected
        bottomNavigation.show(2, true);
        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomePage.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                Toast.makeText(HomePage.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
    }
}