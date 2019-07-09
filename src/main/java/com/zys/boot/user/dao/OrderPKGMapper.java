package com.zys.boot.user.dao;

import com.zys.boot.user.entity.OrderPKG;

import java.util.List;

public interface OrderPKGMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderPKG record);

    int insertSelective(OrderPKG record);

    List<OrderPKG> selectByVehiclePhone(String vehiclePhone);

    int updateByPrimaryKeySelective(OrderPKG record);

    int updateByPrimaryKey(OrderPKG record);
}