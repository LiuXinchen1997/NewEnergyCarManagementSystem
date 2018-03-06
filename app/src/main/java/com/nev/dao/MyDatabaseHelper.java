package com.nev.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import static com.nev.utils.Sqls.*;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private String[] sqls = { CAR_INFO, CAR_STATUS, CAR_LOCATION, CAR_MILE,
            CAR_SPEED, CAR_WARNING, CAR_PECCANCY, CAR_COLLISION,CAR_OVERSPEED,
            CAR_OVERLOAD, CAR_GUARANTEE, CAR_SOC, BATTERY_INFO, BATTERY_WARNING,
            BATTERY_STATUS, BATTERY_FAILURE, TASK_INFO, DRIVER_INFO, CAR_TEAM_INFO,
            ADMIN_INFO, COMPANY_INFO
    };

    private Context mContext;

    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (String sql : sqls) {
            sqLiteDatabase.execSQL(sql);
        }
        Toast.makeText(mContext, "Created succeeded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
