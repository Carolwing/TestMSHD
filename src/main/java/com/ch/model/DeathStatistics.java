package com.ch.model;

public class DeathStatistics {
    private Integer idDeathStatistics=0;

    private String disasterID;

    private String disasterDate;

    private String location;

    private Integer numberDeath;

    private String reportingUnit;

    public DeathStatistics(Integer idDeathStatistics, String disasterID, String disasterDate, String location, Integer numberDeath, String reportingUnit){
        this.idDeathStatistics=idDeathStatistics;
        this.disasterID=disasterID;
        this.disasterDate=disasterDate;
        this.location=location;
        this.numberDeath=numberDeath;
        this.reportingUnit=reportingUnit;
    }

    public DeathStatistics(){
        super();
    }

    public Integer getIdDeathStatistics() {
        return idDeathStatistics;
    }

    public void setIdDeathStatistics(Integer idDeathStatistics) {
        this.idDeathStatistics = idDeathStatistics;
    }

    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String disasterID) {
        this.disasterID = disasterID;
    }

    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberDeath() {
        return numberDeath;
    }

    public void setNumberDeath(Integer numberDeath) {
        this.numberDeath = numberDeath;
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit;
    }
}
