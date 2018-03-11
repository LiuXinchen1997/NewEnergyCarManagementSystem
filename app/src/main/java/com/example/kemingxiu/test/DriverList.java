package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nev.dao.DatabaseBuildHelper;
import com.nev.dao.DriverDao;
import com.nev.domain.DriverInfo;

import java.util.LinkedList;
import java.util.List;

public class DriverList extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        final List<DriverInfo> drivers = DriverDao.getInstance().findAll(db);
        for (DriverInfo driver : drivers) {
            data.add("司机编号："+driver.getDriverNum()+"   姓名："+driver.getDriverName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(DriverList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DriverList.this,personInformation.class);
                intent.putExtra("driverNum", drivers.get(position).getDriverName());
                startActivity(intent);
            }
        });
    }
}
