package com.art.merumuseum.modules;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import com.art.merumuseum.Main;

import com.art.merumuseum.UserInfo.Signin;
import com.art.merumuseum.modules.ModelMyActivitys.MyActivitys;
import com.art.merumuseum1.R;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {
    TextView prize;
    EditText mcode,date;
    LinksModel mm;
    Button pay;
    String hh;
    String name;
    Main main;
    private RequestQueue mRequestQueue;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        prize=findViewById(R.id.Amountid);
        mcode=findViewById(R.id.codeMpesa);
        date=findViewById(R.id.datepicked);
        pay=findViewById(R.id.pay_btn);
        mm=new LinksModel();
        progressDialog=new ProgressDialog(this);
        Bundle extras = getIntent().getExtras();
        main=new Main();
        hh = null;
        name=null;
        hh = extras.getString("prize");
        name = extras.getString("nm");
        prize.setText("Amount:"+hh+"kes");
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( mcode.getText().toString().isEmpty()||date.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Choose date or Enter mpesa code", Toast.LENGTH_SHORT).show();

                }else {
                    sendToDB(hh, date.getText().toString(), main.getName(), mcode.getText().toString());
// Fragment mm=new MyActivitys();
//                     FragmentManager fragmentManager=getSupportFragmentManager();
//                     fragmentManager.beginTransaction().replace(R.id.content, new MyActivitys()).commit();
                }

            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                date.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePicker;

                        Calendar calendar = Calendar.getInstance();
                        int yy = calendar.get(Calendar.YEAR);
                        int mm = calendar.get(Calendar.MONTH);
                        int dd = calendar.get(Calendar.DAY_OF_MONTH);

                        datePicker = new DatePickerDialog(Payment.this, R.style.Theme_AppCompat_DayNight_Dialog, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String date_ = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                date.setText(date_);
                                Log.i("StartTime_booking:", date_);
                            }
                        }, yy, mm, dd);

                        datePicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                        datePicker.show();
                        datePicker.getButton(DatePickerDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        datePicker.getButton(DatePickerDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));

                    }
                });
            }
        });





    }
    private void sendToDB(final String amount, final String date, final String name,final String mpesa ) {
        if (mpesa.length() == 10) {
            progressDialog.setTitle("Paying");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setIndeterminate(false);
            progressDialog.show();
            mRequestQueue = Volley.newRequestQueue(Payment.this);


            StringRequest request = new StringRequest(Request.Method.POST, mm.getBook(), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {


                    if (response.equals("Booked")) {
                        progressDialog.dismiss();
                        Toast.makeText(Payment.this, "wait for approval", Toast.LENGTH_SHORT).show();
                        // Fragment mm=new MyActivitys();
                        // FragmentManager fragmentManager=getSupportFragmentManager();
                        // fragmentManager.beginTransaction().replace(R.id.content, new MyActivitys()).commit();

                    } else {
                        Toast.makeText(Payment.this, response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        startActivity(new Intent(Payment.this,Main.class));

                        finish();


                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Payment.this, error.toString(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> param = new HashMap<>();
                    param.put("fname", name);
                    param.put("sname", name);
                    param.put("email", name);
                    param.put("amount", amount);
                    param.put("date", date);
                    param.put("mpesacode", mpesa);
                    param.put("comp", mpesa);

                    return param;
                }
            };
            request.setShouldCache(false);
            mRequestQueue.add(request);

        }else{

            Toast.makeText(getApplicationContext(), "mpesa code is not  full", Toast.LENGTH_SHORT).show();
        }
    }

}
