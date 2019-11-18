package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DuringRun extends AppCompatActivity {

    TextView input_time;
    TextView input_distance;
    long startTime = 0;
    long millis = 0;
    long accum = 0;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            millis = accum + System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            int miliseconds = (int) (millis % 1000 / 10);
            seconds = seconds % 60;

            input_time.setText(String.format("%d:%02d:%02d", minutes, seconds, miliseconds));

            timerHandler.postDelayed(this, 0);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_run);

        input_time = (TextView) findViewById(R.id.input_time);
        input_distance = (TextView) findViewById(R.id.input_distance);

        //timer
        Button b = (Button) findViewById(R.id.toggle);
        b.setText("start");
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals("pause")) {
                    accum = millis;
                    millis = 0;
                    timerHandler.removeCallbacks(timerRunnable);
                    b.setText("start");
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    b.setText("pause");
                }
            }
        });

        //submit data
        Button btn = (Button) findViewById(R.id.done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String distance_raw = input_distance.getText().toString();
                String time_raw = input_time.getText().toString();

                String delims = "[ ]";
                String distance = distance_raw.split(delims)[0];

                delims = "[:]";
                String min = time_raw.split(delims)[0];
                String sec = time_raw.split(delims)[1];

                Intent intent = new Intent(DuringRun.this, summaryActivity.class);
                intent.putExtra("distance", distance);
                intent.putExtra("min", min);
                intent.putExtra("sec", sec);
                startActivity(intent);
            }
        });
    }
}
