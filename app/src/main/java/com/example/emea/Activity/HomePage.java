package com.example.emea.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.emea.R;

public class HomePage extends AppCompatActivity {

    LinearLayout linearLayoutPersonalDtls,linearLayoutEducaionDtls,linearLayoutFamilyDtls;

    ImageView settings,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        getSupportActionBar();



        linearLayoutPersonalDtls = findViewById(R.id.linearLayoutPersonal);
        linearLayoutEducaionDtls = findViewById(R.id.linearLayoutEducation);
        linearLayoutFamilyDtls = findViewById(R.id.linearLayoutFamily);

        settings = findViewById(R.id.more);
        logout = findViewById(R.id.logout);

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //Creating the instance of PopupMenu
                    PopupMenu popup = new PopupMenu(HomePage.this, settings
                    );
                    //Inflating the Popup using xml file
                    popup.getMenuInflater().inflate(R.menu.home_page, popup.getMenu());

                    //registering popup with OnMenuItemClickListener
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.contactUs:
                                    Intent newIntent=new Intent(getApplicationContext(),ContactUs.class);
                                    startActivity(newIntent);

                            }
                        }
                    });

                    popup.show();//showing popup menu
                }
        });

        linearLayoutPersonalDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent perIntent = new Intent(getApplicationContext(), PersonalDetails.class);
                startActivity(perIntent);

            }
        });

        linearLayoutEducaionDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eduIntent = new Intent(getApplicationContext(), EducationalDetails.class);
                startActivity(eduIntent);

            }
        });

        linearLayoutFamilyDtls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent famIntent = new Intent(getApplicationContext(), FamilyDetails.class);
                startActivity(famIntent);

            }
        });
    }


}