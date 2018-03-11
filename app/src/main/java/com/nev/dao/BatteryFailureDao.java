package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class BatteryFailureDao {
    private static final String TABLE = "batteryFailure";
    private static BatteryFailureDao dao = new BatteryFailureDao();

    private BatteryFailureDao() {}

    public static BatteryFailureDao getInstance() {
        return dao;
    }

    public boolean isFailureByBatteryNum(SQLiteDatabase db, String batteryNum) {
        Cursor cursor = db.query(TABLE, null, "batteryNum = ?", new String[] {batteryNum}, null, null, null);
        if (cursor.moveToFirst()) {
            return true;
        }

        return false;
    }
}
