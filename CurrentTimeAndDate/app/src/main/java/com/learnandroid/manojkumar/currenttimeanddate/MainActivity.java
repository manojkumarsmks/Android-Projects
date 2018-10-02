package com.learnandroid.manojkumar.currenttimeanddate;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView dateTime;
    private Button refreshButton;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateTime = (TextView)findViewById(R.id.actual_date_time);
        refreshButton = (Button)findViewById(R.id.refresh_button);
        getCurrentTimeDate();

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentTimeDate();
            }
        });

    }


    private void getCurrentTimeDate() {
        DateFormat df = new SimpleDateFormat("dd:MM:yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        dateTime.setText(date);
    }
}
