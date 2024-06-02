package com.example.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity3 extends AppCompatActivity {
     ImageView imageView;
     TextView textViewName;
     TextView textViewUsername;
     TextView textViewTitle;
     TextView textViewContent;
     Uri image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String username = intent.getStringExtra("Username");
        String title = intent.getStringExtra("Title");
        String content = intent.getStringExtra("Content");
        String gambar = intent.getStringExtra("Gambar");

        textViewName = findViewById(R.id.textViewName);
        textViewUsername = findViewById(R.id.textViewUsername);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewContent = findViewById(R.id.textViewContent);
        imageView = findViewById(R.id.getImageView);

        textViewName.setText(name);
        textViewUsername.setText(username);
        textViewTitle.setText(title);
        textViewContent.setText(content);

        if (gambar != null) {
            try {
                image = Uri.parse(gambar);
                InputStream inputStream = getContentResolver().openInputStream(image);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, "Gagal memuat gambar", Toast.LENGTH_SHORT).show();
            }
        }

    }
}