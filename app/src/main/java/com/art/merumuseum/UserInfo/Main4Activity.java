package com.art.merumuseum.UserInfo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Main;
import com.art.merumuseum1.R;


import java.util.HashMap;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {
    EditText nm,pas;
    Button l;
    String uu="";
    String ip="192.168.36.103";
    String visitor ="http://"+ip+"/adminmeru/Vistors.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        nm=findViewById(R.id.email_);
        pas=findViewById(R.id.pass_);
        l=findViewById(R.id.btn_user);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(nm.getText().toString(),pas.getText().toString());
            }
        });

    }

    private void login(final String toString, final String toString1) {
        StringRequest request=new StringRequest(Request.Method.POST, visitor, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equals("Login")){
                    uu="Login";
                    Toast.makeText(Main4Activity.this,"gbuyf t"+ uu, Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Main4Activity.this, Main.class));
                    Toast.makeText(Main4Activity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Main4Activity.this, response.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Main4Activity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> hashmap= new HashMap<>();
                hashmap.put("email",toString);

                hashmap.put("psw",toString1);
                return hashmap;
            }
        };
        RequestQueue queue1= Volley.newRequestQueue(getApplicationContext());
        queue1.add(request);

    }
}