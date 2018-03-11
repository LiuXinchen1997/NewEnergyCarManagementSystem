package com.example.kemingxiu.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CarList extends AppCompatActivity {
    private String[] data={"皖A XN000","皖A XN001","皖A XN002","皖A XN003","皖A XN004","皖A XN005","皖A XN006","皖A XN007","皖A XN008","皖A XN009","皖A XN010","皖A XN011","皖A XN012","皖A XN013","皖A XN014","皖A XN015","皖A XN016","皖A XN017","皖A XN018","皖A XN019"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CarList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CarList.this,Information.class);
                startActivity(intent);
            }
        });
    }
}
