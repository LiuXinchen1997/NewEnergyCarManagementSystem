package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nev.dao.BatteryDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.dao.DriverDao;
import com.nev.domain.Battery;
import com.nev.domain.DriverInfo;

import java.util.LinkedList;
import java.util.List;

public class BatteryList extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        final List<Battery> batteries = BatteryDao.getInstance().findAll(db);
        for (Battery battery : batteries) {
            data.add("电池编号："+battery.getBatteryNum());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BatteryList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BatteryList.this, BatteryInformation.class);
                intent.putExtra("batteryNum", batteries.get(position).getBatteryNum());
                startActivity(intent);
            }
        });
    }
}
