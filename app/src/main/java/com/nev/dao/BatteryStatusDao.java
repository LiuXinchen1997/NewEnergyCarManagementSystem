package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2018/3/11.
 */

public class BatteryStatusDao {
    private static final String TABLE = "batteryStatus";
    private static BatteryStatusDao dao = new BatteryStatusDao();

    private BatteryStatusDao() {}

    public static BatteryStatusDao getInstance() {
        return dao;
    }

    public boolean isWarningByBatteryNum(SQLiteDatabase db, String batteryNum) {
        Cursor cursor = db.query(TABLE, null, "batteryNum = ?", new String[] {batteryNum}, null, null, null);
        if (cursor.moveToFirst()) {
            int res = cursor.getInt(cursor.getColumnIndex("levelAlarm"));
            return res == 1 ? true : false;
        }

        return false;
    }

    public boolean isUseByBatteryNum(SQLiteDatabase db, String batteryNum) {
        Cursor cursor = db.query(TABLE, null, "batteryNum = ?", new String[] {batteryNum}, null, null, null);
        if (cursor.moveToFirst()) {
            int res = cursor.getInt(cursor.getColumnIndex("isUse"));
            return res == 1 ? true : false;
        }

        return false;
    }
}
