package com.zys.boot.user.model;

/**
 * 系统名称: 智慧客服平台
 * 模块名称: 客户关系数据平台
 * 类 名 称: CancelInVo
 * 软件版权: 远传股份有限公司
 * 功能说明：为智慧客服平台提供数据支撑
 * 系统版本：v5.0.1.0
 * 开发人员: zys
 * 开发时间: 2019/02/08  22:36
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class CancelInVo {
    private String email;
    private String vCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getvCode() {
        return vCode;
    }

    public void setvCode(String vCode) {
        this.vCode = vCode;
    }

    @Override
    public String toString() {
        return "CancelInVo{" +
                "email='" + email + '\'' +
                ", vCode='" + vCode + '\'' +
                '}';
    }
}
