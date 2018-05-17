package com.example.nick.letsgetdrunk12;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.nick.letsgetdrunk12.DB.DbHelperList;
import java.util.ArrayList;


public class NeverTheGame extends AppCompatActivity {


    int oldValue;
    DbHelperList dbHelper;
    private TextView neverTheText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHelper = new DbHelperList(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_never_the_game);
        changeTextOnce();
         changeTextViewValue();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
    private void changeTextViewValue() {
        neverTheText = (TextView)findViewById(R.id.IveNeverNever);
        ArrayList<String> taskList = dbHelper.getTaskList();
        final String[] neverTasks = taskList.toArray(new String[taskList.size()]);
        final TextView changeText = (TextView) findViewById(R.id.neverText);
        Button changeTextButton = (Button) findViewById(R.id.neverButton);
        changeText.startAnimation(AnimationUtils.loadAnimation(NeverTheGame.this, android.R.anim.slide_in_left));

        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neverTheText.setText("I've Never...");
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