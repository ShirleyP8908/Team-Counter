package com.example.teamcounter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    private int Denver_Nuggets = 0;
    private int Miami_Heat = 0;

    private Button Denver_Tally;
    private Button Miami_Tally;

    private TextView Denver_Score;
    private TextView Miami_Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle("Settings");

        FloatingActionButton fab = findViewById(R.id.fabby);



        fab.setOnClickListener((view)-> {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
                });




        Denver_Tally = findViewById(R.id.Denver_Button);
        Miami_Tally = findViewById(R.id.Heat_Button);

        Denver_Score = findViewById(R.id.Denver_Score_Tally);
        Miami_Score = findViewById(R.id.Miami_Score_Tally);

        if(savedInstanceState != null) {
            Denver_Nuggets = savedInstanceState.getInt("denverNuggetsScore");
            Miami_Heat = savedInstanceState.getInt("miamiHeatScore");
            Miami_Score.setText(String.valueOf(Miami_Heat));
            Denver_Score.setText(String.valueOf(Denver_Nuggets));
        }

        Denver_Tally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Denver_Nuggets++;
                Denver_Score.setText(String.valueOf(Denver_Nuggets));

                if(Denver_Nuggets == 5){
                    Log.d("MainActivty", "The winner is the Nuggets!");
                    openingWinnerActivity("The Nuggets", Denver_Nuggets - Miami_Heat);

                }
            }
        });

        Miami_Tally.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Miami_Heat++;
                Miami_Score.setText(String.valueOf(Miami_Heat));

                if(Miami_Heat == 5){
                    Log.d("MainActivty", "The winner is the Heat!");
                    openingWinnerActivity("The Heat", Miami_Heat - Denver_Nuggets);

                }
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("denverNuggetsScore", Denver_Nuggets);
        outState.putInt("miamiHeatScore", Miami_Heat);
    }
    
    public void openingWinnerActivity(String WinningTeam, int point_diff) {
        String dialouge;
        if(point_diff == 1){
            dialouge = WinningTeam + " won by:\n" + point_diff + " point!";
        }
        else{
            dialouge = WinningTeam + " won by:\n" + point_diff + " points!";
        }
        Intent intent = new Intent(this, WinnerActivity.class);
        intent.putExtra("The winning team is:", WinningTeam);
        intent.putExtra("Dialouge", dialouge);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
