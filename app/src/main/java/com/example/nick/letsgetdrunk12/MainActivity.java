package com.example.nick.letsgetdrunk12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private ImageButton gamesWithCardsButton;
    private ImageButton gamesWithTalksButton;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        gamesWithCardsButton = (ImageButton)findViewById(R.id.buttonToCardGames);
        gamesWithCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity.this, RingOfFire.gamesWithCards.class);
                startActivity(go);
            }


        });
        gamesWithTalksButton = (ImageButton)findViewById(R.id.buttonToTalkGames);
        gamesWithTalksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go1 = new Intent(MainActivity.this, gamesWithTalks.class);
                startActivity(go1);

            }
        });

    }

    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}
