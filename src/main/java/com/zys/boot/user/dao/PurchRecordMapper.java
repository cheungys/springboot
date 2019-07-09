package com.zys.boot.user.dao;

import com.zys.boot.user.entity.PurchRecord;

import java.util.List;

public interface PurchRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PurchRecord record);

    int insertSelective(PurchRecord record);

    List<PurchRecord> selectByOrderNumTraff(String orderNumTraff);

    int updateByPrimaryKeySelective(PurchRecord record);

    int updateByPrimaryKey(PurchRecord record);
}