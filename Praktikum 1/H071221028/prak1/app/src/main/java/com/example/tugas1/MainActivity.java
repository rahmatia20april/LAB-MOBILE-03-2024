package com.example.tugas1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private LinearLayout listLayout;
    private EditText editTextInput;
    private ArrayList<String> textList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listLayout= findViewById(R.id.layout_list);
        editTextInput = findViewById(R.id.edit_text_input);
        textList = new ArrayList<String>();
    }
    public void onButtonClick(View view){
        String inputtedText =editTextInput.getText().toString();
        if (inputtedText.isEmpty()==false){
            textList.add(inputtedText);
            editTextInput.setText("");
            refreshList();
        }
    }
        private void refreshList(){
        listLayout.removeAllViews();
            LayoutInflater inflater = LayoutInflater.from(this);
            for (String text: textList){
                View itemView = inflater.inflate(android.R.layout.simple_list_item_1,listLayout,false);
                TextView textView = itemView.findViewById(android.R.id.text1);

                textView.setText(text);
                listLayout.addView(itemView);
            }
        }
}