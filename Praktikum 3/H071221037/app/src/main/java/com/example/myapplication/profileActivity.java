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

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CircleImageView imageViewProfile = findViewById(R.id.imageViewProfile);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView tvFollowers = findViewById(R.id.tv_followers);
        TextView tvFollowing = findViewById(R.id.tv_following);
        ImageView imageViewPost = findViewById(R.id.imageViewPost);

        Data data = getIntent().getParcelableExtra("profile_data");

        assert data != null;
        imageViewProfile.setImageResource(data.getImage_profile());
        textViewName.setText(String.valueOf(data.getName()));
        tvFollowers.setText(String.valueOf(data.getFollowers()));
        tvFollowing.setText(String.valueOf(data.getFollowing()));
        imageViewPost.setImageResource(data.getImage_post());

        imageViewProfile.setOnClickListener(view -> onItemClick(data));
        imageViewPost.setOnClickListener(view -> onItemClick2(data));
    }
    public void onItemClick(Data data) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_data", data);
        startActivity(intent);
    }

    public void onItemClick2(Data data){
        Intent intent = new Intent(this, detailActivity.class);
        intent.putExtra("detail_data", data);
        startActivity(intent);
    }

}