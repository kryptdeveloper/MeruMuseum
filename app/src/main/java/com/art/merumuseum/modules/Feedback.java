package com.art.merumuseum.modules;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;
import com.art.merumuseum1.R;

import java.util.HashMap;
import java.util.Map;


public class Feedback extends Fragment{
    Button submitfed;
    LinksModel mm;
    Spinner choose;
    Main main;
    EditText feed;
    String link="";
    String receiver="";
    private RequestQueue mRequestQueue;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feedbackmodule,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm=new LinksModel();
        main=new Main();
        progressDialog=new ProgressDialog(getContext());
        submitfed=view.findViewById(R.id.submitFedbtn);
        choose=view.findViewById(R.id.cuser);
        feed=view.findViewById(R.id.fedContent);


        String [] userers={"Curator","Finance","Guide","Admin"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item,userers);
        choose.setAdapter(adapter);
        choose.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        link=mm.getUserfeed();
                        receiver="curator";

                        Toast.makeText(getContext(), receiver, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:

                        receiver="finance";
                        Toast.makeText(getContext(), receiver, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:

                        receiver="guide";
                        Toast.makeText(getContext(), receiver, Toast.LENGTH_SHORT).show();

                        break;
                    case 3:

                        receiver="admin";
                        Toast.makeText(getContext(), receiver, Toast.LENGTH_SHORT).show();

                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        submitfed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(feed.getText().toString().equals("")){
                    Toast.makeText(getContext(), "please enter you feedback", Toast.LENGTH_SHORT).show();
                    
                }else{

                   sendFeedback(main.getName(),feed.getText().toString(),receiver);
                }
                
            

            }
        });

    }


        private void  sendFeedback(final String mail,final String feed, final String receiver) {

                progressDialog.setTitle("Sending feedback");
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setIndeterminate(false);
                progressDialog.show();
                mRequestQueue = Volley.newRequestQueue(getContext());
            Toast.makeText(getContext(), receiver+mail+feed, Toast.LENGTH_SHORT).show();


                StringRequest request = new StringRequest(Request.Method.POST,mm.getUserfeed(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.equals("sen")) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(), "Thank you for your feedback!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(getContext(), "Please try checking your internet and Send your feedback again", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();



                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> param = new HashMap<>();

                       param.put("module",receiver);
                        param.put("email",mail);

                        param.put("feed",feed);



                        return param;
                    }
                };
                request.setShouldCache(false);
                request.setRetryPolicy(new DefaultRetryPolicy(10000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                mRequestQueue.add(request);


        }




}

