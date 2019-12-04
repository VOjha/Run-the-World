package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button createTripButton;
    private Button enterRunButton;
    private Button trackRunButton;
    private BottomNavigationView bottomNav;
    private LinearLayout tripInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createTripButton = (Button) findViewById(R.id.create_trip);
        enterRunButton = (Button) findViewById(R.id.enter_run);
        trackRunButton = (Button) findViewById(R.id.track_run);

        tripInfo = (LinearLayout) findViewById(R.id.trip_info);

        createTripButton.setOnClickListener(this);
        enterRunButton.setOnClickListener(this);
        trackRunButton.setOnClickListener(this);

        trackRunButton.setEnabled(false);

        Globals g = Globals.getInstance();
        boolean isRunCreated = g.isRunCreated();

        enterRunButton.setEnabled(isRunCreated);

        if (isRunCreated) {
            createTripButton.setText("Track Run");
        } else {
            tripInfo.setVisibility(View.GONE);
        }
        
        if (isRunCreated) trackRunButton.setEnabled(true);

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

    public void onClick(View v) {
        if (v.getId() == R.id.enter_run){
            Intent enterRunIntent = new Intent(this, InputRunData.class);
            enterRunIntent.setAction(Intent.ACTION_VIEW);
            startActivity(enterRunIntent);
        } else if (v.getId() == R.id.create_trip) {
            Intent createTripIntent = new Intent(this,CreateNewRun.class);
            createTripIntent.setAction(Intent.ACTION_VIEW);
            startActivity(createTripIntent);
        } else if (v.getId() == R.id.track_run) {
            Intent createTripIntent = new Intent(this,DuringRun.class);
            createTripIntent.setAction(Intent.ACTION_VIEW);
            startActivity(createTripIntent);
        }
    }
}
