/* Calculate the tip you pay at your hotel*/
package com.cs192a.manojkumar.hw1_tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView seekBarValue, tipValue, totalAmount;
    private EditText inputTotal;

    private static String TAG = "LOG_VALUE_IS";
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
               // Update the seekbar progress  on screen
                seekBarValue.setText("("+String.valueOf(progress)+")%");

                // calculate tip only if the total is entered
                if(!inputTotal.getText().toString().matches("")) {
                    float price = Float.parseFloat(inputTotal.getText().toString());
                    if (price > 0) {
                        tipCalculator(price, (float)progress);
                    }
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    // Calculate the tip and set the tip value
    protected  void tipCalculator(float price, float tipPercentage) {
        float tip = price * (tipPercentage / 100);
        tipValue.setText("$" + String.format("%.2f", tip));
        totalCalculator(price, tip);
    }

    // Calculate the total - > fine + tip
    protected void totalCalculator(float price, float tip) {
        totalAmount.setText("$"+String.format("%.2f", price +tip));
    }

    // Initialize the Views
    protected void initialize() {
        seekBar = (SeekBar)findViewById(R.id.percentage_seekbar);
        seekBar.setProgress(0);
        seekBar.incrementProgressBy(1);
        seekBar.setMax(100);

        inputTotal = (EditText)findViewById(R.id.input_text);
        seekBarValue = (TextView)findViewById(R.id.seekbar_value);
        tipValue = (TextView)findViewById(R.id.tip_value);
        totalAmount = (TextView)findViewById(R.id.total_amount);
    }
}
