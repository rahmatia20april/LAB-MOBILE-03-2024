package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rv_story = findViewById(R.id.rv_story);
        RecyclerView rv_post = findViewById(R.id.rv_post);
        rv_story.setHasFixedSize(true);
        rv_post.setHasFixedSize(true);
//        rv_story.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        rv_post.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Adapter1 adapter1 = new Adapter1(Source.datas);
        Adapter2 adapter2 = new Adapter2(Source.datas);
        rv_story.setAdapter(adapter1);
        rv_post.setAdapter(adapter2);

        adapter1.setOnItemClickListener(new Adapter1.OnItemClickListener() {
            @Override
            public void onItemClick(Data data) {

                MainActivity.this.onItemClick(data);
            }
        });

        adapter2.setOnItemClickListener(new Adapter2.OnItemClickListener() {
            @Override
            public void onItemClick(Data data) {
                // Panggil method onItemClick di MainActivity
                MainActivity.this.onItemClick2(data);
            }
        });
    }

    public void onItemClick(Data data) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_data", data);
        startActivity(intent);
    }

    public void onItemClick2(Data data){
        Intent intent = new Intent(this, profileActivity.class);
        intent.putExtra("profile_data", data);
        startActivity(intent);
    }
}