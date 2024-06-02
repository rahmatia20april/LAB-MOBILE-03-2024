package com.example.tuprak7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    private UserAdapter userAdapter;

    private RecyclerView recyclerView;
    private Button loadMore;
    private LinearLayout loadingScreen;
    private ProgressBar loadMoreProgress;
    private LinearLayout parents;
    private LinearLayout failureScreen;
    private Button retryButton;

    private ArrayList<User> users = new ArrayList<>();

    Executor executor = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        loadMore = findViewById(R.id.loadMore);
        loadingScreen = findViewById(R.id.loadingScreen);
        loadMoreProgress = findViewById(R.id.loadMoreProgress);
        parents = findViewById(R.id.parents);
        failureScreen = findViewById(R.id.failureScreen);
        retryButton = findViewById(R.id.retryButton);

        apiService = RetrofitClient.getClient().create(ApiService.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadingScreen.setVisibility(View.VISIBLE);
        parents.setVisibility(View.GONE);

        executor.execute(() -> {
            addUsers(1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            handler.post(() -> {
                if (users.isEmpty()) {
                    loadingScreen.setVisibility(View.GONE);
                    setFailureScreen();
                } else {
                    parents.setVisibility(View.VISIBLE);
                    loadingScreen.setVisibility(View.GONE);
                }
            });
        });

        loadMore.setOnClickListener(v -> {
            loadMore.setVisibility(View.GONE);
            loadMoreProgress.setVisibility(View.VISIBLE);
            executor.execute(() -> {
                addUsers(2);
            });
        });

        retryButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            finish();
            v.getContext().startActivity(intent);
        });
    }

    private void addUsers(int page) {
        Call<UserResponse> call = apiService.getUsers(page, 6);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    List<User> newUsers = response.body().getData();
                    users.addAll(newUsers);
                    if (userAdapter == null) {
                        userAdapter = new UserAdapter(users);
                        recyclerView.setAdapter(userAdapter);
                    } else {
                        userAdapter.notifyDataSetChanged();
                    }
                } else {
                    setFailureScreen();
                }
                loadMoreProgress.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                setFailureScreen();
            }
        });
    }

    private void setFailureScreen() {
        parents.setVisibility(View.GONE);
        failureScreen.setVisibility(View.VISIBLE);
        loadMoreProgress.setVisibility(View.GONE);
    }
}