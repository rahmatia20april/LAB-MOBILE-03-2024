package com.example.tugas03;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas03.Model.Post;
import com.example.tugas03.Model.Story;
import com.example.tugas03.Model.User;

import java.util.ArrayList;

public class PostActvity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allpost_item);

        ImageView imageProfile = findViewById(R.id.iv_profile);
        TextView tvUsername = findViewById(R.id.tv_username);
        ImageView imagePost = findViewById(R.id.iv_post);
        TextView postDesc = findViewById(R.id.tv_postdesc);

        ArrayList<User> users = getIntent().getParcelableArrayListExtra("users");
        ArrayList<Post> posts = getIntent().getParcelableArrayListExtra("posts");
        ArrayList<Story> stories = getIntent().getParcelableArrayListExtra("stories");
        int idUser = getIntent().getIntExtra("idUser", -1);
        int idPost = getIntent().getIntExtra("idPost", -1);

        for (User user : users) {
            for (Post post : posts) {
                if(user.getId() == idUser && post.getUserId() == idUser && post.getId() == idPost){
                    imageProfile.setImageResource(user.getProfilePic());
                    tvUsername.setText(user.getUsername());
                    imagePost.setImageResource(post.getPostPic());
                    postDesc.setText(post.getPostDesc());
                }
            }
        }
        imageProfile.setOnClickListener(v -> {
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("idUser", idUser);
            intent.putExtra("users", users);
            intent.putExtra("posts", posts);
            intent.putExtra("stories", stories);
            startActivity(intent);
        });
        tvUsername.setOnClickListener(v -> {
            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("users",  users);
            intent.putExtra("posts", posts);
            intent.putExtra("stories", stories);
            intent.putExtra("idUser", idUser);
            startActivity(intent);
        });
    }
}
