package com.example.emea.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emea.R;
import com.example.emea.Response.getDetails.ExtraCurricularItem;
import com.example.emea.Response.getDetails.OtherQualificationsItem;

import java.util.List;

public class ExtracurricularAdapter extends RecyclerView.Adapter<ExtracurricularAdapter.MyViewHolder> {

    Context context;
    List<ExtraCurricularItem> extraCurricularItem;

    public ExtracurricularAdapter(Context applicationContext,List<ExtraCurricularItem> extraCurricularItem, ExtraCurricularActivityView context) {
        this.context = context;
        this. extraCurricularItem= extraCurricularItem;

    }

    @NonNull
    @Override
    public ExtracurricularAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_extra,parent,false);

        return new ExtracurricularAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtracurricularAdapter.MyViewHolder holder, int position) {

        holder.activityname.setText(extraCurricularItem.get(position).getActivity());
        holder.yrparticipation.setText(extraCurricularItem.get(position).getYearOfParticipation());
        holder.price.setText(extraCurricularItem.get(position).getPrice());
        holder.detailsparticipation.setText(extraCurricularItem.get(position).getDetailsOfExcellenceInPerformance());

    }

    @Override
    public int getItemCount() {
        return extraCurricularItem.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView activityname,yrparticipation,price,detailsparticipation;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            activityname=itemView.findViewById(R.id.curricularActivityName);
            yrparticipation=itemView.findViewById(R.id.yearOfParticipation);
            price=itemView.findViewById(R.id.priceOfActivity);
            detailsparticipation=itemView.findViewById(R.id.dtlsOfPariticipation);

        }
    }
}
