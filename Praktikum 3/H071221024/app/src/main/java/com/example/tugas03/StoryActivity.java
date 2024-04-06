package com.example.tugas03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.Story;
import com.example.tugas03.Model.User;

import java.util.ArrayList;

public class StoryActivity extends AppCompatActivity {

    ImageView imgProfile, imgStory;
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        imgProfile = findViewById(R.id.profileStory);
        imgStory = findViewById(R.id.imageStory);
        username = findViewById(R.id.usernameStory);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        ArrayList<Post> posts = getIntent().getParcelableArrayListExtra("posts");
        ArrayList<Story> stories = getIntent().getParcelableArrayListExtra("stories");
        int idUser = getIntent().getIntExtra("idUser", -1);

        for (User user: users) {
            for (Story story : stories) {
                if (idUser == user.getId() && idUser == story.getUserId()){
                    imgProfile.setImageResource(user.getProfilePic());
                    username.setText(user.getUsername());
                    imgStory.setImageResource(story.getStoryPic());
                }
            }
        }
        imgProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", posts);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
        username.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", posts);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
    }
}