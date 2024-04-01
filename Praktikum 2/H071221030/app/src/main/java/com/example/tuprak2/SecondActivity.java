package com.example.tuprak2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Uri selectedImage = intent.getParcelableExtra("IMAGE_URI");
        String name = intent.getStringExtra("NAME");
        String nickname = intent.getStringExtra("NICKNAME");

        EditText inputNote1 = findViewById(R.id.editNote1);
        EditText inputNote2 = findViewById(R.id.editNote2);

        Button buttonNext = findViewById(R.id.nextScene);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note1 = inputNote1.getText().toString();
                String note2 = inputNote2.getText().toString();


                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("IMAGE_URI", selectedImage);
                intent.putExtra("NAME", name);
                intent.putExtra("NICKNAME", nickname);
                intent.putExtra("NOTE1", note1);
                intent.putExtra("NOTE2", note2);


                startActivity(intent);
            }
        });
    }
}