package com.example.tugas4.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.tugas4.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    ImageView profilePic;
    TextView fullname, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profilePic = findViewById(R.id.profilePic);
        fullname = findViewById(R.id.fullname);
        username = findViewById(R.id.username);

        Handler handler = new Handler(Looper.getMainLooper());
        ExecutorService executor = Executors.newSingleThreadExecutor();

        LinearLayout progressLayout = findViewById(R.id.progress_layout);
        LinearLayout linearLayout = findViewById(R.id.profile_layout);

        executor.execute(() -> {
            new Thread(() -> {
                try {
                    for(int i = 0; i <= 1; i++){
                        int finalI = i;
                        handler.post(() -> {
                            if (finalI == 1){
                                progressLayout.setVisibility(View.GONE);
                                linearLayout.setVisibility(View.VISIBLE);
                                int profilePicture = getIntent().getIntExtra("profilePic", -1);
                                String full_name = getIntent().getStringExtra("fullname");
                                String user_name = getIntent().getStringExtra("username");

                                profilePic.setImageResource(profilePicture);
                                fullname.setText(full_name);
                                username.setText(user_name);
                            } else {
                                linearLayout.setVisibility(View.GONE);
                                progressLayout.setVisibility(View.VISIBLE);
                            }
                        });
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });
    }
}