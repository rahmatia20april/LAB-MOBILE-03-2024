package com.example.tugas07;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tv_welcome;
    String nim;
    Button btn_logout, btn_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tv_welcome = findViewById(R.id.tv_welcome);
        btn_logout = findViewById(R.id.btn_logout);
        btn_setting = findViewById(R.id.btn_setting);

        SharedPreferences preferences = this.getSharedPreferences("user_pref", MODE_PRIVATE);
        nim = preferences.getString("nim", "");

        tv_welcome.setText("Selamat Datang " + nim);

        btn_logout.setOnClickListener( v -> {
            SharedPreferences preferencesLogin = this.getSharedPreferences("login_status", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferencesLogin.edit();
            editor.clear();
            editor.apply();
            Intent intent = new Intent(this, MainActivity.class);
            finish();
            startActivity(intent);
        });
        btn_setting.setOnClickListener(v -> {
            Intent intent = new Intent(this, SettingActivity.class);
            startActivity(intent);
        });
    }
}