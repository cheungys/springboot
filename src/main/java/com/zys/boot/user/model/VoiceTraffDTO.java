package com.zys.boot.user.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.zys.boot.user.entity.OrderPKG;
import com.zys.boot.user.entity.PurchRecord;

import java.util.List;



public class VoiceTraffDTO {
    //客户姓名
    private String custName;
    //手机号码
    private String cellPhone;
    //城市
    private String city;
    //车架号
    private String vin;
    //车型编码
    private String carModelSN;
    //车型名称
    private String carModelName;
    //车牌号
    private String plateNum;
    //剩余流量
    private String residueTraff;
    //物联网卡号
    private String vehiclePhone;
    private String iccid;
    //运营商
    private String carrOperator;
    //服务状态
    private String serStatus;
    private String apn1Status;
    private String apn2Status;
    //使用周期
    private String usedTraff;
    //短信总量
    private String megTotal;
    //语音状态
    private String voiceStatus;
    //BCall 服务状态
    private String bcallSetSize;
    //语音使用量
    private String voiUseAmount;
    //月总流量
    private String monthTotalTraff;
    //购买记录
    private List<PurchRecord> PurchRecordList;
    //套餐列表
    private List<OrderPKG> OrderPKGList;

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCity() {
        return city;
    }

    @JSONField(name = "param1")
    public void setCity(String city) {
        this.city = city;
    }

    public String getVin() {
        return vin;
    }

    @JSONField(name = "param2")
    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarModelSN() {
        return carModelSN;
    }

    @JSONField(name = "param3")
    public void setCarModelSN(String carModelSN) {
        this.carModelSN = carModelSN;
    }

    public String getCarModelName() {
        return carModelName;
    }

    @JSONField(name = "param4")
    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getPlateNum() {
        return plateNum;
    }

    @JSONField(name = "param5")
    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public String getResidueTraff() {
        return residueTraff;
    }

    @JSONField(name = "param8")
    public void setResidueTraff(String residueTraff) {
        this.residueTraff = residueTraff;
    }

    public String getVehiclePhone() {
        return vehiclePhone;
    }

    public void setVehiclePhone(String vehiclePhone) {
        this.vehiclePhone = vehiclePhone;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getCarrOperator() {
        return carrOperator;
    }

    public void setCarrOperator(String carrOperator) {
        this.carrOperator = carrOperator;
    }

    public String getSerStatus() {
        return serStatus;
    }

    public void setSerStatus(String serStatus) {
        this.serStatus = serStatus;
    }

    public String getApn1Status() {
        return apn1Status;
    }

    public void setApn1Status(String apn1Status) {
        this.apn1Status = apn1Status;
    }

    public String getApn2Status() {
        return apn2Status;
    }

    public void setApn2Status(String apn2Status) {
        this.apn2Status = apn2Status;
    }

    public String getUsedTraff() {
        return usedTraff;
    }

    public void setUsedTraff(String usedTraff) {
        this.usedTraff = usedTraff;
    }

    public String getMegTotal() {
        return megTotal;
    }

    public void setMegTotal(String megTotal) {
        this.megTotal = megTotal;
    }

    public String getVoiceStatus() {
        return voiceStatus;
    }

    public void setVoiceStatus(String voiceStatus) {
        this.voiceStatus = voiceStatus;
    }

    public String getBcallSetSize() {
        return bcallSetSize;
    }

    public void setBcallSetSize(String bcallSetSize) {
        this.bcallSetSize = bcallSetSize;
    }

    public String getVoiUseAmount() {
        return voiUseAmount;
    }

    public void setVoiUseAmount(String voiUseAmount) {
        this.voiUseAmount = voiUseAmount;
    }

    public List<PurchRecord> getPurchRecordList() {
        return PurchRecordList;
    }

    public void setPurchRecordList(List<PurchRecord> purchRecordList) {
        PurchRecordList = purchRecordList;
    }

    public List<OrderPKG> getOrderPKGList() {
        return OrderPKGList;
    }

    public void setOrderPKGList(List<OrderPKG> orderPKGList) {
        OrderPKGList = orderPKGList;
    }

    public String getCustName() {
        return custName;
    }

    @JSONField(name = "param6")
    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getMonthTotalTraff() {
        return monthTotalTraff;
    }

    public void setMonthTotalTraff(String monthTotalTraff) {
        this.monthTotalTraff = monthTotalTraff;
    }

    @Override
    public String toString() {
        return "VoiceTraffDTO{" +
                "custName='" + custName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", city='" + city + '\'' +
                ", vin='" + vin + '\'' +
                ", carModelSN='" + carModelSN + '\'' +
                ", carModelName='" + carModelName + '\'' +
                ", plateNum='" + plateNum + '\'' +
                ", residueTraff='" + residueTraff + '\'' +
                ", vehiclePhone='" + vehiclePhone + '\'' +
                ", iccid='" + iccid + '\'' +
                ", carrOperator='" + carrOperator + '\'' +
                ", serStatus='" + serStatus + '\'' +
                ", apn1Status='" + apn1Status + '\'' +
                ", apn2Status='" + apn2Status + '\'' +
                ", usedTraff='" + usedTraff + '\'' +
                ", megTotal='" + megTotal + '\'' +
                ", voiceStatus='" + voiceStatus + '\'' +
                ", bcallSetSize='" + bcallSetSize + '\'' +
                ", voiUseAmount='" + voiUseAmount + '\'' +
                ", monthTotalTraff='" + monthTotalTraff + '\'' +
                ", PurchRecordList=" + PurchRecordList +
                ", OrderPKGList=" + OrderPKGList +
                '}';
    }
}
