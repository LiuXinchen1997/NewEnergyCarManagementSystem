CREATE TABLE `carInfo`(
  `carNum` text PRIMARY KEY NOT NULL,
  `carBrand` text NOT NULL,
  `carryingCapacity` real default 0.00,
  `dateManu` text NOT NULL,
  `driverNum` integer NOT NULL
);

insert into carInfo(carNum,carBrand,carryingCapacity,dateManu,driverNum)values('a','a',0.2,'2012-02-03 00:00:00',111);

CREATE TABLE `carStatus`(
  `carSId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `carLoca` text NOT NULL,
  `times` text NOT NULL,
  `task` text NOT NULL,
  `isBreakdown` integer NOT NULL,		-- 0为正常,1为故障
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carLocation`(
  `carLId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `carLng` real NOT NULL,
  `carLat` real NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

insert into carLocation(carNum,carLng,carLat,times)values("a",22.3,22.54,'2012-02-03 00:00:00');

CREATE TABLE `carMile`(
  `carMId` integer PRIMARY KEY autoincrement,
  `totalMile` real default 0.00,
  `isCarLock` integer NOT NULL,		-- 0为关,1为开
  `isSeatLock` integer NOT NULL,		-- 0为关,1为开
  `isSafetyBelt` integer NOT NULL,		-- 0为关,1为开
  `isHandBraking` integer NOT NULL,		-- 0为关,1为开
  `times` text NOT NULL,
  `carNum` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carSpeed`(
  `carSId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `waterTem` real default 0.0,
  `engineTem` real default 0.0,
  `revSpeed` real default 0.0,
  `driSpeed` real default 0.0,
  `gear` text NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carWarning`(
  `carWId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `isAlarm` integer NOT NULL,		-- 0为无,1为有
  `alarmDes` text,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carPeccancy`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `peccancyDes` text,
  `times` text NOT NULL,
  `types` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carCollision`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `collRank` integer NOT NULL,
  `limitValue` real default 0.00,
  `actualValue` real default 0.00,
  `collAngle` real default 0.00,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carOverSpeed`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `limitSpeed` real default 0.00,
  `maxSpeed` real default 0.00,
  `statusIdent` integer NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carOverLoad`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `limitLoad` real default 0.00,
  `actulLoad` real default 0.00,
  `ident` integer NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carGuarantee`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `mainPeriod` real default 0.00,
  `mainDes` real NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carSoc`(
  `carId` integer PRIMARY KEY autoincrement,
  `carNum` text NOT NULL,
  `limitValue` real default 0.00,
  `soc` real default 0.00,
  `statusIdent` integer NOT NULL,
  `times` text NOT NULL,
  `batteryNum` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum),
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
);



CREATE TABLE `batteryInfo`(
  `batteryNum` text PRIMARY KEY NOT NULL,
  `batteryBrand` text NOT NULL,
  `batteryVersion` text NOT NULL,
  `carNum` text NOT NULL
);

CREATE TABLE `batteryWarning`(
  `batteryId` integer PRIMARY KEY autoincrement,
  `batteryNum` text NOT NULL,
  `bmsWarn` integer NOT NULL,   -- 0为无,1为有
  `warnDes` text,
  `times` text NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
);

CREATE TABLE `batteryStatus`(
  `batteryId` integer PRIMARY KEY autoincrement,
  `batteryNum` text NOT NULL,
  `batteryTem` real default 0.00,
  `totalVoltage` real default 0.00,
  `levelAlarm` integer NOT NULL,    -- 0为无,1为有
  `isUse` integer NOT NULL,   -- 0为无,1为有
  `current` real default 0.00,
  `soc` real default 0.00,
  `extremeData` real default 0.00,
  `temData` real default 0.00,
  `MonomerV` real default 0.00,
  `times` text NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
);

CREATE TABLE `batteryFailure`(
  `batteryId` integer PRIMARY KEY autoincrement,
  `batteryNum` text NOT NULL,
  `failureDes` text NOT NULL,
  `times` text NOT NULL,
  FOREIGN KEY(batteryNum) REFERENCES batteryInfo(batteryNum)
);


CREATE TABLE `taskInfo`(
  `taskId` integer PRIMARY KEY autoincrement,
  `motorcadeNum` text NOT NULL,
  `taskNum` text NOT NULL,
  `commitTime` text NOT NULL,
  `endTime` text NOT NULL,
  `finishTime` text NOT NULL,
  `finishStatus` integer NOT NULL,
  `taskDes` text
);

CREATE TABLE `driverInfo`(
  `driverId` integer PRIMARY KEY autoincrement,
  `driverNum` text NOT NULL,
  `motorcadeNum` text NOT NULL,
  `carNum` text NOT NULL,
  `driverName` text NOT NULL,
  `driverSex` integer NOT NULL,
  `driverPhone` text NOT NULL,
  `driverPosition` text NOT NULL,
  FOREIGN KEY(carNum) REFERENCES carInfo(carNum)
);

CREATE TABLE `carTeamInfo`(
  `motorcadeId` integer PRIMARY KEY autoincrement,
  `motorcadeNum` text NOT NULL,
  `captainNum` text NOT NULL,
  `motorcadeMount` integer NOT NULL
);

CREATE TABLE `adminInfo`(
  `adminId` integer PRIMARY KEY autoincrement,
  `adminNum` text NOT NULL,
  `adminName` text NOT NULL,
  `adminAccount` text NOT NULL,
  `adminPass` text NOT NULL,
  `adminPhone` text NOT NULL
);

CREATE TABLE `companyInfo`(
  `companyId` integer PRIMARY KEY autoincrement,
  `companyNum` text NOT NULL,
  `companyName` text NOT NULL,
  `companyInfo` text NOT NULL,
  `compantPhone` text NOT NULL
);
