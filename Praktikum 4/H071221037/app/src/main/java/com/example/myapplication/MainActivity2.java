package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    public static String PARCEL_DATA = "parcel_data";

    Data getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewNickname = findViewById(R.id.textViewNickname);
        ImageView imageViewImage = findViewById(R.id.imageViewImage);

        getData = getIntent().getParcelableExtra(PARCEL_DATA);
        textViewName.setText(getData.getName());
        textViewNickname.setText(getData.getNickname());
        imageViewImage.setImageURI(getData.getUriImage());
    }

}