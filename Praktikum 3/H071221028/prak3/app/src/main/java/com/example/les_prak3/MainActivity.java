package com.example.les_prak3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.les_prak3.model.StoryItem;
import com.example.les_prak3.postitem.PostListAdapter;
import com.example.les_prak3.profileitem.ProfileListAdapter;
import com.example.les_prak3.storyitem.StoryListAdapter;

import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainActivity extends AppCompatActivity {
    RecyclerView storyRecyclerView, postRecyclerView;
    StoryListAdapter storyListAdapter;
    PostListAdapter postListAdapter;

    ProfileListAdapter profileListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storyRecyclerView = findViewById(R.id.story_recycler_view);
        postRecyclerView = findViewById(R.id.post_recycler_view);

        StoryItemList storyItemList = new StoryItemList();
        PostItemList postItemList = new PostItemList();

        storyListAdapter = new StoryListAdapter();
        storyListAdapter.setStoryList(storyItemList.getItems());

        this.storyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.storyRecyclerView.setAdapter(storyListAdapter);

        postListAdapter = new PostListAdapter();
        postListAdapter.setPostList(postItemList.getItems());

        this.postRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        this.postRecyclerView.setAdapter(postListAdapter);
    }
}