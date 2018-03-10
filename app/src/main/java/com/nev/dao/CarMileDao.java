package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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
}
