package com.webviewnewone.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showtext;
    Button Start, Stop, Hold;
    int seconds = 0;
    boolean running;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showtext = findViewById(R.id.showtext);
        Start = findViewById(R.id.Startbtn);
        Stop = findViewById(R.id.Stopbtn);
        Hold = findViewById(R.id.Holdbtn);

        handler = new Handler();

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startTimer();
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
            }
        });

        Hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holdTimer();
            }
        });
    }

    private void startTimer() {
        running = true;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                    int hours = seconds / 3600;
                    int minutes = (seconds % 3600) / 60;
                    int secs = seconds % 60;

                    String time = String.format("%02d:%02d:%02d", hours, minutes, secs);
                    showtext.setText(time);
                    startTimer(); // Continue updating the timer
                }
            }
        }, 1000);
    }

    private void stopTimer() {
        running = false;
    }

    private void holdTimer() {
        running = false;
    }
}
