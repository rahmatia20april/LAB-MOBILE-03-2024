package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class detailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CircleImageView imageViewName = findViewById(R.id.imageViewName);
        TextView textViewName = findViewById(R.id.textViewName);
        ImageView imageViewPost = findViewById(R.id.imageViewPost);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        Data data = getIntent().getParcelableExtra("detail_data");

        assert data != null;
        imageViewName.setImageResource(data.getImage_profile());
        textViewName.setText(String.valueOf(data.getName()));
        imageViewPost.setImageResource(data.getImage_post());
        textViewDescription.setText(String.valueOf(data.getDescription()));
        imageViewName.setOnClickListener(view -> onClickItem2(data));

        textViewName.setOnClickListener(view -> onClickItem(data));

    }
    public void onClickItem(Data data) {

        finish();
    }

    public void onClickItem2(Data data) {
        Intent intent = new Intent(this, PostActivity.class);
        intent.putExtra("post_data", data);
        startActivity(intent);
    }
}