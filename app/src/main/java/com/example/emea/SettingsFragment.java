package com.example.emea;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SettingsFragment extends Fragment implements View.OnClickListener {


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

        TextView account = (TextView) view.findViewById(R.id.account);
        TextView logout = (TextView) view.findViewById(R.id.logout);
        TextView help = (TextView) view.findViewById(R.id.help);
        ImageView accountimg = (ImageView) view.findViewById(R.id.account_image);
        ImageView logoutimg = (ImageView) view.findViewById(R.id.logout_image);
        ImageView helpimg = (ImageView) view.findViewById(R.id.help_image);

        account.setText("Account");
        logout.setText("Logout");
        help.setText("Help");
        accountimg.setImageResource(R.drawable.account);
        logoutimg.setImageResource(R.drawable.logout);
        helpimg.setImageResource(R.drawable.help);

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(),MainActivity.class);
                startActivity(myIntent);
            }
        });
        return view;

    }

    @Override
    public void onClick(View v) {

    }
}