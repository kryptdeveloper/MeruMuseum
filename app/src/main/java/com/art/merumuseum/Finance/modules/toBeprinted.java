package com.art.merumuseum.Finance.modules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LinksModel;

import com.art.merumuseum1.R;
import com.gkemon.XMLtoPDF.PdfGenerator;
import com.gkemon.XMLtoPDF.PdfGeneratorListener;
import com.gkemon.XMLtoPDF.model.FailureResponse;
import com.gkemon.XMLtoPDF.model.SuccessResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import static android.service.controls.ControlsProviderService.TAG;

public class toBeprinted extends AppCompatActivity {
    TextView textView,textView1;
    LinksModel mm;
    Button btn;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_beprinted);
        btn=findViewById(R.id.showf);

        v=getLayoutInflater().inflate(R.layout.activity_to_beprinted,null);

        mm=new LinksModel();
        textView1=v.findViewById(R.id.paymentsListy);
        textView=findViewById(R.id.paymentsListy);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateAll();
                btn.setVisibility(View.GONE);

            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tobemenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.idprintIt){
            printReport();
        }
        return true;
    }

    private void printReport() {
      Button  btnn=v.findViewById(R.id.showf);
        btnn.setVisibility(View.GONE);
        PdfGenerator.getBuilder()
                .setContext(toBeprinted.this)
                .fromViewSource()
                .fromView(v)

                .setFileName("report")

                .setFolderName("demo-invoice-folder/")

                .openPDFafterGeneration(true)

                .build(new PdfGeneratorListener() {
                    @Override
                    public void onFailure(FailureResponse failureResponse) {
                        super.onFailure(failureResponse);
                        Log.d(TAG, "onFailure: " + failureResponse.getErrorMessage());

                        Toast.makeText(toBeprinted.this, "" + failureResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
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


    private void generateAll() {
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
                                textView1.append(Amount+","+email+","+mpesacode+","+date+","+tranid+","+status+"\n\n");
                                textView.append(Amount+","+email+","+mpesacode+","+date+","+tranid+","+status+"\n\n");

                            }

                        } catch (Exception e) {

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(toBeprinted.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }


        );
        Volley.newRequestQueue(toBeprinted.this).add(request);

    }
}
