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
import android.widget.ListView;

import com.nev.dao.BatteryDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.Battery;

import java.util.LinkedList;
import java.util.List;

public class BatteryInformation extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery_information);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String batteryNum = getIntent().getStringExtra("batteryNum");
        Battery battery = BatteryDao.getInstance().findByBatteryNum(db, batteryNum);

        data.add("电池编号："+battery.getBatteryNum());
        data.add("电池品牌："+battery.getBatteryBrand());
        data.add("电池型号："+battery.getBatteryVersion());
        data.add("车辆编号："+battery.getCarNum());
        data.add("是否警告："+(battery.isWarning()?"是":"否"));
        data.add("是否在用："+(battery.isUse()?"是":"否"));
        data.add("是否失败："+(battery.isFailure()?"是":"否"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(BatteryInformation.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(""));
                startActivity(intent);
            }
        });
    }
}
