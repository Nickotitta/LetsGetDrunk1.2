package com.example.nick.letsgetdrunk12;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class gamesWithTalks extends AppCompatActivity {

    private ImageButton iveNever;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_with_talks);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        iveNever = (ImageButton)findViewById(R.id.iveNeverButton);
        iveNever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(gamesWithTalks.this, IveNever.class);
                startActivity(go);
            }

        });
    }
}
