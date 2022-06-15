package com.choujiang.domain;

public class Draw {
    private Integer drawId;

    private String drawDesc;

    private Integer drawNum;

    private Integer drawLuck;

    private Integer drawValid;

    public Integer getDrawId() {
        return drawId;
    }

    public void setDrawId(Integer drawId) {
        this.drawId = drawId;
    }

    public String getDrawDesc() {
        return drawDesc;
    }

    public void setDrawDesc(String drawDesc) {
        this.drawDesc = drawDesc;
    }

    public Integer getDrawNum() {
        return drawNum;
    }

    public void setDrawNum(Integer drawNum) {
        this.drawNum = drawNum;
    }

    public Integer getDrawLuck() {
        return drawLuck;
    }

    public void setDrawLuck(Integer drawLuck) {
        this.drawLuck = drawLuck;
    }

    public Integer getDrawValid() {
        return drawValid;
    }

    public void setDrawValid(Integer drawValid) {
        this.drawValid = drawValid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drawId=").append(drawId);
        sb.append(", drawDesc=").append(drawDesc);
        sb.append(", drawNum=").append(drawNum);
        sb.append(", drawLuck=").append(drawLuck);
        sb.append(", drawValid=").append(drawValid);
        sb.append("]");
        return sb.toString();
    }
}