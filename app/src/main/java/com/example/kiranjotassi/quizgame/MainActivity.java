package com.example.kiranjotassi.quizgame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.kiranjotassi.quizgame.model.Question;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private TextView textQuestion;
    private Button trueButton;
    private Button falseButton;
    private TextView textResult;
    private Button nextQuestion;
    public ArrayList<Question> questions;
    boolean trueClicked ;
    boolean falseClicked;
    boolean answer;
    int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textQuestion = findViewById(R.id.txt_question);
        trueButton = findViewById(R.id.btn_true);
        falseButton = findViewById(R.id.btn_false);
        textResult = findViewById(R.id.txt_result);
        nextQuestion = findViewById(R.id.btn_next);
        questions = Question.getQuestions();


            trueButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    trueClicked= true;
                    checkAnswer();
                }
            });

            falseButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    falseClicked = true;
                    checkAnswer();

                }
            });
            nextQuestion.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(counter = 0; counter <= 5; counter++) {
                        displayNextQuestion();
                        int correctAnswers = keepScore();
                        correctAnswers=(correctAnswers/5)*100;
                        textResult.setText("Good job! you got "+ correctAnswers+ "% of the questions correct.");
                    }
                }
            });


    }
    public int displayNextQuestion(){
        int size = questions.size();
        int i;
        for (i = 0; i < size; i++){
            textQuestion.setText(questions.get(i).getQuestion());
            answer = questions.get(i).isAnswer();
        }
        return i;
    }
    public void checkAnswer(){
        if(trueClicked == answer){
            textResult.setText(getResources().getString(R.string.true_answer));
        }else if(falseClicked == answer){
            textResult.setText(getResources().getString(R.string.false_answer));
        }else{
            textResult.setText(getResources().getString(R.string.try_again));
        }
    }
    public int keepScore(){
        int score = 0;
        for (int l = 0; l < 5; l++) {
            if(trueClicked == answer){
               score +=1;
               return score;
            }
            if(falseClicked == answer){
                score+=1;
                return score;
            }
        }
        return score;
    }
}
