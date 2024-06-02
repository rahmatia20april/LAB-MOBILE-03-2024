package com.example.tugasprak1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
//        textView = findViewById(R.id.textView5);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();

                TextView newTextView = new TextView(MainActivity.this);
                newTextView.setText(text);
                newTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                newTextView.setTextColor(Color.BLACK);
                newTextView.setBackgroundColor(Color.WHITE);
                newTextView.setTextDirection(Paint.UNDERLINE_TEXT_FLAG);

                LinearLayout layout = findViewById(R.id.layout);
                layout.addView(newTextView);

                editText.setText("");
            }
        });
    }
}