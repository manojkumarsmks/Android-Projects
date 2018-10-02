package com.lambdaschools.manojkumar.rainbow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button red, orange, yellow, green, blue, indigo, violet;
    LinearLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
            }
        });


        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.YELLOW);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.GREEN);
            }
        });


        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.BLUE);
            }
        });

        indigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.parseColor("#4B0082"));
            }
        });

        violet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundColor(Color.parseColor("#9400D3"));
            }
        });
    }

    private void initialize() {
        red = (Button)findViewById(R.id.red);
        orange = (Button)findViewById(R.id.orange);
        yellow = (Button)findViewById(R.id.yellow);
        green = (Button)findViewById(R.id.green);
        blue = (Button)findViewById(R.id.blue);
        indigo = (Button)findViewById(R.id.indigo);
        violet = (Button)findViewById(R.id.violet);
        background = (LinearLayout)findViewById(R.id.background);
    }
}
