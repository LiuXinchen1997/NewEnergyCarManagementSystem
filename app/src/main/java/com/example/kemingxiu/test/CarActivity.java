package com.example.kemingxiu.test;

import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nev.dao.DatabaseBuildHelper;
import com.nev.dao.DriverDao;
import com.nev.domain.Driver;

import java.util.LinkedList;
import java.util.List;

public class CarActivity extends AppCompatActivity {
    private static final String TAG = "CarActivity";
    private DatabaseBuildHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
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

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);

        Button button = findViewById(R.id.add_data_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 只是为了测试而使用的！
                Driver d = new Driver(1, "a","b", "c","d",2,"e","f");
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                // DriverDao.getInstance().insertARecord(d, db);

                List<Driver> list = DriverDao.getInstance().findBySelection(db, "driverId = ?", new String[] {"1"});
                for (Driver driver : list) {
                    Log.e(TAG, driver+"");
                }

                Toast.makeText(CarActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
