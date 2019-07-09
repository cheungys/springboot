package com.zys.boot.user.entity;

import java.util.Date;

public class OrderPKG {
    private Integer id;

    private String pkgType;

    private String pkgAmount;

    private Date pkgActTime;

    private Date pkgExpireTime;

    private String vehiclePhone;

    private Boolean deltag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPkgType() {
        return pkgType;
    }

    public void setPkgType(String pkgType) {
        this.pkgType = pkgType == null ? null : pkgType.trim();
    }

    public String getPkgAmount() {
        return pkgAmount;
    }

    public void setPkgAmount(String pkgAmount) {
        this.pkgAmount = pkgAmount == null ? null : pkgAmount.trim();
    }

    public Date getPkgActTime() {
        return pkgActTime;
    }

    public void setPkgActTime(Date pkgActTime) {
        this.pkgActTime = pkgActTime;
    }

    public Date getPkgExpireTime() {
        return pkgExpireTime;
    }

    public void setPkgExpireTime(Date pkgExpireTime) {
        this.pkgExpireTime = pkgExpireTime;
    }

    public String getVehiclePhone() {
        return vehiclePhone;
    }

    public void setVehiclePhone(String vehiclePhone) {
        this.vehiclePhone = vehiclePhone == null ? null : vehiclePhone.trim();
    }

    public Boolean getDeltag() {
        return deltag;
    }

    public void setDeltag(Boolean deltag) {
        this.deltag = deltag;
    }
}