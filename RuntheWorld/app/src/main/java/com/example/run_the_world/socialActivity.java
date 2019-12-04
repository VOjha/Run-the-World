package com.example.run_the_world;

import androidx.annotation.NonNull;
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
import android.view.MenuItem;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class socialActivity extends AppCompatActivity {
    private BottomNavigationView bottomNav;

    private TextView text;
    private TextView friendName;
    private ListView myList;
    private List<String> listValues;
    private Button inviteButton;
    Button showPopupBtn, closePopupBtn1, closePopupBtn2;
    PopupWindow popupWindow;
    LinearLayout linearLayout1;

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

        // invited pop up after 5s
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        //instantiate the popup.xml layout file
                        LayoutInflater layoutInflater = (LayoutInflater) socialActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        View customView = layoutInflater.inflate(R.layout.invite_popup,null);

                        closePopupBtn1 = (Button) customView.findViewById(R.id.closePopupBtn1);
                        closePopupBtn2 = (Button) customView.findViewById(R.id.closePopupBtn2);

                        //instantiate popup window
                        popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

                        //display the popup window
                        popupWindow.showAtLocation(linearLayout1, Gravity.CENTER, 0, 0);

                        //close the popup window on button click
                        closePopupBtn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow.dismiss();
                            }
                        });
                        //close the popup window on button click
                        closePopupBtn1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow.dismiss();
                            }
                        });
                    }
                },
                5000);

        // Stuff for bottom nav bar
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        MenuItem socialNav = bottomNav.getMenu().findItem(R.id.social_nav);
        socialNav.setChecked(true);

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

}
