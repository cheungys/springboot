package com.zys.boot.base.utils;


import com.zys.boot.base.entity.SysCallLogEntity;

import java.util.Date;

/**
 * 系统名称: 智慧客服平台
 * 模块名称: 客户关系数据平台
 * 类 名 称: 记录接口调用日志工具类
 * 软件版权: 远传股份有限公司
 * 功能说明：为智慧客服平台提供数据支撑
 * 系统版本：v5.0.1.0
 * 开发人员: ZJP
 * 开发时间:
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class SaveIfacLogUtil {

    /**
     * 封装接口日志的方法
     *
     * @param param
     * @param result
     * @param user
     */
    public static SysCallLogEntity saveIfacLog(String param, String result, String user, Date beginTime, Date endTime, Integer ifacId, Integer orderId) {

        //实例化日志实体类
        SysCallLogEntity sysIcssLogEntity = new SysCallLogEntity();
        //注入请求参数
        sysIcssLogEntity.setParamJsonStr(param);
        //注入返回参数
        sysIcssLogEntity.setResultJsonStr(result);
        //判断调用用户是否为空
        if (user != null) {
            //注入调用用户
            sysIcssLogEntity.setCreateUser(user);
        } else {
            //注入调用用户
            sysIcssLogEntity.setCreateUser("-1");
        }
        //注入开始时间
        sysIcssLogEntity.setCallBeginTime(beginTime);
        //注入结束时间
        sysIcssLogEntity.setCallEndTime(endTime);
        //注入调用时长
        sysIcssLogEntity.setCallLength(endTime.getTime() - beginTime.getTime());
        //注入接口ID
        sysIcssLogEntity.setInterfaceNo(ifacId);
        //注入工单ID
        sysIcssLogEntity.setOrderNo(orderId);
        return sysIcssLogEntity;
    }
}
