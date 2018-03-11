package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarOverSpeedDao {
    private static final String TABLE = "carOverSpeed";
    private static CarOverSpeedDao dao = new CarOverSpeedDao();

    private CarOverSpeedDao() {}

    public static CarOverSpeedDao getInstance() {
        return dao;
    }

    public boolean isOverSpeedByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            double limitSpeed = cursor.getDouble(cursor.getColumnIndex("limitSpeed"));
            double maxSpeed = cursor.getDouble(cursor.getColumnIndex("maxSpeed"));

            if (maxSpeed >= limitSpeed) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
