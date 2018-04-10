package com.example.nick.letsgetdrunk12;

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

    EditText editText;
    Button addButton;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_alist);
        editText = (EditText) findViewById(R.id.editTitle);
        addButton = (Button) findViewById(R.id.addBtn);
        listView = (ListView)findViewById(R.id.listVIew);

        listItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.length() == 0 ){
                    addButton.setEnabled(false);
                    addButton.setEnabled(true);
                    Toast.makeText(CreateAList.this, "You didn´t write anything!", Toast.LENGTH_LONG).show();


                }else {
                    addButton.setEnabled(true);
                    listItems.add(editText.getText().toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position,
                                    long id) {
                Toast.makeText(CreateAList.this, "Clicked", Toast.LENGTH_LONG)
                        .show();
            }
        });
    }
}

