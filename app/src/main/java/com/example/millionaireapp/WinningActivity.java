package com.example.millionaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class WinningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        int score = getIntent().getIntExtra("score", 0);
        TextView winningMessage = findViewById(R.id.winning_message);
        winningMessage.setText(String.format("Congratulations! You've won with a score of %d!", score));

        Button restartQuizButton = findViewById(R.id.restart_quiz_button);
        restartQuizButton.setOnClickListener(v -> {
            Intent intent = new Intent(WinningActivity.this, Question1Activity.class);
            intent.putExtra("score", 0); // Reset score
            startActivity(intent);
            finish(); // Close current activity
        });
    }
}
