package com.example.millionaireapp;

import android.os.Bundle;

public class Question3Activity extends BaseQuestionActivity {

    protected int getCurrentQuestionIndex() {
        // This should return 1 since it's the second question
        return 2;
    }

    @Override
    protected Class<?> getNextQuestionActivityClass() {
        // If you have a Question3Activity, return it here. Otherwise, return null or the final/winning activity.
        return Question4Activity.class; // Assuming you have more questions. Change as necessary.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Your layout must be set here. Assuming it's the same as for other questions:
        //setContentView(R.layout.activity_question);
    }

    @Override
    protected String getQuestionText() {
        return "Who wrote 'Hamlet'?";
    }

    @Override
    protected String[] getAnswers() {
        return new String[]{"Charles Dickens", "William Shakespeare", "Leo Tolstoy", "Mark Twain"};
    }

    @Override
    protected String getCorrectAnswer() {
        return "William Shakespeare";
    }


}
