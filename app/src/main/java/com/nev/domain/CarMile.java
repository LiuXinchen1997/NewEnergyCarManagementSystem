package com.nev.domain;

/**
 * Created by Administrator on 2018/3/10.
 */

public class CarMile {
    private int isCarLock;
    private int isSeatLock;
    private int isSafetyBelt;
    private int isHandBraking;
    private String times;
    private String carNum;

    public int getIsCarLock() {
        return isCarLock;
    }

    public void setIsCarLock(int isCarLock) {
        this.isCarLock = isCarLock;
    }

    public int getIsSeatLock() {
        return isSeatLock;
    }

    public void setIsSeatLock(int isSeatLock) {
        this.isSeatLock = isSeatLock;
    }

    public int getIsSafetyBelt() {
        return isSafetyBelt;
    }

    public void setIsSafetyBelt(int isSafetyBelt) {
        this.isSafetyBelt = isSafetyBelt;
    }

    public int getIsHandBraking() {
        return isHandBraking;
    }

    public void setIsHandBraking(int isHandBraking) {
        this.isHandBraking = isHandBraking;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public CarMile(int isCarLock, int isSeatLock, int isSafetyBelt, int isHandBraking, String times, String carNum) {
        this.isCarLock = isCarLock;
        this.isSeatLock = isSeatLock;
        this.isSafetyBelt = isSafetyBelt;
        this.isHandBraking = isHandBraking;
        this.times = times;
        this.carNum = carNum;
    }

    public CarMile() {
    }

    @Override
    public String toString() {
        return "CarMile{" +
                "isCarLock=" + isCarLock +
                ", isSeatLock=" + isSeatLock +
                ", isSafetyBelt=" + isSafetyBelt +
                ", isHandBraking=" + isHandBraking +
                ", times='" + times + '\'' +
                ", carNum='" + carNum + '\'' +
                '}';
    }
}
