package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreference extends AppCompatActivity  {

    private EditText edText;
    //private Button buttonsave, buttonload;
    private SharedPreferences sPref;

    private final String Saved_Text = "Saved_Text";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        init();

       // buttonsave= findViewById(R.id.buttonload);
        // buttonload= findViewById(R.id.buttonload);
    }
   /*public void OnClick(View v) {
        switch (v.getId()){
            case R.id.buttonsave:
                saveText();
                break;
            case R.id.buttonload:
                loadText();
                break;
            default:
                break;
        }
    }*/
   private void init () {
       sPref=getSharedPreferences("Test",MODE_PRIVATE);
       edText= findViewById(R.id.edText);
       edText.setText(sPref.getString(Saved_Text,""));
   }
    public void saveText(View View) {

        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(Saved_Text,edText.getText().toString());
        ed.apply();
       // Toast.makeText(SharedPreference.this,"Text Saved",Toast.LENGTH_SHORT).show();
    }
    public void loadText(View View) {
        edText.setText((sPref.getString(Saved_Text,"")));
        //Toast.makeText(SharedPreference.this,"Text Loaded",Toast.LENGTH_SHORT).show();

    }
}