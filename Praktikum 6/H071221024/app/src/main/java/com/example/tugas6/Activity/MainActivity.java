package com.example.tugas6.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.example.tugas6.Adapter.UserAdapter;
import com.example.tugas6.Config.RetrofitClient;
import com.example.tugas6.Model.User;
import com.example.tugas6.R;
import com.example.tugas6.Response.UserResponse;
import com.example.tugas6.Service.ApiService;

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
                    // Handle error
                }
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // Handle
                layoutError.setVisibility(View.VISIBLE);
            }
        });
    }
}