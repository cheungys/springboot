package com.zys.boot.user.model;

/**
 * @author zys
 * 系统名称:
 * 模块名称:
 * 类 名 称: ResponseVO
 * 类 定 义:
 * 开发时间: 2019/07/03  22:00
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class ResponseVO {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
