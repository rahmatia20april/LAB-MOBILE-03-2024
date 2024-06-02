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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nim, password;
    TextView tv_nim, tv_password;
    Button btn_login, btn_register;
    Boolean login_status;

    SharedPreferences preferencesLogin, preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences preferencesTheme = this.getSharedPreferences("theme_prefs", MODE_PRIVATE);
        boolean isDark = preferencesTheme.getBoolean("dark_mode", false);

        if (isDark){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        preferencesLogin = this.getSharedPreferences("login_status", MODE_PRIVATE);
        login_status = preferencesLogin.getBoolean("login", false);
        if (login_status){
            Intent intent = new Intent(this, HomeActivity.class);
            finish();
            startActivity(intent);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_nim = findViewById(R.id.tv_nim);
        tv_password = findViewById(R.id.tv_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(v -> {
            login();
        });

        btn_register.setOnClickListener( v -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    public void login(){
        preferences = this.getSharedPreferences("user_pref", MODE_PRIVATE);
        nim = preferences.getString("nim", "");
        password = preferences.getString("password", "");
        if (tv_nim.getText().toString().equals("")){
            tv_nim.setError("NIM harus diisi!");
            return;
        }else if (tv_password.getText().toString().equals("")){
            tv_password.setError("Password harus diisi!");
            return;
        }
        if (nim.equals(tv_nim.getText().toString()) && password.equals(tv_password.getText().toString())){
            SharedPreferences.Editor editor = preferencesLogin.edit();
            editor.putBoolean("login", true);
            editor.apply();

            Intent intent = new Intent(this, HomeActivity.class);
            finish();
            startActivity(intent);
        } else {
            Toast.makeText(this, "NIM atau Password salah!", Toast.LENGTH_LONG).show();
        }
    }
}