package com.zys.boot.base.dao;

import com.zys.boot.base.entity.Dict;
import org.apache.ibatis.annotations.Param;

/**
 * @author zys
 * 系统名称:
 * 模块名称: 公共模块(数据字典)
 * 类 名 称: DictMapper
 * 类 定 义: 字典mapper
 * 开发时间: 2019/05/14  10:57
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */

public interface DictMapper {
    /**
     * 根据主键id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入记录
     *
     * @param record
     * @return
     */
    int insert(Dict record);

    /**
     * 根据条件动态插入
     *
     * @param record
     * @return
     */
    int insertSelective(Dict record);

    /**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    Dict selectByPrimaryKey(Integer id);

    /**
     * 根据条件动态查询
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Dict record);

    /**
     * 根据属性进行更新记录
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Dict record);


    /**
     * 根据字典键和所属定义id 获取该字段名称
     *
     * @param dictKey
     * @param belDictId
     * @return
     */
    Dict selectByKeyAndBelid(@Param("dictKey") String dictKey, @Param("belDictId") Integer belDictId);
}