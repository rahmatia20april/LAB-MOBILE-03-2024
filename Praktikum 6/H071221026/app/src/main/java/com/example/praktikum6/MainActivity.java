package com.example.praktikum6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.praktikum6.UserAdapter;
import com.example.praktikum6.RetrofitClient;
import com.example.praktikum6.User;
import com.example.praktikum6.R;
import com.example.praktikum6.UserResponse;
import com.example.praktikum6.ApiService;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiService apiService;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private LinearLayout layoutError, itemProgress;
    private Button retryBtn, loadBtn;
    private LinearLayout layoutProgress, layoutItem;

    Context context;

    List<User> users;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        handler = new Handler(Looper.getMainLooper());

        recyclerView = findViewById(R.id.recyclerView);
        layoutError = findViewById(R.id.layout_error);
        layoutItem = findViewById(R.id.layoutItem);
        retryBtn = findViewById(R.id.retryBtn);
        layoutProgress = findViewById(R.id.layoutProgress);
        loadBtn = findViewById(R.id.loadBtn);
        itemProgress = findViewById(R.id.itemProgress);

        users = new ArrayList<>();

        layoutProgress.setVisibility(View.VISIBLE);
        handler.postDelayed(() -> {
            layoutProgress.setVisibility(View.GONE);
        }, 1000);
        getUser(1);


        loadBtn.setOnClickListener( v -> {
            loadBtn.setVisibility(View.GONE);
            itemProgress.setVisibility(View.VISIBLE);
            getUser(2);
        });
    }

    public void getUser(int page){
        apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<UserResponse> call = apiService.getUsers(page);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call,
                                   Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    System.out.println(response.body().getData());
                    users.addAll(response.body().getData());
                    userAdapter = new UserAdapter(users, context);
                    recyclerView.setAdapter(userAdapter);
                    if (page == 1){
                        loadBtn.setVisibility(View.VISIBLE);
                    } else if (page == 2){
                        itemProgress.setVisibility(View.GONE);
                    }
                } else {

                }
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                layoutError.setVisibility(View.VISIBLE);
                retryBtn.setVisibility(View.VISIBLE);

                retryBtn.setOnClickListener( v -> {
                    layoutError.setVisibility(View.GONE);
                    users = new ArrayList<>();
                    layoutProgress.setVisibility(View.VISIBLE);
                    handler.postDelayed(() -> {
                        layoutProgress.setVisibility(View.GONE);
                        layoutItem.setVisibility(View.VISIBLE);
                    }, 100);
                    getUser(1);
                });
            }
        });
    }
}