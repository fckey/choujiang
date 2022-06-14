package com.choujiang.domain;

public class Organization {
    private Integer orgCode;

    private String orgName;

    private Integer orgQuota;

    private Integer orgJoined;

    public Integer getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(Integer orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgQuota() {
        return orgQuota;
    }

    public void setOrgQuota(Integer orgQuota) {
        this.orgQuota = orgQuota;
    }

    public Integer getOrgJoined() {
        return orgJoined;
    }

    public void setOrgJoined(Integer orgJoined) {
        this.orgJoined = orgJoined;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgQuota=").append(orgQuota);
        sb.append(", orgJoined=").append(orgJoined);
        sb.append("]");
        return sb.toString();
    }
}