package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class achievements extends AppCompatActivity implements View.OnClickListener{
    private ImageButton milestoneButton;
    private ImageButton travelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);

        milestoneButton = (ImageButton) findViewById(R.id.milestone);
        travelButton = (ImageButton) findViewById(R.id.travel_book);

        milestoneButton.setOnClickListener(this);
        travelButton.setOnClickListener(this);
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
