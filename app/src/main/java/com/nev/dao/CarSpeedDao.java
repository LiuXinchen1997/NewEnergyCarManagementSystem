package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.utils.StringVal;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarSpeedDao {
    private static final String TABLE = "carSpeed";
    private static CarSpeedDao dao = new CarSpeedDao();

    private CarSpeedDao() {}

    public static CarSpeedDao getInstance() {
        return dao;
    }

    public double getRevSpeedByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        double revSpeed = StringVal.INVALID;
        if (cursor.moveToFirst()) {
            revSpeed = cursor.getDouble(cursor.getColumnIndex("revSpeed"));
        }

        return revSpeed;
    }

    public double getDriSpeedByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        double driSpeed = StringVal.INVALID;
        if (cursor.moveToFirst()) {
            driSpeed = cursor.getDouble(cursor.getColumnIndex("driSpeed"));
        }

        return driSpeed;
    }
}
