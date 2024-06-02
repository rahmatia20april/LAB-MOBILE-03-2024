package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    public static final String EXTRA_ALL_USERS = "allUsers";
    static final String EXTRA_USER_ID = "id";
    private ApiService apiService;
    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Inisialisasi Retrofit
        apiService = RetrofitClient.getClient();

        // Inisialisasi View
        imageView = findViewById(R.id.imageView);
        textViewName = findViewById(R.id.textViewName);
        textViewEmail = findViewById(R.id.textViewEmail);

        Intent intent = getIntent();
        int userId = intent.getIntExtra("user", -1);
        Call<SingleUserResponse> call = apiService.getUsersById(userId);
        call.enqueue(new Callback<SingleUserResponse>() {
            @Override
            public void onResponse(Call<SingleUserResponse> call, Response<SingleUserResponse> response) {
                if (response.isSuccessful()) {
                    System.out.println(userId);
                    User user = response.body().getDataUser();
                    textViewName.setText(user.getFirst_name() + " " + user.getLast_name());
                    textViewEmail.setText(user.getEmail());
                    Picasso.get().load(user.getAvatar()).into(imageView);

                }
            }
            @Override
            public void onFailure(Call<SingleUserResponse> call, Throwable t) {
            }
        });
    }
}
