package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.CarMile;

/**
 * Created by Administrator on 2018/3/10.
 */

public class CarMileDao {
    private static final String TABLE = "carMile";
    private static CarMileDao dao = new CarMileDao();

    private CarMileDao() {}

    public static CarMileDao getInstance() {
        return dao;
    }

    public static boolean isCarLock(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);

        if (cursor.moveToFirst()) {
            int res = cursor.getInt(cursor.getColumnIndex("isCarLock"));
            if (1 == res) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static CarMile findByCarNum(SQLiteDatabase db, String carNum) {
        CarMile mile = null;
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);

        if (cursor.moveToFirst()) {
            mile = new CarMile();
            mile.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));
            mile.setIsCarLock(cursor.getInt(cursor.getColumnIndex("isCarLock")));
            mile.setIsHandBraking(cursor.getInt(cursor.getColumnIndex("isHandBraking")));
            mile.setIsSafetyBelt(cursor.getInt(cursor.getColumnIndex("isSafetyBelt")));
            mile.setIsSeatLock(cursor.getInt(cursor.getColumnIndex("isSeatLock")));
            mile.setTimes(cursor.getString(cursor.getColumnIndex("times")));
        }

        return mile;
    }
}
