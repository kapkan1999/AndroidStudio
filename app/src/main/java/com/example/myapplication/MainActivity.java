package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText NumberField1,NumberField2;
    private Button add_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoRed( View v) {
        EditText colourText = findViewById(R.id.colourText);
        String colour = colourText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        //intent.putExtra("colour", colour);
        intent.putExtra("hello", "Hello World");
        startActivity(intent);
    }

}