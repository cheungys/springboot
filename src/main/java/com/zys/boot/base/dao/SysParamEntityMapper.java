package com.zys.boot.base.dao;

import com.zys.boot.base.entity.SysParamEntity;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(系统参数)
 * 类 名 称: SysParamEntityMapper
 * 类 定 义: 系统参数mapper
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public interface SysParamEntityMapper {

    /**
     * 根据paramkey 查找 参数
     *
     * @param paramKey
     * @return
     */
    SysParamEntity selectByParamKey(String paramKey);
}