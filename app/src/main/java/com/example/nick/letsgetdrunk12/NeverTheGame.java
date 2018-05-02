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

    public TextSwitcher textSwitcher;
    private  int stringIndex =0;
    private TextView textView;
    ArrayAdapter<String> mAdapter;
    DbHelperList dbHelper;
    private String[] neverTasks = {
            "Jag har aldrig kollat på anime.",
            "Jag har aldrig stalkat någon på facebook.",
            "Jag har aldrig svimmat.",
            "Jag har aldrig kollat på Disney Channel.",
            "Jag har aldrig varit med på en fest och tänkt för mig själv'Jag är omringad av idioter'.",
            "Jag har aldrig bett om en lönehörhöjning.",
            "Jag har aldrig argumenterat med någon anonym person på internet.",
            "Jag har aldrig försökt ljuga för någon och det gick åt helvete.",
            "Jag har aldrig trott på gud eller nåt liknade."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_never_the_game);
        textSwitcher = (TextSwitcher) findViewById(R.id.neverText);
        Button pushMe = (Button) findViewById(R.id.neverButton);


        pushMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(stringIndex == neverTasks.length-1){
                    stringIndex = 0;
                    textSwitcher.setText(neverTasks[stringIndex]);
                }else {
                    textSwitcher.setText(neverTasks[++stringIndex]);
                }
            }
        });
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView = new TextView(NeverTheGame.this);
                textView.setTextColor(Color.BLACK);
                textView.setTextSize(40);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);
                return textView;
            }
        });
        textSwitcher.setText(neverTasks[stringIndex]);
    }

}




