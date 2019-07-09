package com.zys.boot.user.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.zys.boot.base.model.BaseBean;

public class User extends BaseBean {
    /**
     * 用户id
     */
        private Integer userId;
    /**
     * 用户名 -登陆用  唯一
     */
    @Excel(name = "用户名")
    private String userName;
    /**
     * 真实姓名
     */
    @Excel(name = "真实姓名")
    private String realName;
    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;
    /**
     * 手机号
     */
    @Excel(name = "手机号")
    private String phone;
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;
    /**
     * 证件号码
     */
    @Excel(name = "证件号码")
    private String identityCard;
    /**
     * 证件类型
     */
    @Excel(name = "证件类型")
    private String cardType;
    /**
     * 验证码
     */
    @Excel(name = "验证码")
    private String vCode;

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", cardType='" + cardType + '\'' +
                ", vCode='" + vCode + '\'' +
                '}';
    }
}