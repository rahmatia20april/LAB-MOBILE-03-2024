package com.example.tuprak7;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    public static final String EXTRA_USER_ID = "user_id";
    private ApiService apiService;
    private User selectedUser;

    private LinearLayout contentProfile;
    private ImageView avatarImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private ProgressBar loading_bar;
    private LinearLayout failureScreen;
    private Button retryButton;

    Executor executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        contentProfile = findViewById(R.id.contentProfile);
        avatarImageView = findViewById(R.id.avatarImageView);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        loading_bar = findViewById(R.id.loading_bar);
        failureScreen = findViewById(R.id.failureScreen);
        failureScreen = findViewById(R.id.failureScreen);
        retryButton = findViewById(R.id.retryButton);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        contentProfile.setVisibility(View.GONE);
        loading_bar.setVisibility(View.VISIBLE);

        int userId = getIntent().getIntExtra(EXTRA_USER_ID, 0);

        retryButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra(ProfileActivity.EXTRA_USER_ID, userId);
            finish();
            startActivity(intent);
        });

        Call<SingleUserResponse> call = apiService.getUsers(userId);
        call.enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (response.isSuccessful()) {
                    executor.execute(() -> {
                        User user = response.body().getUser();

                        handler.post(() -> {
                            Picasso.get().load(user.getAvatar()).into(avatarImageView);
                            nameTextView.setText(user.getFirst_name() + " " + user.getLast_name());
                            emailTextView.setText(user.getEmail());

                            contentProfile.setVisibility(View.VISIBLE);
                            loading_bar.setVisibility(View.GONE);
                        });
                    });
                } else {
                    setFailureScreen();
                }
            }

            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
                setFailureScreen();
            }
        });
    }

    private void setFailureScreen() {
        contentProfile.setVisibility(View.GONE);
        loading_bar.setVisibility(View.GONE);
        failureScreen.setVisibility(View.VISIBLE);
    }
}