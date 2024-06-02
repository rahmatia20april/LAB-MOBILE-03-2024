package com.example.praktikum4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView ivProfile = findViewById(R.id.iv_profile);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvUsername = findViewById(R.id.tv_username);

        Intent intent = getIntent();
        Postingan postingan = intent.getParcelableExtra("postingan");

        ivProfile.setImageResource(postingan.getFotoProfile());
        tvName.setText(postingan.getName());
        tvUsername.setText(postingan.getUsername());

    }
}