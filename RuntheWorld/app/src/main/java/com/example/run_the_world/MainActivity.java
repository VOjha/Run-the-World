package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button enterRunButton;
    private Button createTripButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterRunButton = (Button) findViewById(R.id.enter_run);
        createTripButton = findViewById(R.id.create_trip);
        createTripButton.setOnClickListener(this);
        enterRunButton.setOnClickListener(this);

        Button btn = (Button)findViewById(R.id.social);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, socialActivity.class));
            }
        });

        Button btn2 = (Button)findViewById(R.id.DuringRun);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DuringRun.class));
            }
        });
    }

    public void onClick(View v) {
        if(v.getId() == R.id.enter_run){
            Intent enterRunIntent = new Intent(this, InputRunData.class);
            enterRunIntent.setAction(Intent.ACTION_VIEW);
            startActivity(enterRunIntent);
        } else {
            Intent createTripIntent = new Intent(this,CreateNewRun.class);
            createTripIntent.setAction(Intent.ACTION_VIEW);
            startActivity(createTripIntent);
        }
    }
}
