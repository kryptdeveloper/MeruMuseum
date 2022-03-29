package com.art.merumuseum;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;

import com.art.merumuseum.SearchModules.Search;
import com.art.merumuseum.UserInfo.Model;
import com.art.merumuseum.UserInfo.Signin;
import com.art.merumuseum.modules.BuyATicket;
import com.art.merumuseum.modules.Feedback;
import com.art.merumuseum.modules.Help;
import com.art.merumuseum.modules.Home;
import com.art.merumuseum.modules.Learn;

import com.art.merumuseum.modules.ModelMyActivitys.MyActivitys;
import com.art.merumuseum.modules.VrModule.ViewData;
import com.art.merumuseum.modules.VrModule.ViewData2;
import com.art.merumuseum.modules.paymentVr.PaymentVR;
import com.art.merumuseum.modules.Virtualtour;
import com.art.merumuseum1.R;
import com.google.android.material.navigation.NavigationView;
public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
  private DrawerLayout drawerLayout;
  private NavigationView navigationView;
  private Toolbar toolbar;
  private ActionBarDrawerToggle actionBarDrawerToggle;
  private TextView usernm;
  public static String name="";
  Button logout;
  ModelDet modelDet;

  public static String getName() {
    return name;
  }

  public static void setName(String name) {
    Main.name = name;
  }

  public String hh="";
//test
  //yeaa
//  @Override
//  public void onBackPressed() {
//    super.onBackPressed();
//    startActivity(new Intent(getApplicationContext(),Main.class));
//  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main3);
    logout=findViewById(R.id.logout_);

    drawerLayout=findViewById(R.id.drawer);
    navigationView=findViewById(R.id.nav);
    toolbar=findViewById(R.id.toolbar1);
    View header = navigationView.getHeaderView(0);
    usernm = (TextView) header.findViewById(R.id.usernameId);

    actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
    drawerLayout.addDrawerListener(actionBarDrawerToggle);
    actionBarDrawerToggle.syncState();
    navigationView.setNavigationItemSelectedListener(this);
    Model m=new Model();
    Bundle extras = getIntent().getExtras();
   // hh = null;

//if(hh==null||hh!=null){
//  hh = extras.getString("uname");
//
//}
    modelDet=new ModelDet();
    hh= ModelDet.getNam();



    usernm.setText(hh);
    name=hh;

    setName(hh);


    getSupportFragmentManager().beginTransaction().replace(R.id.content,new Home())
            .addToBackStack(" ")
            .commit();

    logout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(Main.this, Signin.class) );
        finish();
      }
    });

  }

  @Override
  public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    Fragment fag=null;


    switch (item.getItemId()){
      case R.id.Homeid:
        fag=new Home();
        loadFragment(fag);
        toolbar.setTitle("Home");
        break;

      case R.id.buyaticket:
        fag=new BuyATicket();
        loadFragment(fag);
        toolbar.setTitle("Buy a Ticket");
        break;
      case R.id.learnmodule:
        fag=new Learn();
        loadFragment(fag);
        toolbar.setTitle("Learn and explore");
        break;

      case R.id.virtualtour:
        startActivity(new Intent(Main.this, ViewData2.class));
        toolbar.setTitle("Virtual Tour");
        break;

      case R.id.help:
        fag=new Help();
        loadFragment(fag);
        toolbar.setTitle("Help");
        break;
      case R.id.feedback:
        fag=new Feedback();
        loadFragment(fag);
        toolbar.setTitle("Feedback");
        break;

      case R.id.myActivities:
        fag=new MyActivitys();
        loadFragment(fag);
        toolbar.setTitle("My Activities");
        break;

    }
    // getSupportFragmentManager().beginTransaction().replace(R.id.content,fag).commit();

    drawerLayout.closeDrawer(GravityCompat.START);

    return true;
  }
  private void loadFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.content, fragment).addToBackStack("").commit();
    drawerLayout.closeDrawer(GravityCompat.START);
    fragmentTransaction.addToBackStack(null);
  }
}
