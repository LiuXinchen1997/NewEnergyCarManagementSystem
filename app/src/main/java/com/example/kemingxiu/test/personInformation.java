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

import com.nev.dao.DatabaseBuildHelper;
import com.nev.dao.DriverDao;
import com.nev.domain.DriverInfo;

import java.util.LinkedList;
import java.util.List;

public class personInformation extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<String> data = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String driverNum = getIntent().getStringExtra("driverNum");
        List<DriverInfo> ds = DriverDao.getInstance().findBySelection(db, "driverNum=?", new String[] {driverNum});
        final DriverInfo driver = ds.get(0);

        data.add("司机编号："+driver.getDriverNum());
        data.add("司机姓名："+driver.getDriverName());
        data.add("车队编号："+driver.getMotorcadeNum());
        data.add("车辆编号："+driver.getCarNum());
        data.add("司机性别："+(driver.getDriverSex()==1?"男":"女"));
        data.add("联系电话："+driver.getDriverPhone());
        data.add("司机位置："+driver.getDriverPosition());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(personInformation.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+driver.getDriverPhone()));
                startActivity(intent);
            }
        });
    }
}
