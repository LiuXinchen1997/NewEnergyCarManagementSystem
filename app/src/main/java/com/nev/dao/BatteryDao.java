package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.Battery;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

// 单例模式
public class BatteryDao {
    private static final String TABLE = "batteryInfo";
    private static BatteryDao dao = new BatteryDao();

    private BatteryDao() {}

    public static BatteryDao getInstance() {
        return dao;
    }

    public static List<Battery> findAll(SQLiteDatabase db) {
        List<Battery> list = new LinkedList<>();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Battery b = new Battery();
                b.setBatteryNum(cursor.getString(cursor.getColumnIndex("batteryNum")));
                b.setBatteryBrand(cursor.getString(cursor.getColumnIndex("batteryBrand")));
                b.setBatteryVersion(cursor.getString(cursor.getColumnIndex("batteryVersion")));
                b.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));

                b.setWarning(BatteryStatusDao.getInstance().isWarningByBatteryNum(db, b.getBatteryNum()));
                b.setUse(BatteryStatusDao.getInstance().isUseByBatteryNum(db, b.getBatteryNum()));

                b.setFailure(BatteryFailureDao.getInstance().isFailureByBatteryNum(db, b.getBatteryNum()));
                list.add(b);
            } while (cursor.moveToNext());
        }

        return list;
    }

    public static Battery findByBatteryNum(SQLiteDatabase db, String batteryNum) {
        Battery b = null;
        Cursor cursor = db.query(TABLE, null, "batteryNum = ?", new String[] {batteryNum}, null, null, null);
        if (cursor.moveToFirst()) {
            b = new Battery();
            b.setBatteryNum(cursor.getString(cursor.getColumnIndex("batteryNum")));
            b.setBatteryBrand(cursor.getString(cursor.getColumnIndex("batteryBrand")));
            b.setBatteryVersion(cursor.getString(cursor.getColumnIndex("batteryVersion")));
            b.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));

            b.setWarning(BatteryStatusDao.getInstance().isWarningByBatteryNum(db, b.getBatteryNum()));
            b.setUse(BatteryStatusDao.getInstance().isUseByBatteryNum(db, b.getBatteryNum()));

            b.setFailure(BatteryFailureDao.getInstance().isFailureByBatteryNum(db, b.getBatteryNum()));
        }

        return b;
    }
}
