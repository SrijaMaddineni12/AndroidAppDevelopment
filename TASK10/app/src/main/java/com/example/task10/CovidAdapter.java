package com.example.task10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CovidAdapter extends RecyclerView.Adapter<CovidAdapter.MyViewHolder> {
    Context context;
    ArrayList<CovidModel> models;

    public CovidAdapter(MainActivity mainActivity, ArrayList<CovidModel> covidModels) {
        context = mainActivity;
        models = covidModels;

    }

    @NonNull
    @Override
    public CovidAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.row_design,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidAdapter.MyViewHolder holder, int position) {

        CovidModel covidModel = models.get(position);

        holder.tv1.setText(covidModel.getDate());
        holder.tv2.setText(covidModel.getConfirm());
        holder.tv3.setText(covidModel.getActive());
        holder.tv4.setText(covidModel.getRecover());
        holder.tv5.setText(covidModel.getDeaths());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4,tv5;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.date);
            tv2 = itemView.findViewById(R.id.confirm);
            tv3 = itemView.findViewById(R.id.active);
            tv4 = itemView.findViewById(R.id.recover);
            tv5 = itemView.findViewById(R.id.deaths);
        }
    }
}
