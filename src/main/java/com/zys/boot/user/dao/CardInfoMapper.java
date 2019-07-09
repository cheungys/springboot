package com.zys.boot.user.dao;

import com.zys.boot.user.entity.CardInfo;

public interface CardInfoMapper {
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入近路
     * @param record
     * @return
     */
    int insert(CardInfo record);

    int insertSelective(CardInfo record);

    CardInfo selectByVehiclePhone(String  vehiclePhone);

    int updateByPrimaryKeySelective(CardInfo record);

    int updateByPrimaryKey(CardInfo record);


}