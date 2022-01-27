package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.getDetails.DegreeItem;

import java.util.List;

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.MyViewHolder> {
    Context context;
    List<DegreeItem>degreeItem;

    public EducationAdapter(Context applicationContext, List<DegreeItem> degreeItem, EducationDetailsView context) {
        this.context = context;
        this.degreeItem= degreeItem;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_degree, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.collegename.setText( degreeItem.get(position).getCollege());
        holder.universityugc.setText(degreeItem.get(position).getUniversity());
        holder.courseugc.setText(degreeItem.get(position).getCourse());
        holder.ugcmainbox.setText(degreeItem.get(position).getCore());
//        holder.ugcsubbox.setText(degreeItem.get(position).get);
        holder.ugccommonOnebox.setText(degreeItem.get(position).getCommonOne());
        holder.ugccommonTwobox.setText(degreeItem.get(position).getCommonTwo());
        holder.opencoursebox.setText(degreeItem.get(position).getOpen());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView collegename, universityugc, courseugc, ugcmainbox, ugcsubbox, ugccommonOnebox, ugccommonTwobox, opencoursebox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            collegename = itemView.findViewById(R.id.collegename);

            universityugc = itemView.findViewById(R.id.ugcuniversitydisplay);

            courseugc = itemView.findViewById(R.id.ugccoursedisplay);

            ugcmainbox = itemView.findViewById(R.id.ugccoredispaly);

            ugcsubbox = itemView.findViewById(R.id.ugccompldisplay);

            ugccommonOnebox = itemView.findViewById(R.id.ugccommondispaly);

            ugccommonTwobox = itemView.findViewById(R.id.commontwodisplay);

            opencoursebox = itemView.findViewById(R.id.opendisplay);

        }
    }
}

