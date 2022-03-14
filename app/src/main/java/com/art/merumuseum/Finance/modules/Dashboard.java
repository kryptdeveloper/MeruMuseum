package com.art.merumuseum.Finance.modules;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Finance.Alltransactions;
import com.art.merumuseum.Finance.Feedback.Feedback;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.Finance.ReportsModulesFinance;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class Dashboard extends Fragment {
    CardView pending,all,approv,rejected;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    Button receipt,feed;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dashboardfinace, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pending=view.findViewById(R.id.pendingcardf);
        all=view.findViewById(R.id.allcard);
        approv=view.findViewById(R.id.aprovcardtrans);
        rejected=view.findViewById(R.id.rejectedcardtrans);
        receipt=view.findViewById(R.id.btndownloadf);
        feed=view.findViewById(R.id.feedbtnf);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fcontent, new ReportsModulesFinance()).commit();
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.fcontent, new Feedback()).commit();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "all transactions", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fcontent, new Alltransactions()).commit();
            }
        });
        approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "all approved transactions", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fcontent, new Approved()).commit();
            }
        });
        rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "all rejected transctions", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fcontent, new Rejected()).commit();
            }
        });
        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "all pending transctions", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.fcontent, new Pending()).commit();
            }
        });

    }
}
