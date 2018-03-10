package com.nev.dao;

/**
 * Created by Administrator on 2018/3/10.
 */

public class AdminDao {
    private static AdminDao dao = new AdminDao();

    private AdminDao() {}

    public static AdminDao getInstance() {
        return dao;
    }

    private static final String TABLE = "adminInfo";



}
