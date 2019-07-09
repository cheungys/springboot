package com.zys.boot.user.entity;

public class CardInfo {
    private Integer id;

    private String vehiclePhone;

    private String iccid;

    private Integer carrOperator;

    private Integer serStatus;

    private Integer apn1Status;

    private Integer apn2Status;

    private String monthTotalTraff;

    private String usedTraff;

    private String megTotal;

    private String cellphone;

    private String city;

    private String vin;

    private String carModelSn;

    private String carModelName;

    private String plateNumber;

    private String custName;

    private String custPhone;

    private String residualTraff;

    private String voiceStatus;

    private String bcallSetSize;

    private String voiUsedAmount;

    private Boolean deltag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVehiclePhone() {
        return vehiclePhone;
    }

    public void setVehiclePhone(String vehiclePhone) {
        this.vehiclePhone = vehiclePhone == null ? null : vehiclePhone.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
    }

    public Integer getCarrOperator() {
        return carrOperator;
    }

    public void setCarrOperator(Integer carrOperator) {
        this.carrOperator = carrOperator;
    }

    public Integer getSerStatus() {
        return serStatus;
    }

    public void setSerStatus(Integer serStatus) {
        this.serStatus = serStatus;
    }

    public Integer getApn1Status() {
        return apn1Status;
    }

    public void setApn1Status(Integer apn1Status) {
        this.apn1Status = apn1Status;
    }

    public Integer getApn2Status() {
        return apn2Status;
    }

    public void setApn2Status(Integer apn2Status) {
        this.apn2Status = apn2Status;
    }

    public String getMonthTotalTraff() {
        return monthTotalTraff;
    }

    public void setMonthTotalTraff(String monthTotalTraff) {
        this.monthTotalTraff = monthTotalTraff == null ? null : monthTotalTraff.trim();
    }

    public String getUsedTraff() {
        return usedTraff;
    }

    public void setUsedTraff(String usedTraff) {
        this.usedTraff = usedTraff == null ? null : usedTraff.trim();
    }

    public String getMegTotal() {
        return megTotal;
    }

    public void setMegTotal(String megTotal) {
        this.megTotal = megTotal == null ? null : megTotal.trim();
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone == null ? null : cellphone.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    public String getCarModelSn() {
        return carModelSn;
    }

    public void setCarModelSn(String carModelSn) {
        this.carModelSn = carModelSn == null ? null : carModelSn.trim();
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName == null ? null : carModelName.trim();
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getResidualTraff() {
        return residualTraff;
    }

    public void setResidualTraff(String residualTraff) {
        this.residualTraff = residualTraff == null ? null : residualTraff.trim();
    }

    public String getVoiceStatus() {
        return voiceStatus;
    }

    public void setVoiceStatus(String voiceStatus) {
        this.voiceStatus = voiceStatus == null ? null : voiceStatus.trim();
    }

    public String getBcallSetSize() {
        return bcallSetSize;
    }

    public void setBcallSetSize(String bcallSetSize) {
        this.bcallSetSize = bcallSetSize == null ? null : bcallSetSize.trim();
    }

    public String getVoiUsedAmount() {
        return voiUsedAmount;
    }

    public void setVoiUsedAmount(String voiUsedAmount) {
        this.voiUsedAmount = voiUsedAmount == null ? null : voiUsedAmount.trim();
    }

    public Boolean getDeltag() {
        return deltag;
    }

    public void setDeltag(Boolean deltag) {
        this.deltag = deltag;
    }
}