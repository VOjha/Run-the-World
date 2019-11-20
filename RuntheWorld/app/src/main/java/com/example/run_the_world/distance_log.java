package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class distance_log extends AppCompatActivity {
    private BottomNavigationView bottomNav;
    private TextView totalRun;
    private TextView numDays;
    private TextView timeMinutes;
    private TextView maxRun;
    private TextView virtualDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_log);

        int defaultNumDays = 11;
        int defaultTotalDist = 304;
        int defaultMinutes = 88;
        int defaultMaxRun = 12;
        int defaultVirtual = 1049;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int minutes = Integer.parseInt(extras.getString("MINUTES"));
            int seconds = Integer.parseInt(extras.getString("SECONDS"));
            int distance = (int) Double.parseDouble(extras.getString("DISTANCE"));

            defaultNumDays += 1;
            defaultTotalDist += distance;
            defaultMinutes += minutes;
            defaultMaxRun = distance;
            defaultVirtual += distance*4;
        }

        totalRun = (TextView) findViewById(R.id.total_run);
        numDays = (TextView) findViewById(R.id.num_days);
        timeMinutes = (TextView) findViewById(R.id.time_min);
        maxRun = (TextView) findViewById(R.id.longest_run);
        virtualDistance = (TextView) findViewById(R.id.virtual_distance);

        totalRun.setText(Integer.toString(defaultTotalDist) + " miles");
        numDays.setText(Integer.toString(defaultNumDays));
        timeMinutes.setText(Integer.toString(defaultMinutes) + " min");
        maxRun.setText(Integer.toString(defaultMaxRun) + " miles");
        virtualDistance.setText(Integer.toString(defaultVirtual) + " miles");

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
