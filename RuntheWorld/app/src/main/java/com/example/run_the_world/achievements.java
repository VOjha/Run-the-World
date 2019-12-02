package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class achievements extends AppCompatActivity implements View.OnClickListener{
    private ImageButton milestoneButton;
    private ImageButton travelButton;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        milestoneButton = (ImageButton) findViewById(R.id.milestone);
        travelButton = (ImageButton) findViewById(R.id.travel_book);

        milestoneButton.setOnClickListener(this);
        travelButton.setOnClickListener(this);

        // Stuff for bottom nav bar
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        MenuItem achievementsNav = bottomNav.getMenu().findItem(R.id.achievements_nav);
        achievementsNav.setChecked(true);

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

    public void onClick(View v) {
        if (v.getId() == R.id.milestone) {
            Intent milestoneIntent = new Intent(this, distance_log.class);
            milestoneIntent.setAction(Intent.ACTION_VIEW);

            startActivity(milestoneIntent);
        } else if (v.getId() == R.id.travel_book){
            Intent travelIntent = new Intent(this, TravelBookActivity.class);
            travelIntent.setAction(Intent.ACTION_VIEW);

            startActivity(travelIntent);
        }
    }
}
