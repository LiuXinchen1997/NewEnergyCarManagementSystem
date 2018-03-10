package com.nev.domain;

/**
 * Created by Administrator on 2018/3/10.
 */

public class Admin {
    private int adminId;
    private String adminNum;
    private String adminName;
    private String adminAccount;
    private String adminPass;
    private String adminPhone;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(String adminNum) {
        this.adminNum = adminNum;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Admin(int adminId, String adminNum, String adminName, String adminAccount, String adminPass, String adminPhone) {
        this.adminId = adminId;
        this.adminNum = adminNum;
        this.adminName = adminName;
        this.adminAccount = adminAccount;
        this.adminPass = adminPass;
        this.adminPhone = adminPhone;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminNum='" + adminNum + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPass='" + adminPass + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                '}';
    }
}
