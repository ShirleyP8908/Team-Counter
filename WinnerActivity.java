package com.example.teamcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    private TextView winningTeam;
    private TextView dialouge_box;

    private Button call_butt;
    private Button map_butt;
    private Button msg_butt;

    private String winning_Team_Dio_Box = "The winning team is:";

    private String dialouge = "Dialouge";
    private int point_diff = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winningTeam = findViewById(R.id.Winning_Team);
        dialouge_box = findViewById(R.id.dialouge);

        call_butt = findViewById(R.id.Call_Button);
        map_butt = findViewById(R.id.map_Button);
        msg_butt = findViewById(R.id.Text_Button);

        winning_Team_Dio_Box = getIntent().getStringExtra(winning_Team_Dio_Box);
        dialouge = getIntent().getStringExtra(dialouge);

        winningTeam.setText(winning_Team_Dio_Box);
        dialouge_box.setText(dialouge);



        //Implicit intent//
        call_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_DIAL);
                Uri uri_call = Uri.parse("tel:3475205312");
                call.setData(uri_call);
                    startActivity(call);

            }
        });

       msg_butt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent msg = new Intent(Intent.ACTION_SEND);
               msg.setType("text/plain");
               msg.putExtra(Intent.EXTRA_TEXT, dialouge);
               startActivity(Intent.createChooser(msg, "Send via"));
           }
       });

        map_butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Uri uri_map = Uri.parse("geo:0,0?q=basketball arena near me");
                Intent map = new Intent(Intent.ACTION_VIEW, uri_map);
                map.setPackage("com.google.android.apps.maps");
                    startActivity(map);
            }
        });

    }

}