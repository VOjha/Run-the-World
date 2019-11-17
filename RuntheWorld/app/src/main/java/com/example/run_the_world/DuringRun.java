package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DuringRun extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_run);

        Button btn = findViewById(R.id.done);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText input_distance = (EditText) findViewById(R.id.input_distance);
                String distance = input_distance.getText().toString();

                final EditText input_time = (EditText) findViewById(R.id.input_time);
                String time = input_time.getText().toString();

                Intent intent = new Intent(DuringRun.this, summaryActivity.class);
                intent.putExtra("distance", distance);
                intent.putExtra("time", time);
                startActivity(intent);
            }
        });
    }
}
