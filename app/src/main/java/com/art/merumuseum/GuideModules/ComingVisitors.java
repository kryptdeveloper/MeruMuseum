package com.art.merumuseum.GuideModules;

import android.content.Intent;
import android.os.Bundle;
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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.GuideModules.guide.guideobject;
import com.art.merumuseum.GuideModules.guide.guiderecyclerview;
import com.art.merumuseum.LinksModel;

import com.art.merumuseum.modules.ModelMyActivitys.ReceiptActivity;
import com.art.merumuseum1.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ComingVisitors extends Fragment {
    RecyclerView recyclerView;
    ArrayList<guideobject> obj=new ArrayList<>();
    guiderecyclerview adapter;
    LinksModel mm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Date currentTime = Calendar.getInstance().getTime();
        Toast.makeText(getContext(), currentTime.toString(), Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.areasguide,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mm=new LinksModel();
        adapter=new guiderecyclerview(getContext(),obj);
        getPayments();
        recyclerView =view.findViewById(R.id.guideRec);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);



        adapter = new guiderecyclerview(getContext(),obj);

        recyclerView.setAdapter(adapter);
    }

    private void getPayments() {
        StringRequest request=new StringRequest(Request.Method.GET, mm.getComing(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String tranid = jsonObject.getString("id");
                                String fname = jsonObject.getString("fname");
                                String sname = jsonObject.getString("sname");
                                String Amount = jsonObject.getString("amount");
                                String email = jsonObject.getString("name");
                                String date = jsonObject.getString("date");
                                String mpesacode = jsonObject.getString("mpesacode");

                                String status=jsonObject.getString("status");
                                String completion=jsonObject.getString("comp");
                                guideobject object = new guideobject(tranid,fname,sname, Amount, email,date, mpesacode, status, completion);
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        adapter = new guiderecyclerview(getContext(), obj);
                        recyclerView.setAdapter(adapter);

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
