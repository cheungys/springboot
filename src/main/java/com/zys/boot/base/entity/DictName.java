package com.zys.boot.base.entity;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(数据字典)
 * 类 名 称: DictName
 * 类 定 义: 字典名称映射定义
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class DictName {
    private Integer id;

    private Integer dictDefineId;

    private String dictDefineName;

    private Boolean deltag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDictDefineId() {
        return dictDefineId;
    }

    public void setDictDefineId(Integer dictDefineId) {
        this.dictDefineId = dictDefineId;
    }

    public String getDictDefineName() {
        return dictDefineName;
    }

    public void setDictDefineName(String dictDefineName) {
        this.dictDefineName = dictDefineName == null ? null : dictDefineName.trim();
    }

    public Boolean getDeltag() {
        return deltag;
    }

    public void setDeltag(Boolean deltag) {
        this.deltag = deltag;
    }
}