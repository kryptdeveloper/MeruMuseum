package com.art.merumuseum.GuideModules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;


import com.art.merumuseum.GuideModules.Feedback.Feedback;
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
        getSupportFragmentManager().beginTransaction().replace(R.id.guideMain,new ComingVisitors()).commit();
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
