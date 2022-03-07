package com.art.merumuseum.LearnModules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.LearnModules.modelEvents.EventObject;
import com.art.merumuseum.LearnModules.modelEvents.RecylerViewAdapter;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Events extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<EventObject> objs=new ArrayList<>();
    RecylerViewAdapter adapter;
    LinksModel mm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        mm=new LinksModel();
        getEvents();

        recyclerView =findViewById(R.id.recView);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        adapter = new RecylerViewAdapter(this, objs);

        recyclerView.setAdapter(adapter);
    }

    private  void getEvents(){
        StringRequest request=new StringRequest(Request.Method.GET, mm.getEvent_url(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String tit = jsonObject.getString("title");
                                String desc = jsonObject.getString("description");
                                String date = jsonObject.getString("date");
                                EventObject object = new EventObject(tit,desc,date);
                                objs.add(object);
                            }

                        } catch (Exception e) {

                        }
                        adapter = new RecylerViewAdapter(Events.this, objs);
                        recyclerView.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Events.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }


        );
        Volley.newRequestQueue(Events.this).add(request);


    }
}

