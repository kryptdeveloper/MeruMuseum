package com.art.merumuseum.modules.ModelMyActivitys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.FinanceActivity;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;
import com.art.merumuseum1.R;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyActivitys extends Fragment {
    RecyclerView recyclerView;
    Main main;


    LinksModel mm;
    ArrayList<ModelObject> modelObjects=new ArrayList<ModelObject>();
    RecyclerviewHistory recyclerviewHistory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.myactivities,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.recViewMyactivities);
        mm=new LinksModel();
        getHistory( main.getName());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        recyclerviewHistory = new RecyclerviewHistory(getContext(),modelObjects);

        recyclerView.setAdapter(recyclerviewHistory);
    }

    private void getHistory(final String name) {
        StringRequest request = new StringRequest(Request.Method.DEPRECATED_GET_OR_POST, mm.getHistory(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String hmount = jsonObject.getString("amount");
                                String hemail = jsonObject.getString("name");
                                String hdate = jsonObject.getString("date");
                                String tranid = jsonObject.getString("id");
                                String hstatus = jsonObject.getString("status");
                                ModelObject object = new ModelObject(hmount, hdate, hemail, hstatus);
                                modelObjects.add(object);
                            }

                        } catch (Exception e) {

                        }
                        recyclerviewHistory = new RecyclerviewHistory(getContext(), modelObjects);
                        recyclerView.setAdapter(recyclerviewHistory);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }


        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> param = new HashMap<>();
                param.put("email",name);


                return param;
            }
        };
        Volley.newRequestQueue(getContext()).add(request);




    }
}
