package com.example.kemingxiu.test;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nev.dao.DatabaseBuildHelper;
import com.nev.dao.DriverDao;
import com.nev.domain.Driver;

public class CarActivity extends AppCompatActivity {
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
                Driver d = new Driver(1, "a","b", "c","d",2,"e","f");
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                DriverDao.getInstance().insertARecord(d, db);
                Toast.makeText(CarActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
