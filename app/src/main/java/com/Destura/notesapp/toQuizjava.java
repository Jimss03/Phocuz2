package com.Destura.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class toQuizjava extends AppCompatActivity {

    public static ArrayList<Modalclass>list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_quizjava);

        list=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Question");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modalclass modalclass=dataSnapshot.getValue(Modalclass.class);
                    list.add(modalclass);
                }
                Intent intent = new Intent(toQuizjava.this,Quizjava.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


//        list.add(new Modalclass("awsdsads","a","b","c","d","a"));
//        list.add(new Modalclass("aws","a","b","c","d","b"));
//        list.add(new Modalclass("awaaaas","a","b","c","d","b"));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(toQuizjava.this,Quizjava.class);
//                    startActivity(intent);
            }
        },1500);
    }
}