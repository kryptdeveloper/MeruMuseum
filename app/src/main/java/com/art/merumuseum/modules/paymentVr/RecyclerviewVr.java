package com.art.merumuseum.modules.paymentVr;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.art.merumuseum.modules.ModelMyActivitys.ModelObject;
import com.art.merumuseum.modules.ModelMyActivitys.ReceiptActivity;
import com.art.merumuseum.modules.ModelMyActivitys.RecyclerviewHistory;
import com.art.merumuseum1.R;

import java.util.ArrayList;

public class RecyclerviewVr extends RecyclerView.Adapter<RecyclerviewVr.Holder> {

    Context context;
    ArrayList<ModelObject> vrPayObjects;


    public RecyclerviewVr(Context context, ArrayList<ModelObject> vrPayObjects) {
        this.context = context;
        this.vrPayObjects = vrPayObjects;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.vrpayment,parent,false);
        Holder holder=new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.hamount.setText(vrPayObjects.get(position).getAmount());
        holder.hdate.setText(vrPayObjects.get(position).getDate());
        holder.hemail.setText(vrPayObjects.get(position).getEmail());
        holder.hstatus.setText(vrPayObjects.get(position).getStatus());
        holder.hbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(view.getContext(), ReceiptActivity.class);
                inte.putExtra("amount",vrPayObjects.get(position).getAmount());
                inte.putExtra("date",vrPayObjects.get(position).getDate());
                inte.putExtra("code",vrPayObjects.get(position).getStatus());
                inte.putExtra("email",vrPayObjects.get(position).getEmail());
                //inte.putExtra("transid",modelObjects.get(position).get());
                view.getContext().startActivity(inte);

            }
        });

    }


    @Override
    public int getItemCount() {
        return vrPayObjects.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView hamount,hdate,hemail,hstatus;
        Button hbtn;


        public Holder(@NonNull View itemView) {
            super(itemView);
            hstatus=itemView.findViewById(R.id.vrHstatus);
            hamount=itemView.findViewById(R.id.vrHamount);
            hdate=itemView.findViewById(R.id.vrHdate);
            hemail=itemView.findViewById(R.id.vrHemail);
            hbtn=itemView.findViewById(R.id.vrHapprove);
        }
    }
}
