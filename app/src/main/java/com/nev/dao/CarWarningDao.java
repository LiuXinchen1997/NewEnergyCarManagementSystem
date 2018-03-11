package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarWarningDao {
    private static final String TABLE = "carWarning";
    private static CarWarningDao dao = new CarWarningDao();

    private CarWarningDao() {}

    public static CarWarningDao getInstance() {
        return dao;
    }

    public static boolean isAlarmByCarNum(SQLiteDatabase db, String carNum) {
        Cursor cursor = db.query(TABLE, null, "carNum = ?", new String[] {carNum}, null, null, null);
        if (cursor.moveToFirst()) {
            int res = cursor.getInt(cursor.getColumnIndex("isAlarm"));
            return res==1 ? true : false;
        } else {
            return false;
        }
    }
}
