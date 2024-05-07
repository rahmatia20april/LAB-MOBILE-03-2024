package com.example.praktikum6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    ImageView profile;
    TextView username, email;
    Handler handler;
    Button retry;
    LinearLayout layoutProfile, layoutProgress, layoutError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        handler = new Handler(Looper.getMainLooper());

        profile = findViewById(R.id.profilePic);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        layoutProfile = findViewById(R.id.layoutItem);
        layoutProgress = findViewById(R.id.layoutProgress);
        layoutError = findViewById(R.id.layout_error);
        retry = findViewById(R.id.retryBtn);

        retry.setOnClickListener( v -> {
            layoutError.setVisibility(View.GONE);
            layoutProgress.setVisibility(View.VISIBLE);
            handler.postDelayed(() -> {
                layoutProgress.setVisibility(View.GONE);
                layoutProfile.setVisibility(View.VISIBLE);
            }, 100);
            getDetailUser(getIntent().getIntExtra("id", 0));
        });

        layoutProgress.setVisibility(View.VISIBLE);
        handler.postDelayed(() -> {
            layoutProgress.setVisibility(View.GONE);
        }, 1000);
        getDetailUser(getIntent().getIntExtra("id", 0));
    }

    public void getDetailUser(int id){
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponseDetail> call = apiService.getDetailUser(id);
        call.enqueue(new Callback<UserResponseDetail>() {
            @Override
            public void onResponse(Call<UserResponseDetail> call, Response<UserResponseDetail> response) {
                if (response.isSuccessful()){
                    User user = response.body().getData();
                    Picasso.get().load(user.getAvatar()).into(profile);
                    username.setText(user.getFirst_name() + " " + user.getLast_name());
                    email.setText(user.getEmail());
                } else {

                }
            }
            @Override
            public void onFailure(Call<UserResponseDetail> call, Throwable t) {
                layoutProfile.setVisibility(View.GONE);
                layoutError.setVisibility(View.VISIBLE);
            }
        });
    }
}