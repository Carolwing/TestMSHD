package com.ch.model;

public class DisasterPrediction {
    private Integer idDisasterPrediction=0;

    private String disasterID;

    private String disasterDate;

    private String location;

    private float longitude=0;

    private float latitude=0;

    private float depth=0;

    private float maginitude=0;

    private String intensity=null;

    private String disasterType;

    private String note=null;

    private String reportingUnit;

    private byte[] picture=null;

    public DisasterPrediction(Integer idDisasterPrediction, String id, String disasterDate, String location, String disasterType, float latitude, float longitude, float depth, float maginitude, String intensity, String note, String reportingUnit, byte[] picture) {
        this.idDisasterPrediction = idDisasterPrediction;
        this.disasterID = id;
        this.disasterDate = disasterDate;
        this.location = location;
        this.disasterType = disasterType;
        this.latitude = latitude;
        this.longitude=longitude;
        this.depth=depth;
        this.maginitude=maginitude;
        this.intensity=intensity;
        this.note = note;
        this.reportingUnit = reportingUnit;
        this.picture = picture;
    }

    public DisasterPrediction(){super();}

    public Integer getIdDisasterPrediction() {
        return idDisasterPrediction;
    }

    public void setIdDisasterPrediction(Integer idDisasterPrediction) {
        this.idDisasterPrediction = idDisasterPrediction;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getDepth() {
        return depth;
    }

    public void setMaginitude(float maginitude) {
        this.maginitude = maginitude;
    }

    public float getMaginitude() {
        return maginitude;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getIntensity() {
        return intensity;
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
