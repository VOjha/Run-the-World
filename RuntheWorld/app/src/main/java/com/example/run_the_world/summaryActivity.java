package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class summaryActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();

        final String min = intent.getStringExtra("min");
        final String sec = intent.getStringExtra("sec");
        TextView timeView = (TextView)findViewById(R.id.input_time);
        timeView.setText("Total run time: " + min + " min " + sec + " sec");

        final String distance = intent.getStringExtra("distance");
        TextView distanceView = (TextView)findViewById(R.id.input_distance);
        distanceView.setText("Total run distance: " + distance + " miles");

        //update global
        Globals g = Globals.getInstance();
        if (Integer.parseInt(min) > 10){
            g.unlockParis();
        }

        Button btn = findViewById(R.id.Continue);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent distanceLogIntent = new Intent(summaryActivity.this, distance_log.class);
                distanceLogIntent.putExtra("MINUTES", min);
                distanceLogIntent.putExtra("SECONDS", sec);
                distanceLogIntent.putExtra("DISTANCE", distance);

                startActivity(distanceLogIntent);
            }
        });

        // Stuff for bottom nav bar
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        MenuItem homeNav = bottomNav.getMenu().findItem(R.id.home_nav);
        homeNav.setChecked(true);

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
