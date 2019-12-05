package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InputRunData extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_run_data);

        final Intent summaryIntent = new Intent(this, summaryActivity.class);

        Button btn = findViewById(R.id.done_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText input_date = (EditText) findViewById(R.id.input_date);
                String date = input_date.getText().toString();

                final EditText input_distance = (EditText) findViewById(R.id.input_distance);
                String distance = input_distance.getText().toString();

                final EditText input_time = (EditText) findViewById(R.id.input_time);
                String time = input_time.getText().toString();

                summaryIntent.putExtra("date", date);
                summaryIntent.putExtra("distance", distance);
                summaryIntent.putExtra("min", time);
                summaryIntent.putExtra("sec", "0");
                startActivity(summaryIntent);
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
