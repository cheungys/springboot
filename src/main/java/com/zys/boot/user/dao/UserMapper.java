package com.zys.boot.user.dao;

import com.zys.boot.user.entity.User;
import com.zys.boot.user.model.LoginInVo;

import java.util.List;

public interface UserMapper {
    int deleteByUserName(String email);

    int insert(User record);

    //注册用户
    int insertSelective(User user);


    //修改用户信息
    int updateByUser(User user);

    //更改密码
    int updateByUserName(LoginInVo loginInVo);


    /**
     * 查找用户
     * @param user
     * @return
     */
    List<User> selectByUser(User user);
    //所有用户
    List<User> findAll();
}