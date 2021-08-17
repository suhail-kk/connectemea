package com.example.emea;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    String studentName;
    ApiCall apiCall;

TextView displayName;
TextView admissionNumber;
String studentNumber;
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

       String authtoken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIyIiwiZW1haWwiOiJsdW5hQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoibHVuYSIsInJlZ2lzdGVyZWQiOnRydWV9.-h25wAytDq3zqu3RPESwJ5QGfkJvncgSHBKWZoMERiI";
        Call<StudentItem> studentCall = apiCall.getUser( authtoken);
        studentCall.enqueue(new Callback<StudentItem>() {
            @Override
            public void onResponse(Call<StudentItem> call, Response<StudentItem> response) {

                 studentName = response.body().getName();
                studentNumber = response.body().getAdmissionNo();
                 Log.e("name",studentName);
                displayName  = (TextView) view.findViewById(R.id.textView);


                displayName.setText(studentName);

                admissionNumber  = (TextView) view.findViewById(R.id.admissionNumber);


               admissionNumber.setText(studentNumber);




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
     return inflater.inflate(R.layout.fragment_home, container, false);
 }

}