package com.getl.demo.testfb.Model;

public class Demo_employees {

private String DLNO,DMCTopicShared,DriverName;

    public Demo_employees() {
    }

    public Demo_employees(String DLNO, String DMCTopicShared, String driverName) {
        this.DLNO = DLNO;
        this.DMCTopicShared = DMCTopicShared;
        DriverName = driverName;
    }

    public String getDLNO() {
        return DLNO;
    }

    public void setDLNO(String DLNO) {
        this.DLNO = DLNO;
    }

    public String getDMCTopicShared() {
        return DMCTopicShared;
    }

    public void setDMCTopicShared(String DMCTopicShared) {
        this.DMCTopicShared = DMCTopicShared;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }
}
