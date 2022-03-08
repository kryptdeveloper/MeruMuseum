package com.art.merumuseum.Contributer.modules;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Contributer.ContributeClass;
import com.art.merumuseum.Contributer.Contrubuter;
import com.art.merumuseum.Contributer.modules.ModulesOb.RecyclerViewContributer;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.ArtefactObject;
import com.art.merumuseum.Finance.Alltransactions;
import com.art.merumuseum.Finance.ReportsModulesFinance;
import com.art.merumuseum.Finance.modules.Approved;
import com.art.merumuseum.Finance.modules.Pending;
import com.art.merumuseum.Finance.modules.Rejected;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum1.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dash extends Fragment {
    CardView pending,all,approv,rejected;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    Button receipt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.dashcontri, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pending=view.findViewById(R.id.cpendingcardf);
        all=view.findViewById(R.id.callcard);
        approv=view.findViewById(R.id.caprovcardtrans);
        rejected=view.findViewById(R.id.crejectedcardtrans);
        receipt=view.findViewById(R.id.cbtndownloadf);
        toolbar=view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        receipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getFragmentManager().beginTransaction().replace(R.id.ccontent, new ContributeClass()).commit();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "gsdfbu ga", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.ccontent, new ContributeClass()).commit();
            }
        });
        approv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "gsdfbu ga", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.ccontent, new ApprovedModules()).commit();
            }
        });
        rejected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "gsdfbu ga", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.ccontent, new RejectedArtefacts()).commit();
            }
        });
        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "gsdfbu ga", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().replace(R.id.ccontent, new PendingArtefacts()).commit();
            }
        });

    }
}
