package com.zys.boot.base.entity;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(接口)
 * 类 名 称: InterfaceEntity
 * 类 定 义: 接口定义类
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class InterfaceEntity {
    private Integer id;
    /**
     * 环境
     */
    private Byte envirenment;
    /**
     * 接口名
     */
    private String name;
    /**
     * 接口提供方
     */
    private String provider;
    /**
     * 相关备注
     */
    private String remark;
    /**
     * 对应接口地址
     */
    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getEnvirenment() {
        return envirenment;
    }

    public void setEnvirenment(Byte envirenment) {
        this.envirenment = envirenment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}