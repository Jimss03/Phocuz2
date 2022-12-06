package com.Destura.notesapp.Pdf;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.Destura.notesapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class myadapter3 extends FirebaseRecyclerAdapter<model, myadapter3.myviewholder>
{
    FirebaseUser user;
    String uid;


    public myadapter3(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final myviewholder holder, @SuppressLint("RecyclerView") final int position, @NonNull final model model) {
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        holder.header.setText(model.getFilename());


                holder.img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(holder.img1.getContext(), viewpdf.class);
                        intent.putExtra("filename",model.getFilename());
                        intent.putExtra("fileurl",model.getFileurl());

                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        holder.img1.getContext().startActivity(intent);
                    }

                });

                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(holder.header.getContext());
                        builder.setTitle("are you sure");
                        builder.setMessage("Delete data cant be undo");

                        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseDatabase.getInstance().getReference("upload1").child(uid)
                                        .child(getRef(position).getKey()).removeValue();

                            }
                        });
                        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(holder.header.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

                            }
                        });
                        builder.show();
                    }
                });

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singelrowdesign,parent,false);
        return  new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
     {
         ImageView img1;
         TextView header;
         Button delete;


         public myviewholder(@NonNull View itemView)
         {
             super(itemView);

             img1=itemView.findViewById(R.id.img1);
             header=itemView.findViewById(R.id.header);
             delete =itemView.findViewById(R.id.deletepdf);


      }
     }
}
