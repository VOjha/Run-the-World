package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button enterRunButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterRunButton = (Button) findViewById(R.id.enter_run);

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
        Intent enterRunIntent = new Intent(this, InputRunData.class);
        enterRunIntent.setAction(Intent.ACTION_VIEW);

        startActivity(enterRunIntent);
    }
}
