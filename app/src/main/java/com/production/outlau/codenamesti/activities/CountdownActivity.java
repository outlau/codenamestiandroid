package com.production.outlau.codenamesti.activities;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.production.outlau.codenamesti.R;

public class CountdownActivity extends AppCompatActivity {

    CountDownTimer countDownTimer;
    TextView timerText;
    long startMillis;
    long endMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        timerText = findViewById(R.id.timer);

        startMillis = System.currentTimeMillis();
        endMillis = 1550790000000L;

        //24*60*60 * 1001

        countDownTimer = new CountDownTimer(endMillis - startMillis, 1000) {
            public void onTick(long millisUntilFinished) {
                timerText.setText(formatSeconds(millisUntilFinished));
            }

            public void onFinish() {
                timerText.setText("Done !");
            }
        };
        countDownTimer.start();
    }

    public static String formatSeconds(long timeInMillisSeconds) {
        int timeInSeconds = (int) timeInMillisSeconds / 1000;

        int days = timeInSeconds / 86400;
        int hours = timeInSeconds / 3600;
        int secondsLeft = timeInSeconds - hours * 3600;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String formattedTime = "";

        if (days > 1) {
            formattedTime += days + " days ";
        } else if (days > 0) {
            formattedTime += days + " day ";
        }

        if (hours % 24 == 1) {
            formattedTime += hours % 24 + " hour ";
        } else {
            formattedTime += hours % 24 + " hours ";
        }

        if (minutes == 1) {
            formattedTime += minutes + " minute ";
        } else {
            formattedTime += minutes + " minutes ";
        }

        if (seconds == 1) {
            formattedTime += seconds + " second ";
        } else {
            formattedTime += seconds + " seconds ";
        }
        return formattedTime;
    }
}
