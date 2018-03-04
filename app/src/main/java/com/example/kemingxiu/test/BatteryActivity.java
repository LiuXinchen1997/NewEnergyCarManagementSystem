package com.example.kemingxiu.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nev.utils.ListViewForScrollView;

public class BatteryActivity extends AppCompatActivity {

    private String[] data = {
            "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                BatteryActivity.this, android.R.layout.simple_list_item_1, data
        );
        ListView listView = findViewById(R.id.battery_list_view);
        listView.setAdapter(adapter);
    }
}
