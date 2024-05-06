package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    private TextInputEditText et_nim;
    private TextInputEditText et_password;
    private Button btn_register;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Memasukkan nilai nightMode dari preferensi
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);
        boolean nightMode = preferences.getBoolean("nightMode", false);
        if (nightMode){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        et_nim = findViewById(R.id.et_nim);
        et_password = findViewById(R.id.et_password);
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nim = et_nim.getText().toString();
                String password = et_password.getText().toString();
                if (nim.isEmpty()) {
                    et_nim.setError("NIM tidak boleh kosong");
                    et_nim.requestFocus();
                    return;
                } else if (password.isEmpty()) {
                    et_password.setError("Password tidak boleh kosong");
                    et_password.requestFocus();
                    return;
                } else {
                    preferences = getSharedPreferences("login", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("nim", nim);
                    editor.putString("password", password);
                    editor.apply();
                    Toast.makeText(MainActivity2.this, "Berhasil Membuat Akun", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}