package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.OtherQualifications;

public class EducationAdapterqual extends RecyclerView.Adapter<EducationAdapterqual.MyViewHolder> {
    Context context;
  OtherQualifications otherQualifications;


    public EducationAdapterqual(Context applicationContext, OtherQualifications otherQualifications, EducationDetailsView context) {
        this.context = context;
      this. otherQualifications= otherQualifications;
  ;

    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_qualification,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {

        holder.coursename.setText(otherQualifications.getCourseName());
        holder.coursetype.setText(otherQualifications.getGrade());
        holder.institution2.setText(otherQualifications.getInstiution());
        holder.university2.setText(otherQualifications.getRecongnisation());




    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView coursename,coursetype,institution2,university2;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


                            coursename=itemView.findViewById(R.id.coursename);
//                collegename.setText(textcollegename);
//
               coursetype=itemView.findViewById(R.id.coursetype);
//                universityugc.setText(textuniversity);
//
                institution2=itemView.findViewById(R.id.institutionname);
//               courseugc.setText(textugccourse);
//
                university2=itemView.findViewById(R.id.university);
//                ugcmainbox.setText(textugcmainbox);
//


        }
    }
}


