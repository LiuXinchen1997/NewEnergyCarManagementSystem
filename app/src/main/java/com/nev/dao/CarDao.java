package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.CarInfo;
import com.nev.domain.CarLocation;
import com.nev.domain.CarMile;
import com.nev.utils.StringVal;

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

    public static List<CarInfo> findAll(SQLiteDatabase db) {
        List<CarInfo> list = new LinkedList<>();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                CarInfo c = new CarInfo();
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
                } else {
                    c.setCarLat(StringVal.INVALID);
                    c.setCarLng(StringVal.INVALID);
                }

                CarMile mile = CarMileDao.getInstance().findByCarNum(db, c.getCarNum());
                if (mile != null) {
                    c.setCarLock(mile.getIsCarLock()==1?true:false);
                    c.setSeatLock(mile.getIsSeatLock()==1?true:false);
                    c.setSafetyBelt(mile.getIsSafetyBelt()==1?true:false);
                    c.setHandBraking(mile.getIsHandBraking()==1?true:false);
                } else {
                    c.setCarLock(true);
                    c.setSeatLock(true);
                    c.setSafetyBelt(true);
                    c.setHandBraking(true);
                }

                c.setRevSpeed(CarSpeedDao.getInstance().getRevSpeedByCarNum(db, c.getCarNum()));
                c.setDriSpeed(CarSpeedDao.getInstance().getDriSpeedByCarNum(db, c.getCarNum()));

                c.setAlarm(CarWarningDao.getInstance().isAlarmByCarNum(db, c.getCarNum()));

                c.setPeccancy(CarPeccancyDao.getInstance().isPeccancyByCarNum(db, c.getCarNum()));

                c.setCollision(CarCollisionDao.getInstance().isCollisionByCarNum(db, c.getCarNum()));

                c.setOverSpeed(CarOverSpeedDao.getInstance().isOverSpeedByCarNum(db, c.getCarNum()));

                c.setOverload(CarOverLoadDao.getInstance().isOverLoadByCarNum(db, c.getCarNum()));
                c.setMotorcadeNum(cursor.getString(cursor.getColumnIndex("motorcadeNum")));

                list.add(c);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return list;
    }

    public static CarInfo findByCarNum(SQLiteDatabase db, String carNum) {
        List<CarInfo> cars = findAll(db);
        for (CarInfo c : cars) {
            if (c.getCarNum().equals(carNum)) {
                return c;
            }
        }

        return null;
    }

    public static List<CarInfo> findByCarTeam(SQLiteDatabase db, String carTeamNum) {
        List<CarInfo> cars = findAll(db);
        List<CarInfo> selected_cars = new LinkedList<>();
        for (CarInfo car : cars) {
            if (car.getMotorcadeNum().equals(carTeamNum)) {
                selected_cars.add(car);
            }
        }

        return selected_cars;
    }
}
