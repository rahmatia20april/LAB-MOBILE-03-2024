package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText et_nim;
    private TextInputEditText et_password;
    private Button btn_login;
    private Button btn_register;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        boolean nightMode = preferences.getBoolean("nightMode", false);
        if (nightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        preferences = getSharedPreferences("login", MODE_PRIVATE);
        boolean isLoggedIn = preferences.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
            finish();
        }
        et_nim = findViewById(R.id.et_nim);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = et_nim.getText().toString();
                String password = et_password.getText().toString();
                if (nim.isEmpty()){
                    et_nim.setError("NIM tidak boleh kosong");
                    et_nim.requestFocus();
                    return;
                } else if (password.isEmpty()) {
                    et_password.setError("Password tidak boleh kosong");
                    et_password.requestFocus();
                    return;
                } else {
                    // Ganti dengan logika pengecekan login yang sesuai
                    String storedNim = preferences.getString("nim", "");
                    String storedPassword = preferences.getString("password", "");
                    if (nim.equals(storedNim) && password.equals(storedPassword)) {
                        Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putBoolean("isLoggedIn", true);
                        editor.apply();
                        Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "NIM atau Password Salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
