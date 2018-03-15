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
import com.nev.service.AdminService;

public class ModifyPasswordActivity extends AppCompatActivity {
    private DatabaseBuildHelper dbHelper;

    private EditText et_oldpwd;
    private EditText et_newpwd;
    private EditText et_newpwd2;
    private Button btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);
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

        et_oldpwd = findViewById(R.id.editText_oldpwd);
        et_newpwd = findViewById(R.id.editText_newpwd);
        et_newpwd2 = findViewById(R.id.editText_newpwd2);

        btn_confirm = findViewById(R.id.button_confirm);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oldPwd = et_oldpwd.getText().toString();
                String newPwd = et_newpwd.getText().toString();
                String newPwd2 = et_newpwd2.getText().toString();

                if (!newPwd.equals(newPwd2)) {
                    Toast.makeText(ModifyPasswordActivity.this, "两次密码输入不相同，请重试！", Toast.LENGTH_SHORT).show();
                    return;
                }

                String adminNum = getIntent().getStringExtra("adminNum");
                if (isEmpty(adminNum)) {
                    Toast.makeText(ModifyPasswordActivity.this, "请重新登录！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ModifyPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                Admin admin = AdminDao.getInstance().findByNum(db, adminNum);
                if (admin == null) {
                    Toast.makeText(ModifyPasswordActivity.this, "请重新登录！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ModifyPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                if (!admin.getAdminPass().equals(oldPwd)) {
                    Toast.makeText(ModifyPasswordActivity.this, "输入原密码不正确！", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (AdminService.modifyPassword(db, adminNum, newPwd)) {
                    Toast.makeText(ModifyPasswordActivity.this, "修改成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ModifyPasswordActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ModifyPasswordActivity.this, "修改失败！", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isEmpty(String str) {
                if (str == null || str.length() == 0) {
                    return true;
                }

                return false;
            }
        });
    }

}
