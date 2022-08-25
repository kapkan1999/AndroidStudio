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


      /*  resultTextView = findViewById(R.id.resultTextView);
        NumberField1 = findViewById(R.id.NumberField1);
        NumberField2 = findViewById(R.id.NumberField2);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(NumberField1.getText().toString());
                float num2 = Float.parseFloat(NumberField2.getText().toString());
                float res = num1+num2;
                resultTextView.setText(String.valueOf(res));

            }
        });*/
    }

    public void GoRed( View v) {
        EditText colourText = findViewById(R.id.colourText);
        String colour = colourText.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("colour", colour);
        startActivity(intent);
    }

}