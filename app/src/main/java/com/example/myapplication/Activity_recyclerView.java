package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public abstract class Activity_recyclerView extends AppCompatActivity implements View.OnClickListener{

    EditText edText;
    Button buttonsave, buttonload;
    RecyclerView recyclerView;
    SharedPreferences sPref;

    String s1[], s2[];
    final String Saved_Text = "Saved_Text";
    int images []={R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd,R.drawable.ee,
            R.drawable.gg,R.drawable.ii,R.drawable.jj,R.drawable.kk};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.programming_languages);
        s2 = getResources().getStringArray(R.array.description);

        MyAdapter myAdapter = new MyAdapter(this, s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        edText= findViewById(R.id.edText);
        buttonsave= findViewById(R.id.buttonload);
        buttonload= findViewById(R.id.buttonload);
    }
    public void OnClick(View v) {
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



}



    private void saveText() {
        sPref=getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(Saved_Text,edText.getText().toString());
        ed.commit();
        Toast.makeText(Activity_recyclerView.this,"Text Saved",Toast.LENGTH_SHORT).show();
    }
    private void loadText() {
        sPref=getPreferences(MODE_PRIVATE);
        String saveText = sPref.getString(Saved_Text,"");
        edText.setText((saveText));
        Toast.makeText(Activity_recyclerView.this,"Text Loaded",Toast.LENGTH_SHORT).show();

    }
}
