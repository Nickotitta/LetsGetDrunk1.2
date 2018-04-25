package com.example.nick.letsgetdrunk12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.nick.letsgetdrunk12.R;
import com.example.nick.letsgetdrunk12.RingOfFire;

public class gamesWithCards extends AppCompatActivity {

    private ImageButton ringOfFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_with_cards);

        ringOfFire = (ImageButton)findViewById(R.id.ringOfFireButton);
        ringOfFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(gamesWithCards.this, RingOfFire.class);
                startActivity(go);
            }


        });

    }
}
