package com.learnandroid.manojkumar.tapcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button tapButton;
    TextView counterTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initailize the views
        tapButton = (Button)findViewById(R.id.tap_button);
        counterTextView = (TextView) findViewById(R.id.counter_display);

        // Button Listener
        tapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = Integer.parseInt(counterTextView.getText().toString());
                Log.d("TGG", String.valueOf(current));
                current = current+1;
                counterTextView.setText(Integer.toString(current));
            }
        });
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
