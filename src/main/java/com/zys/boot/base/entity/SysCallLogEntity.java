package com.zys.boot.base.entity;

import java.util.Date;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(系统日志)
 * 类 名 称: SysCallLogEntity
 * 类 定 义: 系统日志实体类
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class SysCallLogEntity {
    private Integer id;
    /**
     * 开始调用时间
     */
    private Date callBeginTime;
    /**
     * 调用结束时间
     */
    private Date callEndTime;
    /**
     * 调用时长
     */
    private Long callLength;
    /**
     * 调用者
     */
    private String createUser;
    /**
     * 接口编号
     */
    private Integer interfaceNo;
    /**
     * 订单号
     */
    private Integer orderNo;
    /**
     * 请求参数
     */
    private String paramJsonStr;
    /**
     * 返回参数
     */
    private String resultJsonStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCallBeginTime() {
        return callBeginTime;
    }

    public void setCallBeginTime(Date callBeginTime) {
        this.callBeginTime = callBeginTime;
    }

    public Date getCallEndTime() {
        return callEndTime;
    }

    public void setCallEndTime(Date callEndTime) {
        this.callEndTime = callEndTime;
    }

    public Long getCallLength() {
        return callLength;
    }

    public void setCallLength(Long callLength) {
        this.callLength = callLength;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Integer getInterfaceNo() {
        return interfaceNo;
    }

    public void setInterfaceNo(Integer interfaceNo) {
        this.interfaceNo = interfaceNo;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getParamJsonStr() {
        return paramJsonStr;
    }

    public void setParamJsonStr(String paramJsonStr) {
        this.paramJsonStr = paramJsonStr;
    }

    public String getResultJsonStr() {
        return resultJsonStr;
    }

    public void setResultJsonStr(String resultJsonStr) {
        this.resultJsonStr = resultJsonStr;
    }
}