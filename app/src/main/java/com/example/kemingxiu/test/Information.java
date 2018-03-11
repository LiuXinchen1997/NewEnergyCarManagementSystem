package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.nev.dao.CarDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.CarInfo;

import java.util.LinkedList;
import java.util.List;

public class Information extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String carNum = getIntent().getStringExtra("carNum");
        CarInfo car = CarDao.getInstance().findByCarNum(db, carNum);

        data.add("车辆编号："+car.getCarNum()+"        车牌号码："+car.getCarBrand());
        data.add("载重："+car.getCarryingCapacity() + "        日期："+car.getDateManu());
        data.add("司机编号："+car.getDriverNum() + "       车队编号："+car.getMotorcadeNum());
        data.add("车辆位置 经度："+car.getCarLng() + "     纬度："+car.getCarLat());
        data.add("是否上锁："+ (car.isCarLock()?"是":"否"));
        data.add("是否警告："+ (car.isCarLock()?"是":"否"));
        data.add("是否超速："+ (car.isOverSpeed()?"是":"否"));
        data.add("是否超载："+ (car.isOverload()?"是":"否"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Information.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:17730226546"));
                startActivity(intent);
            }
        });

        Button Location = (Button) findViewById(R.id.location);
        Location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Information.this, Carposition.class);
                startActivity(intent);
            }
        });
    }

}
