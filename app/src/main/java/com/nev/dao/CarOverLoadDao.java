package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarOverLoadDao {
    private static final String TABLE = "carOverLoad";
    private static CarOverLoadDao dao = new CarOverLoadDao();

    private CarOverLoadDao() {}

    public static CarOverLoadDao getInstance() {
        return dao;
    }

    public boolean isOverLoadByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            double limitLoad = cursor.getDouble(cursor.getColumnIndex("limitLoad"));
            double actulLoad = cursor.getDouble(cursor.getColumnIndex("actulLoad"));

            if (actulLoad >= limitLoad) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }
}
