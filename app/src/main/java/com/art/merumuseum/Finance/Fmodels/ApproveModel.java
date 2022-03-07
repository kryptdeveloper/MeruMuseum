package com.art.merumuseum.Finance.Fmodels;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;
import com.art.merumuseum.modules.Payment;

import java.util.HashMap;
import java.util.Map;

public class ApproveModel extends AppCompatActivity {
    Button approv,reject,Submit;
    TextView amount,code,mail,date ,id,status;
    ProgressDialog progressDialog;
    private RequestQueue mRequestQueue;
    LinksModel mm;
    EditText reasons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approve_model);
        progressDialog=new ProgressDialog(this);
        id = findViewById(R.id.transctid);
        amount = findViewById(R.id.faamount);
        code = findViewById(R.id.fcode);
        mail = findViewById(R.id.faemail);
        date = findViewById(R.id.faadate);
        reject = findViewById(R.id.faareject);
        approv = findViewById(R.id.faapprovebtn);
        status=findViewById(R.id.statusapprov);
        Submit=findViewById(R.id.subRejectid);
        reasons=findViewById(R.id.rejectdetid);

        Bundle extras = getIntent().getExtras();
        final String ids=extras.getString("transid");

        id.setText("TransactionId:  " + extras.getString("transid"));
        amount.setText("Amount  :" + extras.getString("amount"));
        code.setText("Code:   " + extras.getString("code"));
        mail.setText("Email:  " + extras.getString("email"));
        date.setText("Date:  " + extras.getString("date"));
       // status.setText("Status:" + extras.getString("status"));
        approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Aprove(extras.getString("code"));
                Toast.makeText(getApplicationContext(), extras.getString("code"), Toast.LENGTH_SHORT).show();

            }
        });
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              Submit.setVisibility(View.VISIBLE);
                reasons.setVisibility(View.VISIBLE);




            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String det=reasons.getText().toString();
                if (!det.isEmpty()) {
                    reject((extras.getString("code")), reasons.getText().toString());
                    Toast.makeText(ApproveModel.this, "submit", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ApproveModel.this, "Enter reasons for rejecting please", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

        private void Aprove(final String approve){
            mm=new LinksModel();
            progressDialog.setTitle("Approving");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            mRequestQueue= Volley.newRequestQueue(ApproveModel.this);


            StringRequest request =new StringRequest(Request.Method.POST, mm.getFbtnapprov(), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                   if (response.equals("sucees")){
                       Toast.makeText(ApproveModel.this, "Payment Approved", Toast.LENGTH_SHORT).show();
                       progressDialog.dismiss();
                   }else {
                       Toast.makeText(ApproveModel.this, " Not Approved", Toast.LENGTH_SHORT).show();
                       progressDialog.dismiss();

                   }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(ApproveModel.this, error.toString(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> param = new HashMap<>();
                    param.put("approved",approve);

                    return param;
                }
            };
            request.setShouldCache(false);
            mRequestQueue.add(request);

        }

    private void reject(final String reject,final String det){
        mm=new LinksModel();
        progressDialog.setTitle("Rejecting");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(ApproveModel.this);


        StringRequest request =new StringRequest(Request.Method.POST, mm.getFtbnrej(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucees")){
                    Toast.makeText(ApproveModel.this, "Payment Rejected", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(ApproveModel.this, " Not Rejected", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ApproveModel.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("rejected",reject);
                param.put("det",det);

                return param;
            }
        };
        request.setShouldCache(false);
        mRequestQueue.add(request);

    }







}
