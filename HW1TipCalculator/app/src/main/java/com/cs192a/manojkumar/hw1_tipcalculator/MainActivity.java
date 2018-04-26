package com.cs192a.manojkumar.hw1_tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekBarValue;
    private EditText inputTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inititalize the UI in the xml
        initialize();

        // Seek bar change event handler
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // Update the text value with seekbar change
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue.setText("("+String.valueOf(progress)+")%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }


    protected void initialize() {
        seekBar = (SeekBar)findViewById(R.id.percentage_seekbar);
        seekBar.setProgress(0);
        seekBar.incrementProgressBy(1);
        seekBar.setMax(100);

        inputTotal = (EditText)findViewById(R.id.input_text);
        seekBarValue = (TextView)findViewById(R.id.seekbar_value);
    }

}
