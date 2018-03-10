package com.nev.dao;

import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.Battery;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/10.
 */

// 单例模式
public class BatteryDao {
    private static BatteryDao dao = new BatteryDao();

    private BatteryDao() {}

    public static BatteryDao getInstance() {
        return dao;
    }

    public static List<Battery> findAll(SQLiteDatabase db) {
        List<Battery> list = new LinkedList<>();


        return list;
    }
}
