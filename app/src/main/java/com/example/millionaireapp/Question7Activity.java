package com.example.millionaireapp;

import android.os.Bundle;

public class Question7Activity extends BaseQuestionActivity {

    protected int getCurrentQuestionIndex() {
        // This should return 1 since it's the second question
        return 6;
    }

    @Override
    protected Class<?> getNextQuestionActivityClass() {
        // If you have a Question3Activity, return it here. Otherwise, return null or the final/winning activity.
        return Question8Activity.class; // Assuming you have more questions. Change as necessary.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your layout must be set here. Assuming it's the same as for other questions:
        //setContentView(R.layout.activity_question);
    }

    @Override
    protected String getQuestionText() {
        return "Which of these is not one of the Seven Wonders of the Ancient World?";
    }

    @Override
    protected String[] getAnswers() {
        return new String[]{"Statue of Zeus at Olympia", "Colossus of Rhodes", "Great Wall of China", "Lighthouse of Alexandria"};
    }

    @Override
    protected String getCorrectAnswer() {
        return "Great Wall of China";
    }


}
