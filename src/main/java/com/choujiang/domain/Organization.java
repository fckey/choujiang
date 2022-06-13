package com.choujiang.domain;

public class Organization {
    private String orgCode;

    private String orgName;

    private Integer orgQuota;

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orgCode=").append(orgCode);
        sb.append(", orgName=").append(orgName);
        sb.append(", orgQuota=").append(orgQuota);
        sb.append("]");
        return sb.toString();
    }
}