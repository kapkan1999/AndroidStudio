package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Ac3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac3);
        TextView textView = findViewById(R.id.textView2);

        //textView.setTextSize(26);
       // textView.setPadding(16, 120, 16, 16);

        Bundle arguments = getIntent().getExtras();

        if(arguments!=null){
            String name = arguments.get("colour").toString();
            textView.setText("Colour: " +name);
        }


    }
}