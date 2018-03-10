package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.Car;
import com.nev.domain.CarLocation;
import com.nev.domain.Driver;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

// 单例模式
public class CarDao {
    private static final String TABLE = "carInfo";
    private static CarDao dao = new CarDao();

    private CarDao() {}

    public static CarDao getInstance() {
        return dao;
    }

    public static List<Car> findAll(SQLiteDatabase db) {
        List<Car> list = new LinkedList<>();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Car c = new Car();
                c.setCarNum(cursor.getString(cursor.getColumnIndex("carNum")));
                c.setCarBrand(cursor.getString(cursor.getColumnIndex("carBrand")));
                c.setCarryingCapacity(cursor.getDouble(cursor.getColumnIndex("carryingCapacity")));
                c.setDateManu(cursor.getString(cursor.getColumnIndex("dateManu")));
                c.setDriverNum(cursor.getInt(cursor.getColumnIndex("driverNum")));

                c.setBreakdown(CarStatusDao.getInstance().isBreakdown(db,c.getCarNum()));

                CarLocation loca = CarLocationDao.getInstance().findByCarNum(db, c.getCarNum());
                if (loca != null) {
                    c.setCarLat(loca.getCarLat());
                    c.setCarLng(loca.getCarLng());
                }

                c.setCarLock(CarMileDao.getInstance().isCarLock(db, c.getCarNum()));






                list.add(c);
            } while (cursor.moveToNext());
        }
        cursor.close();


        return list;
    }
}
