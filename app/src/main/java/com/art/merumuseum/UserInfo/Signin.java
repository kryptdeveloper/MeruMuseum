package com.art.merumuseum.UserInfo;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Contributer.Contrubuter;
import com.art.merumuseum.CuratorModules.Curator;
import com.art.merumuseum.Finance.FinanceActivity;
import com.art.merumuseum.GuideModules.Guide;

import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;

import com.art.merumuseum.ModelDet;
import com.art.merumuseum1.R;


import java.util.HashMap;
import java.util.Map;

public class Signin extends AppCompatActivity {


    EditText password,email;
    Button register,login;
    CheckBox checkedStatus;
    Spinner spinner;

    String uRl="";
    public String teaser="";
    TextView usernm;
    ProgressDialog progressDialog;
    private RequestQueue mRequestQueue;
    LinksModel mm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.userinfo_activity_main4);

        mm=new LinksModel();
        email = findViewById(R.id.email);

        spinner=findViewById(R.id.choiceOf);
        password = findViewById(R.id.password);
        checkedStatus = findViewById(R.id.checkbox);


//        final String curator=ipp.getIp();


        String [] userers={"Contributer","Visitor","Guide","Finance","Curator"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,userers);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        uRl=mm.getContributer();
                        break;
                    case 1:
                        uRl=mm.getVisitor();
                        break;
                    case 2:
                        uRl=mm.getGuide();

                        break;
                    case 3:
                        uRl=mm.getFinance();

                        break;
                    case 4:
                        uRl=mm.getCurator();

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        login = findViewById(R.id.login1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tex_email = email.getText().toString();
                String tex_password = password.getText().toString();
                if (TextUtils.isEmpty(tex_email) || TextUtils.isEmpty(tex_password)){
                    Toast.makeText(Signin.this, "All Fields Required", Toast.LENGTH_SHORT).show();
                }
                else{
                    login(tex_email,tex_password);
                }
            }
        });

        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Signin.this,Register.class));
                finish();
            }
        });
    }


    private void login(final String email, final String password){
        final ProgressDialog progressDialog = new ProgressDialog(Signin.this);
        progressDialog.setTitle("Logging into your account");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(Signin.this);
        StringRequest request = new StringRequest(Request.Method.POST, uRl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("Login Curator")) {
                    Intent in=new Intent(Signin.this, Curator.class);
                    startActivity(in);
                    finish();


                }else  if (response.equals("Login")) {
                    Intent i=new Intent(Signin.this,Main.class);
                    Toast.makeText(Signin.this, "You are logged in!", Toast.LENGTH_SHORT).show();
//                    i.putExtra("uname",email);


                    ModelDet modelDe=new ModelDet();
                    modelDe.setNam(email);

                    startActivity(i);
                    finish();


                }else if (response.equals("Login Contributer")) {

                    Intent i=new Intent(Signin.this,Contrubuter.class);
                    Toast.makeText(Signin.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                    i.putExtra("uname",email);

                    startActivity(i);
                    finish();


                }else if (response.equals("Login Finance")) {
                    startActivity(new Intent(Signin.this, FinanceActivity.class));
                    Toast.makeText(Signin.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                    finish();


                }else if (response.equals("Login Guide")) {
                    startActivity(new Intent(Signin.this, Guide.class));
                    Toast.makeText(Signin.this, "You are logged in!", Toast.LENGTH_SHORT).show();
                    finish();


                }
                else {
                    Toast.makeText(Signin.this, "Unsuccesful login!", Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Signin.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("email",email);
                param.put("psw",password);
                return param;

            }
        };

        request.setShouldCache(false);
        mRequestQueue.add(request);

    }




}