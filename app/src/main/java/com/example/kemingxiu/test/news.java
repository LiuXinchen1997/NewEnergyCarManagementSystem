package com.example.kemingxiu.test;

/**
 * Created by kemingxiu on 2018/3/12.
 */

public class news {
    private String new_name;
    private int imageid;

    public news(int imageid, String new_name) {
        this.imageid = imageid;
        this.new_name = new_name;
    }

    public int getImageid() {
        return imageid;
    }

    public String getNew_name() {
        return new_name;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }
}
