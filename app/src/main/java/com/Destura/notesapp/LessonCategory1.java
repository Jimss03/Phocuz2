package com.Destura.notesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LessonCategory1 extends AppCompatActivity {
    TextView p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_category1);

            p1= findViewById(R.id.p1);
        p1.setFocusable(true);
        p1.setEnabled(true);
        p1.setClickable(true);
        p1.setFocusableInTouchMode(true);
        p1.isSaveEnabled();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}