package com.zys.boot.user.model;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 用户模块
 * 类 名 称: UserInVo
 * 类 定 义: 用户输入对象
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class UserInVo {

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInVo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
