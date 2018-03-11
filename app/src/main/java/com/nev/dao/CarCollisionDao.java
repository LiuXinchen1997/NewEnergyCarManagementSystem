package com.nev.dao;

/**
 * Created by Administrator on 2018/3/11.
 */

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CarCollisionDao {
    private static final String TABLE = "carCollision";
    private static CarCollisionDao dao = new CarCollisionDao();

    private CarCollisionDao() {}

    public static CarCollisionDao getInstance() {
        return dao;
    }

    public boolean isCollisionByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            return true;
        }

        return false;
    }
}

