package com.dafer.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizScore extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_score);

        /*
        Even though the code below will not be used, or even the class,
        I'm keeping it for future reference.
         */
        Intent intent = getIntent();
        int score = intent.getIntExtra("finalScore", 0);
        String finalMsg = intent.getStringExtra("incorrectText");

        TextView finalScore = findViewById(R.id.final_score);
        Button tryAgainButton = findViewById(R.id.try_again_button);

        if (score < 75) {
            finalScore.setText(String.format("You didn't pass the quiz...\n" +
                    "You should study more and try again!\n" +
                    "Your final score was: %d%%\n%s", score, finalMsg));
            tryAgainButton.setVisibility(View.VISIBLE);
            finalScore.setTextColor(Color.parseColor("#F44336"));
        }
        else {
            finalScore.setText(String.format("Congratulations on passing the quiz!!\n" +
                    "Your final score was a whopping %d%%!!\n" +
                    "%s", score, finalMsg));
            tryAgainButton.setVisibility(View.GONE);
            finalScore.setTextColor(Color.parseColor("#FF9800"));
        }
    }

    public void tryAgain(View v){
        super.onBackPressed();
    }
}
