package com.ch.model;

public class CommDisaster {
    private Integer idCommDisaster=0;

    private String disasterID;

    private String disasterDate;

    private String location;

    private String disasterType;

    private String grade;

    private String note;

    private String reportingUnit;

    private byte[] picture=null;

    public CommDisaster(Integer idcommdisaster, String id, String disasterDate, String location, String disasterType, String grade, String note, String reportingUnit, byte[] picture) {
        this.idCommDisaster = idcommdisaster;
        this.disasterID = id;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.grade = grade;
        this.note = note;
        this.reportingUnit = reportingUnit;
        this.picture = picture;
    }

    public CommDisaster() {
        super();
    }

    public Integer getIdcommdisaster() {
        return idCommDisaster;
    }

    public void setIdcommdisaster(Integer idcommdisaster) {
        this.idCommDisaster = idcommdisaster;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
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

    @Override
    public String toString(){
        return "自增id:"+idCommDisaster+"\n自身编码："+ disasterID +","+"\n地点"+location+","+disasterType+","+grade+","+reportingUnit+","+note;
    }
}