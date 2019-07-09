package com.zys.boot.base.model;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(结果)
 * 类 名 称: JsonResult
 * 类 定 义: 返回结果
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class JsonResult {
    /**
     * 是否成功标识
     */
    private boolean success;
    /**
     * 返回状态
     */
    private String status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object obj;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
