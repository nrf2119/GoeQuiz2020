package com.example.android.goequiz2020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {

    TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        answerTextView = (TextView) findViewById(R.id.answer_text_view);

        Intent receivingIntent = getIntent();
        //String string = receivingIntent.getStringExtra(Keys.QUESION_KEY);
        Question question = (Question) receivingIntent.getSerializableExtra(Keys.QUESION_KEY);
        //answerTextView.setText(string);
        answerTextView.setText(question.getTextResourceId());

    }
}
