package com.example.emea.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.emea.Network.ApiCall;
import com.example.emea.Network.ApiClient;
import com.example.emea.R;
import com.example.emea.Response.StudentItem;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment{
    ProgressBar pgBar;
    String studentName;
    ApiCall apiCall;

    TextView displayName, admissionNumber, displayMobile;
    String studentNumber, authtoken, studentMobile;
    //   String studentName;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//
//        TextView displayName = (TextView) view.findViewById(R.id.textView);
//        displayName.setText(studentName);
//
//        return view;
//        // Inflate the layout for this fragment
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        apiCall = ApiClient.getRetrofit().create(ApiCall.class);

        SharedPreferences shared = this.getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        authtoken = (shared.getString("token", ""));

        pgBar.setVisibility(View.VISIBLE);
        //  String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyIiwiZW1haWwiOiJsdW5hQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoibHVuYSIsInJlZ2lzdGVyZWQiOnRydWV9.-h25wAytDq3zqu3RPESwJ5QGfkJvncgSHBKWZoMERiI";
        Call<StudentItem> studentCall = apiCall.getUser(authtoken);
        studentCall.enqueue(new Callback<StudentItem>() {
            @Override
            public void onResponse(Call<StudentItem> call, Response<StudentItem> response) {
                pgBar.setVisibility(View.GONE);

                studentName = response.body().getName();
                studentNumber = response.body().getAdmissionNo();
                studentMobile = response.body().getMobile();

               displayName = (TextView) view.findViewById(R.id.textView);
                displayName.setText(studentName);

                admissionNumber = (TextView) view.findViewById(R.id.admissionNumber);
                admissionNumber.setText(studentNumber);

//                displayMobile = (TextView) view.findViewById(R.id.textPhone);
//                displayMobile.setText(studentMobile);


            }

            @Override
            public void onFailure(Call<StudentItem> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
//                Toast.makeText(HomeFragment, "Failed", Toast.LENGTH_SHORT).show();

            }

        });
//        TextView displayName = (TextView) getView().findViewById(R.id.textView);
//        displayName.setText(studentName);

    }

    /*   @Override
       public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           LayoutInflater lf = getActivity().getLayoutInflater();
           View view =  lf.inflate(R.layout.fragment_home, container, false); //pass the correct layout name for the fragment

         //  displayName  = (TextView) view.findViewById(R.id.textView);
     //     TextView text = (TextView) view.findViewById(R.id.textView);
       //    text.setText(studentName);
         //  displayName.setText("jane");


           return  view;


       }
   */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);

        pgBar=view.findViewById(R.id.progressBarView);
      //  return inflater.inflate(R.layout.fragment_home, container, false);
        return  view;

    }

}