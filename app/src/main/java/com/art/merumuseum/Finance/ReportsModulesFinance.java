package com.art.merumuseum.Finance;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Fmodels.ApproveModel;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.Finance.modules.toBeprinted;
import com.art.merumuseum.LinksModel;

import com.art.merumuseum1.R;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.service.controls.ControlsProviderService.TAG;

public class ReportsModulesFinance  extends Fragment {
    Button all,pen,app,rej;
    LinksModel mm;
    TextView det;
    View v1,v;
    TextView textView,textView1;
    View finalInvoiceViewToPrint;
    private RequestQueue mRequestQueue;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //allpayments
        v=inflater.inflate(R.layout.allpayments,container,false);
        det=v.findViewById(R.id.paymentsList);
        v=getLayoutInflater().inflate(R.layout.allpayments,null);
         v1=getLayoutInflater().inflate(R.layout.activity_to_beprinted,null);
        textView1= v1.findViewById(R.id.paymentsListy);



        return inflater.inflate(R.layout.reportsmodulefinance,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm = new LinksModel();
        finalInvoiceViewToPrint = view.findViewById(R.id.paymetdi);
        View yy=view.findViewById(R.id.reportsLin);

//        generateAll();
        all=view.findViewById(R.id.allTranactions);
        pen=view.findViewById(R.id.allpending);
        app=view.findViewById(R.id.allapproved);
        rej=view.findViewById(R.id.allrejected);
        pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar=Snackbar.make(yy,"click to get report",Snackbar.LENGTH_LONG).setAction("view pdf", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        generateAll(mm.getApprovepays());
                        getAllApproved();

                    }
                });
                snackbar.show();

            }
        });
        rej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar=Snackbar.make(yy,"click to get report",Snackbar.LENGTH_LONG).setAction("view pdf", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        generateAll(mm.getApprovepays());
                        getAllApproved();

                    }
                });
                snackbar.show();

            }
        });

        app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar=Snackbar.make(yy,"click to get report",Snackbar.LENGTH_LONG).setAction("view pdf", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        generateAll(mm.getApprovepays());
                        getAllApproved();

                    }
                });
                snackbar.show();

            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), toBeprinted.class));
            }
        });


    }

    private void getAllApproved() {

            Button  btnn=v1.findViewById(R.id.showf);
            btnn.setVisibility(View.GONE);
            PdfGenerator.getBuilder()
                    .setContext(getContext())
                    .fromViewSource()
                    .fromView(v1)

                    .setFileName("report")

                    .setFolderName("demo-invoice-folder/")

                    .openPDFafterGeneration(true)

                    .build(new PdfGeneratorListener() {
                        @Override
                        public void onFailure(FailureResponse failureResponse) {
                            super.onFailure(failureResponse);
                            Log.d(TAG, "onFailure: " + failureResponse.getErrorMessage());

                            Toast.makeText(getContext(), "" + failureResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void showLog(String log) {
                            super.showLog(log);
                            Log.d(TAG, "log: " + log);

                        }

                        @Override
                        public void onStartPDFGeneration() {

                        }

                        @Override
                        public void onFinishPDFGeneration() {

                        }

                        @Override
                        public void onSuccess(SuccessResponse response) {
                            super.onSuccess(response);
                            /* If PDF is generated successfully then you will find SuccessResponse
                             * which holds the PdfDocument,File and path (where generated pdf is stored)*/
                            //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Success: " + response.getPath());

                        }
                    });






    }
    private void generateAll(String link) {
        StringRequest request=new StringRequest(Request.Method.GET,link,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String Amount = jsonObject.getString("amount");
                                String email = jsonObject.getString("name");
                                String date = jsonObject.getString("date");
                                String mpesacode = jsonObject.getString("mpesacode");
                                String tranid = jsonObject.getString("id");
                                String status = jsonObject.getString("status");
                                textView1= v1.findViewById(R.id.paymentsListy);
                                textView1.append(Amount+","+email+","+mpesacode+","+date+","+tranid+","+status+"\n\n");
                                //textView.append(Amount+","+email+","+mpesacode+","+date+","+tranid+","+status+"\n\n");

                            }

                        } catch (Exception e) {

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }


        );
        Volley.newRequestQueue(getContext()).add(request);

    }


}
