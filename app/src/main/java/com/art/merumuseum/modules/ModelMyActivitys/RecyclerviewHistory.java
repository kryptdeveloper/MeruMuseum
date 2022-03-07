package com.art.merumuseum.modules.ModelMyActivitys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.art.merumuseum1.R;

import java.util.ArrayList;

public class RecyclerviewHistory extends RecyclerView.Adapter<RecyclerviewHistory.Holder> {

    Context context;
    ArrayList<ModelObject> modelObjects;


    public RecyclerviewHistory(Context context, ArrayList<ModelObject> modelObjects) {
        this.context = context;
        this.modelObjects = modelObjects;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.useractivities,parent,false);
        Holder holder=new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") final int position) {
        holder.hamount.setText("Amount: "+modelObjects.get(position).getAmount());
        holder.hdate.setText("Date: "+modelObjects.get(position).getDate());
        holder.hemail.setText("email  "+modelObjects.get(position).getEmail());
        holder.hstatus.setText("Status "+modelObjects.get(position).getStatus());
        holder.hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String var=modelObjects.get(position).getStatus();
                if (var.equals("approved")){

                    Intent inte = new Intent(view.getContext(), ReceiptActivity.class);
                    inte.putExtra("amount", modelObjects.get(position).getAmount());
                    inte.putExtra("date", modelObjects.get(position).getDate());
                    inte.putExtra("code", modelObjects.get(position).getStatus());
                    inte.putExtra("email", modelObjects.get(position).getEmail());
                    //inte.putExtra("transid",modelObjects.get(position).get());
                    view.getContext().startActivity(inte);
                }else{
                    Toast.makeText(context, "Cant print  unapproved receipt!", Toast.LENGTH_SHORT).show();

                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return modelObjects.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView hamount,hdate,hemail,hstatus;
        Button hbtn;


        public Holder(@NonNull View itemView) {
            super(itemView);
            hstatus=itemView.findViewById(R.id.Hstatus);
            hamount=itemView.findViewById(R.id.Hamount);
            hdate=itemView.findViewById(R.id.Hdate);
            hemail=itemView.findViewById(R.id.Hemail);
            hbtn=itemView.findViewById(R.id.Happrove);
        }
    }
}
