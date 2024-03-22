package com.example.millionaireapp;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_DISPLAY_LENGTH = 2000; // Delay in milliseconds
        new Handler().postDelayed(() -> {
            Intent mainIntent = new Intent(SplashActivity.this, Question1Activity.class);
            //mainIntent.putExtra("score", 0);
            startActivity(mainIntent);

            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}
