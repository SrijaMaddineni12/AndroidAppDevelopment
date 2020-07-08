package com.example.task9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    int myImages[];
    String myNames[];
    String myNumber[];
    String myapiLevel[];
    String myreleasedate[];
    Context ct;
    public MyAdapter(MainActivity mainActivity, int[] images, String[] names, String[] numbers, String[] apilevel, String[] releasedate ) {

        myImages = images;
        myNames = names;
        myNumber = numbers;
        myapiLevel = apilevel;
        myreleasedate = releasedate;
        ct = mainActivity;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.myitem,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(myImages[position]);
        holder.tv.setText(myNames[position]);
        holder.tv1.setText(myNumber[position]);
        holder.tv2.setText(myapiLevel[position]);
        holder.tv3.setText(myreleasedate[position]);

    }

    @Override
    public int getItemCount() {
        return myImages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.poster);
            tv = itemView.findViewById(R.id.postername);
            tv1 = itemView.findViewById(R.id.versionnumber);
            tv2 = itemView.findViewById(R.id.apilevel);
            tv3 = itemView.findViewById(R.id.releasedate);
        }
    }
}
