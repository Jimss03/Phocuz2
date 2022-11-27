package com.Destura.notesapp.Timedquiz;

import static com.Destura.notesapp.Timedquiz.toQuizpython.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.Destura.notesapp.QuizAvtivity.QuizActivity;

import com.Destura.notesapp.R;
import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.Collections;
import java.util.List;

public class Quizpython extends AppCompatActivity {

    CountDownTimer countDownTimer;
    int timerValue=20;
    RoundedHorizontalProgressBar progressBar;
    List<Modalclass>allQuestionslist;
    Modalclass modalclass;
    int index=0;
    TextView card_quetion,optiona,optionb,optionc,optiond,ic_exit;
    CardView cardOA,cardOB,cardOC,cardOD;
    int correctCount =0;
    int wrongCount=0;
    LinearLayout nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizjava);

        Hooks();
        progressBar = findViewById(R.id.quiz_timer);
        ic_exit=findViewById(R.id.ic_exit);
        allQuestionslist=list;
        modalclass=list.get(index);
        Collections.shuffle(allQuestionslist);

        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));

        nextBtn.setClickable(false);

        setAllData();

        ic_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quizpython.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                    timerValue = timerValue-1;
                    progressBar.setProgress(timerValue);


            }



            @Override
            public void onFinish(){
                Dialog dialog = new Dialog(Quizpython.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out_dialog);

                dialog.findViewById(R.id.btn_tryAgain).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Quizpython.this, QuizActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();

            }
        }.start();



    }

    private void setAllData() {
        card_quetion.setText(modalclass.getQuetion());
        optiona.setText(modalclass.getoA());
        optionb.setText(modalclass.getoB());
        optionc.setText(modalclass.getoC());
        optiond.setText(modalclass.getoD());
    }

    private void Hooks() {
        progressBar = findViewById(R.id.quiz_timer);
        card_quetion = findViewById(R.id.card_question);
        optiona = findViewById(R.id.card_optiona);
        optionb = findViewById(R.id.card_optionb);
        optionc = findViewById(R.id.card_optionc);
        optiond = findViewById(R.id.card_optiond);

        cardOA=findViewById(R.id.carda);
        cardOB=findViewById(R.id.cardb);
        cardOC=findViewById(R.id.cardc);
        cardOD=findViewById(R.id.cardd);
        nextBtn=findViewById(R.id.nextBtn);

    }
    public void Correct(CardView cardView){
        cardView.setBackgroundColor(getResources().getColor(R.color.cool_green));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                index++;
                modalclass= list.get(index);
                setAllData();
                resetColor();

            }
        });


    }
    public void Wrong(CardView cardOA){
        cardOA.setBackgroundColor(getResources().getColor(R.color.cool_pink));

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                wrongCount++;
                if (index<list.size()-1){
                    index++;
                    modalclass= list.get(index);
                    setAllData();
                    resetColor();
                }else {
                    gameWon();
                }
            }
        });


    }

    private void gameWon() {
        Intent intent= new Intent(Quizpython.this, WonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("Wrong",wrongCount);
        startActivity(intent);
    }
    public void enableButton(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableButton(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }
    public void resetColor(){
        cardOA.setBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view) {
        nextBtn.setClickable(true);
        if (modalclass.getoA().equals(modalclass.getAns())){
            cardOA.setBackgroundColor(getResources().getColor(R.color.cool_green));

            if (index<list.size()-1){
                Correct(cardOA);
            }
            else {
                gameWon();
            }

        }
        else {
            Wrong(cardOA);
        }
    }

    public void OptionClickB(View view) {

        nextBtn.setClickable(true);
        if (modalclass.getoB().equals(modalclass.getAns())){
            cardOB.setBackgroundColor(getResources().getColor(R.color.cool_green));

            if (index<list.size()-1){
             Correct(cardOB);
            }
            else {
                gameWon();
            }

        }
        else {
            Wrong(cardOB);
        }
    }

    public void OptionClickC(View view) {

        nextBtn.setClickable(true);
        if (modalclass.getoC().equals(modalclass.getAns())){
            cardOC.setBackgroundColor(getResources().getColor(R.color.cool_green));

            if (index<list.size()-1){
                Correct(cardOC);
            }
            else {
                gameWon();
            }

        }
        else {
            Wrong(cardOC);
        }
    }

    public void OptionClickD(View view) {

        nextBtn.setClickable(true);
        if (modalclass.getoD().equals(modalclass.getAns())){
            cardOD.setBackgroundColor(getResources().getColor(R.color.cool_green));

            if (index<list.size()-1){
                Correct(cardOD);
            }
            else {
                gameWon();
            }

        }
        else {
            Wrong(cardOD);
        }
    }
}