package com.getl.demo.testfb.Model;

public class Employees {
    public Employees() {
    }

    public Employees(String driverName, String truckNo, String driverMobNo, String DOB, String DLNO, String DLValidty, String GPS, String LOADTYPE, String TRANSPORT, String safetyTrainings, String vehicleRegnNo, String vehicleMake, String DMCTopicShared, String driverMedicalCondition, String driverFeedbackonTempHazards, String trainerName) {
        DriverName = driverName;
        TruckNo = truckNo;
        DriverMobNo = driverMobNo;
        this.DOB = DOB;
        this.DLNO = DLNO;
        this.DLValidty = DLValidty;
        this.GPS = GPS;
        this.LOADTYPE = LOADTYPE;
        this.TRANSPORT = TRANSPORT;
        SafetyTrainings = safetyTrainings;
        VehicleRegnNo = vehicleRegnNo;
        VehicleMake = vehicleMake;
        this.DMCTopicShared = DMCTopicShared;
        DriverMedicalCondition = driverMedicalCondition;
        DriverFeedbackonTempHazards = driverFeedbackonTempHazards;
        TrainerName = trainerName;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getTruckNo() {
        return TruckNo;
    }

    public void setTruckNo(String truckNo) {
        TruckNo = truckNo;
    }

    public String getDriverMobNo() {
        return DriverMobNo;
    }

    public void setDriverMobNo(String driverMobNo) {
        DriverMobNo = driverMobNo;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDLNO() {
        return DLNO;
    }

    public void setDLNO(String DLNO) {
        this.DLNO = DLNO;
    }

    public String getDLValidty() {
        return DLValidty;
    }

    public void setDLValidty(String DLValidty) {
        this.DLValidty = DLValidty;
    }

    public String getGPS() {
        return GPS;
    }

    public void setGPS(String GPS) {
        this.GPS = GPS;
    }

    public String getLOADTYPE() {
        return LOADTYPE;
    }

    public void setLOADTYPE(String LOADTYPE) {
        this.LOADTYPE = LOADTYPE;
    }

    public String getTRANSPORT() {
        return TRANSPORT;
    }

    public void setTRANSPORT(String TRANSPORT) {
        this.TRANSPORT = TRANSPORT;
    }

    public String getSafetyTrainings() {
        return SafetyTrainings;
    }

    public void setSafetyTrainings(String safetyTrainings) {
        SafetyTrainings = safetyTrainings;
    }

    public String getVehicleRegnNo() {
        return VehicleRegnNo;
    }

    public void setVehicleRegnNo(String vehicleRegnNo) {
        VehicleRegnNo = vehicleRegnNo;
    }

    public String getVehicleMake() {
        return VehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        VehicleMake = vehicleMake;
    }

    public String getDMCTopicShared() {
        return DMCTopicShared;
    }

    public void setDMCTopicShared(String DMCTopicShared) {
        this.DMCTopicShared = DMCTopicShared;
    }

    public String getDriverMedicalCondition() {
        return DriverMedicalCondition;
    }

    public void setDriverMedicalCondition(String driverMedicalCondition) {
        DriverMedicalCondition = driverMedicalCondition;
    }

    public String getDriverFeedbackonTempHazards() {
        return DriverFeedbackonTempHazards;
    }

    public void setDriverFeedbackonTempHazards(String driverFeedbackonTempHazards) {
        DriverFeedbackonTempHazards = driverFeedbackonTempHazards;
    }

    public String getTrainerName() {
        return TrainerName;
    }

    public void setTrainerName(String trainerName) {
        TrainerName = trainerName;
    }

    private String DriverName,TruckNo,DriverMobNo,DOB,DLNO,DLValidty,GPS,LOADTYPE,TRANSPORT,
            SafetyTrainings,VehicleRegnNo,VehicleMake,DMCTopicShared,DriverMedicalCondition,
            DriverFeedbackonTempHazards,TrainerName;
}
