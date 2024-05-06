package com.example.myapplication;

import static com.example.myapplication.MainActivity4.switchMode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    private TextView tv_welcome;
    private Button btn_logout, btn_setting;
    SharedPreferences preferences;
    SharedPreferences preferences2;

    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        preferences = getSharedPreferences("login", MODE_PRIVATE);
        String nim = preferences.getString("nim", "");
        String password = preferences.getString("password", "");
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        if (!isLoggedIn) {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
            return;
        }
        preferences2 = getSharedPreferences("nightMode", MODE_PRIVATE);
        boolean nightMode = preferences2.getBoolean("nightMode", false);
        if (nightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        tv_welcome = findViewById(R.id.tv_welcome);
        btn_logout = findViewById(R.id.btn_logout);
        btn_setting = findViewById(R.id.btn_setting);
        tv_welcome.setText("Selamat Datang " + nim);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = preferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();
                Intent intent = new Intent(MainActivity3.this, MainActivity.class);
                startActivity(intent);
                finish(); // Tutup Activity saat ini (MainActivity3)
            }
        });
        btn_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
    }
}
