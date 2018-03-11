package com.nev.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.nev.domain.CarTeam;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarTeamDao {
    private static final String TABLE = "carTeamInfo";
    private static CarTeamDao dao;

    private CarTeamDao() {}

    public static CarTeamDao getInstance() {
        return dao;
    }

    public static List<CarTeam> findAll(SQLiteDatabase db) {
        List<CarTeam> list = new LinkedList<>();
        Cursor cursor = db.query(TABLE, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                CarTeam ct = new CarTeam();
                ct.setCaptainNum(cursor.getString(cursor.getColumnIndex("captainNum")));
                ct.setMotorcadeId(cursor.getInt(cursor.getColumnIndex("motorcadeId")));
                ct.setMotorcadeNum(cursor.getString(cursor.getColumnIndex("motorcadeNum")));
                ct.setMotorcadeMount(cursor.getInt(cursor.getColumnIndex("motorcadeMount")));
                list.add(ct);
            } while (cursor.moveToNext());
        }

        return list;
    }
}
