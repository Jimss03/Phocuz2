package com.Destura.notesapp.video;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.Destura.notesapp.R;
import com.Destura.notesapp.lessonActivity.Member;
import com.Destura.notesapp.lessonActivity.Showvideo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity2 extends AppCompatActivity {

    private static final int PICK_VIDEO = 1;
    VideoView videoView;
    Button button;
    EditText editText;
    ProgressBar progressBar;
    private Uri videoUri;
    MediaController mediaController;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    Member member;


    UploadTask uploadTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        member = new Member();

        storageReference = FirebaseStorage.getInstance().getReference().child("uservid");
        databaseReference = FirebaseDatabase.getInstance().getReference().child("uservid");



        videoView= findViewById(R.id.videoview_main ) ;
        button =findViewById(R.id.button_upload_main ) ;
        progressBar = findViewById(R.id.progressBar_main ) ;
        editText = findViewById ( R.id.et_video_name ) ;
        mediaController = new MediaController(this);
        videoView.setMediaController (mediaController) ;
        videoView.start () ;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadVideo();

            }
        });


    }
    @Override
    protected void onActivityResult ( int requestCode , int resultCode , @Nullable Intent data ) {
        super.onActivityResult ( requestCode , resultCode , data ) ;

     if (requestCode == PICK_VIDEO || resultCode == RESULT_OK ||
     data !=null || data.getData() !=null){
         videoUri = data.getData();

         videoView.setVideoURI(videoUri);
     }
    }


    public void ChooseVideo(View view) {
        Intent intent = new Intent ( ) ;
        intent.setType ( "video/*" ) ;
        intent.setAction ( Intent.ACTION_GET_CONTENT ) ;
        startActivityForResult (intent,PICK_VIDEO ) ;
    }

    private String getExt(Uri uri){
        ContentResolver contentResolver = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return  mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(uri));
    }

    public void ShowVideo(View view) {

        Intent intent = new Intent(MainActivity2.this, Showvideo.class);
        startActivity(intent);

    }
    private void UploadVideo(){
        String videoName = editText.getText().toString();
        String search = editText.getText().toString().toLowerCase();
        if(videoUri !=null || !TextUtils.isEmpty(videoName)){
            progressBar.setVisibility(View.VISIBLE);
            final StorageReference reference = storageReference.child(System.currentTimeMillis()+ "." + getExt(videoUri));
            uploadTask = reference.putFile(videoUri);

            Task<Uri>urltask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if(!task.isSuccessful()){
                        throw task.getException();

                    }
                    return reference.getDownloadUrl();
                }
            })
                    .addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {

                            if(task.isSuccessful()) {
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                String currentuser = user.getUid();
                                Uri downloadUrl = task.getResult();
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(MainActivity2.this, "data save", Toast.LENGTH_SHORT).show();

                                member.setName(videoName);
                                member.setVideourl(downloadUrl.toString());
                                member.setSearch(search);
                                member.setIduser(currentuser);

                                databaseReference.child(currentuser).setValue(member);

                            }else{
                                Toast.makeText(MainActivity2.this,"failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }else{
            Toast.makeText(this,"All fields are required",Toast.LENGTH_SHORT).show();
        }
    }
}