package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.Admin;

/**
 * Created by Administrator on 2018/3/10.
 */

public class AdminDao {
    private static AdminDao dao = new AdminDao();

    private AdminDao() {}

    public static AdminDao getInstance() {
        return dao;
    }

    private static final String TABLE = "adminInfo";

    public static Admin findByName(SQLiteDatabase db, String name, String password) {
        Admin admin = null;
        Cursor cursor = db.query(TABLE, null, "adminName = ? and adminPass = ?", new String[] {name, password}, null, null, null);
        if (cursor.moveToFirst()) {
            admin = new Admin();
            admin.setAdminAccount(cursor.getString(cursor.getColumnIndex("adminAccount")));
            admin.setAdminId(cursor.getInt(cursor.getColumnIndex("adminId")));
            admin.setAdminName(cursor.getString(cursor.getColumnIndex("adminName")));
            admin.setAdminNum(cursor.getString(cursor.getColumnIndex("adminNum")));
            admin.setAdminPass(cursor.getString(cursor.getColumnIndex("adminPass")));
            admin.setAdminPhone(cursor.getString(cursor.getColumnIndex("adminPhone")));
        }
        cursor.close();

        return admin;
    }
}
