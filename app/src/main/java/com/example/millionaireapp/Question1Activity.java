package com.example.millionaireapp;

import android.os.Bundle;

public class Question1Activity extends BaseQuestionActivity {

    @Override
    protected int getCurrentQuestionIndex() {
        return 0; // This is the first question
    }

    @Override
    protected Class<?> getNextQuestionActivityClass() {
        // Assuming you have a Question2Activity for the next question
        return Question2Activity.class;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_question); // Ensure this layout exists and is correctly set up

        // No need to call displayQuestion() explicitly here since
        // your BaseQuestionActivity's onCreate method already sets up the question text and options
    }

    @Override
    protected String getQuestionText() {
        return "Which planet is known as the Red Planet?";
    }

    @Override
    protected String[] getAnswers() {
        return new String[]{"Mars", "Jupiter", "Saturn", "Venus"};
    }

    @Override
    protected String getCorrectAnswer() {
        return "Mars";
    }

}
