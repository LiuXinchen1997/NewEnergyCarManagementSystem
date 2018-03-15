package com.nev.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nev.domain.Admin;

/**
 * Created by Administrator on 2018/3/10.
 */

public class AdminDao {
    private static final String TAG = "AdminDao";
    private static AdminDao dao = new AdminDao();

    private AdminDao() {}

    public static AdminDao getInstance() {
        return dao;
    }

    private static final String TABLE = "adminInfo";

    public static Admin findByNameAndPwd(SQLiteDatabase db, String name, String password) {
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

    public static Admin findByName(SQLiteDatabase db, String name) {
        Admin admin = null;
        Cursor cursor = db.query(TABLE, null, "adminName = ?", new String[] {name}, null, null, null);

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

    public static Admin findByNum(SQLiteDatabase db, String adminNum) {
        Admin admin = null;
        Cursor cursor = db.query(TABLE, null, "adminNum = ?", new String[] {adminNum}, null, null, null);

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

    public static void updateAdmin(SQLiteDatabase db, Admin admin) {
        ContentValues values = new ContentValues();
        values.put("adminName", admin.getAdminName());
        values.put("adminPhone", admin.getAdminPhone());
        values.put("adminAccount", admin.getAdminAccount());

        db.update(TABLE, values, "adminNum = ?", new String[] { admin.getAdminNum() });
        Log.e(TAG, "updateAdmin: !!!");
    }
}
