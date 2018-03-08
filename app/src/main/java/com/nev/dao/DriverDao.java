package com.nev.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.Driver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

// 单例模式
public class DriverDao {
    private static DriverDao dao = new DriverDao();
    private static final String TABLE = "driverInfo";
    private static final String WHERE_CLAUSE = "driverId = ?";

    private DriverDao() {}

    public static DriverDao getInstance() {
        return dao;
    }

    public static void insertARecord(Driver d, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("driverId", d.getDriverId());
        values.put("driverNum", d.getCarNum());
        values.put("motorcadeNum", d.getMotorcadeNum());
        values.put("carNum", d.getCarNum());
        values.put("driverName", d.getDriverName());
        values.put("driverSex", d.getDriverSex());
        values.put("driverPhone", d.getDriverPhone());
        values.put("driverPosition", d.getDriverPosition());

        db.insert(TABLE, null, values);
    }

    public static void insertRecords(List<Driver> ds, SQLiteDatabase db) {
        for (Driver d : ds) {
            ContentValues values = new ContentValues();
            values.put("driverId", d.getDriverId());
            values.put("driverNum", d.getCarNum());
            values.put("motorcadeNum", d.getMotorcadeNum());
            values.put("carNum", d.getCarNum());
            values.put("driverName", d.getDriverName());
            values.put("driverSex", d.getDriverSex());
            values.put("driverPhone", d.getDriverPhone());
            values.put("driverPosition", d.getDriverPosition());
            db.insert(TABLE, null, values);
        }
    }

    public static void updateARecord(Driver d, SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put("driverId", d.getDriverId());

        if (d.getCarNum() != null) {
            values.put("driverNum", d.getCarNum());
        }
        if (d.getMotorcadeNum() != null) {
            values.put("motorcadeNum", d.getMotorcadeNum());
        }
        if (d.getCarNum() != null) {
            values.put("carNum", d.getCarNum());
        }
        if (d.getDriverName() != null) {
            values.put("driverName", d.getDriverName());
        }
        values.put("driverSex", d.getDriverSex());

        if (d.getDriverPhone() != null) {
            values.put("driverPhone", d.getDriverPhone());
        }
        if (d.getDriverPosition() != null) {
            values.put("driverPosition", d.getDriverPosition());
        }

        db.update(TABLE, values, WHERE_CLAUSE, new String[] { d.getDriverId()+"" });
    }

    public static void deleteARecord(int id, SQLiteDatabase db) {
        db.delete(TABLE, WHERE_CLAUSE, new String[] { id+"" });
    }

    public static void deleteRecords(List<Integer> ids, SQLiteDatabase db) {
        for (Integer id : ids) {
            db.delete(TABLE, WHERE_CLAUSE, new String[] { id+"" });
        }
    }

    public static List<Driver> findAll(SQLiteDatabase db) {
        List<Driver> list = new LinkedList<>();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Driver d = new Driver();
                d.setDriverId(cursor.getInt(cursor.getColumnIndex("driverId")));
                d.setDriverPosition(cursor.getString(cursor.getColumnIndex("driverPosition")));
                d.setDriverPhone(cursor.getString(cursor.getColumnIndex("driverPhone")));
                d.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));
                d.setDriverName(cursor.getString(cursor.getColumnIndex("driverName")));
                d.setDriverSex(cursor.getInt(cursor.getColumnIndex("driverSex")));
                d.setDriverNum(cursor.getString(cursor.getColumnIndex("driverNum")));
                d.setMotorcadeNum(cursor.getString(cursor.getColumnIndex("motorcadeNum")));
                list.add(d);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }
}
