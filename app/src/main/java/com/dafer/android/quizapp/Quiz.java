package com.dafer.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

public class Quiz extends AppCompatActivity{

    private int correctAnswers;
    private String incorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    public void submitQuiz(View v) {

        //Intent intent = new Intent(Quiz.this, QuizScore.class);

        correctAnswers = 0; // reset the correctAnswers to 0
        incorrectAnswers = ""; // reset incorrectAnswers text to an empty string
        getCorrectAnswers(); // gets the correct answers

        /* Just in case we want to use the code below:
        String finalScore = String.valueOf(calculateScore());
        intent.putExtra("finalScore", Integer.valueOf(finalScore));

        intent.putExtra("finalScore", calculateScore());
        intent.putExtra("incorrectText", incorrectAnswers);
         */

        Context context = getApplicationContext();
        int finalScore = calculateScore();
        String finalText = getFinalToast(finalScore);
        Toast toast = Toast.makeText(context, finalText, Toast.LENGTH_LONG);

        ViewGroup group = findViewById(R.id.quizGroup);
        ScrollView scroll = findViewById(R.id.mainScroll);


        // Reset all the controls in the UI
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText){
                ((EditText)view).getText().clear();
            }
            else if (view instanceof CheckBox){
                ((CheckBox)view).setChecked(false);
            }
            else if (view instanceof RadioGroup){
                ((RadioGroup) view).clearCheck();
            }
        }

        scroll.scrollTo(0, 0);
        toast.show();

        //startActivity(intent);
    }

    private int calculateScore(){
        return correctAnswers * 100 / 10;
    }

    private String getFinalToast(int score){
        if (score < 75) {
            return("You didn't pass the quiz...\n" +
                    "Your final score was: " + score + "%");
        }
        else {
            return("Congratulations on passing the quiz!!\n" +
                    "Your final score was: " + score + "%");
        }

    }

    private void getCorrectAnswers(){
        q1();
        q2();
        q3();
        q4();
        q5();
        q6();
        q7();
        q8();
        q9();
        q10();
    }

    private void q1() {
        RadioButton radioQ1 = findViewById(R.id.q1_radioC);
        if (radioQ1.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 1 was incorrect\n";
        }
    }

    private void q2() {
        CheckBox chk1Q2 = findViewById(R.id.q2_checkbox1);
        CheckBox chk2Q2 = findViewById(R.id.q2_checkbox2);
        CheckBox chk2Q3 = findViewById(R.id.q2_checkbox3);
        CheckBox chk2Q4 = findViewById(R.id.q2_checkbox4);

        if (chk1Q2.isChecked() && chk2Q2.isChecked() && !chk2Q3.isChecked() && chk2Q4.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 2 was incorrect\n";
        }
    }

    private void q3() {
        RadioButton radioQ3 = findViewById(R.id.q3_radioB);
        if (radioQ3.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 3 was incorrect\n";
        }
    }

    private void q4() {
        EditText editTextQ4 = findViewById(R.id.q4_edit_text);
        if (editTextQ4.getText().toString().equalsIgnoreCase("255.255.255.0")){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 4 was incorrect\n";
        }
    }

    private void q5() {
        EditText editTextQ5 = findViewById(R.id.q5_edit_text);
        if (editTextQ5.getText().toString().equalsIgnoreCase("transmission control protocol")) {
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 5 was incorrect\n";
        }
    }

    private void q6() {
        RadioButton radioQ6 = findViewById(R.id.q6_radioB);
        if (radioQ6.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 6 was incorrect\n";
        }
    }

    private void q7() {
        RadioButton radioQ7 = findViewById(R.id.q7_radioC);
        if (radioQ7.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 7 was incorrect\n";
        }
    }

    private void q8() {
        EditText editTextQ8 = findViewById(R.id.q8_edit_text);
        String txtQ8 = editTextQ8.getText().toString();
        if (txtQ8.equalsIgnoreCase("icmp") || txtQ8.equalsIgnoreCase("internet control message protocol")) {
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 8 was incorrect\n";
        }
    }

    private void q9() {
        EditText editTextQ9 = findViewById(R.id.q9_edit_text);
        if (editTextQ9.getText().toString().equalsIgnoreCase("metro ui")) {
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 9 was incorrect\n";
        }
    }

    private void q10() {
        CheckBox chk1Q10 = findViewById(R.id.q10_checkbox1);
        CheckBox chk2Q10 = findViewById(R.id.q10_checkbox2);
        CheckBox chk3Q10 = findViewById(R.id.q10_checkbox3);
        CheckBox chk4Q10 = findViewById(R.id.q10_checkbox4);

        if (chk1Q10.isChecked() && chk2Q10.isChecked() && chk3Q10.isChecked() && !chk4Q10.isChecked()){
            correctAnswers++;
        }
        else {
            incorrectAnswers += "Question 10 was incorrect\n";
        }
    }
}
