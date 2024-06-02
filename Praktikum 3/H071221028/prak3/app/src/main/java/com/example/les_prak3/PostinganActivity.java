package com.example.les_prak3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.les_prak3.model.PostItem;
import com.example.les_prak3.model.ProfileItem;

public class PostinganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postingan);

        ImageView iv_profil = findViewById(R.id.post_user_image);
        TextView tv_profil = findViewById(R.id.post_username_tv);
        ImageView iv_post = findViewById(R.id.post_image);
        TextView tv_post = findViewById(R.id.post_description);

        PostItemList postItemList = new PostItemList();
        Intent intent= getIntent();

        iv_profil.setOnClickListener(v -> {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {

                PostItem profileItem = postItemList.getPostItemByUsername(username);
                Intent storyIntent = new Intent(PostinganActivity.this, StoryActivity.class);
                storyIntent.putExtra("USERNAME", username);
                startActivity(storyIntent);
            }
        });

        tv_profil.setOnClickListener(v -> {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {

                PostItem profileItem = postItemList.getPostItemByUsername(username);
                Intent storyIntent = new Intent(PostinganActivity.this, ProfileActivity.class);
                storyIntent.putExtra("USERNAME", username);
                startActivity(storyIntent);
            }
        });


        if (intent != null) {
            String username = intent.getStringExtra("USERNAME");
            if (username != null) {
                PostItem postItem = postItemList.getPostItemByUsername(username);
                iv_profil.setImageResource(postItem.getDrawableLogo());
                tv_profil.setText(postItem.getUsername());
                iv_post.setImageResource(postItem.getDrawablePost());
                tv_post.setText(postItem.getDescription());
            }
        }
    }
}