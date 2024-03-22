package com.example.millionaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LosingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);

        int score = getIntent().getIntExtra("score", 0);
        TextView losingMessage = findViewById(R.id.losing_message);
        losingMessage.setText(String.format("Sorry, you lost. Final score: %d", score));


        Button restartQuizButton = findViewById(R.id.restart_quiz_button);
        restartQuizButton.setOnClickListener(v -> {
            Intent intent = new Intent(LosingActivity.this, Question1Activity.class);
            intent.putExtra("score", 0); // Reset score
            startActivity(intent);
            finish(); // Close current activity
        });
    }
}
