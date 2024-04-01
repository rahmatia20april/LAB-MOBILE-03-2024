package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView imageViewPost = findViewById(R.id.imageViewPost);
        CircleImageView imageViewName = findViewById(R.id.imageViewProfile);
        TextView textViewName = findViewById(R.id.textViewName);

        Data data = getIntent().getParcelableExtra("post_data");

        assert data != null;
        imageViewPost.setImageResource(data.getImage_Story());
        imageViewName.setImageResource(data.getImage_profile());
        textViewName.setText(String.valueOf(data.getName()));

        textViewName.setOnClickListener(view -> onItemClick(data));

    }

    public void onItemClick(Data data) {
        Intent intent = new Intent(this, profileActivity.class);
        intent.putExtra("profile_data", data);
        startActivity(intent);
    }

}