package com.example.run_the_world;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CreateNewRun extends AppCompatActivity implements View.OnClickListener {
    private Button toTripButton;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_run);
        toTripButton = (Button)findViewById(R.id.done_create);
        toTripButton.setOnClickListener(this);

        /*Spinner spinner = (Spinner) findViewById(R.id.starting_point);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/

        Spinner spinnerDestination = (Spinner) findViewById(R.id.destinations);
        ArrayAdapter<CharSequence> adapterDestination = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapterDestination.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDestination.setAdapter(adapterDestination);

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
        Globals g = Globals.getInstance();
        g.createRun();

        Intent toTrip = new Intent(this, tripProgressActivity.class);
        toTrip.setAction(Intent.ACTION_VIEW);
        startActivity(toTrip);
    }

}
