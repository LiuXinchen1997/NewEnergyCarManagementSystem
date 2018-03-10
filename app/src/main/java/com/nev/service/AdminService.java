package com.nev.service;

import android.database.sqlite.SQLiteDatabase;

import com.example.kemingxiu.test.LoginActivity;
import com.nev.dao.AdminDao;
import com.nev.dao.DatabaseBuildHelper;

/**
 * Created by Administrator on 2018/3/10.
 */

// 单例模式
public class AdminService {
    private AdminService() {}

    private static AdminService service = new AdminService();

    public static AdminService getInstance() {
        return service;
    }

    public static boolean login(SQLiteDatabase db, String name, String password) {
        AdminDao dao = AdminDao.getInstance();
        if (null == dao.findByName(db, name, password)) {
            return false;
        } else {
            return true;
        }
    }
}
