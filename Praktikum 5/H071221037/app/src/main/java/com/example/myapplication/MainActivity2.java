package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    public static String PARCEL_DATA = "parcel_data";

    Data getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewNickname = findViewById(R.id.textViewNickname);
        ImageView imageViewImage = findViewById(R.id.imageViewImage);
        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        linearLayout.setVisibility(View.GONE);
        Handler handler = new Handler(Looper.getMainLooper());
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                handler.post(() -> {
                   progressBar.setVisibility(View.GONE);
                   linearLayout.setVisibility(View.VISIBLE);
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        getData = getIntent().getParcelableExtra(PARCEL_DATA);
        textViewName.setText(getData.getName());
        textViewNickname.setText(getData.getNickname());
        if (getData.getImage() != null){
            imageViewImage.setImageResource(getData.getImage());
        } else {
            imageViewImage.setImageURI(getData.getUriImage());
        }
    }
}