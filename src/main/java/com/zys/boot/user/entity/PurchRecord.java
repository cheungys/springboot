package com.zys.boot.user.entity;

import java.util.Date;

public class PurchRecord {
    private Integer id;

    private String orderNumDi;

    private String orderNumTraff;

    private String channel;

    private String puctName;

    private String amount;

    private Date purchTime;

    private String voiceSet;

    private String traffSet;

    private String usedCycle;

    private String setSize;

    private Date setStartTime;

    private Date setEndTime;

    private String vehiclePhone;

    private Boolean deltag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumDi() {
        return orderNumDi;
    }

    public void setOrderNumDi(String orderNumDi) {
        this.orderNumDi = orderNumDi == null ? null : orderNumDi.trim();
    }

    public String getOrderNumTraff() {
        return orderNumTraff;
    }

    public void setOrderNumTraff(String orderNumTraff) {
        this.orderNumTraff = orderNumTraff == null ? null : orderNumTraff.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getPuctName() {
        return puctName;
    }

    public void setPuctName(String puctName) {
        this.puctName = puctName == null ? null : puctName.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public Date getPurchTime() {
        return purchTime;
    }

    public void setPurchTime(Date purchTime) {
        this.purchTime = purchTime;
    }

    public String getVoiceSet() {
        return voiceSet;
    }

    public void setVoiceSet(String voiceSet) {
        this.voiceSet = voiceSet == null ? null : voiceSet.trim();
    }

    public String getTraffSet() {
        return traffSet;
    }

    public void setTraffSet(String traffSet) {
        this.traffSet = traffSet == null ? null : traffSet.trim();
    }

    public String getUsedCycle() {
        return usedCycle;
    }

    public void setUsedCycle(String usedCycle) {
        this.usedCycle = usedCycle == null ? null : usedCycle.trim();
    }

    public String getSetSize() {
        return setSize;
    }

    public void setSetSize(String setSize) {
        this.setSize = setSize == null ? null : setSize.trim();
    }

    public Date getSetStartTime() {
        return setStartTime;
    }

    public void setSetStartTime(Date setStartTime) {
        this.setStartTime = setStartTime;
    }

    public Date getSetEndTime() {
        return setEndTime;
    }

    public void setSetEndTime(Date setEndTime) {
        this.setEndTime = setEndTime;
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