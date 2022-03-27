package com.art.merumuseum.UserInfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;


import com.art.merumuseum1.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Register extends AppCompatActivity {
    LinksModel linksModel;


    String []users ={"Contributer","Visitor"};
    Spinner spinner;
    String selectedUrl="";





    MaterialEditText userName,secondname,emailAddress,password,mobile;
    RadioGroup radioGroup;
    Button register;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Register.this,Signin.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity_register);
        linksModel=new LinksModel();


        Objects.requireNonNull(getSupportActionBar()).setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userName = findViewById(R.id.username);
        emailAddress = findViewById(R.id.email);
        secondname=findViewById(R.id.sname);

        password = findViewById(R.id.password);

        spinner=findViewById(R.id.choiceOfUser);
        mobile = findViewById(R.id.mobile);
        radioGroup = findViewById(R.id.radioButton);



        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,users);

        spinner.setAdapter(arrayAdapter);

        register = findViewById(R.id.register);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        selectedUrl=linksModel.getContributerurl();


                        break;
                    case 1:
                        selectedUrl=linksModel.getCustomer();

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                final String user_name = userName.getText().toString();
                final String secName = secondname.getText().toString();
                final String email = emailAddress.getText().toString();
                final String txt_password = password.getText().toString();
                final String txt_mobile = mobile.getText().toString();
                int checkedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selected_gender = radioGroup.findViewById(checkedId);
                if (selected_gender == null){
                    Toast.makeText(Register.this, "Select gender please", Toast.LENGTH_SHORT).show();
                }
                else {
                    final String gender = selected_gender.getText().toString();
                    if(TextUtils.isEmpty(user_name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(txt_password) ||
                            TextUtils.isEmpty(txt_mobile)){
                        Toast.makeText(Register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    }

                    else{
                        register(user_name,secName,email,txt_password,txt_mobile,gender);
                    }
                }


            }
        });



    }



    private void register(final String username,final String secName, final String email, final String password, final String mobile, final String gender) {
        if (mobile.length() == 10) {
            Toast.makeText(getApplicationContext(), secName, Toast.LENGTH_SHORT).show();

            final ProgressDialog progressDialog = new ProgressDialog(Register.this);
            progressDialog.setTitle("Registering your account");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();


            StringRequest request = new StringRequest(Request.Method.POST,selectedUrl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response.equals("You are registered successfully")) {
                        Toast.makeText(Register.this, "Wait for approval", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, Signin.class));
                        progressDialog.dismiss();
                        finish();
                    } else {
                        Toast.makeText(Register.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Register.this, error.toString(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<>();
                    param.put("username", username);
                    param.put("secondname",secName);
                    param.put("email", email);
                    param.put("psw", password);
                    param.put("mobile", mobile);
                    param.put("gender", gender);
                    return param;

                }
            };

            request.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            Singleton.getmInstance(Register.this).addToRequestQueue(request);

        }else{
            Toast.makeText(Register.this, "max phone length 10", Toast.LENGTH_SHORT).show();

            return;
        }
    }





}