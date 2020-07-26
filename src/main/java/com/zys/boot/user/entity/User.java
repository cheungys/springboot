package com.zys.boot.user.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.zys.boot.base.model.BaseBean;
import lombok.Data;

@Data
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

}