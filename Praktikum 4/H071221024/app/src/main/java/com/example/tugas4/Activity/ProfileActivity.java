package com.example.tugas4.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugas4.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView profilePic;
    TextView fullname, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilePic = findViewById(R.id.profilePic);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);

        int profilePicture = getIntent().getIntExtra("profilePic", -1);
        String full_name = getIntent().getStringExtra("fullname");
        String user_name = getIntent().getStringExtra("username");

        profilePic.setImageResource(profilePicture);
        fullname.setText(full_name);
        username.setText(user_name);
    }
}