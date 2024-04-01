package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private EditText edit_Title ;
    private EditText edit_Content;
    private String name;
    private String username;
    private String image;
    private Uri convertedImage;

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

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        username = intent.getStringExtra("Username");
        image = intent.getStringExtra("Gambar");
        convertedImage = Uri.parse(image);

        edit_Title = findViewById(R.id.edit_Title);
        edit_Content = findViewById(R.id.edit_Content);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAndSubmit();
            }
        });
    }

    private void validateAndSubmit(){
        String title = edit_Title.getText().toString();
        String content = edit_Content.getText().toString();

        if (title.isEmpty()){
            edit_Title.setError("Title tidak boleh kosong");
            return;
        }
        if (content.isEmpty()){
            edit_Content.setError("Content tidak boleh kosong");
            return;
        }
        Intent intent2 = new Intent(MainActivity2.this, MainActivity3.class);
        intent2.putExtra("Name", name);
        intent2.putExtra("Username", username);
        intent2.putExtra("Title" , title);
        intent2.putExtra("Content", content);
        intent2.putExtra("Gambar", convertedImage.toString());

        startActivity(intent2);

    }
}