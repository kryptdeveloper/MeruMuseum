package com.art.merumuseum.LearnModules.modelEvents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.art.merumuseum1.R;

import java.util.ArrayList;


public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.Holder> {
    Context context;

    ArrayList<EventObject> eventObjects;

    public RecylerViewAdapter(Context context, ArrayList<EventObject> eventObjects) {
        this.context = context;
        this.eventObjects = eventObjects;
    }




    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.customevent,parent,false);
        Holder holder=new Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.title.setText(eventObjects.get(position).getTitle());
        holder.desc.setText(eventObjects.get(position).getDes());
        holder.date.setText(eventObjects.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return eventObjects.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView title,desc,date;

        public Holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.eventtitle);
            desc=itemView.findViewById(R.id.eventdesc);
            date=itemView.findViewById(R.id.date_id);

        }
    }
}
