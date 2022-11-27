package com.Destura.notesapp.QuizAvtivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


import com.Destura.notesapp.R;
import com.Destura.notesapp.Timedquiz.toOopQuiz;
import com.Destura.notesapp.Timedquiz.toQuizpython;
import com.Destura.notesapp.Timedquiz.tobackendQ;
import com.Destura.notesapp.Timedquiz.tocloud;
import com.Destura.notesapp.untimequiz.toOopQuizuntime;
import com.Destura.notesapp.untimequiz.toQuizpythonuntime;
import com.Destura.notesapp.untimequiz.tobackendQchoice;


public class QuizActivity extends AppCompatActivity {
    private LinearLayout mtopython;
    private LinearLayout mtooop,mtocss,db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mtopython = findViewById(R.id.toquiz1);
        mtooop = findViewById(R.id.tojavaquiz1);
        mtocss = findViewById(R.id.css);
        db1 =findViewById(R.id.db);


        mtopython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(QuizActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.pytonchoic);

                dialog.findViewById(R.id.pytimeq).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, toQuizpython.class);
                        startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.pyuntime).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, toQuizpythonuntime.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }

        });



        mtooop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(QuizActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.oopchoic);

                dialog.findViewById(R.id.pytimeq).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, toOopQuiz.class);
                        startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.pyuntime).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, toOopQuizuntime.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });


        mtocss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(QuizActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.dbmschoice);
                dialog.findViewById(R.id.pytimeq).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, tobackendQ.class);
                        startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.pyuntime).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, tobackendQchoice.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });

        db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(QuizActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.dbmschoice);
                dialog.findViewById(R.id.pytimeq).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, tocloud.class);
                        startActivity(intent);
                    }
                });
                dialog.findViewById(R.id.pyuntime).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(QuizActivity.this, tobackendQchoice.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        });

 
    }
}