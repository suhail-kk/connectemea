package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.getDetails.AdditionalCourseItem;

import java.util.List;

public class AdditionalCourseAdapter extends RecyclerView.Adapter<AdditionalCourseAdapter.MyViewHolder>{

    Context context;
    List<AdditionalCourseItem> additionalCourseItem;

    public AdditionalCourseAdapter(Context applicationContext, List<AdditionalCourseItem> additionalCourseItem, ExtraCurricularActivityView context) {
        this.context = context;
        this. additionalCourseItem= additionalCourseItem;

    }

    @NonNull
    @Override
    public AdditionalCourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_additional,parent,false);

        return new AdditionalCourseAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdditionalCourseAdapter.MyViewHolder holder, int position) {

        holder.courseName.setText(additionalCourseItem.get(position).getCourseName());
        holder.institutionName.setText(additionalCourseItem.get(position).getInstitutionName());
        holder.university.setText(additionalCourseItem.get(position).getUniversity());
        holder.cgp.setText(Integer.toString(additionalCourseItem.get(position).getCgp()));

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView courseName,institutionName,university,cgp;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            courseName=itemView.findViewById(R.id.Coursename);
            institutionName=itemView.findViewById(R.id.University);
            university=itemView.findViewById(R.id.institutionName);
            cgp=itemView.findViewById(R.id.cgp);

        }
    }
}
