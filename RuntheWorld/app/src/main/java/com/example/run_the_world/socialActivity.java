package com.example.run_the_world;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class socialActivity extends AppCompatActivity {

    private TextView text;
    private TextView friendName;
    private ListView myList;
    private List<String> listValues;
    private Button inviteButton;

    public class inviteListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            CharSequence text = "Invitation sent!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        myList = (ListView)findViewById(R.id.list);

        listValues = new ArrayList<String>();
        listValues.add("John");
        listValues.add("Amy");
        listValues.add("Kate");
        listValues.add("Adam");
        listValues.add("Kathy");

        // initiate the listadapter
        final ArrayAdapter<String> myAdapter = new ArrayAdapter <String>(this,
                R.layout.row_layout, R.id.listText, listValues);

        // assign the list adapter
        myList.setAdapter(myAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Snackbar.make(view, "Send invite?", Snackbar.LENGTH_LONG)
                        .setAction("send", new inviteListener())
                        .show();

            }
        });
    }

}
