package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DuringRun extends AppCompatActivity {
    private BottomNavigationView bottomNav;

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
    protected void onCreate(Bundle savedInstanceState){
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

        // Stuff for bottom nav bar
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        final Intent socialIntent = new Intent(this, socialActivity.class);
        socialIntent.setAction(Intent.ACTION_VIEW);

        final Intent achievementsIntent = new Intent(this, achievements.class);
        achievementsIntent.setAction(Intent.ACTION_VIEW);

        final Intent settingsIntent = new Intent(this, SettingsActivity.class);
        settingsIntent.setAction(Intent.ACTION_VIEW);

        final Intent homeIntent = new Intent(this, MainActivity.class);
        homeIntent.setAction(Intent.ACTION_VIEW);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.social_nav:
                        startActivity(socialIntent);
                        break;
                    case R.id.achievements_nav:
                        startActivity(achievementsIntent);
                        break;
                    case R.id.settings_nav:
                        startActivity(settingsIntent);
                        break;
                    case R.id.home_nav:
                        startActivity(homeIntent);
                        break;
                }
                return true;
            }
        });
    }
}
