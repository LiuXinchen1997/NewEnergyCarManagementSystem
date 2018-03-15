package com.nev.service;

import android.database.sqlite.SQLiteDatabase;

import com.example.kemingxiu.test.LoginActivity;
import com.nev.dao.AdminDao;
import com.nev.dao.DatabaseBuildHelper;
import com.nev.domain.Admin;

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
        if (null == dao.findByNameAndPwd(db, name, password)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean modifyPassword(SQLiteDatabase db, String adminNum, String newPwd) {
        Admin admin = AdminDao.getInstance().findByNum(db, adminNum);
        if (admin == null) {
            return false;
        }

        AdminDao.getInstance().updatePassword(db, adminNum, newPwd);
        return true;
    }
}
