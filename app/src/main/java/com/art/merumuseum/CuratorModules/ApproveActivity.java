package com.art.merumuseum.CuratorModules;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.Map;

public class ApproveActivity extends AppCompatActivity {
    ImageView art;
    TextView nm,artnm,des,status;
    ProgressDialog progressDialog;
    Button approv,reject;
    LinksModel mm;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog=new ProgressDialog(this);
        setContentView(R.layout.activity_approve);
        art=findViewById(R.id.aprovactimag);
        nm=findViewById(R.id.artnmAprov);
        artnm=findViewById(R.id.artnmAprov);
        des=findViewById(R.id.aproactDes);
        status=findViewById(R.id.approvactstatus);
        reject=findViewById(R.id.rejecBtnCura);
        approv=findViewById(R.id.aprovBtnCura);

        Bundle extras = getIntent().getExtras();
        final String ids=extras.getString("transid");

        nm.setText("Contributer email:" + extras.getString("name"));
        artnm.setText("Artefact name:" + extras.getString("artnm"));
        des.setText("Description:" + extras.getString("desc"));
        status.setText("Status:" + extras.getString("status"));
        Glide.with(ApproveActivity.this).load(extras.getString("imgurl")).fitCenter().into(art);
        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rejectArt(extras.getString("name"));

            }
        });
        approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                approvArt(extras.getString("name"));

            }
        });



    }

    private void approvArt(String approve) {
        mm=new LinksModel();
        progressDialog.setTitle("Approving");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(ApproveActivity.this);


        StringRequest request =new StringRequest(Request.Method.DEPRECATED_GET_OR_POST, mm.getApprbtncura(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucees")){
                    Toast.makeText(ApproveActivity.this, "artefact Approved", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(ApproveActivity.this, " Not Approved", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ApproveActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
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

    private void rejectArt(String reject) {
        mm=new LinksModel();
        progressDialog.setTitle("Rejecting");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        mRequestQueue= Volley.newRequestQueue(ApproveActivity.this);


        StringRequest request =new StringRequest(Request.Method.DEPRECATED_GET_OR_POST, mm.getRejbtncura(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("sucees")){
                    Toast.makeText(ApproveActivity.this, "artefact Rejected", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(ApproveActivity.this, " Not Rejected", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ApproveActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("rejected",reject);

                return param;
            }
        };
        request.setShouldCache(false);
        mRequestQueue.add(request);
    }
}
