package com.art.merumuseum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.art.merumuseum.UserInfo.Signin;
import com.art.merumuseum1.R;

public class MainActivity extends AppCompatActivity {
    private int time_out=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, Signin.class));
                finish();


            }
        },time_out);
    }
}
