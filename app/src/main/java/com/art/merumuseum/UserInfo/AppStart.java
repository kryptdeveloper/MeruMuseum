package com.art.merumuseum.UserInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.art.merumuseum1.R;
public class AppStart extends AppCompatActivity {

    Button logout;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_start);

        logout = findViewById(R.id.logout);
        sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getResources().getString(R.string.prefStatus),"logout");
                editor.apply();
                startActivity(new Intent(AppStart.this,Signin.class));
                finish();
            }
        });
    }
}