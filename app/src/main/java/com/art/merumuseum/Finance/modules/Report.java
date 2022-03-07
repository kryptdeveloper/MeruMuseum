package com.art.merumuseum.Finance.modules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Report extends AppCompatActivity {
    Button btn;
    TextView mtextView;
    TextView textView;
    LinksModel mm;
    View v;

    RequestQueue requestQueue;
    CharSequence yy="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        btn=findViewById(R.id.showReport);
        mtextView=findViewById(R.id.reportTextview);
        v=getLayoutInflater().inflate(R.layout.activity_report,null);
        textView=v.findViewById(R.id.detailsreport);
        requestQueue=Volley.newRequestQueue(Report.this);
        mm=new LinksModel();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showreport();
            }
        });
    }

    private void showreport() {



        StringRequest request=new StringRequest(Request.Method.GET, mm.getApprovepays(),
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

                                mtextView.append(Amount+","+email+","+date+","+mpesacode+","+tranid+","+status+"\n\n");

                                //  textView.append(Amount+","+email+","+date+","+mpesacode+","+tranid+","+status+"\n\n");
                                yy=Amount+","+email+","+date+","+mpesacode+","+tranid+","+status+"\n\n";




                            }

                        } catch (Exception e) {

                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }


        );



        requestQueue.add(request);










        PdfGenerator.getBuilder()
                .setContext(Report.this)
                .fromViewSource()
                .fromView(v)
                .setFileName("approved")
                .setFolderName("Approvec-folder")
                .openPDFafterGeneration(true)
                .build(new PdfGeneratorListener() {
                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                    }

                    @Override
                    public void showLog(String log) {
                        super.showLog(log);
                    }

                    @Override
                    public void onStartPDFGeneration() {
                        /*When PDF generation begins to start*/
                    }

                    @Override
                    public void onFinishPDFGeneration() {
                        /*When PDF generation is finished*/
                    }

                    @Override
                    public void onSuccess(SuccessResponse response) {
                        super.onSuccess(response);
                    }
                });


    }
}
