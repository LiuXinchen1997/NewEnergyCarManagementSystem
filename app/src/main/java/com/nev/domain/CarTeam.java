package com.nev.domain;

/**
 * Created by Administrator on 2018/3/11.
 */

public class CarTeam {
    private int motorcadeId;
    private String motorcadeNum;
    private String captainNum;
    private int motorcadeMount;

    public int getMotorcadeId() {
        return motorcadeId;
    }

    public void setMotorcadeId(int motorcadeId) {
        this.motorcadeId = motorcadeId;
    }

    public String getMotorcadeNum() {
        return motorcadeNum;
    }

    public void setMotorcadeNum(String motorcadeNum) {
        this.motorcadeNum = motorcadeNum;
    }

    public String getCaptainNum() {
        return captainNum;
    }

    public void setCaptainNum(String captainNum) {
        this.captainNum = captainNum;
    }

    public int getMotorcadeMount() {
        return motorcadeMount;
    }

    public void setMotorcadeMount(int motorcadeMount) {
        this.motorcadeMount = motorcadeMount;
    }

    public CarTeam() {
    }

    public CarTeam(int motorcadeId, String motorcadeNum, String captainNum, int motorcadeMount) {
        this.motorcadeId = motorcadeId;
        this.motorcadeNum = motorcadeNum;
        this.captainNum = captainNum;
        this.motorcadeMount = motorcadeMount;
    }

    @Override
    public String toString() {
        return "CarTeam{" +
                "motorcadeId=" + motorcadeId +
                ", motorcadeNum='" + motorcadeNum + '\'' +
                ", captainNum='" + captainNum + '\'' +
                ", motorcadeMount=" + motorcadeMount +
                '}';
    }
}
