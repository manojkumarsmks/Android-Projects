package com.learnandroid.manojkumar.passingdatetoanotheracitivty;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    TextView ouputTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Second Screen");
        setContentView(R.layout.activity_second);
        ouputTextView = (TextView)findViewById(R.id.output_textview);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String output = extras.getString("Input_value");
            ouputTextView.setText(output);
        }
        else {
            ouputTextView.setText("Its all empty");
        }
    }
}
