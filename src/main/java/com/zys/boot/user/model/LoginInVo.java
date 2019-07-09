package com.zys.boot.user.model;

import com.zys.boot.base.model.BaseBean;



public class LoginInVo extends BaseBean {
    //用户名
    private String userName;
    //密码
    private String password;
    //新密码
    private String newPassword;

    @Override
    public String toString() {
        return "LoginInVo{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
