package com.art.merumuseum.GuideModules.Feedback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.art.merumuseum1.R;

import java.util.ArrayList;

public class FeedAdapterObj extends RecyclerView.Adapter<FeedAdapterObj.HolderFeed>{

    Context context;
    private ArrayList<FeedbackObj> Objs;

    public FeedAdapterObj(Context context, ArrayList<FeedbackObj> objs) {
        this.context = context;
        Objs = objs;
    }

    @NonNull
    @Override
    public HolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.feedbackshow,parent,false);
      HolderFeed holderFinance=new HolderFeed(v);
        return holderFinance;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderFeed holder, int position) {

        holder.feed.setText(Objs.get(position).getFeedback());
        holder.mail.setText(Objs.get(position).getMail());

    }

    @Override
    public int getItemCount() {
        return Objs.size();
    }

    public class HolderFeed extends RecyclerView.ViewHolder {
        TextView feed,mail;
        public HolderFeed(@NonNull View itemView) {
            super(itemView);
            feed=itemView.findViewById(R.id.feeddetID);
            mail=itemView.findViewById(R.id.emailID);
        }
    }
}
