package com.art.merumuseum.Contributer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;
import com.art.merumuseum1.R;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ContributeClass extends Fragment {

    private RequestQueue mRequestQueue;
    EditText name,des;
    ImageView viewimageselected;
    LinksModel linksModel;
    Bitmap bitmap;
    String userem;
    String n;
    Button send;
    public static int PICK_IMAGE = 5;
    Contrubuter mm;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contributelayout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm=new Contrubuter();
        viewimageselected=view.findViewById(R.id.imageselected);
        name=view.findViewById(R.id.artfactname);
        des=view.findViewById(R.id.artdescrptions);
        send=view.findViewById(R.id.artsendToDb);
        linksModel=new LinksModel();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(des.getText().toString(),toStingbit(bitmap),mm.getName(),name.getText().toString());
            }
        });
        viewimageselected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImageFromPhone();

            }
        });


    }
    private void getImageFromPhone() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_IMAGE) {
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {

                    try {
                        bitmap= MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),selectedImageUri);
                        viewimageselected.setImageBitmap(bitmap);


                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    n=selectedImageUri.toString();
                }
            }

        }
    }
    public void sendData(final String descri, final String image, final String email,final String nameart){
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Uploading Artefact");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();


        mRequestQueue= Volley.newRequestQueue(getContext());
        StringRequest request=new StringRequest(Request.Method.POST, linksModel.getUploadurl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                if(response.equals("succes")){
                    Toast.makeText(getContext(), "Uploaded Succesfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), "Did not uploaded..try again", Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("image",image);
                param.put("description",descri);
                param.put("email",email);
                param.put("artname",nameart);
                param.put("ips",linksModel.getIp());
                return param;
            }
        };
        request.setShouldCache(false);
        mRequestQueue.add(request);


    }

    public String toStingbit(Bitmap bitmap) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        byte[] imageByteArray = byteArrayOutputStream.toByteArray();
        String encodeImage = Base64.encodeToString(imageByteArray, Base64.DEFAULT);

        return encodeImage;
    }



}
