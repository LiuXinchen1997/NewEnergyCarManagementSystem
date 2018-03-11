package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarPeccancyDao {
    private static final String TABLE = "carPeccancy";
    private static CarPeccancyDao dao = new CarPeccancyDao();

    private CarPeccancyDao() {}

    public static CarPeccancyDao getInstance() {
        return dao;
    }

    public static boolean isPeccancyByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }
}

