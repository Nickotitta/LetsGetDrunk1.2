package com.example.nick.letsgetdrunk12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateAList extends AppCompatActivity {

    EditText editTitle;
    EditText editLine;
    Button addButton;
    Button submbitButton;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alist);
        editLine = (EditText)findViewById(R.id.editList);
        addButton = (Button) findViewById(R.id.addBtn);
        submbitButton = (Button) findViewById(R.id.submitBtn);
        listView = (ListView)findViewById(R.id.lstTask);
        listItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);




        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editLine.length() == 0 ) {
                   /* addButton.setEnabled(false);
                    addButton.setEnabled(true);*/
                    editLine.setEnabled(false);
                    editLine.setEnabled(true);
                    Toast.makeText(CreateAList.this, "You didn´t write anything!", Toast.LENGTH_LONG).show();

                }else {
                    addButton.setEnabled(true);
                    listItems.add(editLine.getText().toString());
                    adapter.notifyDataSetChanged();
                    editLine.setText("");
                }

            }
        });

        submbitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go1 = new Intent(CreateAList.this, IveNever.class);
                startActivity(go1);
                Toast.makeText(CreateAList.this, "The list is added", Toast.LENGTH_LONG)
                        .show();
            }
        });


    }
}

