package com.example.kemingxiu.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Car extends AppCompatActivity {
    private String[] data={"车队一","车队二","车队三","车队四","车队五","车队六","车队七","车队八","车队九","车队十"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Car.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Car.this,CarList.class);
                startActivity(intent);
            }
        });

    }

}
