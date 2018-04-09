package com.example.nick.letsgetdrunk12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class IveNever extends AppCompatActivity {

    ListView listView;
    private Button createAList;
    private Button howTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ive_never);


        listView = (ListView)findViewById(R.id.ListViewIveNever);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(IveNever.this, android.R.layout.simple_list_item_1,
        getResources().getStringArray(R.array.talkLists));

        howTo = (Button)findViewById(R.id.iveNeverHowBtn);
        howTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent how = new Intent( IveNever.this, NeverWeb.class);
                startActivity(how);
            }
        });

        createAList = (Button)findViewById(R.id.createNewListBtn);
        createAList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent create = new Intent (IveNever.this, CreateAList.class);
                startActivity(create);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(IveNever.this, NeverTheGame.class);
                intent.putExtra("ListOfTheNeverGame", listView.getItemAtPosition(position).toString());
                startActivity(intent);

            }
        });
        listView.setAdapter(mAdapter);
    }
}
