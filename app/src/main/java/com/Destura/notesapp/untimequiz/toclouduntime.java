package com.Destura.notesapp.untimequiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.Destura.notesapp.R;
import com.Destura.notesapp.Timedquiz.Modalclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class toclouduntime extends AppCompatActivity {
    public static ArrayList<Modalclass> list;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toclouduntime);

        list=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Cloud");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                    Modalclass modalclass=dataSnapshot.getValue(Modalclass.class);
                    list.add(modalclass);
                }
                Intent intent = new Intent(toclouduntime.this, clouduntime.class);
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


