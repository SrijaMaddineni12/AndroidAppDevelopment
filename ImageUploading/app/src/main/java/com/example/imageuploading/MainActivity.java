package com.example.imageuploading;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    FirebaseStorage storage;
    StorageReference storageReference;
    EditText et_name, et_mobile;
    ImageView iv;
    Button b_camera, b_gallery, b_save, b_viewdata;
    public static final int CAMERA_REQUEST_CODE = 22;
    public static final int GALLERY_REQUEST_CODE = 22;

     FirebaseDatabase database;
     DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobile);
        iv = findViewById(R.id.image);
        b_camera = findViewById(R.id.camerabutton);
        b_gallery = findViewById(R.id.gallerybutton);
        b_save = findViewById(R.id.saveButton);
        b_viewdata = findViewById(R.id.viewdataButton);
        b_camera.setOnClickListener(this);
        b_gallery.setOnClickListener(this);
        b_save.setOnClickListener(this);
        b_viewdata.setOnClickListener(this);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camerabutton:
                openCamera();
                break;
            case R.id.gallerybutton:
                openGallery();
                break;
            case R.id.saveButton:
                saveData();
                break;
            case R.id.viewdataButton:
                viewData();
                break;


        }
    }

    private void viewData() {
        Intent i = new Intent(this,ViewDataActivity.class);
        startActivity(i);
    }

    private void saveData() {
        final String name = et_name.getText().toString();
        final String mobile = et_mobile.getText().toString();
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String filelocation = uri.toString();
                User u = new User(name, mobile, filelocation);
                databaseReference.child("Users").push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(MainActivity.this,
                                "Details are saved Successfully...",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void openGallery() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, GALLERY_REQUEST_CODE);
    }

    private void openCamera() {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, CAMERA_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
// TO ACCESS THE CAMERA IMAGE
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                Uri uri = getImageURI(MainActivity.this, bitmap);
                iv.setImageURI(uri);
                uploadImage(uri);
            }
            //TO ACESS THE GALLERY IMAGE
        }else if(requestCode == GALLERY_REQUEST_CODE){
            if (resultCode == RESULT_OK) {
                Uri u = data.getData();
                iv.setImageURI(u);
                uploadImage(u);
            }
        }
    }

    private void uploadImage(Uri uri) {
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Uploading File");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();
        storageReference = storageReference.child("Images/"+UUID.randomUUID().toString());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(MainActivity.this, "Image Uploaded successfullyy", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("MainActivity",e.getMessage());
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                double d = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setProgress((int)d);
            }
        });

    }

    //TO CONVERT BITMAP TO URI
    private Uri getImageURI(Context mainActivity, Bitmap bitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bytes);
        String path = MediaStore.Images.Media.insertImage(mainActivity
                .getContentResolver(),bitmap,"Title",null);
        return Uri.parse(path);

    }
}
