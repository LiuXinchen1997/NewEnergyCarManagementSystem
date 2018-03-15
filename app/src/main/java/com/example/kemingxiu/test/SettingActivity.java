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
import android.widget.EditText;
import android.widget.Toast;

import com.nev.dao.AdminDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.Admin;

public class SettingActivity extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;

    private EditText et_adminName;
    private EditText et_adminAccount;
    private EditText et_adminPhone;

    private Button btn_modifypwd;
    private Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dbHelper = new DatabaseBuildHelper(this, "nev.db", null, 1);
        final SQLiteDatabase db = dbHelper.getWritableDatabase();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        final String adminNum = getIntent().getStringExtra("adminNum");
        Admin admin = AdminDao.getInstance().findByNum(db, adminNum);
        if (admin == null) {
            Toast.makeText(this, "请重新登录！", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
            startActivity(intent);
        }

        et_adminName = findViewById(R.id.editText_adminName);
        et_adminName.setText(admin.getAdminName());

        et_adminAccount = findViewById(R.id.editText_adminAccount);
        et_adminAccount.setText(admin.getAdminAccount());

        et_adminPhone = findViewById(R.id.editText_adminPhone);
        et_adminPhone.setText(admin.getAdminPhone());

        btn_confirm = findViewById(R.id.button_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Admin admin = new Admin();
                admin.setAdminName(et_adminName.getText().toString());
                admin.setAdminPhone(et_adminPhone.getText().toString());
                admin.setAdminAccount(et_adminAccount.getText().toString());
                admin.setAdminNum(adminNum);
                AdminDao.getInstance().updateAdmin(db, admin);
                Toast.makeText(SettingActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SettingActivity.this, PersonalInfoActivity.class);
                intent.putExtra("adminName", et_adminName.getText().toString());
                startActivity(intent);
            }
        });
    }

}
