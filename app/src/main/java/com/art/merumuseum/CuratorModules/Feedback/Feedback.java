package com.art.merumuseum.CuratorModules.Feedback;

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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Feedback extends Fragment {
    RecyclerView recyclerView;
    LinksModel mm;
    ArrayList<FeedbackObj> obj=new ArrayList<>();
    FeedAdapterObj feedAdapterObj;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rejectedfinace,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm=new LinksModel();
        feedAdapterObj=new FeedAdapterObj(getContext(), obj);

        getFinancefeed();
        recyclerView =view.findViewById(R.id.frejrecView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(feedAdapterObj);
    }

    private void getFinancefeed() {
        StringRequest request=new StringRequest(Request.Method.GET, mm.getFedcura(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String feed = jsonObject.getString("amount");
                                String email = jsonObject.getString("name");

                                FeedbackObj object = new FeedbackObj(email,feed);
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        feedAdapterObj = new FeedAdapterObj(getContext(),obj);
                        recyclerView.setAdapter(feedAdapterObj);

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
