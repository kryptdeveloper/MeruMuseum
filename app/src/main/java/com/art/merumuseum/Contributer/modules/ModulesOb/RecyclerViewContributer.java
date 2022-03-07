package com.art.merumuseum.Contributer.modules.ModulesOb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.art.merumuseum.CuratorModules.ApproveArtefacts.ArtefactModelObject;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.ArtefactObject;
import com.art.merumuseum.Finance.Fmodels.ApproveModel;

import com.art.merumuseum1.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewContributer extends RecyclerView.Adapter<RecyclerViewContributer.Holder>{
    Context context;
    ArrayList<ArtefactObject> artefactObjects;
    Picasso picasso;

    public RecyclerViewContributer(Context context, ArrayList<ArtefactObject> artefactObjects) {
        this.context = context;
        this.artefactObjects = artefactObjects;
    }

    @NonNull
    @Override
    public RecyclerViewContributer.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.artholder,parent,false);
        Holder holder=new Holder(v);
        holder.approv.setVisibility(View.GONE);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewContributer.Holder holder, final int position) {


        holder.name.setText("Name:"+artefactObjects.get(position).getName());
        holder.title.setText("Artname:"+artefactObjects.get(position).getTitle());
        holder.status.setText("Status:"+artefactObjects.get(position).getStatus());
        holder.des.setText("Description:"+artefactObjects.get(position).getDesc());
        Glide.with(context).load(artefactObjects.get(position).getImageurl()).fitCenter().into(holder.art);




    }

    @Override
    public int getItemCount() {
        return artefactObjects.size();
    }

    public static class Holder extends RecyclerView.ViewHolder{
        TextView title,name,des,status;
        ImageView art;
        Button approv;


        public Holder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleIDcura);

            name=itemView.findViewById(R.id.namecura);
            des=itemView.findViewById(R.id.descriartcura);
            status=itemView.findViewById(R.id.idstatuscura);
            art=itemView.findViewById(R.id.imgIDcura);
            approv=itemView.findViewById(R.id.artcurabtn);

        }
    }


    public Bitmap bitmap(String s){
        byte[] decodeByte = Base64.decode(s, Base64.DEFAULT);
        Bitmap decodedBitmap = BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
        return decodedBitmap;
    }
}
