package com.zys.boot.user.model;

import com.alibaba.fastjson.annotation.JSONField;



public class TraffInVo {
    private String tenId = "VIV-BYD";
    private String sysId = "Runner-Web";
    private String vin;

    public String getTenId() {
        return tenId;
    }

    public void setTenId(String tenId) {
        this.tenId = tenId;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    @JSONField(name = "VIN")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "TraffInVo{" +
                "tenId='" + tenId + '\'' +
                ", sysId='" + sysId + '\'' +
                ", vin='" + vin + '\'' +
                '}';
    }
}
