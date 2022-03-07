package com.art.merumuseum.CuratorModules.Feedback;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.LinksModel;

import com.art.merumuseum1.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class SeeFeedback extends Fragment {
    private ArrayList<PayObject> mExampleList;
    RecyclerView recyclerView;
    ArrayList<Feedobj> obj=new ArrayList<>();
    FeedRec adapter;
    LinksModel mm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mm=new LinksModel();

        return inflater.inflate(R.layout.seefeedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPayments();
        recyclerView=view.findViewById(R.id.feedbackMod);

    }
    private void getPayments() {
        StringRequest request=new StringRequest(Request.Method.GET, mm.getFeedcura(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String desc = jsonObject.getString("descri");

                                Feedobj object = new Feedobj("feed",desc);
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        //adapter = new FeedRec(getContext(), obj);
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
