package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.nev.dao.CarTeamDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.CarTeam;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;


public class Car extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;
    private List<CarTeam> carTeams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        carTeams = CarTeamDao.getInstance().findAll(db);
        List<String> data = new LinkedList<>();
        for (CarTeam ct : carTeams) {
            data.add("车队 "+ct.getMotorcadeNum());
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Car.this,android.R.layout.simple_list_item_1,data);
        final ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Car.this,CarList.class);
                String tmp_data = carTeams.get(position).getMotorcadeNum();
                intent.putExtra("carTeamNum", tmp_data);
                startActivity(intent);
            }
        });
    }
}
