package com.nev.utils;

/**
 * Created by Administrator on 2018/3/6.
 */

public class Sqls {
    public static final String CAR_INFO = "CREATE TABLE `carInfo`(\n" +
            "  `carNum` text PRIMARY KEY NOT NULL,\n" +
            "  `carBrand` text NOT NULL,\n" +
            "  `carryingCapacity` real default 0.00,\n" +
            "  `dateManu` text NOT NULL,\n" +
            "  `driverNum` integer NOT NULL\n" +
            ");";

    public static final String CAR_STATUS = "CREATE TABLE `carStatus`(\n" +
            "  `carSId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `carLoca` text NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  `task` text NOT NULL,\n" +
            "  `isBreakdown` integer NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_LOCATION = "CREATE TABLE `carLocation`(\n" +
            "  `carLId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `carLng` real NOT NULL,\n" +
            "  `carLat` real NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_MILE = "CREATE TABLE `carMile`(\n" +
            "  `carMId` integer PRIMARY KEY autoincrement,\n" +
            "  `totalMile` real default 0.00,\n" +
            "  `isCarLock` integer NOT NULL,\n" +
            "  `isSeatLock` integer NOT NULL,\n" +
            "  `isSafetyBelt` integer NOT NULL,\n" +
            "  `isHandBraking` integer NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_SPEED = "CREATE TABLE `carSpeed`(\n" +
            "  `carSId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `waterTem` real default 0.0,\n" +
            "  `engineTem` real default 0.0,\n" +
            "  `revSpeed` real default 0.0,\n" +
            "  `driSpeed` real default 0.0,\n" +
            "  `gear` text NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_WARNING = "CREATE TABLE `carWarning`(\n" +
            "  `carWId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `isAlarm` integer NOT NULL,\n" +
            "  `alarmDes` text,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_PECCANCY = "CREATE TABLE `carPeccancy`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `peccancyDes` text,\n" +
            "  `times` text NOT NULL,\n" +
            "  `types` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_COLLISION = "CREATE TABLE `carCollision`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `collRank` integer NOT NULL,\n" +
            "  `limitValue` real default 0.00,\n" +
            "  `actualValue` real default 0.00,\n" +
            "  `collAngle` real default 0.00,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_OVERSPEED = "CREATE TABLE `carOverSpeed`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `limitSpeed` real default 0.00,\n" +
            "  `maxSpeed` real default 0.00,\n" +
            "  `statusIdent` integer NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_OVERLOAD = "CREATE TABLE `carOverLoad`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `limitLoad` real default 0.00,\n" +
            "  `actulLoad` real default 0.00,\n" +
            "  `ident` integer NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_GUARANTEE = "CREATE TABLE `carGuarantee`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `mainPeriod` real default 0.00,\n" +
            "  `mainDes` real NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_SOC = "CREATE TABLE `carSoc`(\n" +
            "  `carId` integer PRIMARY KEY autoincrement,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `limitValue` real default 0.00,\n" +
            "  `soc` real default 0.00,\n" +
            "  `statusIdent` integer NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  `batteryNum` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum),\n" +
            "  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)\n" +
            ");";

    public static final String BATTERY_INFO = "CREATE TABLE `batteryInfo`(\n" +
            "  `batteryNum` text PRIMARY KEY NOT NULL,\n" +
            "  `batteryBrand` text NOT NULL,\n" +
            "  `batteryVersion` text NOT NULL,\n" +
            "  `carNum` text NOT NULL\n" +
            ");";

    public static final String BATTERY_WARNING = "CREATE TABLE `batteryWarning`(\n" +
            "  `batteryId` integer PRIMARY KEY autoincrement,\n" +
            "  `batteryNum` text NOT NULL,\n" +
            "  `bmsWarn` integer NOT NULL,\n" +
            "  `warnDes` text,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)\n" +
            ");";

    public static final String BATTERY_STATUS = "CREATE TABLE `batteryStatus`(\n" +
            "  `batteryId` integer PRIMARY KEY autoincrement,\n" +
            "  `batteryNum` text NOT NULL,\n" +
            "  `batteryTem` real default 0.00,\n" +
            "  `totalVoltage` real default 0.00,\n" +
            "  `levelAlarm` integer NOT NULL,\n" +
            "  `isUse` integer NOT NULL,\n" +
            "  `current` real default 0.00,\n" +
            "  `soc` real default 0.00,\n" +
            "  `extremeData` real default 0.00,\n" +
            "  `temData` real default 0.00,\n" +
            "  `MonomerV` real default 0.00,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)\n" +
            ");";

    public static final String BATTERY_FAILURE = "CREATE TABLE `batteryFailure`(\n" +
            "  `batteryId` integer PRIMARY KEY autoincrement,\n" +
            "  `batteryNum` text NOT NULL,\n" +
            "  `failureDes` text NOT NULL,\n" +
            "  `times` text NOT NULL,\n" +
            "  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)\n" +
            ");\n";

    public static final String TASK_INFO = "CREATE TABLE `taskInfo`(\n" +
            "  `taskId` integer PRIMARY KEY autoincrement,\n" +
            "  `motorcadeNum` text NOT NULL,\n" +
            "  `taskNum` text NOT NULL,\n" +
            "  `commitTime` text NOT NULL,\n" +
            "  `endTime` text NOT NULL,\n" +
            "  `finishTime` text NOT NULL,\n" +
            "  `finishStatus` integer NOT NULL,\n" +
            "  `taskDes` text\n" +
            ");";

    public static final String DRIVER_INFO = "CREATE TABLE `driverInfo`(\n" +
            "  `driverId` integer PRIMARY KEY autoincrement,\n" +
            "  `driverNum` text NOT NULL,\n" +
            "  `motorcadeNum` text NOT NULL,\n" +
            "  `carNum` text NOT NULL,\n" +
            "  `driverName` text NOT NULL,\n" +
            "  `driverSex` integer NOT NULL,\n" +
            "  `driverPhone` text NOT NULL,\n" +
            "  `driverPosition` text NOT NULL,\n" +
            "  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)\n" +
            ");";

    public static final String CAR_TEAM_INFO = "CREATE TABLE `carTeamInfo`(\n" +
            "  `motorcadeId` integer PRIMARY KEY auto_increment,\n" +
            "  `motorcadeNum` text NOT NULL,\n" +
            "  `captainNum` text NOT NULL,\n" +
            "  `motorcadeMount` integer NOT NULL\n" +
            ");";

    public static final String ADMIN_INFO = "CREATE TABLE `adminInfo`(\n" +
            "  `adminId` integer PRIMARY KEY autoincrement,\n" +
            "  `adminNum` text NOT NULL,\n" +
            "  `adminName` text NOT NULL,\n" +
            "  `adminAccount` text NOT NULL,\n" +
            "  `adminPass` text NOT NULL,\n" +
            "  `adminPhone` text NOT NULL\n" +
            ");";

    public static final String COMPANY_INFO = "CREATE TABLE `companyInfo`(\n" +
            "  `companyId` integer PRIMARY KEY autoincrement,\n" +
            "  `companyNum` text NOT NULL,\n" +
            "  `companyName` text NOT NULL,\n" +
            "  `companyInfo` text NOT NULL,\n" +
            "  `compantPhone` text NOT NULL\n" +
            ");";
}
