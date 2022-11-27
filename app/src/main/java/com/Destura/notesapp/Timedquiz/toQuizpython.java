package com.Destura.notesapp.Timedquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.Destura.notesapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class toQuizpython extends AppCompatActivity {

    public static ArrayList<Modalclass>list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_quizjava);

        list=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("python");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modalclass modalclass=dataSnapshot.getValue(Modalclass.class);
                    list.add(modalclass);
                }
                Intent intent = new Intent(toQuizpython.this, Quizpython.class);
                startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1500);
    }
}