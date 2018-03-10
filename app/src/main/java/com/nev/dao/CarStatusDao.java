package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/10.
 */

public class CarStatusDao {
    private static final String TABLE = "carStatus";
    private static CarStatusDao dao = new CarStatusDao();

    private CarStatusDao() {}

    public static CarStatusDao getInstance() {
        return dao;
    }

    public static boolean isBreakdown(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);

        if (cursor.moveToFirst()) {
            int res = cursor.getInt(cursor.getColumnIndex("isBreakdown"));
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
