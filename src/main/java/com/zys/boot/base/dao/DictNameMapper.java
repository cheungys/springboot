package com.zys.boot.base.dao;

import com.zys.boot.base.entity.DictName;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(数据字典)
 * 类 名 称: DictNameMapper
 * 类 定 义: 字典mapper
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public interface DictNameMapper {
    /**
     * 根据主键删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     *
     * @param record
     * @return
     */
    int insert(DictName record);

    /**
     * 根据条件动态插入
     *
     * @param record
     * @return
     */
    int insertSelective(DictName record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    DictName selectByPrimaryKey(Integer id);

    /**
     * 根据条件动态更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DictName record);

    /**
     * 更新操作
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(DictName record);
}