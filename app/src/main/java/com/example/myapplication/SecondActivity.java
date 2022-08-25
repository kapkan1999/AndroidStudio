package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView =  this.findViewById(R.id.textView2);
        Bundle arguments = getIntent().getExtras();
        textView.setText("Hello Kitty!");
        /*
        if(arguments!=null){
            String colour = arguments.get("colour").toString();
            textView.setText("colour: " + colour);
        }*/
        setContentView(textView);
    }

    public void Goback( View v) {
        Intent intent= new Intent (this, MainActivity.class);
        startActivity(intent);
    }

}