package com.art.merumuseum.UserInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.art.merumuseum.Main;

import com.art.merumuseum1.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

public class Visitor extends AppCompatActivity {
    Button btnvs;
    String ip="192.168.137.1";
    MaterialEditText vemail,vpassword;
    String mainuRl ="http://"+ip+"/adminmeru/signinVisitor.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor);

        btnvs=findViewById(R.id.login1vs);
        vemail = findViewById(R.id.passwordvs);
        vpassword = findViewById(R.id.passwordvs);
        btnvs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(vemail.getText().toString(),vpassword.getText().toString());
            }
        });
    }

    private void login(final String email, final String password) {

        StringRequest request = new StringRequest(Request.Method.POST, mainuRl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equals("Login")) {
                    Toast.makeText(Visitor.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Visitor.this,Main.class));



                }

                else {
                    Toast.makeText(Visitor.this, response, Toast.LENGTH_SHORT).show();

                }
                Toast.makeText(Visitor.this, response, Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Visitor.this, error.toString(), Toast.LENGTH_SHORT).show();

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
        request.setRetryPolicy(new DefaultRetryPolicy(30000,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Singleton.getmInstance(Visitor.this).addToRequestQueue(request);

    }
}
