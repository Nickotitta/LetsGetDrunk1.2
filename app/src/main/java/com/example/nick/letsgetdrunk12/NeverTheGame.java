package com.example.nick.letsgetdrunk12;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.nick.letsgetdrunk12.DB.DbHelperList;

import java.util.ArrayList;

public class NeverTheGame extends AppCompatActivity {


    int oldValue;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_never_the_game);
        changeTextOnce();
         changeTextViewValue();

    }
    private void changeTextViewValue() {
        final String[] neverTasks = {
              /*  "Jag har aldrig kollat på anime.",
                "Jag har aldrig stalkat någon på facebook.",
                "Jag har aldrig svimmat.",
                "Jag har aldrig kollat på Disney Channel.",
                "Jag har aldrig varit med på en fest och tänkt för mig själv'Jag är omringad av idioter'.",
                "Jag har aldrig bett om en lönehörhöjning.",
                "Jag har aldrig argumenterat med någon anonym person på internet.",
                "Jag har aldrig försökt ljuga för någon och det gick åt helvete.",
                "Jag har aldrig trott på gud eller nåt liknade."*/};
        final TextView changeText = (TextView) findViewById(R.id.neverText);
        Button changeTextButton = (Button) findViewById(R.id.neverButton);
        changeText.startAnimation(AnimationUtils.loadAnimation(NeverTheGame.this, android.R.anim.slide_in_left));

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * neverTasks.length);
                if(random == oldValue){
                    random = (int) (Math.random() * neverTasks.length);
                }
                changeText.setText(neverTasks[random]);
                oldValue = random;
            }
        });
    };
    private void changeTextOnce(){
        final TextView changeText = (TextView) findViewById(R.id.neverText);
        Button changeTextButton = (Button)findViewById(R.id.neverButton);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText.setText("Go hard!");
            }
        });
    }
}