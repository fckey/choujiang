package com.choujiang.domain;

public class DrawRecord {
    private Integer recordId;

    private Integer drawId;

    private Integer recordRand;

    private Integer recordIssused;

    private Integer recordStatus;

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getDrawId() {
        return drawId;
    }

    public void setDrawId(Integer drawId) {
        this.drawId = drawId;
    }

    public Integer getRecordRand() {
        return recordRand;
    }

    public void setRecordRand(Integer recordRand) {
        this.recordRand = recordRand;
    }

    public Integer getRecordIssused() {
        return recordIssused;
    }

    public void setRecordIssused(Integer recordIssused) {
        this.recordIssused = recordIssused;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recordId=").append(recordId);
        sb.append(", drawId=").append(drawId);
        sb.append(", recordRand=").append(recordRand);
        sb.append(", recordIssused=").append(recordIssused);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append("]");
        return sb.toString();
    }
}