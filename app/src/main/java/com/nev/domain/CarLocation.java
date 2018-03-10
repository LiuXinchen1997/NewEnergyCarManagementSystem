package com.nev.domain;

/**
 * Created by Administrator on 2018/3/10.
 */

public class CarLocation {
    private String carNum;
    private double carLng;
    private double carLat;
    private String times;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public double getCarLng() {
        return carLng;
    }

    public void setCarLng(double carLng) {
        this.carLng = carLng;
    }

    public double getCarLat() {
        return carLat;
    }

    public void setCarLat(double carLat) {
        this.carLat = carLat;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public CarLocation() {
    }

    public CarLocation(String carNum, double carLng, double carLat, String times) {
        this.carNum = carNum;
        this.carLng = carLng;
        this.carLat = carLat;
        this.times = times;
    }

    @Override
    public String toString() {
        return "CarLocationDao{" +
                "carNum='" + carNum + '\'' +
                ", carLng=" + carLng +
                ", carLat=" + carLat +
                ", times='" + times + '\'' +
                '}';
    }
}
