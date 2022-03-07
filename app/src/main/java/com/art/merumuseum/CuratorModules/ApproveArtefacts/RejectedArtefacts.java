package com.art.merumuseum.CuratorModules.ApproveArtefacts;

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

public class RejectedArtefacts extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ArtefactObject> obj=new ArrayList<>();
    ArtefactModelObject adapter;
    LinksModel mm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.approveartefacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm=new LinksModel();
        getArtefacts();

        recyclerView =view.findViewById(R.id.approveartrec);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        adapter = new ArtefactModelObject(getContext(),obj);

        recyclerView.setAdapter(adapter);

    }

    private void getArtefacts() {
        StringRequest request=new StringRequest(Request.Method.GET, mm.getRejArtefact(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("email");
                                String desc = jsonObject.getString("descri");
                                String image = jsonObject.getString("image");
                                String title = jsonObject.getString("artname");
                                String status = jsonObject.getString("status");

                                ArtefactObject object = new ArtefactObject(name,desc,image,title,status);
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        adapter = new ArtefactModelObject(getContext(), obj);
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
