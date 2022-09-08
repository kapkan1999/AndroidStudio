package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    TextView tvOut;
    EditText ename, esurname, eyear;
    Button btnDel, btnAdd, btnGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        tvOut = findViewById(R.id.tvOut);

        ename = findViewById(R.id.editTextName);
        esurname = findViewById(R.id.editTextSurname);
        eyear = findViewById(R.id.editTextYear);

        btnDel = findViewById(R.id.buttonDel);
        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGetAll);

        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnGet.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.buttonDel:
                dbHelper.DeleteALl();
                break;
            case  R.id.buttonAdd:
                String name = ename.getText().toString();
                String surname = esurname.getText().toString();
                int year = Integer.parseInt(eyear.getText().toString());

                Data data = new Data(name,surname,year);
                dbHelper.AddOne(data);
                break;
            case R.id.buttonGetAll:
                LinkedList<Data> list =dbHelper.GetAll();

                String text ="";
                for (Data d:list) text = text + d.name+" "+ d.surName+" "+ d.year+"\n";
                tvOut.setText(text);
                break;
        }

    }
}