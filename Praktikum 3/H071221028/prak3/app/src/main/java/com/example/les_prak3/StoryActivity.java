package com.example.les_prak3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.les_prak3.model.StoryItem;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryActivity extends AppCompatActivity {

    private ImageView storySnapImage;
    private CircleImageView userImage;
    private TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storySnapImage = findViewById(R.id.story_snap_image);
        userImage = findViewById(R.id.story_user_image);
        usernameTextView = findViewById(R.id.post_username_tv);

        StoryItemList storyItemList = new StoryItemList();

        Intent intent = getIntent();
        if (intent != null){
            String username = intent.getStringExtra("USERNAME");
            if (username != null){
                StoryItem storyItem = storyItemList.getStoryItemByUsername(username);
                storySnapImage.setImageResource(storyItem.getDrawableSnap());
                userImage.setImageResource(storyItem.getDrawableLogo());
                usernameTextView.setText(storyItem.getUsername());
            }
        }

    }
}