//package com.example.emea.Activity;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.emea.R;
//
//public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyViewHolder> {
//    Context context;
//    DegreeDetails degreeDetails;
//    DegreeMarkList degreeMarkList;
//
//    public EducationAdapter(Context applicationContext, DegreeDetails degreeDetails, DegreeMarkList degreeMarkList, EducationDetailsView context) {
//        this.context = context;
//        this.degreeDetails = degreeDetails;
//        this.degreeMarkList = degreeMarkList;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_degree, parent, false);
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        holder.collegename.setText(degreeDetails.getCollegeName());
//        holder.universityugc.setText(degreeDetails.getUniversity());
//        holder.courseugc.setText(degreeDetails.getCourseName());
//        holder.ugcmainbox.setText(degreeMarkList.getCoreMark());
//        holder.ugcsubbox.setText(degreeMarkList.getSubMark());
//        holder.ugcenglishbox.setText(degreeMarkList.getEnglishMark());
//        holder.ugclangbox.setText(degreeMarkList.getLanguageMark());
//        holder.opencoursebox.setText(degreeMarkList.getOpenMark());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 1;
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView collegename, universityugc, courseugc, ugcmainbox, ugcsubbox, ugcenglishbox, ugclangbox, opencoursebox;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            collegename = itemView.findViewById(R.id.collegename);
//
//            universityugc = itemView.findViewById(R.id.ugcuniversitydisplay);
//
//            courseugc = itemView.findViewById(R.id.ugccoursedisplay);
//
//            ugcmainbox = itemView.findViewById(R.id.ugccoredispaly);
//
//            ugcsubbox = itemView.findViewById(R.id.ugccompldisplay);
//
//            ugcenglishbox = itemView.findViewById(R.id.ugcengdispaly);
//
//            ugclangbox = itemView.findViewById(R.id.langdisplay);
//
//            opencoursebox = itemView.findViewById(R.id.opendisplay);
//
//        }
//    }
//}
//
