package com.example.android.goequiz2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private ArrayList<Question> questionsBank = new ArrayList<>();
    private TextView questionTextView;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = (Button)findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        questionsBank.add(new Question(R.string.question_australia, true));
        questionsBank.add(new Question(R.string.question_ocean, true));
        questionsBank.add(new Question(R.string.question_mideast, false));
        questionsBank.add(new Question(R.string.question_africa, false));
        questionsBank.add(new Question(R.string.question_americas, true));

        questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questionsBank.get(currentIndex).getTextResourceId());
    }

    public void clickFalse(View view) {
        checkAnswer(false);
    }


    public void updateQuestion(View view) {
        currentIndex++;
        if (currentIndex == questionsBank.size()){
            currentIndex = 0;
            Toast.makeText(this, "Back to the beginning", Toast.LENGTH_SHORT).show();
        }
        Question q = questionsBank.get(currentIndex);
        questionTextView.setText(q.getTextResourceId());
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean correctAnswer = questionsBank.get(currentIndex).isAnswerTrue();
        if(userPressedTrue == correctAnswer) {
            Toast.makeText(this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    public void clickCheat(View view) {
        Intent msIntent = new Intent(this, CheatActivity.class);
        //String question = questionTextView.getText().toString();
        //above code gets the question from the textview
        Question q = questionsBank.get(currentIndex);
        msIntent.putExtra(Keys.QUESION_KEY, q);
        startActivity(msIntent);

    }

}
