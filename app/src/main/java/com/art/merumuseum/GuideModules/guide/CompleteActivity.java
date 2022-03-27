package com.art.merumuseum.GuideModules.guide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Fmodels.ApproveModel;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;


import java.util.HashMap;
import java.util.Map;

public class CompleteActivity extends AppCompatActivity {
    Button complete;
    Button didnotComplete;
    LinksModel mm;
    ProgressDialog progressDialog;
    private RequestQueue mRequestQueue;
    TextView id,amount,code,mail,date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);
        progressDialog=new ProgressDialog(this);
        complete=findViewById(R.id.didcomplete);
        didnotComplete=findViewById(R.id.dnCome);
        id=findViewById(R.id.ggtransctid);
        amount=findViewById(R.id.ggfaamount);
        code=findViewById(R.id.ggfcode);
        mail=findViewById(R.id.ggfaemail);
        date=findViewById(R.id.ggfaadate);
        mm=new LinksModel();
        Bundle extras = getIntent().getExtras();
        String ids=extras.getString("transid");
        id.setText("TransactionId:" + extras.getString("transid"));
        amount.setText("Amount:" + extras.getString("amount"));
        code.setText("Code:" + extras.getString("code"));
        mail.setText("Email:" + extras.getString("email"));
        date.setText("Date:" + extras.getString("date"));



        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                completeFun(ids);

            }
        });
        didnotComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                didnotCompleteFun(ids);

            }
        });
    }

    private void didnotCompleteFun(String complete ) {
        mm=new LinksModel();
        progressDialog.setTitle("Setting did not complete");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(CompleteActivity.this);


        StringRequest request =new StringRequest(Request.Method.POST, mm.getBtncomplete(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucees")){
                    Toast.makeText(CompleteActivity.this, "task complete", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(CompleteActivity.this, " not succesful try again!", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CompleteActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("approve",complete);

                return param;
            }
        };
        request.setShouldCache(false);
        mRequestQueue.add(request);
    }

    private void completeFun(String didnotcomplete) {
        mm=new LinksModel();
        progressDialog.setTitle("Setting up");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(CompleteActivity.this);


        StringRequest request =new StringRequest(Request.Method.POST, mm.getBtndnComplete(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucees")){
                    Toast.makeText(CompleteActivity.this, "Visitor completed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(CompleteActivity.this, "not succesful", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CompleteActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("approved",didnotcomplete);

                return param;
            }
        };
        request.setShouldCache(false);
        mRequestQueue.add(request);
    }
}
