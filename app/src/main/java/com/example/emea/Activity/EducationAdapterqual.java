package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.getDetails.OtherQualificationsItem;

import java.util.List;

public class EducationAdapterqual extends RecyclerView.Adapter<EducationAdapterqual.MyViewHolder> {
    Context context;
    List<OtherQualificationsItem> otherQualificationsItem;

    public EducationAdapterqual(Context applicationContext,List<OtherQualificationsItem> otherQualificationsItem, EducationDetailsView context) {
        this.context = context;
      this. otherQualificationsItem= otherQualificationsItem;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_qualification,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {

        holder.institutionName.setText(otherQualificationsItem.get(position).getCourseType());
        holder.courseType.setText(otherQualificationsItem.get(position).getGrade());
        holder.Grade.setText(otherQualificationsItem.get(position).getInstitutionName());
        holder.university.setText(otherQualificationsItem.get(position).getUniversity());

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView institutionName,courseType,Grade,university;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            institutionName=itemView.findViewById(R.id.InstitutionName);
            courseType=itemView.findViewById(R.id.coursetype);
            Grade=itemView.findViewById(R.id.Grade);
            university=itemView.findViewById(R.id.university);

        }
    }
}


