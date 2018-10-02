package com.learnandroid.manojkumar.taporholdcounter;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button tapButton;
    private TextView counterTextView;
    private Handler handler = new Handler();
    private boolean longPressFlag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initailize the views
        tapButton = (Button)findViewById(R.id.tap_button);
        counterTextView = (TextView) findViewById(R.id.counter_display);

        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });

        tapButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                longPressFlag = true;
                handler.post(new ContinuousUpdate());
                return false;
            }
        });

        tapButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP && longPressFlag) {
                    longPressFlag = false;
                }
                return false;
            }
        });
    }

    class ContinuousUpdate implements Runnable {
        @Override
        public void run() {
            if(longPressFlag) {
                increment();
                handler.postDelayed(new ContinuousUpdate(), 50);
            }
        }
    }

    private void increment() {
        int value = Integer.parseInt(String.valueOf(counterTextView.getText()));
        value = value +1;
        counterTextView.setText(Integer.toString(value));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_reset:
                counterTextView.setText(Integer.toString(0));
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
