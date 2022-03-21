package com.art.merumuseum.CuratorModules;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.ApproveArtefacts;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.PendingArtefacts;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.RealApproveArtefacts;
import com.art.merumuseum.CuratorModules.ApproveArtefacts.RejectedArtefacts;
import com.art.merumuseum.CuratorModules.Feedback.Feedback;
import com.art.merumuseum.CuratorModules.Feedback.SeeFeedback;
import com.art.merumuseum.UserInfo.Signin;
import com.art.merumuseum1.R;
import com.art.merumuseum.modules.VrModule.UploadData;
import com.google.android.material.navigation.NavigationView;

public class Curator extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    TextView usernm;
    Button log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curators);
        log=findViewById(R.id.logout_c);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Curator.this, Signin.class));
                finish();
            }
        });

        drawerLayout=findViewById(R.id.curadrawer);
        navigationView=findViewById(R.id.curanav);
        toolbar=findViewById(R.id.toolbar);
        View header = navigationView.getHeaderView(0);
        usernm = (TextView) header.findViewById(R.id.usernameId);
        usernm.setText("Welcome Curator");

        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.curatorframe,new ApproveArtefacts())
                .addToBackStack("")
                .commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fag=null;


        switch (item.getItemId()) {

            case R.id.getFeedbck:
                fag = new Feedback();
                loadFragment(fag);

                break;
            case R.id.recEvent:
                fag = new ApproveArtefacts();
                loadFragment(fag);
//                toolbar.setTitle("feedback");
                break;

            case R.id.aprovedArts:
                fag = new RealApproveArtefacts();
                loadFragment(fag);
//                toolbar.setTitle("Create events");
                break;
            case R.id.PendingArts:
                fag = new PendingArtefacts();
                loadFragment(fag);
//                toolbar.setTitle("Create events");
                break;
            case R.id.rejarts:
                fag = new RejectedArtefacts();
                loadFragment(fag);
//                toolbar.setTitle("Create events");
                break;
//            case R.id.vr:
//                startActivity(new Intent(Curator.this, UploadData.class));
////                toolbar.setTitle("Create events");
//                break;

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.curatorframe,fag).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.curatorframe, fragment).commit();
        drawerLayout.closeDrawer(GravityCompat.START);
        fragmentTransaction.addToBackStack(null);
    }
}
