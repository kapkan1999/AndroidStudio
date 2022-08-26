package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class Ac3 extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac3);
        TextView textView = findViewById(R.id.textView2);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            String name = arguments.get("colour").toString();
            textView.setText("Colour: " +name);
            if (name=="Красный") {
                textView.setTextColor(Color.parseColor("#a8323e"));
            }
            if (name=="Синий") {

                textView.setTextColor(Color.parseColor("#0048ff"));
            }
        }
    }
}