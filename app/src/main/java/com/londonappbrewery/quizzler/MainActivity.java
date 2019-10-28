package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    Button mTrueButton;
    Button mFalseButton;
    TextView mQuestionTextView;
    int index;
    int question;
    TextView ScoreTextView;
    ProgressBar progress;
    int pscore;
    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    // TODO: Declare constants here

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0 / mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mQuestionTextView = findViewById(R.id.question_text_view);
        ScoreTextView = findViewById(R.id.score);
        progress = findViewById(R.id.progress_bar);

        question = mQuestionBank[index].getQuestionId();
        mQuestionTextView.setText(question);

       mTrueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               CheckAnswer(true);
               update();
           }
       });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(false);
               update();
            }
        });


    }

    private void update(){

        index = (index + 1) % mQuestionBank.length;

        if(index == 0){

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Completed");
            alert.setCancelable(false);
            alert.setMessage("Your score: " + pscore);
            alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }

        question = mQuestionBank[index].getQuestionId();
        mQuestionTextView.setText(question);
        progress.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        ScoreTextView.setText("Score " + pscore + "/" + mQuestionBank.length);
    }

    private void CheckAnswer(boolean userselection){

        boolean correctanswer = mQuestionBank[index].isAnswer();

        if (userselection == correctanswer){
            pscore = pscore + 1;
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();

        } else{

            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }

}}
