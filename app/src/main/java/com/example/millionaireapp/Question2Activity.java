package com.example.millionaireapp;

import android.os.Bundle;

public class Question2Activity extends BaseQuestionActivity {

    @Override
    protected int getCurrentQuestionIndex() {
        // This should return 1 since it's the second question
        return 1;
    }

    @Override
    protected Class<?> getNextQuestionActivityClass() {
        // If you have a Question3Activity, return it here. Otherwise, return null or the final/winning activity.
        return Question3Activity.class; // Assuming you have more questions. Change as necessary.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your layout must be set here. Assuming it's the same as for other questions:
        //setContentView(R.layout.activity_question);

        // Since question setup and the submit button listener are handled in BaseQuestionActivity's onCreate,
        // there's no need to duplicate that logic here unless you're adding something specific to this question.
    }

    @Override
    protected String getQuestionText() {
        return "What is the capital of France?";
    }

    @Override
    protected String[] getAnswers() {
        return new String[]{"Paris", "London", "Berlin", "Madrid"};
    }

    @Override
    protected String getCorrectAnswer() {
        return "Paris";
    }

}
