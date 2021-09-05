//package com.example.emea.Activity;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.example.emea.R;
//import com.example.emea.Response.EducationResponse;
//import com.example.emea.Response.EducationViewResponse;
//import com.example.movielistapp.model.ResultsItem;
//
//import java.util.ArrayList;
//
//public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyViewHolder> {
//    Context context;
//    ArrayList<EducationViewResponse> alleducationItem;
////   OnMovieCallBack callBack;
//
//    public EducationAdapter(Context context) {
//        this.context = context;
//  //      this.allMovieItem = allMovieItem;
//   //     this.callBack = callBack;
//
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view= LayoutInflater.from(context).inflate(R.layout.recyclerview_degree,parent,false);
//
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//
//        holder.collegename.setText(EducationResponse.get(position).getC());
//        holder.universityugc.setText(allMovieItem.get(position).getOriginalLanguage());
//        holder.courseugc.setText(allMovieItem.get(position).getReleaseDate());
//        holder.ugcmainbox.setText(String.valueOf(allMovieItem.get(position).getVoteAverage()));
//        holder.ugcsubbox.setText(String.valueOf(allMovieItem.get(position).getVoteCount()));
//        holder.ugcenglishbox.setText(String.valueOf(allMovieItem.get(position).getVoteCount()));
//        holder.ugclangbox.setText(String.valueOf(allMovieItem.get(position).getVoteCount()));
//        holder.opencoursebox.setText(String.valueOf(allMovieItem.get(position).getVoteCount()));
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return allMovieItem.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView collegename,universityugc,courseugc,ugcmainbox,ugcsubbox,ugcenglishbox,ugclangbox,opencoursebox;
//
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//
//                            collegename=itemView.findViewById(R.id.coursedisplay);
////                collegename.setText(textcollegename);
////
//                universityugc=itemView.findViewById(R.id.ugcuniversitydisplay);
////                universityugc.setText(textuniversity);
////
//                courseugc=itemView.findViewById(R.id.ugccoursedisplay);
////               courseugc.setText(textugccourse);
////
//                ugcmainbox=itemView.findViewById(R.id.ugccoredispaly);
////                ugcmainbox.setText(textugcmainbox);
////
//                ugcsubbox=itemView.findViewById(R.id.ugccompldisplay);
////                ugcsubbox.setText(textcoresub);
////
//                ugcenglishbox=itemView.findViewById(R.id.ugcengdispaly);
////                ugcenglishbox.setText(textugcenglishbox);
////
//               ugclangbox=itemView.findViewById(R.id.langdisplay);
////                ugclangbox.setText(textugclangbox);
////
//                opencoursebox=itemView.findViewById(R.id.opendisplay);
////                opencoursebox.setText(textopencoursebox);
//
//
//        }
//    }
//}
//
