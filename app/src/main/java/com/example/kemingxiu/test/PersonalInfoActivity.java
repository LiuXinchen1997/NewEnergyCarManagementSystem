package com.example.kemingxiu.test;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.nev.dao.AdminDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.Admin;

public class PersonalInfoActivity extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
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

        Button exitButton = (Button) findViewById(R.id.button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalInfoActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Admin admin = AdminDao.getInstance().findByName(db, getIntent().getStringExtra("adminName"));
        if (admin == null || isEmpty(getIntent().getStringExtra("adminName"))) {
            Toast.makeText(this, "请重新登录！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PersonalInfoActivity.this, LoginActivity.class);
            startActivity(intent);
        }



        TextView adminName_tv = findViewById(R.id.adminName_textview);
        adminName_tv.setText("用户名："+admin.getAdminName());
        adminName_tv.setTextSize(20);

        TextView adminAccount_tv = findViewById(R.id.adminAccount_textview);
        adminAccount_tv.setText("个人账号："+admin.getAdminAccount());
        adminAccount_tv.setTextSize(20);

        TextView gender_tv = findViewById(R.id.gender_textview);
        gender_tv.setText("性别：男");
        gender_tv.setTextSize(20);

        TextView age_tv = findViewById(R.id.age_textview);
        age_tv.setText("年龄：20");
        age_tv.setTextSize(20);

        TextView adminNum_tv = findViewById(R.id.adminNum_textview);
        adminNum_tv.setText("工号："+admin.getAdminNum());
        adminNum_tv.setTextSize(20);

        TextView adminPhone_tv = findViewById(R.id.adminPhone_textview);
        adminPhone_tv.setText("联系电话："+admin.getAdminPhone());
        adminPhone_tv.setTextSize(20);
    }

    private boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        return false;
    }

}
