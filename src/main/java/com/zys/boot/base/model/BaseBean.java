package com.zys.boot.base.model;

import lombok.Data;

import java.util.Date;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(基础bean)
 * 类 名 称: BaseBean
 * 类 定 义: 基础属性
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
@Data
public class BaseBean {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改人
     */
    private String modifier;
    /**
     * 修改时间
     */
    private String modifyTime;
    /**
     * 删除标识
     */
    private Boolean deltag;
    private int delflag;

    public int getDelflag() {
        return delflag;
    }

    public void setDelflag(int delflag) {
        this.delflag = delflag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDeltag() {
        return deltag;
    }

    public void setDeltag(Boolean deltag) {
        this.deltag = deltag;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "id='" + id + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifier='" + modifier + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", deltag='" + deltag + '\'' +
                '}';
    }
}
