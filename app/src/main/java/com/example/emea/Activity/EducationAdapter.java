package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.DegreeDetails;
import com.example.emea.Response.DegreeMarkList;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyViewHolder> {
    Context context;
    DegreeDetails degreeDetails;
    DegreeMarkList degreeMarkList;
//   OnMovieCallBack callBack;



    public EducationAdapter(Context applicationContext, DegreeDetails degreeDetails, DegreeMarkList degreeMarkList, EducationDetailsView context) {
        this.context = context;
        this.degreeDetails = degreeDetails;
        this.degreeMarkList = degreeMarkList;
    }

//    public EducationAdapter(Context applicationContext, DegreeMarkList degreeMarkList, EducationDetailsView context) {
//        this.context = context;
////        this.degreeDetails = degreeDetails;
//        this.degreeMarkList = degreeMarkList;
//    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_degree, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.collegename.setText(degreeDetails.getCollegeName());
        holder.universityugc.setText(degreeDetails.getUniversity());
        holder.courseugc.setText(degreeDetails.getCourseName());
        holder.ugcmainbox.setText(degreeMarkList.getCoreMark());
        holder.ugcsubbox.setText(degreeMarkList.getSubMark());
        holder.ugcenglishbox.setText(degreeMarkList.getEnglishMark());
        holder.ugclangbox.setText(degreeMarkList.getLanguageMark());
        holder.opencoursebox.setText(degreeMarkList.getOpenMark());


    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView collegename, universityugc, courseugc, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            collegename = itemView.findViewById(R.id.collegename);
//                collegename.setText(textcollegename);
//
            universityugc = itemView.findViewById(R.id.ugcuniversitydisplay);
//                universityugc.setText(textuniversity);
//
            courseugc = itemView.findViewById(R.id.ugccoursedisplay);
//               courseugc.setText(textugccourse);
//
            ugcmainbox = itemView.findViewById(R.id.ugccoredispaly);
//                ugcmainbox.setText(textugcmainbox);
//
            ugcsubbox = itemView.findViewById(R.id.ugccompldisplay);
//                ugcsubbox.setText(textcoresub);
//
            ugcenglishbox = itemView.findViewById(R.id.ugcengdispaly);
//                ugcenglishbox.setText(textugcenglishbox);
//
            ugclangbox = itemView.findViewById(R.id.langdisplay);
//                ugclangbox.setText(textugclangbox);
//
            opencoursebox = itemView.findViewById(R.id.opendisplay);
//                opencoursebox.setText(textopencoursebox);


        }
//    }
    }
}

