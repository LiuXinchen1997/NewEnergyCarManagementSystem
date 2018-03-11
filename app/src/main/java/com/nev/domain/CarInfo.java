package com.nev.domain;

/**
 * Created by Administrator on 2018/3/6.
 */

public class CarInfo {
    private String carNum;
    private String carBrand;
    private double carryingCapacity;
    private String dateManu;
    private int driverNum;
    private boolean isBreakdown;
    private double carLng;
    private double carLat;
    private boolean isCarLock;
    private boolean isSeatLock;
    private boolean isSafetyBelt;
    private boolean isHandBraking;
    private double revSpeed;
    private double driSpeed;
    private boolean isAlarm;
    private boolean isPeccancy;
    private boolean isCollision;
    private boolean isOverSpeed;
    private boolean isOverload;
    private String motorcadeNum;

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public String getDateManu() {
        return dateManu;
    }

    public void setDateManu(String dateManu) {
        this.dateManu = dateManu;
    }

    public int getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(int driverNum) {
        this.driverNum = driverNum;
    }

    public boolean isBreakdown() {
        return isBreakdown;
    }

    public void setBreakdown(boolean breakdown) {
        isBreakdown = breakdown;
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

    public boolean isCarLock() {
        return isCarLock;
    }

    public void setCarLock(boolean carLock) {
        isCarLock = carLock;
    }

    public boolean isSeatLock() {
        return isSeatLock;
    }

    public void setSeatLock(boolean seatLock) {
        isSeatLock = seatLock;
    }

    public boolean isSafetyBelt() {
        return isSafetyBelt;
    }

    public void setSafetyBelt(boolean safetyBelt) {
        isSafetyBelt = safetyBelt;
    }

    public boolean isHandBraking() {
        return isHandBraking;
    }

    public void setHandBraking(boolean handBraking) {
        isHandBraking = handBraking;
    }

    public double getRevSpeed() {
        return revSpeed;
    }

    public void setRevSpeed(double revSpeed) {
        this.revSpeed = revSpeed;
    }

    public double getDriSpeed() {
        return driSpeed;
    }

    public void setDriSpeed(double driSpeed) {
        this.driSpeed = driSpeed;
    }

    public boolean isAlarm() {
        return isAlarm;
    }

    public void setAlarm(boolean alarm) {
        isAlarm = alarm;
    }

    public boolean isPeccancy() {
        return isPeccancy;
    }

    public void setPeccancy(boolean peccancy) {
        isPeccancy = peccancy;
    }

    public boolean isCollision() {
        return isCollision;
    }

    public void setCollision(boolean collision) {
        isCollision = collision;
    }

    public boolean isOverSpeed() {
        return isOverSpeed;
    }

    public void setOverSpeed(boolean overSpeed) {
        isOverSpeed = overSpeed;
    }

    public boolean isOverload() {
        return isOverload;
    }

    public void setOverload(boolean overload) {
        isOverload = overload;
    }

    public String getMotorcadeNum() {
        return motorcadeNum;
    }

    public void setMotorcadeNum(String motorcadeNum) {
        this.motorcadeNum = motorcadeNum;
    }

    public CarInfo() {
    }

    public CarInfo(String carNum, String carBrand, double carryingCapacity, String dateManu, int driverNum, boolean isBreakdown, double carLng, double carLat, boolean isCarLock, boolean isSeatLock, boolean isSafetyBelt, boolean isHandBraking, double revSpeed, double driSpeed, boolean isAlarm, boolean isPeccancy, boolean isCollision, boolean isOverSpeed, boolean isOverload, String motorcadeNum) {
        this.carNum = carNum;
        this.carBrand = carBrand;
        this.carryingCapacity = carryingCapacity;
        this.dateManu = dateManu;
        this.driverNum = driverNum;
        this.isBreakdown = isBreakdown;
        this.carLng = carLng;
        this.carLat = carLat;
        this.isCarLock = isCarLock;
        this.isSeatLock = isSeatLock;
        this.isSafetyBelt = isSafetyBelt;
        this.isHandBraking = isHandBraking;
        this.revSpeed = revSpeed;
        this.driSpeed = driSpeed;
        this.isAlarm = isAlarm;
        this.isPeccancy = isPeccancy;
        this.isCollision = isCollision;
        this.isOverSpeed = isOverSpeed;
        this.isOverload = isOverload;
        this.motorcadeNum = motorcadeNum;
    }

    @Override
    public String toString() {
        return "CarInfo{" +
                "carNum='" + carNum + '\'' +
                ", carBrand='" + carBrand + '\'' +
                ", carryingCapacity=" + carryingCapacity +
                ", dateManu='" + dateManu + '\'' +
                ", driverNum=" + driverNum +
                ", isBreakdown=" + isBreakdown +
                ", carLng=" + carLng +
                ", carLat=" + carLat +
                ", isCarLock=" + isCarLock +
                ", isSeatLock=" + isSeatLock +
                ", isSafetyBelt=" + isSafetyBelt +
                ", isHandBraking=" + isHandBraking +
                ", revSpeed=" + revSpeed +
                ", driSpeed=" + driSpeed +
                ", isAlarm=" + isAlarm +
                ", isPeccancy=" + isPeccancy +
                ", isCollision=" + isCollision +
                ", isOverSpeed=" + isOverSpeed +
                ", isOverload=" + isOverload +
                ", motorcadeNum='" + motorcadeNum + '\'' +
                '}';
    }
}
