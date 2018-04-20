package com.example.nick.letsgetdrunk12;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IveNever extends AppCompatActivity {

    ListView listView;
    private Button createAList;
    private Button howTo;
    ArrayAdapter<String> mAdapter;
    DbHelperList dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ive_never);


        listView = (ListView)findViewById(R.id.ListViewIveNever);
        dbhelper = new DbHelperList(this);
        loadTaskList();

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

    }
    private void loadTaskList() {
        ArrayList<String> taskList = dbhelper.getTaskList();
        if (mAdapter==null){
            mAdapter = new ArrayAdapter<String>(this,R.layout.createlinerow, R.id.lstTask_title, taskList);
            listView.setAdapter(mAdapter);
        }else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add,menu );

        Drawable icon = menu.getItem(0).getIcon();
        icon.mutate();
        icon.setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_title:
            final EditText taskEditeText = new EditText(this);
            AlertDialog dialog = new AlertDialog.Builder(this)
                    .setTitle("Add New Task")
                    .setMessage("What will you title be ?")
                    .setView(taskEditeText)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String task = String.valueOf(taskEditeText.getText());
                            dbhelper.insertNewTask(task);
                            loadTaskList();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .create();
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void deleteTask(View view){
        View parent = (View)view.getParent();
        TextView taskTextView = (TextView)findViewById(R.id.lstTask_title);
        String task = String.valueOf(taskTextView.getText());
        dbhelper.deleteTask(task);
        loadTaskList();
    }
}
