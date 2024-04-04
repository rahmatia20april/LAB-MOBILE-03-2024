package com.example.instagramapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_post);

        ImageView adpl_image_profile = findViewById(R.id.adpl_image_profile);
        TextView adpl_username = findViewById(R.id.adpl_username);
        ImageView adpl_post = findViewById(R.id.adpl_post);
        TextView adpl_caption = findViewById(R.id.adpl_caption);

        String username = getIntent().getStringExtra("send_username");
        String caption = getIntent().getStringExtra("send_caption");
        int profile = getIntent().getIntExtra("send_profile_image",0);
        int story = getIntent().getIntExtra("send_story_image",0);
        int post = getIntent().getIntExtra("send_post_image",0);
        int following = getIntent().getIntExtra("send_following",0);
        int followers = getIntent().getIntExtra("send_followers",0);

        adpl_image_profile.setImageResource(profile);
        adpl_username.setText(username);
        adpl_post.setImageResource(post);
        adpl_caption.setText(caption);

        adpl_image_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PostActivity.this ,StoryActivity.class);
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
        adpl_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}