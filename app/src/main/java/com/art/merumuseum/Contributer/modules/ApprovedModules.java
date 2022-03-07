package com.art.merumuseum.Contributer.modules;

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
import com.art.merumuseum.Contributer.Contrubuter;
import com.art.merumuseum.Contributer.modules.ModulesOb.RecyclerViewContributer;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.ArtefactModelObject;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.ArtefactObject;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ApprovedModules extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ArtefactObject> obj=new ArrayList<>();
    RecyclerViewContributer adapter;
    LinksModel mm;
    Contrubuter contrubuter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contrubuter=new Contrubuter();

        return inflater.inflate(R.layout.contributerartfacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mm=new LinksModel();
        getArtefacts();

        recyclerView =view.findViewById(R.id.contributerarteRecy);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        adapter = new RecyclerViewContributer(getContext(),obj);

        recyclerView.setAdapter(adapter);

    }

    private void getArtefacts() {
        StringRequest request=new StringRequest(Request.Method.DEPRECATED_GET_OR_POST, mm.getaContributer(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String name = jsonObject.getString("name");
                                String desc = jsonObject.getString("descri");
                                String image = jsonObject.getString("image");
                                String title = jsonObject.getString("name");

                                String status = jsonObject.getString("status");
                                ArtefactObject object = new ArtefactObject(name,desc,image,title,status);
                                Toast.makeText(getContext(), object.toString(), Toast.LENGTH_SHORT).show();
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        adapter = new RecyclerViewContributer(getContext(), obj);
                        recyclerView.setAdapter(adapter);

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
                Map<String,String> params=new HashMap<>();
                params.put("email",contrubuter.getName());
                return params;
            }
        };;
        Volley.newRequestQueue(getContext()).add(request);



    }
}
