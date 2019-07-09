package com.zys.boot.base.exception;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(异常)
 * 类 名 称: BusinessException
 * 类 定 义: 业务异常
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -1340328704145759576L;

    public BusinessException() {
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}
