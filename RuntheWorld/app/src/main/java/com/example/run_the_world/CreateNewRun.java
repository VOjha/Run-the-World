package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class CreateNewRun extends AppCompatActivity implements View.OnClickListener{

    private Button toTrackingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_run);
        toTrackingButton = (Button)findViewById(R.id.done_create);
        toTrackingButton.setOnClickListener(this);

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
    }

    public void onClick(View v) {
        Intent toTracking = new Intent(this, DuringRun.class);
        toTracking.setAction(Intent.ACTION_VIEW);
        startActivity(toTracking);
    }

}
