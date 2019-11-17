package com.zys.boot.user.model;

/**
 * @author zys
 * 系统名称:
 * 模块名称:
 * 类 名 称: DLink
 * 类 定 义:
 * 开发时间: 2019/11/03  20:02
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class DLink {
    private String vin;
    private String iccid;
    private String vCode;
    private String originDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public String getOriginDate() {
        return originDate;
    }

    public void setOriginDate(String originDate) {
        this.originDate = originDate;
    }

    @Override
    public String toString() {
        return "DLink{" +
                "vin='" + vin + '\'' +
                ", iccid='" + iccid + '\'' +
                ", vCode='" + vCode + '\'' +
                ", originDate='" + originDate + '\'' +
                '}';
    }

}
