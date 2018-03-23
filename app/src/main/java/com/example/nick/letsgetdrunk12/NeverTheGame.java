package com.example.nick.letsgetdrunk12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class NeverTheGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_never_the_game);

        final TextView textOne = (TextView) findViewById(R.id.neverText);
        Button pushMe = (Button)findViewById(R.id.neverButton);

        final String [] neverTasks = {
                "Jag har aldrig kollat på anime.",
                "Jag har aldrig stalkat någon på facebook.",
                "Jag har aldrig svimmat.",
                "Jag har aldrig kollat på Disney Channel.",
                "Jag har aldrig varit med på en fest och tänkt för mig själv'Jag är omringad av idioter'.",
                "Jag har aldrig bett om en lönehörhöjning.",
                "Jag har aldrig argumenterat med någon anonym person på internet.",
                "Jag har aldrig försökt ljuga för någon och det gick åt helvete.",
                "jag har aldrig trott på gud eller nåt liknade."};

        pushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int randomText = (int)(Math.random() * 9);
                textOne.setText(neverTasks[randomText]);
                textOne.startAnimation(AnimationUtils.loadAnimation(NeverTheGame.this, android.R.anim.fade_in));
            }

        });

    }
}
