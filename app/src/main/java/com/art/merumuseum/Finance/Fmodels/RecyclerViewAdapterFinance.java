package com.art.merumuseum.Finance.Fmodels;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.art.merumuseum1.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapterFinance extends RecyclerView.Adapter<RecyclerViewAdapterFinance.HolderFinance> implements Filterable{
    Context context;
    private ArrayList<PayObject> payObjects;

    private ArrayList<PayObject> exampleListFull;
    String ghghdf="";







    public RecyclerViewAdapterFinance(Context context, ArrayList<PayObject> payObjects) {
        this.context = context;
        this.payObjects = payObjects;
        exampleListFull=new ArrayList<>(payObjects);

    }



    @NonNull
    @Override
    public HolderFinance onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.approvefinance,parent,false);
        HolderFinance holderFinance=new HolderFinance(v);
        Toast.makeText(context.getApplicationContext(), ghghdf, Toast.LENGTH_SHORT).show();



        return holderFinance;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFinance holder, @SuppressLint("RecyclerView")final int position) {


        holder.status.setText("Status:"+payObjects.get(position).getStatus());
        holder.amount.setText("Amount:"+payObjects.get(position).getAmount());
        holder.mpesacode.setText("Mpesa Code:"+payObjects.get(position).getMpesacode());
        holder.email.setText("Email :"+payObjects.get(position).getName());
        ghghdf=payObjects.get(position).getName();
        holder.approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(view.getContext(),ApproveModel.class);
                inte.putExtra("amount",payObjects.get(position).getAmount());
                inte.putExtra("date",payObjects.get(position).getDate());
                inte.putExtra("code",payObjects.get(position).getMpesacode());
                inte.putExtra("email",payObjects.get(position).getName());
                inte.putExtra("transid",payObjects.get(position).getTransid());
                inte.putExtra("status",payObjects.get(position).getStatus());
                view.getContext().startActivity(inte);


            }
        });

    }



    @Override
    public int getItemCount() {
        return payObjects.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PayObject> filteredList = new ArrayList<>();


            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (PayObject item : exampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            payObjects.clear();


            payObjects.addAll((ArrayList) results.values);




            notifyDataSetChanged();
        }
    };

    public static class HolderFinance extends RecyclerView.ViewHolder{
        TextView amount,date,email,mpesacode,status;
        Button approv;


        public HolderFinance(@NonNull View itemView) {
            super(itemView);
            amount=itemView.findViewById(R.id.amountapprov);
            date=itemView.findViewById(R.id.dateApprov);
            email=itemView.findViewById(R.id.emailapprov);
            status=itemView.findViewById(R.id.statusapprov);
            mpesacode=itemView.findViewById(R.id.mpesaApprov);
            approv=itemView.findViewById(R.id.btnApprove);
        }
    }

}
