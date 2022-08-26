package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class ScrollActivity extends AppCompatActivity {

    private ScrollView scrollView;

    private Button buttonScrollUp;
    private Button buttonScrollDown;

    public static final int SCROLL_DELTA = 15; // Pixel.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        this.scrollView = (ScrollView) this.findViewById(R.id.ScrollView);

        this.buttonScrollUp = (Button) this.findViewById(R.id.button2);
        this.buttonScrollDown = (Button) this.findViewById(R.id.button3);

        this.buttonScrollUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollUp();
            }
        });

        this.buttonScrollDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doScrollDown();
            }
        });
    }
    private void doScrollUp() {

        int x = this.scrollView.getScrollX();
        int y = this.scrollView.getScrollY();

        if(y - SCROLL_DELTA >= 0) {
            this.scrollView.scrollTo(x, y-SCROLL_DELTA);
        }

    }

    private void doScrollDown() {
        int maxAmount = scrollView.getMaxScrollAmount();

        int x = this.scrollView.getScrollX();
        int y = this.scrollView.getScrollY();

        if(y + SCROLL_DELTA <= maxAmount) {
            this.scrollView.scrollTo(x, y + SCROLL_DELTA);
        }
    }
}