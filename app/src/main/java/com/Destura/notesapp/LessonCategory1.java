package com.Destura.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Destura.notesapp.Pdf.Pdfactivity;
import com.Destura.notesapp.Pdf.myadapter;
import com.google.firebase.auth.FirebaseAuth;

public class LessonCategory1 extends AppCompatActivity {

    LinearLayout act1,act2,act3,act4,act5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_category1);

        act1 = findViewById(R.id.activity1);
        act2 = findViewById(R.id.activity2);
        act3 = findViewById(R.id.activity3);
        act4 = findViewById(R.id.activity4);
        act5 = findViewById(R.id.activity5);



        act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonCategory1.this, Pdfactivity.class);
                startActivity(intent);


            }
        });
        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonCategory1.this, Pdfactivity1.class);
                startActivity(intent);
            }
        });
        act3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonCategory1.this, Pdfactivity2.class);
                startActivity(intent);


            }
        });
        act4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonCategory1.this, Pdfactivity3.class);
                startActivity(intent);
            }
        });
        act5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LessonCategory1.this, Pdfactivity4.class);
                startActivity(intent);
            }
        });









    }
}