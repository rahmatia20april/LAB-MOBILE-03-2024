package com.example.tugas03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugas03.Adapter.AllPostAdapter;
import com.example.tugas03.Adapter.StoryAdapter;
import com.example.tugas03.Data.DataSource;

public class MainActivity extends AppCompatActivity {

//    TextView tvUsernameStory, tvUsernamePost, tvPostDesc;
//    ImageView ivImageProfileInStory, ivImageProfileInPost, ivImagePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvStory = findViewById(R.id.rv_stories);
        rvStory.setHasFixedSize(true);
//        rvStory.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        StoryAdapter storyAdapter = new StoryAdapter(MainActivity.this, DataSource.users, DataSource.posts, DataSource.stories);

        RecyclerView rvAllPost = findViewById(R.id.rv_all_posts);
        rvAllPost.setHasFixedSize(true);
//        rvAllPost.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        AllPostAdapter allPostAdapter = new AllPostAdapter(MainActivity.this, DataSource.users, DataSource.posts, DataSource.stories);

        rvStory.setAdapter(storyAdapter);
        rvAllPost.setAdapter(allPostAdapter);
    }
}