package com.art.merumuseum.modules;

import android.Manifest;
import android.app.Activity;
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

import com.art.merumuseum1.R;


public class Feedback extends Fragment{
    Button submitfed;
    Spinner choose;
    EditText feed;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.feedbackmodule,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
                        Toast.makeText(getContext(), "Curator", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getContext(), "Finance", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(), "Guide", Toast.LENGTH_SHORT).show();

                        break;
                    case 3:
                        Toast.makeText(getContext(), "admin", Toast.LENGTH_SHORT).show();

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
                if(feed.getText().toString()==""){
                    Toast.makeText(getContext(), "please enter you feedback", Toast.LENGTH_SHORT).show();
                    
                }else{

                    sendFeedback();
                }
                
            

            }
        });

    }

    private void sendFeedback() {
        Toast.makeText(getContext(), "yeaa", Toast.LENGTH_SHORT).show();
    }


}

