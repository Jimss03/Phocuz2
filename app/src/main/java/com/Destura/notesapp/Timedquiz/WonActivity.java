package com.Destura.notesapp.Timedquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Destura.notesapp.QuizAvtivity.QuizActivity;
import com.Destura.notesapp.R;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText,exit;
    int correct,wrong;
    LinearLayout btnshare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);
        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("Wrong",0);

        exit=findViewById(R.id.ic_exit);
        circularProgressBar= findViewById(R.id.circularProgressBar);
        resultText=findViewById(R.id.resultText);


        circularProgressBar.setProgress(correct);
        resultText.setText(correct+"/30");



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WonActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

    }
}