package com.art.merumuseum.GuideModules.guide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.art.merumuseum1.R;

import java.util.ArrayList;

public class guiderecyclerview extends RecyclerView.Adapter<guiderecyclerview.Holder> {

    Context context;
    ArrayList<guideobject> guideobjects;


    public guiderecyclerview(Context context, ArrayList<guideobject> guideobjects) {
        this.context = context;
        this.guideobjects=guideobjects;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.guidemodellayout,parent,false);
        Holder holder=new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") int position) {
        holder.hamount.setText(guideobjects.get(position).getAmount());
        holder.hdate.setText(guideobjects.get(position).getDate());
        holder.hemail.setText(guideobjects.get(position).getEmail());
        holder.hstatus.setText(guideobjects.get(position).getStatus());
        holder.hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(view.getContext(), CompleteActivity.class);
                inte.putExtra("amount",guideobjects.get(position).getAmount());
                inte.putExtra("date",guideobjects.get(position).getDate());
                inte.putExtra("code",guideobjects.get(position).getStatus());
                inte.putExtra("email",guideobjects.get(position).getEmail());
                inte.putExtra("transid",guideobjects.get(position).getId());
                view.getContext().startActivity(inte);

            }
        });

    }




    @Override
    public int getItemCount() {
        return guideobjects.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView hamount,hdate,hemail,hstatus;
        Button hbtn;


        public Holder(@NonNull View itemView) {
            super(itemView);
            hstatus=itemView.findViewById(R.id.ggstatus);
            hamount=itemView.findViewById(R.id.ggamount);
            hdate=itemView.findViewById(R.id.ggdate);
            hemail=itemView.findViewById(R.id.ggemail);
            hbtn=itemView.findViewById(R.id.ggapprove);
        }
    }
}

