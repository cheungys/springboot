package com.zys.boot.base.entity;

import java.util.Date;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(数据字典)
 * 类 名 称: Dict
 * 类 定 义: 字典基础定义
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class Dict {
    private Integer id;

    private String dictKey;

    private String dictValue;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date modifyTime;

    private Integer belDictId;

    private Boolean deltag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getBelDictId() {
        return belDictId;
    }

    public void setBelDictId(Integer belDictId) {
        this.belDictId = belDictId;
    }

    public Boolean getDeltag() {
        return deltag;
    }

    public void setDeltag(Boolean deltag) {
        this.deltag = deltag;
    }
}