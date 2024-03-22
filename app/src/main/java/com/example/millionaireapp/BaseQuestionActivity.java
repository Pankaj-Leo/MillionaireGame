package com.example.millionaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseQuestionActivity extends AppCompatActivity {

    protected int score;
    private TextView scoreHeader;
    protected int[] points = { 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 300000, 511500};

    protected abstract int getCurrentQuestionIndex();
    protected abstract Class<?> getNextQuestionActivityClass();
    protected abstract String getQuestionText();
    protected abstract String[] getAnswers();
    protected abstract String getCorrectAnswer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        score = getIntent().getIntExtra("score", 0);
        scoreHeader = findViewById(R.id.score_header);
        updateScoreHeader();

        TextView questionText = findViewById(R.id.question_text);
        RadioGroup optionsGroup = findViewById(R.id.options_group);
        Button submitButton = findViewById(R.id.submit_button);

        questionText.setText(getQuestionText());
        String[] answers = getAnswers();

        for (String answer : answers) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answer);
            optionsGroup.addView(radioButton);
        }

        submitButton.setOnClickListener(v -> {
            int selectedId = optionsGroup.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selectedRadioButton = findViewById(selectedId);
                boolean isCorrect = selectedRadioButton.getText().toString().equals(getCorrectAnswer());
                handleAnswer(isCorrect);
            } else {
                Toast.makeText(getApplicationContext(), "Please select an answer.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleAnswer(boolean isCorrect) {
        if (isCorrect) {
            score += points[getCurrentQuestionIndex()];
            Toast.makeText(getApplicationContext(), "Correct answer!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect answer.", Toast.LENGTH_SHORT).show();
        }

        Intent intent;
        Class<?> nextActivity = getNextQuestionActivityClass();
        if (nextActivity != null) {
            intent = new Intent(BaseQuestionActivity.this, nextActivity);
        } else {
            // Determine if the player has won
            intent = (score == 1000000) ?
                    new Intent(BaseQuestionActivity.this, WinningActivity.class) :
                    new Intent(BaseQuestionActivity.this, LosingActivity.class);
        }
        intent.putExtra("score", score); // Use "score" consistently for passing the score
        startActivity(intent);
        finish();
    }

    private void updateScoreHeader() {
        scoreHeader.setText(getString(R.string.score_text, score)); // Make sure you have defined this string resource
    }
}
