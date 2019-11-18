package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DuringRun extends AppCompatActivity implements View.OnClickListener{
    private Button backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_run);
        backHome = (Button) findViewById(R.id.stop_run);
        backHome.setOnClickListener(this);
    }

    public void onClick(View v) {
        Intent toHome = new Intent(this, MainActivity.class);
        toHome.setAction(Intent.ACTION_VIEW);
        startActivity(toHome);
    }
}
