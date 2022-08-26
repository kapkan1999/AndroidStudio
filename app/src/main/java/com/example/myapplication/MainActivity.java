package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoRed( View v) {
        //EditText colourText = findViewById(R.id.editTextColour);
        //String colour = colourText.getText().toString();
        Intent intent = new Intent(this, Ac3.class);
        intent.putExtra("colour", "Красный");
        startActivity(intent);
    }

    public void GoBlue( View v) {
        //EditText colourText = findViewById(R.id.editTextColour);
        //String colour = colourText.getText().toString();
        Intent intent = new Intent(this, Ac3.class);
        intent.putExtra("colour", "Синий");
        startActivity(intent);
    }
    public void Scroll( View v) {

        Intent intent = new Intent(this, ScrollActivity.class);
        startActivity(intent);
    }

}