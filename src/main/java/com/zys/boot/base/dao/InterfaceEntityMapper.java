package com.zys.boot.base.dao;

import com.zys.boot.base.entity.InterfaceEntity;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(接口)
 * 类 名 称: InterfaceEntityMapper
 * 类 定 义: 接口mapper
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public interface InterfaceEntityMapper {
    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入接口记录
     *
     * @param record
     * @return
     */
    int insert(InterfaceEntity record);

    /**
     * 动态插入
     *
     * @param record
     * @return
     */
    int insertSelective(InterfaceEntity record);

    /**
     * 根据接口名和环境查询
     *
     * @param interfaceEntity
     * @return
     */
    InterfaceEntity selectByNameAndEnv(InterfaceEntity interfaceEntity);

    /**
     * 根据条件动态更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(InterfaceEntity record);

    /**
     * 根据主键更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(InterfaceEntity record);
}