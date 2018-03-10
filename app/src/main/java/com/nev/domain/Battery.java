package com.nev.domain;

/**
 * Created by Administrator on 2018/3/6.
 */

public class Battery {
    private String batteryNum;
    private String batteryBrand;
    private String batteryVersion;
    private String carNum;
    private boolean isWarning;
    private boolean isUse;
    private boolean isFailure;

    public String getBatteryNum() {
        return batteryNum;
    }

    public void setBatteryNum(String batteryNum) {
        this.batteryNum = batteryNum;
    }

    public String getBatteryBrand() {
        return batteryBrand;
    }

    public void setBatteryBrand(String batteryBrand) {
        this.batteryBrand = batteryBrand;
    }

    public String getBatteryVersion() {
        return batteryVersion;
    }

    public void setBatteryVersion(String batteryVersion) {
        this.batteryVersion = batteryVersion;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public boolean isWarning() {
        return isWarning;
    }

    public void setWarning(boolean warning) {
        isWarning = warning;
    }

    public boolean isUse() {
        return isUse;
    }

    public void setUse(boolean use) {
        isUse = use;
    }

    public boolean isFailure() {
        return isFailure;
    }

    public void setFailure(boolean failure) {
        isFailure = failure;
    }

    public Battery(String batteryNum, String batteryBrand, String batteryVersion, String carNum, boolean isWarning, boolean isUse, boolean isFailure) {
        this.batteryNum = batteryNum;
        this.batteryBrand = batteryBrand;
        this.batteryVersion = batteryVersion;
        this.carNum = carNum;
        this.isWarning = isWarning;
        this.isUse = isUse;
        this.isFailure = isFailure;
    }

    public Battery() {
    }

    @Override
    public String toString() {
        return "Battery{" +
                "batteryNum='" + batteryNum + '\'' +
                ", batteryBrand='" + batteryBrand + '\'' +
                ", batteryVersion='" + batteryVersion + '\'' +
                ", carNum='" + carNum + '\'' +
                ", isWarning=" + isWarning +
                ", isUse=" + isUse +
                ", isFailure=" + isFailure +
                '}';
    }
}
