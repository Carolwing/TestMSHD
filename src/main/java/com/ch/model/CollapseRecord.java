package com.ch.model;

public class CollapseRecord {
    private Integer idCollapseRecord=0;

    private String disasterID;

    private String disasterDate;

    private String location;

    private String disasterType;

    private String status;

    private String note=null;

    private String reportingUnit;

    private byte[] picture=null;

    public CollapseRecord(Integer idCollapseRecord, String id, String disasterDate, String location, String disasterType, String status, String note, String reportingUnit, byte[] picture) {
        this.idCollapseRecord = idCollapseRecord;
        this.disasterID = id;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.status = status;
        this.note = note;
        this.reportingUnit = reportingUnit;
        this.picture = picture;
    }

    public CollapseRecord(){super();}

    public Integer getIdCollapseRecord() {
        return idCollapseRecord;
    }

    public void setIdCollapseRecord(Integer idCollapseRecord) {
        this.idCollapseRecord = idCollapseRecord;
    }

    public String getDisasterID() {
        return disasterID;
    }

    public void setDisasterID(String id) {
        this.disasterID = id == null ? null : id.trim();
    }

    public String getDisasterDate() {
        return disasterDate;
    }

    public void setDisasterDate(String disasterDate) {
        this.disasterDate = disasterDate == null ? null : disasterDate.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType == null ? null : disasterType.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String grade) {
        this.status = grade == null ? null : grade.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getReportingUnit() {
        return reportingUnit;
    }

    public void setReportingUnit(String reportingUnit) {
        this.reportingUnit = reportingUnit == null ? null : reportingUnit.trim();
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
