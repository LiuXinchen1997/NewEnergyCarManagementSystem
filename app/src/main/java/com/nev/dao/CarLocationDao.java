package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.CarLocation;

/**
 * Created by Administrator on 2018/3/10.
 */

public class CarLocationDao {
    private static final String TABLE = "carLocation";
    private static CarLocationDao dao = new CarLocationDao();
    private CarLocationDao() {}

    public static CarLocationDao getInstance() {
        return dao;
    }

    public CarLocation findByCarNum(SQLiteDatabase db, String carNum) {
        CarLocation loca = null;
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            loca = new CarLocation();
            loca.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));
            loca.setCarLat(cursor.getDouble(cursor.getColumnIndex("carLat")));
            loca.setCarLng(cursor.getDouble(cursor.getColumnIndex("carLng")));
            loca.setTimes(cursor.getString(cursor.getColumnIndex("times")));
        }

        return loca;
    }
}
