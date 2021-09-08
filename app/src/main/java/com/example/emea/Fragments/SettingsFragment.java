package com.example.emea.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.emea.Activity.Help;
import com.example.emea.Activity.MainActivity;
import com.example.emea.Activity.PersonalDetails;
import com.example.emea.R;

public class SettingsFragment extends Fragment implements View.OnClickListener {
    SharedPreferences sharedPreferences;



    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);


        TextView logout = (TextView) view.findViewById(R.id.logout);
        TextView help = (TextView) view.findViewById(R.id.help);

        logout.setText("Logout");
        help.setText("Help");

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(getActivity().getApplicationContext(), Help.class);
                startActivity(newIntent);
            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                SharedPreferences shared =getActivity(). getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = shared.edit();
                editor.clear();
                editor.commit();


                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(myIntent);




//                Log.d(TAG, sharedPreferences.getString("email", ""));
//
//                Log.d(TAG, sharedPreferences.getString("password", ""));
            }
        });

        return view;


    }

    @Override
    public void onClick(View v) {

    }
}

