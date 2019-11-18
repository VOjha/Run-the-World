package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class summaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intent = getIntent();

        String min = intent.getStringExtra("min");
        String sec = intent.getStringExtra("sec");
        TextView timeView = (TextView)findViewById(R.id.input_time);
        timeView.setText("Total run time: " + min + " min " + sec + " sec");

        String distance = intent.getStringExtra("distance");
        TextView distanceView = (TextView)findViewById(R.id.input_distance);
        distanceView.setText("Total run distance: " + distance + " miles");

        Button btn = findViewById(R.id.Continue);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(summaryActivity.this, distance_log.class));
            }
        });
    }

}
