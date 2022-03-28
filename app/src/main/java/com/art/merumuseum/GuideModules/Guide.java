package com.art.merumuseum.GuideModules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.art.merumuseum.GuideModules.Feedback.Feedback;
import com.art.merumuseum.UserInfo.Signin;
import com.art.merumuseum1.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Guide extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        bottomNavigationView=findViewById(R.id.btmNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.guideMain,new Visitors()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.guide, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logoutguide:
                startActivity(new Intent(Guide.this, Signin.class));
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fag = null;


        switch (item.getItemId()) {

            case R.id.areasTobevisted:
                fag = new ComingVisitors();

                break;
            case R.id.Visitorsid:
                fag = new Visitors();
                break;
            case R.id.scuraevents:
                fag = new Completed();

                break;
            case R.id.feedbackgui:
                fag = new Feedback();

                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.guideMain, fag).commit();
        return true;
    }


}
