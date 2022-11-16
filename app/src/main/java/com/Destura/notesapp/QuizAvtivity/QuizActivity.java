package com.Destura.notesapp.QuizAvtivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.Destura.notesapp.R;
import com.Destura.notesapp.toOopQuiz;
import com.Destura.notesapp.toQuizjava;
import com.Destura.notesapp.tobackendQ;
import com.Destura.notesapp.tocloud;


public class QuizActivity extends AppCompatActivity {
    private LinearLayout mtoquiz1;
    private LinearLayout mtojavaquiz1,mtocss,db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mtoquiz1 = findViewById(R.id.toquiz1);
        mtojavaquiz1 = findViewById(R.id.tojavaquiz1);
        mtocss = findViewById(R.id.css);
        db1 =findViewById(R.id.db);


        mtoquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, toOopQuiz.class);
                startActivity(intent);
            }

        });

        mtojavaquiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, toQuizjava.class);
                startActivity(intent);
            }
        });


        mtocss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, tocloud.class);
                startActivity(intent);
            }
        });

        db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, tocloud.class);
                startActivity(intent);
            }
        });

 
    }
}