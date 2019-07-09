package com.zys.boot.base.controller;

import com.zys.boot.base.model.JsonResult;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块
 * 类 名 称: BaseController
 * 类 定 义: 基础控制器
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class BaseController {

    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected JsonResult renderError() {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        return result;
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected JsonResult renderError(String msg) {
        JsonResult result = renderError();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        JsonResult result = new JsonResult();
        result.setMsg("success");
        result.setSuccess(true);
        result.setStatus("200");
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult renderSuccess(String msg) {
        JsonResult result = renderSuccess();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    protected JsonResult renderSuccess(Object obj) {
        JsonResult result = renderSuccess();
        result.setMsg("success");
        result.setObj(obj);
        return result;
    }

}
