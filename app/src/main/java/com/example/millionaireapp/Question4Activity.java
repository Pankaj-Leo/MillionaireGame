package com.example.millionaireapp;

import android.os.Bundle;

public class Question4Activity extends BaseQuestionActivity {

    protected int getCurrentQuestionIndex() {
        // This should return 1 since it's the second question
        return 3;
    }

    @Override
    protected Class<?> getNextQuestionActivityClass() {
        // If you have a Question3Activity, return it here. Otherwise, return null or the final/winning activity.
        return Question5Activity.class; // Assuming you have more questions. Change as necessary.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your layout must be set here. Assuming it's the same as for other questions:
       // setContentView(R.layout.activity_question);
    }

    @Override
    protected String getQuestionText() {
        return "What is the smallest prime number?";
    }

    @Override
    protected String[] getAnswers() {
        return new String[]{"1", "2", "3", "5"};
    }

    @Override
    protected String getCorrectAnswer() {
        return "2";
    }


}
