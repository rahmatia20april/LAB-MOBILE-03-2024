package com.example.tugas07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    String nim, password;
    TextView tv_nim, tv_password;
    Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tv_nim = findViewById(R.id.tv_nim);
        tv_password = findViewById(R.id.tv_password);
        btn_register = findViewById(R.id.btn_register);

        btn_register.setOnClickListener( v -> {
            nim = String.valueOf(tv_nim.getText());
            password = String.valueOf(tv_password.getText());

            if (tv_nim.getText().toString().equals("")){
                tv_nim.setError("NIM harus diisi!");
                return;
            }else if (tv_password.getText().toString().equals("")){
                tv_password.setError("Password harus diisi!");
                return;
            }
            SharedPreferences preferences = this.getSharedPreferences("user_pref", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("nim", nim);
            editor.putString("password", password);
            editor.apply();

            Toast.makeText(this, "Berhasil Membuat Akun!", Toast.LENGTH_LONG).show();

            finish();
        });
    }
}