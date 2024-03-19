package com.example.tugas01;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout containerLayout;
    Button btnOke;
    EditText input1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOke = findViewById(R.id.button_oke);
        input1 = findViewById(R.id.input1);
        containerLayout = findViewById(R.id.result);

        btnOke.setOnClickListener( v -> {
            TextView textview = new TextView(MainActivity.this);
            String inputText = input1.getText().toString();
            if (!inputText.isEmpty()){
                textview.setText(inputText);
                textview.setTextColor(Color.WHITE);
                textview.setTextSize(15);
                textview.setHeight(110);
                textview.setGravity(Gravity.CENTER_VERTICAL);
                textview.setPadding(20,20,20,20);
                input1.getText().clear();
                containerLayout.addView(textview);
            }
        });
    }
}