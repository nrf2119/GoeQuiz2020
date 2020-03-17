package com.example.android.goequiz2020;

import java.io.Serializable;

public class Question implements Serializable {
    private  int textResourceId;
    private boolean answerTrue;

    public Question(int textResourceId, boolean answerTrue) {
        this.textResourceId = textResourceId;
        this.answerTrue = answerTrue;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public int getTextResourceId() {
        return textResourceId;
    }
}
