package com.art.merumuseum.CuratorModules.ApproveArtefacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.art.merumuseum.CuratorModules.ApproveActivity;
import com.art.merumuseum.Finance.Fmodels.ApproveModel;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

public class ArtefactModelObject extends RecyclerView.Adapter<ArtefactModelObject.Holder> {
    Context context;
    ArrayList<ArtefactObject> artefactObjects;
    Picasso picasso;
    LinksModel ll;
    public ArtefactModelObject(Context context, ArrayList<ArtefactObject> artefactObjects) {
        this.context = context;
        this.artefactObjects = artefactObjects;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.artholder,parent,false);
        Holder holder=new Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, @SuppressLint("RecyclerView") final int position) {
        ll=new LinksModel();


        holder.name.setText("Name:"+artefactObjects.get(position).getName());
        holder.title.setText("Artname:"+artefactObjects.get(position).getTitle());
        holder.status.setText("Status:"+artefactObjects.get(position).getStatus());
        holder.des.setText("Description:"+artefactObjects.get(position).getDesc());

        Glide.with(context).load(artefactObjects.get(position).getImageurl()).fitCenter().into(holder.art);
        Toast.makeText(context.getApplicationContext(), artefactObjects.get(position).getImageurl(), Toast.LENGTH_SHORT).show();

        holder.approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(view.getContext(), ApproveActivity.class);
                inte.putExtra("name",artefactObjects.get(position).getName());
                inte.putExtra("status",artefactObjects.get(position).getStatus());
                inte.putExtra("artnm",artefactObjects.get(position).getTitle());
                inte.putExtra("desc",artefactObjects.get(position).getDesc());
                inte.putExtra("imgurl",artefactObjects.get(position).getImageurl());
                // Toast.makeText(context.getApplicationContext(), "http://"+ll.getIp()+"/adminmeru/images/"+artefactObjects.get(position).getImageurl()+".jpg", Toast.LENGTH_SHORT).show();


                view.getContext().startActivity(inte);


            }
        });

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

}
