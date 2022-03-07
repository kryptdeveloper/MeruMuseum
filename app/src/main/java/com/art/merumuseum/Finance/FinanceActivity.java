package com.art.merumuseum.Finance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.art.merumuseum.Contributer.ContributeClass;
import com.art.merumuseum.Contributer.modules.ApprovedModules;
import com.art.merumuseum.Contributer.modules.PendingArtefacts;
import com.art.merumuseum.Contributer.modules.RejectedArtefacts;
import com.art.merumuseum.Finance.Fmodels.PayObject;
import com.art.merumuseum.Finance.Fmodels.RecyclerViewAdapterFinance;
import com.art.merumuseum.Finance.modules.Approved;
import com.art.merumuseum.Finance.modules.Dashboard;
import com.art.merumuseum.Finance.modules.Pending;
import com.art.merumuseum.Finance.modules.Rejected;
import com.art.merumuseum.LearnModules.Events;
import com.art.merumuseum.LearnModules.modelEvents.EventObject;
import com.art.merumuseum.LearnModules.modelEvents.RecylerViewAdapter;
import com.art.merumuseum.LinksModel;

import com.art.merumuseum1.R;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FinanceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private com.google.android.material.appbar.MaterialToolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    TextView usernm;
    RecyclerViewAdapterFinance adapter;
    private ArrayList<PayObject> exampleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        ArrayList<PayObject> exampleList = new ArrayList<>();
        adapter = new RecyclerViewAdapterFinance(getApplicationContext(),exampleList);


        drawerLayout=findViewById(R.id.fdrawer);
        navigationView=findViewById(R.id.fnav);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        View header = navigationView.getHeaderView(0);
        usernm = (TextView) header.findViewById(R.id.usernameId);
        usernm.setText("Welcome to Finance");

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fcontent,new Dashboard()).commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fag=null;


        switch (item.getItemId()){

            case R.id.dashboardf:
                fag=new Dashboard();
                toolbar.setTitle("Dashboard");
                break;

            case R.id.fapprovedf:
                fag=new Approved();
                toolbar.setTitle("Approved transactions");
                break;
            case R.id.frejected:
                fag=new Rejected();
                toolbar.setTitle("Rejected transactions");
                break;
            case R.id.fpending:
                fag=new Pending();
                toolbar.setTitle("Pending transactions");
                break;
            case R.id.fidtrans:
                fag=new Alltransactions();
                toolbar.setTitle("All transactions");
                break;
            case R.id.reportsModulef:
                fag=new ReportsModulesFinance();
                toolbar.setTitle("Get reports");
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fcontent,fag).commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


}
