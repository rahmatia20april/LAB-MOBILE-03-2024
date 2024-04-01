package com.example.tuprak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ImageView imageView = findViewById(R.id.imageView);
        TextView textNama = findViewById(R.id.textNama);
        TextView textNickname = findViewById(R.id.textNickname);
        TextView textNote1 = findViewById(R.id.textNote1);
        TextView textNote2 = findViewById(R.id.textNote2);

        Intent intent = getIntent();
        Uri selectedImage = intent.getParcelableExtra("IMAGE_URI");
        String name = intent.getStringExtra("NAME");
        String nickname = intent.getStringExtra("NICKNAME");
        String note1 = intent.getStringExtra("NOTE1");
        String note2 = intent.getStringExtra("NOTE2");

        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(selectedImage);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        textNama.setText(name);
        textNickname.setText(nickname);
        textNote1.setText(note1);
        textNote2.setText(note2);
    }
}