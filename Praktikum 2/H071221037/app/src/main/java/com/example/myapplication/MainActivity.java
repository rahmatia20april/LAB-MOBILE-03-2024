package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private EditText edit_name;
    private EditText edit_username;
    private ImageView imageView;
    private boolean imageSelected = false;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_name = findViewById(R.id.edit_name);
        edit_username = findViewById(R.id.edit_username);
        Button btnSubmit = findViewById(R.id.btnSubmit);
        imageView = findViewById(R.id.sendImageView);

        ActivityResultLauncher<Intent>intentLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
           if (result.getResultCode() == RESULT_OK && result.getData() != null) {
               selectedImageUri = result.getData().getData();
               try {
                   InputStream inputStream = getContentResolver().openInputStream(selectedImageUri);
                   Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//                   imageView.setImageBitmap(bitmap);
                   imageView.setImageURI(selectedImageUri);
                   imageSelected = true;
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
                   Toast.makeText(this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
               }
           }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                intentLaunch.launch(intent);
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                validateAndSubmit();
            }
        });
    }
    private void validateAndSubmit(){
        String name = edit_name.getText().toString();
        String username = edit_username.getText().toString();
        if (!imageSelected) {
            Toast.makeText(this, "Pilih gambar dulu", Toast.LENGTH_SHORT).show();
            return;
        }
        if (name.isEmpty()){
            edit_name.setError("Nama tidak boleh kosong");
            return;
        }
        if (username.isEmpty()){
            edit_username.setError("Username tidak boleh Kosong");
            return;
        }

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("Name",  name);
        intent.putExtra("Username", username);
        intent.putExtra("Gambar", selectedImageUri.toString());
        startActivity(intent);
    }   

}