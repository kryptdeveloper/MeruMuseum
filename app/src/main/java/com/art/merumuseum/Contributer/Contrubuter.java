package com.art.merumuseum.Contributer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.art.merumuseum.Contributer.modules.ApprovedModules;
import com.art.merumuseum.Contributer.modules.Dash;
import com.art.merumuseum.Contributer.modules.PendingArtefacts;
import com.art.merumuseum.Contributer.modules.RejectedArtefacts;
import com.art.merumuseum1.R;
import com.google.android.material.navigation.NavigationView;

public class Contrubuter extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView usernm;
    public static String uemail="";
    public String hh="";
    public static String name="";

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Contrubuter.name = name;
    }

    String userem="";




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrubuter);


        drawerLayout=findViewById(R.id.cdrawer);
        navigationView=findViewById(R.id.cnav);
        toolbar=findViewById(R.id.toolbar);
        View header = navigationView.getHeaderView(0);
        usernm = (TextView) header.findViewById(R.id.usernameId);

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        Bundle extras = getIntent().getExtras();
        String hh = null;


        hh = extras.getString("uname");

        userem=hh;
        usernm.setText(userem);
        name=hh;
        setName(hh);

        getSupportFragmentManager().beginTransaction().replace(R.id.ccontent,new Dash()).commit();




    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fag=null;


        switch (item.getItemId()){
            case R.id.contriDash:
                fag=new Dash();
                toolbar.setTitle("Dashboard");
                break;

            case R.id.approvedc:
                fag=new ContributeClass();
                toolbar.setTitle("Approved Artefacts");
                break;
            case R.id.idUploadc:
                fag=new ContributeClass();
                toolbar.setTitle("Upload your artefacts here");
                break;
            case R.id.Rejectedc:
                fag=new RejectedArtefacts();
                toolbar.setTitle("Rejected artefacts");
                break;
            case R.id.pendingc:
                fag=new PendingArtefacts();
                toolbar.setTitle("Pending Artefacts");
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.ccontent,fag).commit();

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }
}
