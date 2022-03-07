package com.art.merumuseum.modules;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;

import com.art.merumuseum.UserInfo.Model;
import com.art.merumuseum1.R;
import com.google.android.material.navigation.NavigationView;

public class BuyATicket extends Fragment implements CheckBox.OnCheckedChangeListener {
    LinksModel ll;
    CheckBox ac,kc,ar,kr,a_r,k_r;
    EditText eac,ekc,ear,ekr,ea_r,ek_r;
    Button proceed;
    int pac,pkc,par,pkr,pa_r,pk_r;
    int total=0;
    Main mm;

    Model model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ll=new LinksModel();

        return inflater.inflate(R.layout.buyatickect, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ac = view.findViewById(R.id.ac);
        kc = view.findViewById(R.id.kc);
        ar = view.findViewById(R.id.ar);
        kr = view.findViewById(R.id.kr);
        a_r = view.findViewById(R.id.a_r);
        k_r = view.findViewById(R.id.k_r);
        proceed=view.findViewById(R.id.pCheck);


        eac = view.findViewById(R.id.acitizens);
        ekc = view.findViewById(R.id.kcitizens);
        ear = view.findViewById(R.id.aresidents);
        ekr = view.findViewById(R.id.kresidents);
        ea_r = view.findViewById(R.id.anonresidents);
        ek_r = view.findViewById(R.id.knonresidents);
        ac.setOnCheckedChangeListener(this);
        kc.setOnCheckedChangeListener(this);
        ar.setOnCheckedChangeListener(this);
        kr.setOnCheckedChangeListener(this);
        a_r.setOnCheckedChangeListener(this);
        k_r.setOnCheckedChangeListener(this);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ac.isChecked() ||kc.isChecked()||ar.isChecked()||kr.isChecked()||a_r.isChecked()||k_r.isChecked()){
                    if(ac.isChecked()){

                        try {
                            pac=Integer.valueOf(eac.getText().toString());
                            total+=(pac*200);
                            eac.getText().clear();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if (kc.isChecked()){
                        try {
                            pkc=Integer.valueOf(ekc.getText().toString());
                            total+=(pkc*100);
                            ekc.getText().clear();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if (ar.isChecked()){
                        try {
                            par=Integer.valueOf(ear.getText().toString());
                            total+=(par*400);
                            ear.getText().clear();

                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if (kr.isChecked()){
                        try {
                            pkr=Integer.valueOf(ekr.getText().toString());
                            total+=(pkr*200);
                            ekr.getText().clear();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if (a_r.isChecked()){
                        try {
                            pa_r=Integer.valueOf(ea_r.getText().toString());
                            total+=(pa_r*500);

                            ea_r.getText().clear();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if (k_r.isChecked()){
                        try {
                            pk_r=Integer.valueOf(ek_r.getText().toString());
                            total+=(pk_r*250);
                            ek_r.getText().clear();
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }
                    if(total==0){

                        Toast.makeText(getContext(), "enter no of adults or children", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        Intent intent=new Intent(getContext(),Payment.class);
                        intent.putExtra("prize",String.valueOf(total));

                        startActivity(intent);


                        getActivity().finish();

                    }





                }else{
                    Toast.makeText(getContext(), "You cannot proceed before choosing", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (ac.isChecked()) {
            eac.setVisibility(View.VISIBLE);

        } else {
            eac.setVisibility(View.GONE);

        }

        if (kc.isChecked()) {
            ekc.setVisibility(View.VISIBLE);

        } else {
            ekc.setVisibility(View.GONE);

        }
        if (ar.isChecked()) {
            ear.setVisibility(View.VISIBLE);

        } else {
            ear.setVisibility(View.GONE);

        }
        if (kr.isChecked()) {
            ekr.setVisibility(View.VISIBLE);

        } else {
            ekr.setVisibility(View.GONE);

        }
        if (a_r.isChecked()) {
            ea_r.setVisibility(View.VISIBLE);

        } else {
            ea_r.setVisibility(View.GONE);

        }

        if (k_r.isChecked()) {
            ek_r.setVisibility(View.VISIBLE);

        } else {
            ek_r.setVisibility(View.GONE);

        }

    }
}

