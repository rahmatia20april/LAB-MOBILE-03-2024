package com.example.instagramapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout_story);

        ImageView asl_profile = findViewById(R.id.asl_profile);
        ImageView asl_story = findViewById(R.id.asl_story);
        TextView asl_username = findViewById(R.id.asl_username);

        String username = getIntent().getStringExtra("send_username");
        String caption = getIntent().getStringExtra("send_caption");
        int profile = getIntent().getIntExtra("send_profile_image",0);
        int story = getIntent().getIntExtra("send_story_image",0);
        int post = getIntent().getIntExtra("send_post_image",0);
        int following = getIntent().getIntExtra("send_following",0);
        int followers = getIntent().getIntExtra("send_followers",0);

        asl_story.setImageResource(story);
        asl_profile.setImageResource(profile);
        asl_username.setText(username);

        asl_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StoryActivity.this ,ProfileActivity.class);
                intent.putExtra("send_username",username);
                intent.putExtra("send_post_image",post);
                intent.putExtra("send_caption",caption);
                intent.putExtra("send_followers",followers);
                intent.putExtra("send_following",following);
                intent.putExtra("send_profile_image",profile);
                intent.putExtra("send_story_image",story);
                startActivity(intent);
            }
        });


    }
}