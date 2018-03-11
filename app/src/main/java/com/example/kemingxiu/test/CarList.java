package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nev.dao.CarDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.CarInfo;

import java.util.LinkedList;
import java.util.List;

public class CarList extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();
    public static List<CarInfo> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_list);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String carTeamNum = getIntent().getStringExtra("carTeamNum");
        cars = CarDao.findByCarTeam(db, carTeamNum);
        for (CarInfo car : cars) {
            data.add("皖"+car.getCarBrand());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(CarList.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CarList.this,Information.class);
                intent.putExtra("carNum", cars.get(position).getCarNum());
                startActivity(intent);
            }
        });
    }
}
