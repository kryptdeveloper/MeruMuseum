package com.art.merumuseum.Finance.modules;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.pdf.PdfDocument;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
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



public class Approved extends Fragment {
    RecyclerView recyclerView;
    TextView textView;
    ArrayList<PayObject> obj = new ArrayList<>();
    RecyclerViewAdapterFinance adapter;
    LinksModel mm;
    Button gen;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<PayObject> exampleList = new ArrayList<>();
        adapter = new RecyclerViewAdapterFinance(getActivity(), exampleList);
        return inflater.inflate(R.layout.approvemodulef, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        mm = new LinksModel();
        adapter = new RecyclerViewAdapterFinance(getContext(), obj);
        getPayments();


        recyclerView = view.findViewById(R.id.farecView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);


        adapter = new RecyclerViewAdapterFinance(getContext(), obj);

        recyclerView.setAdapter(adapter);
    }

    private void generateReport() {

        startActivity(new Intent(getContext(), Report.class));


    }


    private void getPayments() {
        StringRequest request = new StringRequest(Request.Method.GET, mm.getFfapprove(),
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
                                String fname = jsonObject.getString("fname");
                                String sname = jsonObject.getString("sname");
                                String comp = jsonObject.getString("comp");
                                PayObject object = new PayObject(fname,sname,Amount,email,mpesacode,date,tranid,status,comp);
                                obj.add(object);
                            }

                        } catch (Exception e) {

                        }
                        adapter = new RecyclerViewAdapterFinance(getContext(), obj);
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
